package src.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import src.Entitati.Vanzator;

public class VanzatorDatabase {
    private static VanzatorDatabase instance;

    private static final String INSERT_STATEMENT = "INSERT INTO vanzator (employee_id, nume) VALUES (?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM vanzator WHERE employee_id = ?";
    private static final String UPDATE_STATEMENT = "UPDATE vanzator SET nume = ? WHERE employee_id = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM vanzator WHERE employee_id=?";

    private static final String FIND_NEWEST_STATEMENT = "SELECT * FROM vanzator ORDER BY employee_id DESC LIMIT 1";

    private VanzatorDatabase() {
    }

    public static VanzatorDatabase getInstance() {
        if (instance == null) {
            instance = new VanzatorDatabase();
        }

        return instance;
    }

    public Vanzator saveVanzator(Vanzator vanzator) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setInt(1, vanzator.getId());
            statement.setString(2, vanzator.getNume());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new vanzator was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new vanzator: " + e.getMessage());
            return new Vanzator();
        }
        return vanzator;
    }

    public Vanzator findVanzator(int employee_id) {
        Vanzator vanzator = new Vanzator();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setInt(1, employee_id);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find user: Vanzator was not found!");
                    return vanzator;
                }

                System.out.println("Vanzator was found!");
                vanzator.setId(result.getInt("employee_id"));
                vanzator.setNume(result.getString("nume"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find vanzator: " + e.getMessage());
        }
        return vanzator;
    }

    public Vanzator updateVanzator (Vanzator vanzator) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setString(1, vanzator.getNume());
            statement.setInt(2, vanzator.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Vanzator was updated successfully!");
                return vanzator;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update vanzator: " + e.getMessage());
            return new Vanzator();
        }

        System.out.println("Something went wrong when trying to update user: Vanzator was not found!");
        return new Vanzator();
    }

    public boolean deleteVanzator(int employee_id) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setInt(1, employee_id);

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

    public Vanzator findNewestMember() {
        Vanzator vanzator = new Vanzator();
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement()) {

            try (ResultSet result = statement.executeQuery(FIND_NEWEST_STATEMENT)) {
                if (!result.next()) {
                    System.out.println("Database might be empty!");
                    return vanzator;
                }

                System.out.println("Newest member was found!");
                vanzator.setId(result.getInt("employee_id"));
                vanzator.setNume(result.getString("nume"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find the most newly registered user: " + e.getMessage());
        }
        return vanzator;
    }
}
