package src.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.Vehicule.Motocicleta;

public class MotocicletaDatabase {
    private static MotocicletaDatabase instance;

    private static final String INSERT_STATEMENT = "INSERT INTO motocicleta (serie, pret, capacitateCiclindrica, putere, anFabricatie, capacitateRezervor, denumire, culoare, permiteAtas, permitePasager) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM motocicleta WHERE serie = ?";
    private static final String UPDATE_STATEMENT = "UPDATE motocicleta SET denumire = ? WHERE serie = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM motocicleta WHERE serie=?";

    private static final String FIND_NEWEST_MOTO = "SELECT * FROM motocicleta ORDER BY anFabricatie DESC LIMIT 1";

    private MotocicletaDatabase() {
    }

    public static MotocicletaDatabase getInstance() {
        if (instance == null) {
            instance = new MotocicletaDatabase();
        }

        return instance;
    }

    public Motocicleta saveMotocicleta(Motocicleta motocicleta) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setString(1, motocicleta.getSerie());
            statement.setDouble(2, motocicleta.getPret());
            statement.setInt(3, motocicleta.getCapacitateCiclindrica());
            statement.setInt(4, motocicleta.getPutere());
            statement.setInt(5, motocicleta.getAnFabricatie());
            statement.setDouble(6, motocicleta.getCapacitateRezervor());
            statement.setString(7, motocicleta.getDenumire());
            statement.setString(8, motocicleta.getCuloare());
            statement.setBoolean(9, motocicleta.isPermiteAtas());
            statement.setBoolean(10, motocicleta.isPermitePasager());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new motocicleta was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new motocicleta: " + e.getMessage());
            return new Motocicleta();
        }
        return motocicleta;
    }

    public Motocicleta findMotocicleta(String serie) {
        Motocicleta motocicleta = new Motocicleta();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, serie);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find user: motocicleta was not found!");
                    return motocicleta;
                }

                System.out.println("motocicleta was found!");
                motocicleta.setSerie(result.getString("serie"));
                motocicleta.setPret(result.getDouble("pret"));
                motocicleta.setCapacitateCiclindrica(result.getInt("capacitateCiclindrica"));
                motocicleta.setPutere(result.getInt("putere"));
                motocicleta.setAnFabricatie(result.getInt("anFabricatie"));
                motocicleta.setCapacitateRezervor(result.getDouble("capacitateRezervor"));
                motocicleta.setCuloare(result.getString("culoare"));
                motocicleta.setPermiteAtas(result.getBoolean("permiteAtas"));
                motocicleta.setPermiteAtas(result.getBoolean("permitePasager"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find motocicleta: " + e.getMessage());
        }
        return motocicleta;
    }

    public Motocicleta updateMotocicleta (Motocicleta motocicleta) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setString(1, motocicleta.getSerie());
            statement.setDouble(2, motocicleta.getPret());
            statement.setInt(3, motocicleta.getCapacitateCiclindrica());
            statement.setInt(4, motocicleta.getPutere());
            statement.setInt(5, motocicleta.getAnFabricatie());
            statement.setDouble(6, motocicleta.getCapacitateRezervor());
            statement.setString(7, motocicleta.getDenumire());
            statement.setString(8, motocicleta.getCuloare());
            statement.setBoolean(9, motocicleta.isPermiteAtas());
            statement.setBoolean(10, motocicleta.isPermitePasager());


            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Motocicleta was updated successfully!");
                return motocicleta;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update motocicleta: " + e.getMessage());
            return new Motocicleta();
        }

        System.out.println("Something went wrong when trying to update user: motocicleta was not found!");
        return new Motocicleta();
    }

    public boolean deleteMotocicleta(String serie) {
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

    public Motocicleta findNewestmotocicleta() {
        Motocicleta motocicleta = new Motocicleta();
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement()) {

            try (ResultSet result = statement.executeQuery(FIND_NEWEST_MOTO)) {
                if (!result.next()) {
                    System.out.println("Database might be empty!");
                    return motocicleta;
                }

                System.out.println("Newest member was found!");
                motocicleta.setSerie(result.getString("serie"));
                motocicleta.setPret(result.getDouble("pret"));
                motocicleta.setCapacitateCiclindrica(result.getInt("capacitateCiclindrica"));
                motocicleta.setPutere(result.getInt("putere"));
                motocicleta.setAnFabricatie(result.getInt("anFabricatie"));
                motocicleta.setCapacitateRezervor(result.getDouble("capacitateRezervor"));
                motocicleta.setDenumire(result.getString("nume"));
                motocicleta.setCuloare(result.getString("culoare"));
                motocicleta.setPermiteAtas(result.getBoolean("permiteAtas"));
                motocicleta.setPermiteAtas(result.getBoolean("permitePasager"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find the most newly registered user: " + e.getMessage());
        }
        return motocicleta;
    }
}
