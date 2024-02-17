package com.example.movieexplorer;

public class Movie {

    private  int movie_id;
    private String title, posterPath, overview;
    private double voteAverage;

    private String releaseDate;


    public Movie(String title, String posterPath, String overview, double voteAverage, String releaseDate, int movie_id) {
        this.title = title;
        this.posterPath = posterPath;
        this.overview = overview;
        this.voteAverage = Math.round(voteAverage);
        this.releaseDate = releaseDate;
        this.movie_id = movie_id;

    }

    public int getMovie_id() {
        return movie_id;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public double getVoteAverage() {
        return voteAverage;
    }



}
