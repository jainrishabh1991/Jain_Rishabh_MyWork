/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import Business.ClinicalPackage.TreatmentHistory;
import Business.DrugPackage.Drug;
import Business.PreClinicalPackage.AnimalTreatmentHistory;

/**
 *
 * @author Rishabh
 */
public class DrugApprovalFromManuToFDA extends WorkRequest{
    private AnimalTreatmentHistory animalTreatmentHistory;
    private TreatmentHistory patientTreatmentHistory;
    private Drug drug;

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
    
    
    public AnimalTreatmentHistory getAnimalTreatmentHistory() {
        return animalTreatmentHistory;
    }

    public void setAnimalTreatmentHistory(AnimalTreatmentHistory animalTreatmentHistory) {
        this.animalTreatmentHistory = animalTreatmentHistory;
    }

    public TreatmentHistory getPatientTreatmentHistory() {
        return patientTreatmentHistory;
    }

    public void setPatientTreatmentHistory(TreatmentHistory patientTreatmentHistory) {
        this.patientTreatmentHistory = patientTreatmentHistory;
    }
    
}
