/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import Business.PreClinicalPackage.AnimalTreatmentHistory;

/**
 *
 * @author Rishabh
 */
public class SendReportToManuFromPreclinical extends WorkRequest{
    private AnimalTreatmentHistory animalTreatmentHistory;

    public AnimalTreatmentHistory getAnimalTreatmentHistory() {
        return animalTreatmentHistory;
    }

    public void setAnimalTreatmentHistory(AnimalTreatmentHistory animalTreatmentHistory) {
        this.animalTreatmentHistory = animalTreatmentHistory;
    }
    
    
}
