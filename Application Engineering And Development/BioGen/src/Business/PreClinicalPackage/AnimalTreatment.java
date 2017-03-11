/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PreClinicalPackage;

import Business.ClinicalPackage.Patient;
import Business.DrugPackage.Drug;

/**
 *
 * @author Rishabh
 */
public class AnimalTreatment {
    private String treatmentId;
    private Animal animal;
    private Drug drug;
    private String dosage;
    private int response;
    private int sideEffect;
    private static int count=0;
    
    public AnimalTreatment(){
        count++;
        this.treatmentId=String.valueOf(count++);
    }

    public int getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(int sideEffect) {
        this.sideEffect = sideEffect;
    }

    public String getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }
    @Override
    public String toString(){
        return treatmentId;
    }

}
