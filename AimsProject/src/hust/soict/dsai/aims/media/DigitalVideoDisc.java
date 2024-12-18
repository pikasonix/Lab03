package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;
    private int length;
    
    private static int nbDigitalVideoDisc = 0;
    
    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }

    public DigitalVideoDisc(String title) {
        super(title);
        nbDigitalVideoDisc += 1;
        this.setId(nbDigitalVideoDisc);
    }

    public DigitalVideoDisc(String title, String category , float cost) {
        super(title, category, cost);
        nbDigitalVideoDisc += 1;
        this.setId(nbDigitalVideoDisc);
        this.setCost(cost);
    }
    
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
        nbDigitalVideoDisc += 1;
        this.setId(nbDigitalVideoDisc);
        this.setCost(cost);
    }
    
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        nbDigitalVideoDisc += 1;
        this.setId(nbDigitalVideoDisc);
        this.setLength(length);
    }

    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getLength() + ": " + this.getCost() + "$"; 
    }

    public boolean isMatch(String titleToCompare) {
        return this.getTitle().equalsIgnoreCase(titleToCompare);
    }

    @Override
    public void play() throws PlayerException {
        // TODO Auto-generated method stub
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }        
    }
    
}
