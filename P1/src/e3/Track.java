package e3;

import java.util.Objects;

public class Track {
    private String trackPos;
    private String trackId;
    private String artist;
    private String title;
    private int duration;


    public Track(String trackPos, String trackId, String artist, String title, int duration) {
        this.trackPos = trackPos;
        this.trackId = trackId;
        this.artist = artist;
        this.title = title;
        this.duration = duration;
    }

    public String getTrackPos() {
        return trackPos;
    }

    public String getTrackId() {
        return trackId;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackPos='" + trackPos + '\'' +
                ", trackId='" + trackId + '\'' +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return  Objects.equals(trackId, track.trackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackId);
    }
}
