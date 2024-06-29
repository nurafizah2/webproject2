/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author 1
 */
public class Socmed {
    private int id;
    private Date log_date;
    private String description;

    public Socmed() {
        super();
    }

    public Socmed(Date log_date, String description) {
        this.log_date = log_date;
        this.description = description;
    }
    
    public Socmed(int id, Date log_date, String description) {
        this.id = id;
        this.log_date = log_date;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Date getLog_date() {
        return log_date;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLog_date(Date log_date) {
        this.log_date = log_date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
