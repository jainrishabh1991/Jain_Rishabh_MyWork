/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.OrganizationPackage;

import Business.PreClinicalPackage.AnimalDirectory;
import Business.PreClinicalPackage.AnimalTreatmentHistory;
import Business.RolePackage.PreClinicalTesterRole;
import Business.RolePackage.Role;
import Business.RolePackage.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Rishabh
 */
public class PreClinicalTesterOrgnization extends Organization{
    private AnimalTreatmentHistory animalTreatmentHistory;
    private AnimalDirectory animalDirectory;
    
    
     public PreClinicalTesterOrgnization() {
        super(Type.PreClinicalTester.getValue());
        animalTreatmentHistory = new AnimalTreatmentHistory();
        animalDirectory = new AnimalDirectory();
    }

    public AnimalDirectory getAnimalDirectory() {
        return animalDirectory;
    }

    public void setAnimalDirectory(AnimalDirectory animalDirectory) {
        this.animalDirectory = animalDirectory;
    }

     
     
    public AnimalTreatmentHistory getAnimalTreatmentHistory() {
        return animalTreatmentHistory;
    }

    public void setAnimalTreatmentHistory(AnimalTreatmentHistory animalTreatmentHistory) {
        this.animalTreatmentHistory = animalTreatmentHistory;
    }
     
     
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PreClinicalTesterRole());
        return roles;
    }
}
