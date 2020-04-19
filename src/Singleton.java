package src;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance (){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

//    public static void deleteInstance(){
//        instance = null;
//    }

    private String createPath(String numeClasa){
        String path = "Programare-Avansata-pe-Obiecte/csv/" + numeClasa + ".txt";

        return path;
    }

    public <T> void citire (T clasa, ClasaSerivce sv){
        String path = this.createPath(clasa.getClass().toString().substring(10));

        if (clasa instanceof Showroom){
            //citire showroom
            Showroom showroom = new Showroom();
            String[] clase = {"Masina", "Motocicleta", "Vanzator"};

            for (String i : clase){
                String showroomPath = this.createPath(i);
                try (BufferedReader shReader = new BufferedReader(new FileReader(showroomPath))){
                    String data = "";
                    while((data = shReader.readLine()) != null){
                        String[] splitData = data.split(", ");
                        switch(i){
                            case "Masina":
                                showroom.addMasina(new Masina(Double.parseDouble(splitData[0]), Integer.parseInt(splitData[1]), Integer.parseInt(splitData[2]),
                                        Integer.parseInt(splitData[3]), Double.parseDouble(splitData[4]), splitData[5], splitData[6], splitData[7],
                                        Integer.parseInt(splitData[8]), Integer.parseInt(splitData[9]), Boolean.parseBoolean(splitData[10])));
                                break;
                            case "Motocicleta":
                                showroom.addMoto(new Motocicleta(Double.parseDouble(splitData[0]), Integer.parseInt(splitData[1]), Integer.parseInt(splitData[2]),
                                        Integer.parseInt(splitData[3]), Double.parseDouble(splitData[4]), splitData[5], splitData[6], splitData[7],
                                        Boolean.parseBoolean(splitData[8]), Boolean.parseBoolean(splitData[9])));
                                break;
                            case "Vanzator":
                                showroom.addVanzator(new Vanzator(splitData[0], Integer.parseInt(splitData[1])));
                                break;
                        }
                    }
                    Collections.sort(showroom.vanzatori);//sortare descrescatoare dupa id
                    sv.setShow(showroom);
                }

                catch(IOException e){
                    e.printStackTrace();
                }
             }
        }

        if (clasa instanceof Service){
            //citire service
            String mecanicPath = this.createPath("Mecanic");
            try (BufferedReader servReader = new BufferedReader(new FileReader(mecanicPath))){
                Service service = new Service();
                String data = "";
                while((data = servReader.readLine()) != null) {
                    String[] splitData = data.split(", ");
                    service.addMecanic(new Mecanic(splitData[0], Integer.parseInt(splitData[1])));
                }
                sv.setServ(service);
            }
            catch(IOException e){
                e.printStackTrace();
            }

        }
    }

    private boolean createFile (){
        try{
            File file = new File("Programare-Avansata-pe-Obiecte/csv/Audit.txt");
            if (file.createNewFile()){
                ;
                //System.out.println("Fisierul s-a creat.");
            }
            else{
                ;
                //System.out.println("Fisierul exista deja.");
            }
            return true;
        }
        catch(IOException e){
            System.out.println("Eroare la crearea fisierului.");
            e.printStackTrace();
            return false;
        }

    }

    public <T> void scrie (T data){
        if (!this.createFile()){
            return;
        }

        try {
            FileWriter fw = new FileWriter("Programare-Avansata-pe-Obiecte/csv/Audit.txt", true);
            LocalDateTime dmy = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm.dd-MM-yyyy");
            fw.write(String.class.cast(data) + ", " + dmy.format(format) + "\n");

            fw.close();
        }
        catch (IOException e){
            System.out.println("A aparut o eroare la scriere.");
            e.printStackTrace();
        }
    }

    public ArrayList<Object> returneazaDate (String clasa){
        ArrayList<Object> lista = new ArrayList<Object>();
        String path = "src/csv/" + clasa + ".txt";
        String data;

        try{
            File file = new File (path);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                data = sc.nextLine();

                switch (clasa){
                    case "Masina":
                        lista.add(generareMasina(data));
                        break;
                    case "Motocicleta":
                        lista.add(generareMotocicleta(data));
                        break;
                    case "Vanzator":
                        lista.add(generareVanzator(data));
                        break;
                    case "Mecanic":
                        lista.add(generareMecanic(data));
                        break;

                    default:
                        System.out.println("Eroare la incarcarea datelor din fisiere.\n" + clasa + " not found!");
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Eroare la deschiderea fisierului.");
            e.printStackTrace();
        }
        return lista;
    }

    private Masina generareMasina(String data){
        String[] sd = data.split("\\s*, \\s*");

        return new Masina(Double.parseDouble(sd[0]), Integer.parseInt(sd[1]), Integer.parseInt(sd[2]), Integer.parseInt(sd[3]),
                Double.parseDouble(sd[4]), sd[5], sd[6], sd[7], Integer.parseInt(sd[8]), Integer.parseInt(sd[9]), Boolean.parseBoolean(sd[10]));
    }

    private Motocicleta generareMotocicleta(String data){
        String[] sd = data.split("\\s*, \\s*");

        return new Motocicleta(Double.parseDouble(sd[0]), Integer.parseInt(sd[1]), Integer.parseInt(sd[2]), Integer.parseInt(sd[3]),
                Double.parseDouble(sd[4]), sd[5], sd[6], sd[7], Boolean.parseBoolean(sd[8]), Boolean.parseBoolean(sd[9]));
    }

    private Vanzator generareVanzator(String data){
        String[] sd = data.split("\\s*, \\s*");

        return new Vanzator(sd[0], Integer.parseInt(sd[1]));
    }

    private Mecanic generareMecanic (String data){
        String[] sd = data.split("\\s*, \\s*");

        return new Mecanic(sd[0], Integer.parseInt(sd[1]));
    }
}
