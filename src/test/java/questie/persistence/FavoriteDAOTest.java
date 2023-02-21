package questie.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import questie.entity.User;
import questie.entity.Favorite;
import questie.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Favorite dao test.
 */
class FavoriteDAOTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    FavoriteDAO dao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new FavoriteDAO();
    }

    /**
     * Verifies getAllFavorites success.
     */
    @Test
    void getAllFavoritesSuccess() {
        List<Favorite> favorites = dao.getAll();
        assertEquals(11, favorites.size());
    }

    /**
     * Verifies a favorite is returned correctly based on Id search.
     */
    @Test
    void getByIdSuccess() {
        Favorite retrievedFavorite = dao.getById(3);
        assertNotNull(retrievedFavorite);
        assertEquals(3, retrievedFavorite.getId());
    }

    /**
     * Verify successful insert of a favorite
     */
    @Test
    void insertWithFavoriteSuccess() {

        UserDAO userDao = new UserDAO();
        User user = userDao.getById(1);

        Favorite newFavorite = new Favorite(user);
        user.addFavorite(newFavorite);

        int id = dao.insert(newFavorite);

        assertNotEquals(0,id);
        Favorite insertedFavorite = dao.getById(id);
        assertEquals(18, insertedFavorite.getId());
        assertEquals(3, user.getFavorites().size());
        assertEquals("Joe", user.getFirstName());
    }

    /**
     * Verify successful delete of favorite
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Verifies update success.
     */
//    @Test
//    void updateSuccess() {
//        String newLastName = "Davis";
//        Favorite favoriteToUpdate = dao.getById(3);
//        favoriteToUpdate.setLastName(newLastName);
//        logger.info("new last name: " + newLastName);
//        dao.saveOrUpdate(favoriteToUpdate);
//        Favorite retrievedFavorite = dao.getById(3);
//        assertEquals(newLastName, retrievedFavorite.getLastName());
//    }

    /**
     * Verify successful get by property (equal match)
     */
//    @Test
//    void getByPropertyEqualSuccess() {
//        List<Favorite> favorites = dao.getByPropertyEqual("lastName", "Curry");
//        assertEquals(1, favorites.size());
//        assertEquals(3, favorites.get(0).getId());
//    }

    /**
     * Verify successful get by property (like match)
     */
//    @Test
//    void getByPropertyLikeSuccess() {
//        List<Favorite> favorites = dao.getByPropertyLike("lastName", "c");
//        assertEquals(3, favorites.size());
//    }
}
