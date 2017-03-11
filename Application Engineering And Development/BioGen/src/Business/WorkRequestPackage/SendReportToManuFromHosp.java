/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import Business.ClinicalPackage.TreatmentHistory;

/**
 *
 * @author Rishabh
 */
public class SendReportToManuFromHosp extends WorkRequest{
    private TreatmentHistory treatmentHistory;

    public TreatmentHistory getTreatmentHistory() {
        return treatmentHistory;
    }

    public void setTreatmentHistory(TreatmentHistory treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }
    
    
    
}
