package questie.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import questie.entity.Favorite;
import questie.entity.User;
import questie.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class UserDAOTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    UserDAO dao;

    GenericDAO userDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new UserDAO();
        userDao = new GenericDAO(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies getAllUsers success.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = userDao.getAll();
        assertEquals(6, users.size());
    }

    /**
     * Verifies a user is returned correctly based on Id search.
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)userDao.getById(3);
        assertNotNull(retrievedUser);
        assertEquals("Barney", retrievedUser.getFirstName());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertWithFavoriteSuccess() {

        User newUser = new User("Fred", "Flintstone", "fflintstone");

        Favorite favorite = new Favorite(newUser);

        newUser.addFavorite(favorite);

        int id = userDao.insert(newUser);

        assertNotEquals(0,id);
        User insertedUser = (User)userDao.getById(id);
        assertEquals("Fred", insertedUser.getFirstName());
        assertEquals(1, insertedUser.getFavorites().size());
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        userDao.delete(userDao.getById(3));
        assertNull(userDao.getById(3));
    }

    /**
     * Verifies update success.
     */
    @Test
    void updateSuccess() {
        String newLastName = "Davis";
        User userToUpdate = (User)userDao.getById(3);
        userToUpdate.setLastName(newLastName);
        logger.info("new last name: " + newLastName);
        userDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)userDao.getById(3);
        assertEquals(newLastName, retrievedUser.getLastName());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = userDao.getByPropertyEqual("lastName", "Curry");
        assertEquals(1, users.size());
        assertEquals(3, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = userDao.getByPropertyLike("lastName", "c");
        assertEquals(3, users.size());
    }

    /**
     * Verifies getUsersByLastName success.
     */
    @Test
    void getUsersByLastNameSuccess() {
        List<User> users = dao.getByLastName("c");
        assertEquals(3, users.size());
    }
}