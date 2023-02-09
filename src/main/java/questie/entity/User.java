package questie.entity;

/**
 * User javabean.
 */
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String gamertag;

    /**
     * Instantiates a new User.
     */
    public User() {
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
}
