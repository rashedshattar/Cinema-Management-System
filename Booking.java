package oop;

public class Booking {
    private String selectedMovie;
    private double ticketPrice;
    private int count;

    public Booking(String selectedMovie, double ticketPrice, int count) {
        this.selectedMovie = selectedMovie;
        this.ticketPrice = ticketPrice;
        this.count = count;
    }

    public String getSelectedMovie() {
        return selectedMovie;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getCount() {
        return count;
    }

    public void setSelectedMovie(String selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setCount(int count) {
        this.count = count;
    }

    protected double calculateTotal() {
        return ticketPrice * count;
    }

    public void printSummary() {
        double total = calculateTotal();
        double displayTotal = Math.round(total * 100.0) / 100.0;

        System.out.println("\n--- Booking Summary ---");
        System.out.println("Movie: " + selectedMovie);
        System.out.println("Ticket Price: $" + ticketPrice);
        System.out.println("Number of Tickets: " + count);
        System.out.println("Total Price: $" + displayTotal);
        System.out.println("Thank you for booking with us!");
    }

   
}
