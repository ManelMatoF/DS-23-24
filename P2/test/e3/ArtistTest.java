package e3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

class ArtistTest {
    private static Artist artist1;
    private static Artist artist2;
    private static Artist artist3;
    private static Artist artist4;
    private static Artist artist5;
    private static Artist artist6;


    @BeforeAll
    static void setUp() {//CAMBIAR ALGUNOS PARAMETROS
        artist1 = new Artist("abcdef", "artist1", TypeArtist.PERSON, "Colombia",
                new ArrayList<>(Arrays.asList(2.5, 5.0, 3.8)),  new ArrayList<>(Arrays.asList("Pop", "Rock")));

        artist2 = new Artist("bacdef", "artist2", TypeArtist.OTHER, "Reino Unido",
                new ArrayList<>(Arrays.asList(3.7, 3.2, 4.8)),  new ArrayList<>(Arrays.asList("Pop", "Electronic", "Rock")));

        artist3 = new Artist("cabdef", "artist3", TypeArtist.GROUP, "Estados Unidos",
                new ArrayList<>(Arrays.asList(1.0, 4.1, 3.3)),  new ArrayList<>(Arrays.asList("Rock", "Folk", "Country", "Jazz", "Heavy Metal", "Electronic")));

        artist4 = new Artist("dabcef", "artist4", TypeArtist.CHOIR, "Francia",
                new ArrayList<>(Arrays.asList(3.7, 3.9, 4.3)),  new ArrayList<>(Arrays.asList("Jazz", "Chanson", "Country")));

        artist5 = new Artist("eabcdf", "artist5", TypeArtist.ORCHESTRA, "Dinamarca",
                new ArrayList<>(Arrays.asList(4.8, 4.9, 4.5)),  new ArrayList<>(Arrays.asList("Jazz", "Swing", "Big Band", "Classical")));

        artist6 = new Artist("fabcde", "artist6", TypeArtist.CHARACTER, "Alemania",
                new ArrayList<>(Arrays.asList()),  new ArrayList<>(Arrays.asList("Classical")));
    }

    @Test
    void testNaturalSort() {
        setUp();
        ArtistList artists = new ArtistList();
        artists.addArtist(artist3);
        artists.addArtist(artist2);
        artists.addArtist(artist1);
        artists.addArtist(artist6);
        artists.addArtist(artist4);
        artists.addArtist(artist5);

        artists.NaturalSort();


        ArtistList sortedArtists = new ArtistList();
        sortedArtists.addArtist(artist1);
        sortedArtists.addArtist(artist2);
        sortedArtists.addArtist(artist3);
        sortedArtists.addArtist(artist4);
        sortedArtists.addArtist(artist5);
        sortedArtists.addArtist(artist6);

        assertEquals(artists.getArtists(), sortedArtists.getArtists());
    }

    @Test
    void testRatingSort(){
        setUp();
        ArtistList artists = new ArtistList();
        artists.addArtist(artist3);
        artists.addArtist(artist2);
        artists.addArtist(artist1);
        artists.addArtist(artist6);
        artists.addArtist(artist4);
        artists.addArtist(artist5);

        artists.ComparatorSort(Artist.RatingComparatorDescender());

        ArtistList sortedArtists = new ArtistList();
        sortedArtists.addArtist(artist5);
        sortedArtists.addArtist(artist4);
        sortedArtists.addArtist(artist2);
        sortedArtists.addArtist(artist1);
        sortedArtists.addArtist(artist3);
        sortedArtists.addArtist(artist6);

        assertEquals(artists.getArtists(), sortedArtists.getArtists());
    }

    @Test
    void testNameSort(){
        setUp();
        ArtistList artists = new ArtistList();
        artists.addArtist(artist3);
        artists.addArtist(artist2);
        artists.addArtist(artist1);
        artists.addArtist(artist6);
        artists.addArtist(artist4);
        artists.addArtist(artist5);

        artists.ComparatorSort(Artist.NameComparatorAscender());

        ArtistList sortedArtists = new ArtistList();
        sortedArtists.addArtist(artist1);
        sortedArtists.addArtist(artist2);
        sortedArtists.addArtist(artist3);
        sortedArtists.addArtist(artist4);
        sortedArtists.addArtist(artist5);
        sortedArtists.addArtist(artist6);

        assertEquals(artists.getArtists(), sortedArtists.getArtists());
    }

    @Test
    void testEclecticismSort(){
        setUp();
        ArtistList artists = new ArtistList();
        artists.addArtist(artist1);
        artists.addArtist(artist2);
        artists.addArtist(artist3);
        artists.addArtist(artist4);
        artists.addArtist(artist5);
        artists.addArtist(artist6);

        artists.ComparatorSort(Artist.EclecticismComparatorAscender());

        ArtistList sortedArtists = new ArtistList();
        sortedArtists.addArtist(artist6);
        sortedArtists.addArtist(artist1);
        sortedArtists.addArtist(artist2);
        sortedArtists.addArtist(artist4);
        sortedArtists.addArtist(artist5);
        sortedArtists.addArtist(artist3);

        assertEquals(artists.getArtists(), sortedArtists.getArtists());
    }

    @Test
    void testTypeSort(){
        setUp();
        ArtistList artists = new ArtistList();
        artists.addArtist(artist3);
        artists.addArtist(artist2);
        artists.addArtist(artist1);
        artists.addArtist(artist6);
        artists.addArtist(artist4);
        artists.addArtist(artist5);

        artists.ComparatorSort(Artist.TypeComparatorDescender());

        ArtistList sortedArtists = new ArtistList();
        sortedArtists.addArtist(artist4);
        sortedArtists.addArtist(artist5);
        sortedArtists.addArtist(artist3);
        sortedArtists.addArtist(artist1);
        sortedArtists.addArtist(artist6);
        sortedArtists.addArtist(artist2);

        assertEquals(artists.getArtists(), sortedArtists.getArtists());

    }
}
