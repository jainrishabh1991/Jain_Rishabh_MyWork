/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.NetworkPackage;
import Business.*;
import Business.EnterprisePackage.EnterpriseDirectory;
/**
 *
 * @author Atul
 */
public class Network {
    
     private String name;
    private EnterpriseDirectory enterprisedirectory;

    public Network() {
        enterprisedirectory = new EnterpriseDirectory();
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterprisedirectory() {
        return enterprisedirectory;
    }

    public void setEnterprisedirectory(EnterpriseDirectory enterprisedirectory) {
        this.enterprisedirectory = enterprisedirectory;
    }
    
    
    
    @Override
    public String toString()
    {
        return name;
    }
    
    
    
}
