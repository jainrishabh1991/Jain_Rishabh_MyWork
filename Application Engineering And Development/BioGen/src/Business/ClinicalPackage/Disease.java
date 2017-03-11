/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ClinicalPackage;

/**
 *
 * @author Rishabh
 */
public class Disease {
    private int diseaseId;
    private String name;
    private String symptoms;
    private int severity;
    private static int count=0;
    
    public Disease(){
        count++;
        this.diseaseId=count;
    }

    public int getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }
    @Override
    public String toString()
    {
        return name;
    }
}
