/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import Business.DrugPackage.Drug;
import Business.EnterprisePackage.ManufacturerEnterprise;

/**
 *
 * @author Rishabh
 */
public class ForTestingByManuToPreclinical extends WorkRequest{
    private ManufacturerEnterprise manufacturerEnterprise;
    private Drug drug;

    public ManufacturerEnterprise getManufacturerEnterprise() {
        return manufacturerEnterprise;
    }

    public void setManufacturerEnterprise(ManufacturerEnterprise manufacturerEnterprise) {
        this.manufacturerEnterprise = manufacturerEnterprise;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
    
    
    
}
