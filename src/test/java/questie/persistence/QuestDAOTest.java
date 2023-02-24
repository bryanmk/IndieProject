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
    GenericDAO questDAO;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new QuestDAO();
        questDAO = new GenericDAO(Quest.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies getAllQuests success.
     */
    @Test
    void getAllQuestsSuccess() {
        List<Quest> quests = questDAO.getAll();
        assertEquals(10, quests.size());
    }

    /**
     * Verifies a quest is returned correctly based on Id search.
     */
    @Test
    void getByIdSuccess() {
        Quest retrievedQuest = (Quest)questDAO.getById(3);
        assertNotNull(retrievedQuest);
        assertEquals("Off To Area 52", retrievedQuest.getQuestName());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        Quest newQuest = new Quest("Repeat After Me", 10, 1400, "Maldraxxus", "Signet of the Learned");
        int id = questDAO.insert(newQuest);
        assertNotEquals(0,id);
        Quest insertedQuest = (Quest)questDAO.getById(id);
        assertEquals("Repeat After Me", insertedQuest.getQuestName());
    }

    /**
     * Verify successful delete of quest
     */
    @Test
    void deleteSuccess() {
        questDAO.delete(questDAO.getById(3));
        assertNull(questDAO.getById(3));
    }

    /**
     * Verifies update success.
     */
    @Test
    void updateSuccess() {
        String newQuestName = "Cursed to Wither";
        Quest questToUpdate = (Quest)questDAO.getById(1);
        questToUpdate.setQuestName(newQuestName);
        logger.info("new quest name: " + newQuestName);
        questDAO.saveOrUpdate(questToUpdate);
        Quest retrievedQuest = (Quest)questDAO.getById(1);
        assertEquals(newQuestName, retrievedQuest.getQuestName());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Quest> quests = questDAO.getByPropertyEqual("questName", "A Dying World");
        assertEquals(1, quests.size());
        assertEquals(1, quests.get(0).getQuestId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Quest> quests = questDAO.getByPropertyLike("questName", "the");
        assertEquals(3, quests.size());
    }

    /**
     * Verifies getByQuestName success.
     */
    @Test
    void getByQuestNameSuccess() {
        List<Quest> quests = dao.getByQuestName("the");
        assertEquals(3, quests.size());
    }
}