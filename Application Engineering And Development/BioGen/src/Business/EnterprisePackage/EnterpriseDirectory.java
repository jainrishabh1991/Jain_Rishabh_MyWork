/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EnterprisePackage;

import Business.DrugPackage.Drug;
import java.util.ArrayList;

/**
 *
 * @author Atul
 */
public class EnterpriseDirectory {
    
    public ArrayList<Enterprise> enterpriseDirectory ;

    public EnterpriseDirectory() {
        enterpriseDirectory = new ArrayList<>();
    }
    
    

    public ArrayList<Enterprise> getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(ArrayList<Enterprise> enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type)
    {
        Enterprise enterprise = null;
        if ( type == Enterprise.EnterpriseType.FDA)
        {
            enterprise = new FDAEnterprise(name);
            enterpriseDirectory.add(enterprise);
            
        }
        else if ( type == Enterprise.EnterpriseType.Hospital)
        {
            enterprise = new HospitalEnterprise(name);
            enterpriseDirectory.add(enterprise);
            
        }
        else if ( type == Enterprise.EnterpriseType.License)
        {
            enterprise = new LicenseEnterprise(name);
            enterpriseDirectory.add(enterprise);
            
        }
        else if ( type == Enterprise.EnterpriseType.Warehouse)
        {
            enterprise = new WarehouseEnterprise(name);
            enterpriseDirectory.add(enterprise);
            
        }
        else if ( type == Enterprise.EnterpriseType.Manufacturer)
        {
            enterprise = new ManufacturerEnterprise(name);
            enterpriseDirectory.add(enterprise);
            
        }
        
        return enterprise;
    
    
}

}
