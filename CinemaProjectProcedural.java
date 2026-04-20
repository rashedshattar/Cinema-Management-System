 package procedural;
import java.util.Scanner;

public class CinemaProjectProcedural {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] movies = {"Avengers", "Inception", "Titanic", "Joker", "Frozen"};
        double[] prices = {10.5, 8.0, 7.5, 9.0, 6.0};

        displayMovies(movies, prices, sc);
	}
        
    public static void insertionSort(String[] movies, double[] prices) {
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
    

    public static void displayMovies(String[] movies, double[] prices, Scanner sc) {
        insertionSort(movies, prices);

        System.out.println("Available Movies (Sorted by Price):");
        for (int i = 1; i < movies.length; i++) {
            System.out.println((i) + ". " + movies[i-1] + " - $" + prices[i-1]);
        }

        System.out.print("Please choose a movie (1-" + movies.length + "): ");
        int choice = sc.nextInt();
        if (choice < 1 || choice > movies.length) {
            System.out.println("Invalid choice. please choose again...");
            displayMovies(movies, prices, sc);
            return;
        }

        String selectedMovie = movies[choice - 1];
        double ticketPrice = prices[choice - 1];

        System.out.print("Enter number of tickets: ");
        int count = sc.nextInt();

        double total = ticketPrice * count;

        System.out.println("\n--- Booking Summary ---");
        System.out.println("Movie: " + selectedMovie);
        System.out.println("Ticket Price: $" + ticketPrice);
        System.out.println("Number of Tickets: " + count);
        System.out.println("Total Price: $" + total);
        System.out.println("Thank you for booking with us!");
    }

  
    
}
