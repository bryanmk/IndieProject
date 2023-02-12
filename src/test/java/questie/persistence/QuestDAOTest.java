package questie.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import questie.entity.Quest;
import questie.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Quest dao test.
 */
class QuestDAOTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    QuestDAO dao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new QuestDAO();
    }

    /**
     * Verifies getAllUsers success.
     */
    @Test
    void getAllQuestsSuccess() {
        List<Quest> quests = dao.getAll();
        assertEquals(10, quests.size());
    }

    /**
     * Verifies getUsersByLastName success.
     */
//    @Test
//    void getUsersByLastNameSuccess() {
//        List<Quest> quests = dao.getByLastName("c");
//        assertEquals(3, quests.size());
//    }

    /**
     * Verifies a user is returned correctly based on Id search.
     */
//    @Test
//    void getByIdSuccess() {
//        Quest retrievedQuest = dao.getById(3);
//        assertNotNull(retrievedQuest);
//        assertEquals("Barney", retrievedQuest.getQuestName());
//    }

    /**
     * Verify successful insert of a user
     */
//    @Test
//    void insertSuccess() {
//
//        User newUser = new User("Fred", "Flintstone", "fflintstone");
//        int id = dao.insert(newUser);
//        assertNotEquals(0,id);
//        User insertedUser = dao.getById(id);
//        assertEquals("Fred", insertedUser.getFirstName());
//    }

    /**
     * Verify successful delete of user
     */
//    @Test
//    void deleteSuccess() {
//        dao.delete(dao.getById(3));
//        assertNull(dao.getById(3));
//    }

    /**
     * Verifies update success.
     */
//    @Test
//    void updateSuccess() {
//        String newLastName = "Davis";
//        User userToUpdate = dao.getById(3);
//        userToUpdate.setLastName(newLastName);
//        logger.info("new last name: " + newLastName);
//        dao.saveOrUpdate(userToUpdate);
//        User retrievedUser = dao.getById(3);
//        assertEquals(newLastName, retrievedUser.getLastName());
//    }

    /**
     * Verify successful get by property (equal match)
     */
//    @Test
//    void getByPropertyEqualSuccess() {
//        List<User> users = dao.getByPropertyLike("lastName", "Curry");
//        assertEquals(1, users.size());
//        assertEquals(3, users.get(0).getId());
//    }

    /**
     * Verify successful get by property (like match)
     */
//    @Test
//    void getByPropertyLikeSuccess() {
//        List<User> users = dao.getByPropertyLike("lastName", "c");
//        assertEquals(3, users.size());
//    }
}