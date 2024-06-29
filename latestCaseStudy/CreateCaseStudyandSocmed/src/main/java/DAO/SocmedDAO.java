/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.DBConnection;
import Model.Socmed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SocmedDAO {

    private static final String INSERT_SOCMED = "INSERT INTO socmed (log_date, description) VALUES (?, ?);";
    private static final String SELECT_ALL_SOCMED = "SELECT * FROM socmed;";
    private static final String SELECT_SOCMED_BY_SOCMEDID = "SELECT * FROM socmed WHERE id = ?;";
    private static final String UPDATE_SOCMED = "UPDATE socmed SET log_date = ?, description = ? WHERE id = ?;";
    private static final String DELETE_SOCMED = "DELETE FROM socmed WHERE id = ?;";

    public void insertSocmed(Socmed socmed) throws SQLException, ClassNotFoundException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SOCMED)) {
            preparedStatement.setDate(1, socmed.getLog_date());
            preparedStatement.setString(2, socmed.getDescription());
            preparedStatement.executeUpdate();
        }
    }

    // Retrieve all marketing records
    public List<Socmed> selectAllSocmed() throws ClassNotFoundException {
        List<Socmed> socmedList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SOCMED)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                java.sql.Date log_date = rs.getDate("log_date");
                String description = rs.getString("description");
                socmedList.add(new Socmed(id, log_date, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return socmedList;
    }

    // Retrieve a marketing record by ID
    public Socmed selectSocmedByID(int id) throws ClassNotFoundException {
        Socmed socmed = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SOCMED_BY_SOCMEDID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                java.sql.Date log_date = rs.getDate("log_date");
                String description = rs.getString("description");
                socmed = new Socmed(id, log_date, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return socmed;
    }
     
     
    // Update a marketing record
    public boolean updateSocmed(Socmed socmed) throws SQLException, ClassNotFoundException {
        boolean recordUpdated = false;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SOCMED)) {
            preparedStatement.setDate(1, socmed.getLog_date());
            preparedStatement.setString(2, socmed.getDescription());
            preparedStatement.setInt(3, socmed.getId());
            recordUpdated = preparedStatement.executeUpdate() > 0;
        }
        return recordUpdated;
    }

    // Delete a marketing record by ID
    public boolean deleteSocmed(int id) throws SQLException, ClassNotFoundException {
        boolean recordDeleted = false;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SOCMED)) {
            preparedStatement.setInt(1, id);
            recordDeleted = preparedStatement.executeUpdate() > 0;
        }
        return recordDeleted;
    }
}
