/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.DBConnection;
import Model.CaseStudy;
import Model.Socmed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class CaseStudyDAO {

    private static final String INSERT_CASESTUDY = "INSERT INTO casestudy (log_date, description) VALUES (?, ?);";
    private static final String SELECT_ALL_CASESTUDY = "SELECT * FROM casestudy;";
    private static final String SELECT_CASESTUDY_BY_CASESTUDYID = "SELECT * FROM casestudy WHERE id = ?;";
    private static final String UPDATE_CASESTUDY = "UPDATE casestudy SET log_date = ?, description = ? WHERE id = ?;";
    private static final String DELETE_CASESTUDY = "DELETE FROM casestudy WHERE id = ?;";

    public void insertCaseStudy(CaseStudy casestudy) throws SQLException, ClassNotFoundException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CASESTUDY)) {
            preparedStatement.setDate(1, casestudy.getLog_date());
            preparedStatement.setString(2, casestudy.getDescription());
            preparedStatement.executeUpdate();
        }
    }

    // Retrieve all marketing records
    public List<CaseStudy> selectAllCaseStudy() throws ClassNotFoundException {
        List<CaseStudy> CaseStudyList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CASESTUDY)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                java.sql.Date log_date = rs.getDate("log_date");
                String description = rs.getString("description");
                CaseStudyList.add(new CaseStudy(id, log_date, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CaseStudyList;
    }

    // Retrieve a marketing record by ID
    public CaseStudy selectCaseStudyByID(int id) throws ClassNotFoundException {
        CaseStudy caseStudy = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CASESTUDY_BY_CASESTUDYID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                java.sql.Date log_date = rs.getDate("log_date");
                String description = rs.getString("description");
                caseStudy = new CaseStudy(id, log_date, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return caseStudy;
    }
     
     
    // Update a marketing record
    public boolean updateCaseStudy(CaseStudy caseStudy) throws SQLException, ClassNotFoundException {
        boolean recordUpdated = false;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CASESTUDY)) {
            preparedStatement.setDate(1, caseStudy.getLog_date());
            preparedStatement.setString(2, caseStudy.getDescription());
            preparedStatement.setInt(3, caseStudy.getId());
            recordUpdated = preparedStatement.executeUpdate() > 0;
        }
        return recordUpdated;
    }

    // Delete a marketing record by ID
    public boolean deleteCaseStudy(int id) throws SQLException, ClassNotFoundException {
        boolean recordDeleted = false;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CASESTUDY)) {
            preparedStatement.setInt(1, id);
            recordDeleted = preparedStatement.executeUpdate() > 0;
        }
        return recordDeleted;
    }
}


