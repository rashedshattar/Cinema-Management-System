package oop;

public class VipBooking extends Booking {
    public VipBooking(String selectedMovie, double ticketPrice, int count) {
        super(selectedMovie, ticketPrice, count);
    }
    protected double calculateTotal() {
        double vipFeePerTicket = 3.0;
        return (getTicketPrice() + vipFeePerTicket) * getCount();
    }
    public void printSummary() {
        System.out.println("[VIP BOOKING]");
        super.printSummary();
    }
}
