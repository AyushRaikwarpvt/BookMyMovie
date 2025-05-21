package Service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BookMyMovieApp {

        public static void main(String[] args) {
                BookMyMoviesys mbs = new BookMyMoviesys();
                Scanner sc = new Scanner(System.in);

                System.out.println("Enter city:");
                String city = sc.next();
                mbs.DiplaysThreaters(city);

                System.out.println("Enter Theater Id:");
                int theaterId = sc.nextInt();
                System.out.println("Enter Movie Id:");
                int movieId = sc.nextInt();

                mbs.displayShows(movieId, theaterId);

                System.out.println("\nEnter Show Id:");
                int showId = sc.nextInt();

                // Show available and already booked seats
                mbs.showAvailableSeats(showId);
                mbs.showBookedSeats(showId);

                System.out.println("Enter comma separated seat numbers to book (e.g. A1,A2):");
                sc.nextLine(); // clear buffer
                String[] seatsInput = sc.nextLine().split(",");
                List<String> seatsToBook = Arrays.asList(seatsInput);

                mbs.bookticket(1, showId, seatsToBook);
        }
}
