package mp3.multilnheritance;

import mp3.BookValidation;

public class Plot implements IPlot {

    private double surface;

    public Plot(double surface) {
        setSurface(surface);
    }

    @Override
    public double getSurface(){
        return surface;
    }

    @Override
    public void setSurface(double surface) {
        if(surface <= 0 ) {
            throw new BookValidation("Surface cannot be smaller than 0!!");
        }
        this.surface = surface;
    }
}
