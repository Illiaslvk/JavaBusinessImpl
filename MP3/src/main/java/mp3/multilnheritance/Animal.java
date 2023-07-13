package mp3.multilnheritance;

import mp3.NullValidation;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    private double weight;
    private String animalName;

    public Animal(double weight, String animalName){
        setWeight(weight);
        setAnimalName(animalName);
    }

    //Weight

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(weight <= 0) {
            throw new NullValidation("Weight cannot be smaller than 1");
        }
        this.weight = weight;
    }

    // Animal name

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        if(animalName == null) {
            throw new NullValidation("Animal name cannot be null!!!");
        }
        this.animalName = animalName;
    }

}
