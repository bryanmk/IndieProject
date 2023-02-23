package questie.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import questie.entity.User;
import questie.entity.Quest;
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
    GenericDAO favoriteDAO;
    GenericDAO userDAO;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {

        favoriteDAO = new GenericDAO(Favorite.class);
        userDAO = new GenericDAO(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies getAllFavorites success.
     */
    @Test
    void getAllFavoritesSuccess() {
        List<Favorite> favorites = (List<Favorite>)favoriteDAO.getAll();
        assertEquals(11, favorites.size());
    }

    /**
     * Verifies a favorite is returned correctly based on Id search.
     */
    @Test
    void getByIdSuccess() {
        Favorite retrievedFavorite = (Favorite)favoriteDAO.getById(3);
        assertNotNull(retrievedFavorite);
        assertEquals(3, retrievedFavorite.getId());
    }

    /**
     * Verify successful insert of a favorite
     */
    @Test
    void insertWithFavoriteSuccess() {

        User user = (User)userDAO.getById(1);

        Favorite newFavorite = new Favorite(user);
        user.addFavorite(newFavorite);

        int id = favoriteDAO.insert(newFavorite);

        assertNotEquals(0,id);
        assertEquals(3, user.getFavorites().size());
        assertEquals("Joe", user.getFirstName());
    }

    /**
     * Verify successful delete of favorite
     */
    @Test
    void deleteSuccess() {
        favoriteDAO.delete(favoriteDAO.getById(3));
        assertNull(favoriteDAO.getById(3));
    }

    /**
     * Verifies update success.
     */
    @Test
    void updateSuccess() {

        User user = (User)userDAO.getById(5);
        Favorite favoriteToUpdate = (Favorite)favoriteDAO.getById(3);
        favoriteToUpdate.setUser(user);
        logger.info("new user:" + user.getFirstName());
        favoriteDAO.saveOrUpdate(favoriteToUpdate);
        Favorite retrievedFavorite = (Favorite)favoriteDAO.getById(3);
        assertEquals("Dianne", retrievedFavorite.getUser().getFirstName());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Favorite> favorites = favoriteDAO.getByPropertyEqual("id", "2");
        assertEquals(1, favorites.size());
        assertEquals(2, favorites.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
//    @Test
//    void getByPropertyLikeSuccess() {
//        List<Favorite> favorites = dao.getByPropertyLike("lastName", "c");
//        assertEquals(3, favorites.size());
//    }
}
