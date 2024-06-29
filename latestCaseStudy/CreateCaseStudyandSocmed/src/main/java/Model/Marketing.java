/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

public class Marketing {
    private int id;
    private Date log_date;
    private String description;

    // Constructors
    public Marketing() {
        super();
    }

    public Marketing(Date log_date, String description) {
        this.log_date = log_date;
        this.description = description;
    }

    public Marketing(int id, Date log_date, String description) {
        this.id = id;
        this.log_date = log_date;
        this.description = description;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLog_date() {
        return log_date;
    }

    public void setLog_date(Date log_date) {
        this.log_date = log_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}