/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ClinicalPackage;

import Business.DrugPackage.Drug;

/**
 *
 * @author Rishabh
 */
public class Treatment {
    private String treatmentId;
    private Patient patient;
    private Drug drug;
    private int dosage;
    private int response;
    private int sideEffects;
    private static int count=0;
    
    public Treatment(){
        count++;
        this.treatmentId=String.valueOf(count);
    }

    public String getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
    }

    

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public int getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(int sideEffects) {
        this.sideEffects = sideEffects;
    }
    @Override
    public String toString()
    {
        return treatmentId;
    }

  }
