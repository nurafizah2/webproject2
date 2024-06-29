package DAO;

import Model.Marketing;
import Connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarketingDAO {

    private static final String INSERT_MARKETING = "INSERT INTO marketing (log_date, description) VALUES (?, ?);";
    private static final String SELECT_ALL_MARKETING = "SELECT * FROM marketing;";
    private static final String SELECT_MARKETING_BY_MARKETINGID = "SELECT * FROM marketing WHERE id = ?;";
    private static final String UPDATE_MARKETING = "UPDATE marketing SET log_date = ?, description = ? WHERE id = ?;";
    private static final String DELETE_MARKETING = "DELETE FROM marketing WHERE id = ?;";

    public void insertMarketing(Marketing marketing) throws SQLException, ClassNotFoundException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MARKETING)) {
            preparedStatement.setDate(1, marketing.getLog_date());
            preparedStatement.setString(2, marketing.getDescription());
            preparedStatement.executeUpdate();
        }
    }

    // Retrieve all marketing records
    public List<Marketing> selectAllMarketing() throws ClassNotFoundException {
        List<Marketing> marketingList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MARKETING)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                java.sql.Date log_date = rs.getDate("log_date");
                String description = rs.getString("description");
                marketingList.add(new Marketing(id, log_date, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marketingList;
    }

    // Retrieve a marketing record by ID
    public Marketing selectMarketingByID(int id) throws ClassNotFoundException {
        Marketing marketing = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MARKETING_BY_MARKETINGID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                java.sql.Date log_date = rs.getDate("log_date");
                String description = rs.getString("description");
                marketing = new Marketing(id, log_date, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marketing;
    }
 
    // Update a marketing record
    public boolean updateMarketing(Marketing marketing) throws SQLException, ClassNotFoundException {
        boolean recordUpdated = false;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MARKETING)) {
            preparedStatement.setDate(1, marketing.getLog_date());
            preparedStatement.setString(2, marketing.getDescription());
            preparedStatement.setInt(3, marketing.getId());
            recordUpdated = preparedStatement.executeUpdate() > 0;
        }
        return recordUpdated;
    }

    // Delete a marketing record by ID
    public boolean deleteMarketing(int id) throws SQLException, ClassNotFoundException {
        boolean recordDeleted = false;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MARKETING)) {
            preparedStatement.setInt(1, id);
            recordDeleted = preparedStatement.executeUpdate() > 0;
        }
        return recordDeleted;
    }
}

