package event_driven;

import java.awt.event.*;
import javax.swing.*;

public class CinemaProjectEventDriven {
    static String[] movies = {"Avengers", "Inception", "Titanic", "Joker", "Frozen"};
    static double[] prices = {10.5, 8.0, 7.5, 9.0, 6.0};

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

    public static void main(String[] args) {
        insertionSort(movies, prices);  

        JFrame frame = new JFrame("Cinema Booking");
        frame.setLayout(null);

        JLabel label1 = new JLabel("Choose Movie:");
        label1.setBounds(30, 30, 120, 25);
        frame.add(label1);

        String[] displayItems = new String[movies.length];
        for (int i = 0; i < movies.length; i++) {
            displayItems[i] = movies[i] + " ($" + prices[i] + ")";
        }
        JComboBox<String> cmovies = new JComboBox<>(displayItems);
        cmovies.setBounds(150, 30, 180, 25);
        frame.add(cmovies);

        JLabel label2 = new JLabel("Tickets:");
        label2.setBounds(30, 70, 120, 25);
        frame.add(label2);

        JTextField txtTickets = new JTextField();
        txtTickets.setBounds(150, 70, 180, 25);
        frame.add(txtTickets);

        JButton btnBook = new JButton("Book Now");
        btnBook.setBounds(150, 110, 180, 30);
        frame.add(btnBook);
        
        JButton btnBook2 = new JButton("Booked");
        btnBook2.setBounds(30, 160, 320, 25);
        frame.add(btnBook2);
        

        JLabel lblSelected = new JLabel("Selected movie: ");
        lblSelected.setBounds(30, 160, 320, 25);
        frame.add(lblSelected);

        JLabel success = new JLabel("");
        success.setBounds(30, 190, 320, 25);
        frame.add(success);
        
        cmovies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chosen = (String) cmovies.getSelectedItem();
                lblSelected.setText("Selected movie: " + chosen);
            }
        });

        btnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = cmovies.getSelectedIndex();
                String text = txtTickets.getText().trim();

                try {
                    int ticketCount = Integer.parseInt(text);
                    
                   if (ticketCount <= 0) {

                        JOptionPane.showMessageDialog(frame, "Please enter a positive number of tickets.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String selectedMovie = movies[selectedIndex];
                    double ticketPrice = prices[selectedIndex];
                    double totalPrice = ticketPrice * ticketCount;

                    System.out.println("Booking Summary");
                    System.out.println("-------------------------");
                    System.out.println("Movie: " + selectedMovie);
                    System.out.println("Ticket price: $" + ticketPrice);
                    System.out.println("Tickets: " + ticketCount);
                    System.out.printf("TOTAL: $%.2f%n", totalPrice);
                    System.out.println("Thank you for booking with us!");

                    success.setText("Successfully booked");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for tickets.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        txtTickets.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                success.setText("Tickets entered: " + txtTickets.getText());
            }
        });

        btnBook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                success.setText("Click to confirm your booking!");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                success.setText("");
            }
        });
        btnBook2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                success.setText("movie is booked");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                success.setText("");
            }
        });
        btnBook2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("The movie is booked");
				
			}
		} );

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}
