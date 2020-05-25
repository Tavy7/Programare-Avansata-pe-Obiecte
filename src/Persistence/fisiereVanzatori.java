package src.Persistence;

import src.Database.VanzatorDatabase;
import src.Entitati.Vanzator;
import src.Locatii.Showroom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;


public class fisiereVanzatori {
    private static fisiereVanzatori instance = null;

    private fisiereVanzatori() {
    }

    public static fisiereVanzatori getInstance() {
        if (instance == null) {
            instance = new fisiereVanzatori();
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
        String path = "src/csv/Vanzator.txt";

        try (BufferedReader shReader = new BufferedReader(new FileReader(path))) {
            String data = "";

            while ((data = shReader.readLine()) != null) {
                String[] splitData = data.split(", ");

                Vanzator aux = new Vanzator(splitData[0], Integer.parseInt(splitData[1]));
                showroom.addVanzator(aux);

                VanzatorDatabase.getInstance().saveVanzator(aux);
            }
            //showroom.setVanzatori(Collections.sort(showroom.getVanzatori()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
