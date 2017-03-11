/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import Business.DrugPackage.Drug;

/**
 *
 * @author Rishabh
 */
public class ForPreClinicalFromManuToPreclinical {
    private Drug drug;
    
    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
    
    @Override
    public String toString() {
        return drug.getDrugName();
    }
    
}
