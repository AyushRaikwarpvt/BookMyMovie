package Entity;

public class shows {
    int show_id ;
    int movie_id;
    int theater_id;
    String Timing;
    int available_Seat ;

    public shows(int show_id, int movie_id, int theater_id, String timing, int available_Seat) {
        this.show_id = show_id;
        this.movie_id = movie_id;
        this.theater_id = theater_id;
        Timing = timing;
        this.available_Seat = available_Seat;
    }


    public int getShow_id() {
        return show_id;
    }

    public void setShow_id(int show_id) {
        this.show_id = show_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public String getTiming() {
        return Timing;
    }

    public void setTiming(String timing) {
        Timing = timing;
    }

    public int getAvailable_Seat() {
        return available_Seat;
    }

    public void setAvailable_Seat(int available_Seat) {
        this.available_Seat = available_Seat;
    }
}
