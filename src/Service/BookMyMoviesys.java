package Service;

import Configaure.DataBaseConfig;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class BookMyMoviesys {

    Scanner sc = new Scanner(System.in);

    public void DisplayMovies() {
        try {
            Connection con = DataBaseConfig.getConnection();
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("SELECT * FROM movies");

            System.out.println("---------------Available Movies------------------");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("movie_id") + "  "
                                + rs.getString("title") + "  "
                                + rs.getString("genre") + "  "
                                + rs.getString("lang") + "  "
                                + rs.getInt("duration") + " mins"
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DiplaysThreaters(String city) {
        try {
            Connection con = DataBaseConfig.getConnection();
            PreparedStatement smt = con.prepareStatement("SELECT * FROM theaters WHERE city = ?");
            smt.setString(1, city);
            ResultSet res = smt.executeQuery();

            System.out.println("----------Theaters Available in " + city + "-------------");
            while (res.next()) {
                System.out.println(res.getInt("theater_id") + "  "
                        + res.getString("name") + "  Available in  "
                        + res.getString("city"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayShows(int movieId, int theaterId) {
        try {
            Connection con = DataBaseConfig.getConnection();
            PreparedStatement smt = con.prepareStatement(
                    "SELECT * FROM shows WHERE movie_id = ? AND theater_id = ?"
            );
            smt.setInt(1, movieId);
            smt.setInt(2, theaterId);

            ResultSet rs = smt.executeQuery();

            System.out.println("---------- Available Shows ----------");
            while (rs.next()) {
                System.out.println(
                        "Show ID: " + rs.getInt("show_id") + ", " +
                                "Movie ID: " + rs.getInt("movie_id") + ", " +
                                "Theater ID: " + rs.getInt("theater_id") + ", " +
                                "Timing: " + rs.getString("Timing") + ", " +
                                "Available Seats: " + rs.getInt("available_Seats")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void bookticket(int user_id, int show_id, List<String> selectedseats) {
        Connection con = null;
        try {
            con = DataBaseConfig.getConnection();
            con.setAutoCommit(false);

            boolean AlreadyBookedSeat = false;

            for (String seat : selectedseats) {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM seat WHERE seat_number = ? AND show_id = ?");
                ps.setString(1, seat);
                ps.setInt(2, show_id);
                ResultSet rs = ps.executeQuery();

                if (rs.next() && rs.getBoolean("is_booked")) {
                    AlreadyBookedSeat = true;
                    System.out.println("Seat " + seat + " is already booked. Please choose another seat.");
                }
            }

            if (AlreadyBookedSeat) {
                System.out.println("Booking failed. Some seats are already booked.");
                con.rollback();
                return;
            }

            for (String seat : selectedseats) {
                PreparedStatement ps = con.prepareStatement("UPDATE seat SET is_booked = true WHERE seat_number = ? AND show_id = ?");
                ps.setString(1, seat);
                ps.setInt(2, show_id);
                ps.executeUpdate();
            }

            double seatPrice = 200.0;
            double totalPrice = selectedseats.size() * seatPrice;

            PreparedStatement ps = con.prepareStatement("INSERT INTO booking (user_id, show_id, seats_booked, total_price) VALUES (?, ?, ?, ?)");
            ps.setInt(1, user_id);
            ps.setInt(2, show_id);
            ps.setString(3, String.join(", ", selectedseats));
            ps.setDouble(4, totalPrice);
            ps.executeUpdate();

            con.commit();
            System.out.println("Booking successful! Seats: " + selectedseats + " | Total Price: ₹" + totalPrice);

        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        BookMyMoviesys obj = new BookMyMoviesys();
//        obj.DisplayMovies();
//        obj.DiplaysThreaters("Indore");
        obj.displayShows(1, 1);
    }
}
