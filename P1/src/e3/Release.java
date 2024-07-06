package e3;


import java.util.*;

public class Release {
    private final String releaseId;
    private String title;
    private String artist;
    private List<Track> tracklist;


    public Release(String releaseId) {
        this.releaseId = releaseId;
        this.tracklist = new LinkedList<>();
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addTrack(Track track) {
        tracklist.add(track);
    }

    public String getReleaseId() {
        return releaseId;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public List<Track> getTracklist() {
        return tracklist;
    }

    @Override
    public String toString() {
        return "Release{" +
                "releaseId=" + releaseId +
                ", title='" + title + '\'' + // CAMBIAR
                ", artist='" + artist + '\'' +
                ", tracklist=" + tracklist +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Release release = (Release) o;
        return Objects.equals(new HashSet<>(tracklist), new HashSet<>(release.tracklist));
    }

    @Override
    public int hashCode() {
        return Objects.hash(new HashSet<>(tracklist));
    }
}
