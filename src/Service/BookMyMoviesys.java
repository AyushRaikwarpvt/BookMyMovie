package Service;

import Configaure.DataBaseConfig;

import java.sql.*;
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
            smt.setInt(1, movieId);      // 1st ?
            smt.setInt(2, theaterId);    // 2nd ?

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


    public static void main(String[] args) {

        BookMyMoviesys obj = new BookMyMoviesys();
//          obj.DisplayMovies();
//        obj.DiplaysThreaters("Indore");
//        obj.displayShows(1,1);

    }
}
