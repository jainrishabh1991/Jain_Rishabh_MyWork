/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PreClinicalPackage;

import Business.ClinicalPackage.Treatment;
import java.util.ArrayList;

/**
 *
 * @author Rishabh
 */
public class AnimalTreatmentHistory {
    private ArrayList<AnimalTreatment> animaltreatmentHistory;
    
    public AnimalTreatmentHistory(){
        animaltreatmentHistory=new ArrayList<AnimalTreatment>();
    }

    public ArrayList<AnimalTreatment> getAnimalTreatmentHistory() {
        return animaltreatmentHistory;
    }

    public void setAnimalTreatmentHistory(ArrayList<AnimalTreatment> treatmentHistory) {
        this.animaltreatmentHistory = treatmentHistory;
    }

    public AnimalTreatment addAnimalTreatment(){
        AnimalTreatment animalTreatment=new AnimalTreatment();
        animaltreatmentHistory.add(animalTreatment);
        return animalTreatment;
    }
    public void deleteAnimalTreatment(AnimalTreatment animalTreatment){
        animaltreatmentHistory.remove(animalTreatment);
        
    }
    public void addExistingTreatment(AnimalTreatment treatment){
        animaltreatmentHistory.add(treatment);
    }

}
