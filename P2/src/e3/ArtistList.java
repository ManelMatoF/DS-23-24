package e3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;

class ArtistList {
    private List<Artist> artists;

    public ArtistList() {
        this.artists = new ArrayList<>();
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public List<Artist> getArtists() { return artists; }

    public void NaturalSort() {
        Collections.sort(artists);
    }

    public void ComparatorSort(Comparator<Artist> comparator) {
        artists.sort(comparator);
    }

}
