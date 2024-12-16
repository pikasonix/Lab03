package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category, String director, float cost, String artist) {
        super(id, title, category, cost);
        this.setDirector(director);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, String artist, ArrayList<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, String director, int length, float cost, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String director, int length, float cost, String artist, ArrayList<Track> tracks) {
        super(title, category, director, length, cost);
        this.artist = artist;
        this.tracks = tracks;
    }



    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
        else System.out.println("Fail to add! The track is existed");
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        }
        else System.out.println("Fail to delete! The track is not exist");
    }

    @Override
    public int getLength() {
        int l = 0;
        for (Track t : tracks) {
            l += t.getLength();
        }

        return l;
    }

    @Override
    public void play() {
        System.out.println("Artist: " + this.artist);
        System.out.println("List of track");
        for (Track t : tracks) {
            t.play();
        }
    }

    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getArtist() + " - " + this.getDirector() + " - " + this.getCategory() + " - "  + this.getLength() + " - " + this.getCost() + "$";
    }
}
