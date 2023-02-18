package questie.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The type Favorite.
 */
@Entity(name = "Favorite")
@Table(name = "Favorite")
public class Favorite {

    private int id;
    private User user;

    /**
     * No argument constructor.
     */
    public Favorite() {
    }

    /**
     * Instantiates a new Favorite.
     *
     * @param user the user
     */
    public Favorite(User user) {
        this.user = user;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Creates a string representation of a user's favorites.
     * @return string representation of a user's favorites.
     */
    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
