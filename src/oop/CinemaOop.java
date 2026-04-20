package oop;

import java.util.Scanner;

public class CinemaOop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] movies = {"Avengers", "Inception", "Titanic", "Joker", "Frozen"};
        double[] prices = {10.5, 8.0, 7.5, 9.0, 6.0};

        Catalog catalog = new Catalog(movies, prices);

        catalog.insertionSort();
        catalog.display();

        int choice;

        System.out.print("Please choose a movie (1-" + movies.length + "): ");
        choice = sc.nextInt();
        while (choice <= 0 || choice > movies.length) {
            System.out.println("Invalid choice. please choose again...");
            catalog.display();
            System.out.print("Please choose a movie (1-" + movies.length + "): ");
            choice = sc.nextInt();
        }

        String selectedMovie = movies[choice - 1];
        double ticketPrice = prices[choice - 1];

        System.out.print("Enter number of tickets: ");
        int count = sc.nextInt();
        
        System.out.print("Do you want VIP tickets? (yes/no): ");
        String vipChoice = sc.next();

        Booking booking;
        if (vipChoice.equalsIgnoreCase("yes")) {
            booking = new VipBooking(selectedMovie, ticketPrice, count);
        } else {
            booking = new Booking(selectedMovie, ticketPrice, count);
        }

        booking.printSummary();

    }
}
