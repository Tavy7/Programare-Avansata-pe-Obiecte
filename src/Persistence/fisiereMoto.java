package src.Persistence;

import src.Locatii.Showroom;
import src.Vehicule.Motocicleta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class fisiereMoto{
    private static fisiereMoto instance = null;

    private fisiereMoto() {
    }

    public static fisiereMoto getInstance() {
        if (instance == null) {
            instance = new fisiereMoto();
        }

        return instance;
    }

    public void scrie(String data) throws IOException {
        FileWriter fw = new FileWriter("src/csv/Audit.txt", true);

        LocalDateTime dmy = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm.dd-MM-yyyy");
        fw.write(data.toString() + ", " + dmy.format(format) + "\n");

        fw.close();
    }

    public void citire(Showroom showroom) {
        String path = "src/csv/Motocicleta.txt";

        try (BufferedReader shReader = new BufferedReader(new FileReader(path))) {
            String data = "";

            while ((data = shReader.readLine()) != null) {
                String[] splitData = data.split(", ");
                showroom.addMoto(new Motocicleta(Double.parseDouble(splitData[0]), Integer.parseInt(splitData[1]), Integer.parseInt(splitData[2]),
                        Integer.parseInt(splitData[3]), Double.parseDouble(splitData[4]), splitData[5], splitData[6], splitData[7],
                        Boolean.parseBoolean(splitData[8]), Boolean.parseBoolean(splitData[9])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
