package oop;

public class Catalog {
    private String[] movies;
    private double[] prices;

    public Catalog(String[] movies, double[] prices) {
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

    public void insertionSort() {
        for (int i = 1; i < prices.length; i++) {
            double price1 = prices[i];
            String movie1 = movies[i];
            int j = i - 1;

            while (j >= 0 && prices[j] > price1) {
                prices[j + 1] = prices[j];
                movies[j + 1] = movies[j];
                j--;
            }
            prices[j + 1] = price1;
            movies[j + 1] = movie1;
        }
    }

    public void display() {
        System.out.println("Available Movies (Sorted by Price):");
        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i] + " - $" + prices[i]);
        }
    }
}
