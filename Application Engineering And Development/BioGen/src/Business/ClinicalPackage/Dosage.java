/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ClinicalPackage;

/**
 *
 * @author Rishabh
 */
public class Dosage {
    private int id;
    private int dosgae;
    private static int count=0;
    public Dosage(){
        count++;
        this.id=count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDosgae() {
        return dosgae;
    }

    public void setDosgae(int dosgae) {
        this.dosgae = dosgae;
    }
    
}
