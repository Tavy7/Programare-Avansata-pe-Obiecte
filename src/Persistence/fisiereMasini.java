package src.Persistence;

import src.Locatii.Showroom;
import src.Vehicule.Masina;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class fisiereMasini{
    private static fisiereMasini instance = null;

    private fisiereMasini() {
    }

    public static fisiereMasini getInstance() {
        if (instance == null) {
            instance = new fisiereMasini();
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
        String path = "src/csv/Masina.txt";

        try (BufferedReader shReader = new BufferedReader(new FileReader(path))) {
            String data = "";

            while ((data = shReader.readLine()) != null) {
                String[] splitData = data.split(", ");
                showroom.addMasina(new Masina(Double.parseDouble(splitData[0]), Integer.parseInt(splitData[1]), Integer.parseInt(splitData[2]),
                        Integer.parseInt(splitData[3]), Double.parseDouble(splitData[4]), splitData[5], splitData[6], splitData[7],
                        Integer.parseInt(splitData[8]), Integer.parseInt(splitData[9]), Boolean.parseBoolean(splitData[10])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
