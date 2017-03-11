/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PreClinicalPackage;

/**
 *
 * @author Rishabh
 */
public class Animal {
    private String animalId;
    private String animalType;
    private String BodyPart;
    private int GeneMatch;
    private static int c;

    public Animal() {
        c=c+1;
        animalId="A-00"+c;
    }
    
    

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getBodyPart() {
        return BodyPart;
    }

    public void setBodyPart(String BodyPart) {
        this.BodyPart = BodyPart;
    }

    public int getGeneMatch() {
        return GeneMatch;
    }

    public void setGeneMatch(int GeneMatch) {
        this.GeneMatch = GeneMatch;
    }
    @Override
    public String toString(){
        return animalType;
    }
    
}
