/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DrugPackage;

import Business.*;
import java.util.ArrayList;

/**
 *
 * @author Atul
 */
public class DrugDirectory {
    
    private ArrayList<Drug> drugDirectory ;

    public DrugDirectory() {
        drugDirectory = new ArrayList<>();
    }

    public ArrayList<Drug> getDrugDirectory() {
        return drugDirectory;
    }

    public void setDrugDirectory(ArrayList<Drug> drugDirectory) {
        this.drugDirectory = drugDirectory;
    }
    public Drug newDrug(){
        Drug drug = new Drug();
        drugDirectory.add(drug);
        return drug;
    }
    
    public void removeDrug(Drug d){
        drugDirectory.remove(d);
    }
    
    
    
    
}
