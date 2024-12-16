package hust.soict.dsai.aims.media;

public abstract class Disc extends Media implements Playable {
    private int length;
    private String director;

    public Disc() {
        super();
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);

    }

    public Disc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
