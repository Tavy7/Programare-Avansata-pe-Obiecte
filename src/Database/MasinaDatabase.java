package src.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.Vehicule.Masina;

public class MasinaDatabase {
    private static MasinaDatabase instance;

    private static final String INSERT_STATEMENT = "INSERT INTO masina (serie, pret, capacitateCiclindrica, putere, anFabricatie, capacitateRezervor, denumire, culoare, numarPortiere, numarLocuri, gpl) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM masina WHERE serie = ?";
    private static final String UPDATE_STATEMENT = "UPDATE masina SET denumire = ? WHERE serie = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM masina WHERE serie=?";

    private static final String FIND_NEWEST_CAR = "SELECT * FROM Masina ORDER BY anFabricatie DESC LIMIT 1";

    private MasinaDatabase() {
    }

    public static MasinaDatabase getInstance() {
        if (instance == null) {
            instance = new MasinaDatabase();
        }

        return instance;
    }

    public Masina saveMasina(Masina masina) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setString(1, masina.getSerie());
            statement.setDouble(2, masina.getPret());
            statement.setInt(3, masina.getCapacitateCiclindrica());
            statement.setInt(4, masina.getPutere());
            statement.setInt(5, masina.getAnFabricatie());
            statement.setDouble(6, masina.getCapacitateRezervor());
            statement.setString(7, masina.getDenumire());
            statement.setString(8, masina.getCuloare());
            statement.setInt(9, masina.getNumarPortiere());
            statement.setInt(10, masina.getNumarLocuri());
            statement.setBoolean(11, masina.isGpl());


            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Masina was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new Masina: " + e.getMessage());
            return new Masina();
        }
        return masina;
    }

    public Masina findMasina(String serie) {
        Masina masina = new Masina();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, serie);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find user: Masina was not found!");
                    return masina;
                }

                System.out.println("Masina was found!");
                masina.setSerie(result.getString("serie"));
                masina.setPret(result.getDouble("pret"));
                masina.setCapacitateCiclindrica(result.getInt("capacitateCiclindrica"));
                masina.setPutere(result.getInt("putere"));
                masina.setAnFabricatie(result.getInt("anFabricatie"));
                masina.setCapacitateRezervor(result.getDouble("capacitateRezervor"));
                masina.setDenumire(result.getString("nume"));
                masina.setCuloare((result.getString("culoare")));
                masina.setNumarPortiere(result.getInt("numarPortiere"));
                masina.setNumarLocuri(result.getInt("numarLocuri"));
                masina.setGpl(result.getBoolean("gpl"));

            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find Masina: " + e.getMessage());
        }
        return masina;
    }

    public Masina updateMasina (Masina masina) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setString(1, masina.getSerie());
            statement.setDouble(2, masina.getPret());
            statement.setInt(3, masina.getCapacitateCiclindrica());
            statement.setInt(4, masina.getPutere());
            statement.setInt(5, masina.getAnFabricatie());
            statement.setDouble(6, masina.getCapacitateRezervor());
            statement.setString(7, masina.getDenumire());
            statement.setString(8, masina.getCuloare());
            statement.setInt(9, masina.getNumarPortiere());
            statement.setInt(10, masina.getNumarLocuri());
            statement.setBoolean(11, masina.isGpl());


            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Masina was updated successfully!");
                return masina;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update Masina: " + e.getMessage());
            return new Masina();
        }

        System.out.println("Something went wrong when trying to update user: Masina was not found!");
        return new Masina();
    }

    public boolean deleteMasina(String serie) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setString(1, serie);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete user: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete user: User was not found!");
        return false;
    }

    public Masina findNewestMasina() {
        Masina masina = new Masina();
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement()) {

            try (ResultSet result = statement.executeQuery(FIND_NEWEST_CAR)) {
                if (!result.next()) {
                    System.out.println("Database might be empty!");
                    return masina;
                }

                System.out.println("Newest member was found!");
                masina.setSerie(result.getString("serie"));
                masina.setPret(result.getDouble("pret"));
                masina.setCapacitateCiclindrica(result.getInt("capacitateCiclindrica"));
                masina.setPutere(result.getInt("putere"));
                masina.setAnFabricatie(result.getInt("anFabricatie"));
                masina.setCapacitateRezervor(result.getDouble("capacitateRezervor"));
                masina.setDenumire(result.getString("nume"));
                masina.setCuloare((result.getString("culoare")));
                masina.setNumarPortiere(result.getInt("numarPortiere"));
                masina.setNumarLocuri(result.getInt("numarLocuri"));
                masina.setGpl(result.getBoolean("gpl"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find the most newly registered user: " + e.getMessage());
        }
        return masina;
    }
}
