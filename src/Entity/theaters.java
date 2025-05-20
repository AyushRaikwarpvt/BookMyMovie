package Entity;

public class theaters {
    int theater_id;
    String name ;
    String city;

    public theaters(int theater_id, String name, String city) {
        this.theater_id = theater_id;
        this.name = name;
        this.city = city;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
