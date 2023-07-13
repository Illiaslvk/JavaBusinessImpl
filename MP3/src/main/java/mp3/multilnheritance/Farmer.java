package mp3.multilnheritance;

import mp3.NullValidation;

public class Farmer extends Animal implements IPlot {

    private String name;
    private double surface;

    public Farmer(String name, double weight, String animalName,double surface) {
        super(weight,animalName);
        setName(name);
        setSurface(surface);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new NullValidation("Name cannot be null!!");
        }
        this.name = name;
    }

    @Override
    public double getSurface() {
        return surface;
    }

    @Override
    public void setSurface(double surface) {
        if(surface <= 0) {
            throw new NullValidation("Surface cannot be smaller than 1");
        }
        this.surface = surface;
    }

    @Override
    public String toString(){
        return name;
    }
}
