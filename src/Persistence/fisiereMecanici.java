package src.Persistence;

import src.Entitati.Mecanic;
import src.Locatii.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class fisiereMecanici {
    private static fisiereMecanici instance = null;

    private fisiereMecanici() {
    }

    public static fisiereMecanici getInstance(){
        if (instance == null){
            instance = new fisiereMecanici();
        }

        return instance;
    }

    private static String path (){
        return "src/csv/Mecanic.txt";
    }

    public void scrie(String data) throws IOException {
        FileWriter fw = new FileWriter("src/csv/Audit.txt", true);

        LocalDateTime dmy = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm.dd-MM-yyyy");
        fw.write(data.toString() + ", " + dmy.format(format) + "\n");

        fw.close();
    }

    public void citire(Service service) {
        String path = "src/csv/Mecanic.txt";

        try (BufferedReader shReader = new BufferedReader(new FileReader(path))) {
            String data = "";

            while ((data = shReader.readLine()) != null) {
                String[] splitData = data.split(", ");
                service.addMecanic(new Mecanic(splitData[0], Integer.parseInt(splitData[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
