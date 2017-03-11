/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ClinicalPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Rishabh
 */
public class Patient {
    private int patientId;
    private String name;
    private boolean gender;
    private double height;
    private double weight;
    private Date dateOfBirth;
    private Disease disease;
    private Date infectedDate;
    private static int count=0;
    
    public Patient(){
        count++;
        this.patientId=count;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return  height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        this.dateOfBirth = sdf.parse(dateOfBirth);
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Date getInfectedDate() {
        return infectedDate;
    }

    public void setInfectedDate(String infectedDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        this.infectedDate = sdf.parse(infectedDate);
    }

    public int getPatientId() {
        return patientId;
    }
    @Override
    public String toString(){
        return  name;
    }

}
