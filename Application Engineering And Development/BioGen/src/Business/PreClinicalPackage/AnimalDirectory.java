/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PreClinicalPackage;

import java.util.ArrayList;

/**
 *
 * @author Rishabh
 */
public class AnimalDirectory {
    
    private ArrayList<Animal> animalDirectory;
    
    public AnimalDirectory(){
        animalDirectory=new ArrayList<Animal>();
    }

    public ArrayList<Animal> getAnimalDirectory() {
        return animalDirectory;
    }

    public void setAnimalDirectory(ArrayList<Animal> animalDirectory) {
        this.animalDirectory = animalDirectory;
    }
    public Animal addAnimal(){
        Animal animal=new Animal();
        animalDirectory.add(animal);
        return animal;
    }
    public void deleteAnimal(Animal animal){
        animalDirectory.remove(animal);
    }
}
