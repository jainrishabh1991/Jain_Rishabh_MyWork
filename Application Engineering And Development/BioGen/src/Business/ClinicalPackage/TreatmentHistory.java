/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ClinicalPackage;

import java.util.ArrayList;

/**
 *
 * @author Rishabh
 */
public class TreatmentHistory {
    private ArrayList<Treatment> treatmentHistory;
    
    public TreatmentHistory(){
        treatmentHistory=new ArrayList<Treatment>();
    }

    public ArrayList<Treatment> getTreatmentHistory() {
        return treatmentHistory;
    }

    public void setTreatmentHistory(ArrayList<Treatment> treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }
    public Treatment addTreatment(){
        Treatment treatment=new Treatment();
        treatmentHistory.add(treatment);
        return treatment;
    }
    public void deleteTreatment(Treatment treatment){
        treatmentHistory.remove(treatment);
        
    }
    public void addExistingTreatment(Treatment treatment){
        treatmentHistory.add(treatment);
    }
}
