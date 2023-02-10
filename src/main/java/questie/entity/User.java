package questie.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * User javabean.
 */
@Entity(name = "User")
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name= "first_name")
    private String firstName;
    @Column(name= "last_name")
    private String lastName;
    @Column(name= "gamertag")
    private String gamertag;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param gamertag  the gamertag
     */
    public User(String firstName, String lastName, String gamertag) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gamertag = gamertag;
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param gamertag  the gamertag
     * @param id        the id
     */
    public User(String firstName, String lastName, String gamertag, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gamertag = gamertag;
        this.id = id;
    }

    /**
     * Gets user id.
     *
     * @return user id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets user id.
     *
     * @param id user id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user first name.
     *
     * @return user first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets user first name.
     *
     * @param firstName user first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets user last name.
     *
     * @return user last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets user last name.
     *
     * @param lastName user last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user gamertag.
     *
     * @return user gamertag
     */
    public String getGamertag() {
        return gamertag;
    }

    /**
     * Sets user gamertag.
     *
     * @param gamertag user gamertag
     */
    public void setGamertag(String gamertag) {
        this.gamertag = gamertag;
    }

    /**
     * Creates a string representation of a User.
     * @return string representation of a User.
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gamertag='" + gamertag + '\'' +
                '}';
    }
}
