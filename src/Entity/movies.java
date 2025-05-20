package Entity;

public class movies {

    int movie_id ;
    String title ;
    String genre;
    String lang;
    int duration ;

    public movies(int movie_id, String title, String genre, String lang, int duration) {
        this.movie_id = movie_id;
        this.title = title;
        this.genre = genre;
        this.lang = lang;
        this.duration = duration;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
