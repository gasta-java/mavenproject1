
package org.glassfish.movieplex7.client;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author Arun Gupta
 */
@Named
@SessionScoped
public class MovieBackingBean implements Serializable {

    int movieId;
    String movieName;
    String actors;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int mid) {
        this.movieId = mid;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
}
