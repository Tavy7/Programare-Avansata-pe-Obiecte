package src.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import src.Entitati.Mecanic;

public class MecanicDatabase {
    private static MecanicDatabase instance;

    private static final String INSERT_STATEMENT = "INSERT INTO mecanic (employee_id, nume) VALUES (?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM mecanic WHERE employee_id = ?";
    private static final String UPDATE_STATEMENT = "UPDATE mecanic SET nume = ? WHERE employee_id = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM mecanic WHERE employee_id=?";

    private static final String FIND_NEWEST_STATEMENT = "SELECT * FROM mecanic ORDER BY employee_id DESC LIMIT 1";

    private MecanicDatabase() {
    }

    public static MecanicDatabase getInstance() {
        if (instance == null) {
            instance = new MecanicDatabase();
        }

        return instance;
    }

    public Mecanic saveMecanic(Mecanic mecanic) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setInt(1, mecanic.getId());
            statement.setString(2, mecanic.getNume());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new mecanic was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new mecanic: " + e.getMessage());
            return new Mecanic();
        }
        return mecanic;
    }

    public Mecanic findMecanic(int employee_id) {
        Mecanic mecanic = new Mecanic();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setInt(1, employee_id);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find user: mecanic was not found!");
                    return mecanic;
                }

                System.out.println("mecanic was found!");
                mecanic.setId(result.getInt("employee_id"));
                mecanic.setNume(result.getString("nume"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find mecanic: " + e.getMessage());
        }
        return mecanic;
    }

    public Mecanic updateMecanic (Mecanic mecanic) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setString(1, mecanic.getNume());
            statement.setInt(2, mecanic.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("mecanic was updated successfully!");
                return mecanic;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update mecanic: " + e.getMessage());
            return new Mecanic();
        }

        System.out.println("Something went wrong when trying to update user: mecanic was not found!");
        return new Mecanic();
    }

    public boolean deleteMecanic(int employee_id) {
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

    public Mecanic findNewestMember() {
        Mecanic mecanic = new Mecanic();
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement()) {

            try (ResultSet result = statement.executeQuery(FIND_NEWEST_STATEMENT)) {
                if (!result.next()) {
                    System.out.println("Database might be empty!");
                    return mecanic;
                }

                System.out.println("Newest member was found!");
                mecanic.setId(result.getInt("employee_id"));
                mecanic.setNume(result.getString("nume"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find the most newly registered user: " + e.getMessage());
        }
        return mecanic;
    }
}
