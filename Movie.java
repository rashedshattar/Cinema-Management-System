package oop;

public class Movie {
    private String[] movies;
    private double[] prices;

    public Movie(String[] movies, double[] prices) {
        this.movies = movies;
        this.prices = prices;
    }

    public String[] getMovies() {
        return movies;
    }

    public double[] getPrices() {
        return prices;
    }

    public void setMovies(String[] movies) {
        this.movies = movies;
    }

    public void setPrices(double[] prices) {
        this.prices = prices;
    }
}
