package e3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

enum TypeArtist {
    OTHER,
    CHARACTER,
    PERSON,
    GROUP,
    ORCHESTRA,
    CHOIR
}

class Artist implements Comparable<Artist> {
    private String id;
    private String name;
    private TypeArtist type;
    private String area;
    private ArrayList<Double> Ratings;
    private ArrayList<String> genres;

    public Artist(String id, String name, TypeArtist type, String area, ArrayList<Double> Ratings, ArrayList<String> genres) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.area = area;
        this.Ratings = Ratings;
        this.genres = genres;

    }

    public String getName() {
        return name;
    }

    public List<String> getGenres() {
        return genres;
    }

    public TypeArtist getType() {
        return TypeArtist.valueOf(type.name());
    }

    public String getArea() {
        return area;
    }

    private double getAverageRating() {
        if (Ratings.isEmpty())
            return 0.0;

        double sum = 0;
        for (double rating : Ratings)
            sum += rating;

        return sum / Ratings.size();
    }

    private int getNumGenres(){
        return genres.size();
    }

    public static Comparator<Artist> RatingComparatorDescender() {
        return Comparator.comparingDouble(Artist::getAverageRating).reversed();
    }

    public static Comparator<Artist> EclecticismComparatorAscender() {
        return Comparator.comparingInt(Artist::getNumGenres);
    }

    public static Comparator<Artist> NameComparatorAscender() {
        return Comparator.comparing(Artist::getName);
    }

    public static Comparator<Artist> TypeComparatorDescender() {
        return Comparator.comparing(Artist::getType).reversed();
    }

    @Override
    public int compareTo(Artist o) {
        return this.id.compareTo(o.id);
    }
}

