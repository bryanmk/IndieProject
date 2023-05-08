package questie.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import quest.api.QuestAPI;
//import questie.entity.Quest;
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

//    /**
//     * Creating the dao.
//     */
//    @BeforeEach
//    void setUp() {
//        dao = new QuestDAO();
//        questDAO = new GenericDAO(Quest.class);
//        Database database = Database.getInstance();
//        database.runSQL("cleandb.sql");
//    }

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new QuestDAO();
        questDAO = new GenericDAO(QuestAPI.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

//    /**
//     * Verifies getAllQuests success.
//     */
//    @Test
//    void getAllQuestsSuccess() {
//        List<Quest> quests = questDAO.getAll();
//        assertEquals(10, quests.size());
//    }

    /**
     * Verifies getAllQuests success.
     */
    @Test
    void getAllQuestsSuccess() {
        List<QuestAPI> quests = questDAO.getAll();
        assertEquals(52, quests.size());
    }

//    /**
//     * Verifies a quest is returned correctly based on Id search.
//     */
//    @Test
//    void getByIdSuccess() {
//        Quest retrievedQuest = (Quest)questDAO.getById(3);
//        assertNotNull(retrievedQuest);
//        assertEquals("Off To Area 52", retrievedQuest.getQuestName());
//    }

    /**
     * Verifies a quest is returned correctly based on Id search.
     */
    @Test
    void getByIdSuccess() {
        QuestAPI retrievedQuest = (QuestAPI) questDAO.getById(313);
        assertNotNull(retrievedQuest);
        assertEquals("Forced to Watch from Afar", retrievedQuest.getTitle());
    }

//    /**
//     * Verify successful insert of a user
//     */
//    @Test
//    void insertSuccess() {
//
//        Quest newQuest = new Quest("Repeat After Me", 10, 1400, "Maldraxxus", "Signet of the Learned");
//        int id = questDAO.insert(newQuest);
//        assertNotEquals(0,id);
//        Quest insertedQuest = (Quest)questDAO.getById(id);
//        assertEquals("Repeat After Me", insertedQuest.getQuestName());
//    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        QuestAPI newQuest = new QuestAPI(1, "Repeat After Me", 10, "Maldraxxus", 1400, 100, 50, 10);
        int id = questDAO.insert(newQuest);
        assertNotEquals(0,id);
        QuestAPI insertedQuest = (QuestAPI) questDAO.getById(id);
        assertEquals("Repeat After Me", insertedQuest.getTitle());
    }

//    /**
//     * Verify successful delete of quest
//     */
//    @Test
//    void deleteSuccess() {
//        questDAO.delete(questDAO.getById(3));
//        assertNull(questDAO.getById(3));
//    }

    /**
     * Verify successful delete of quest
     */
    @Test
    void deleteSuccess() {
        questDAO.delete(questDAO.getById(313));
        assertNull(questDAO.getById(313));
    }

//    /**
//     * Verifies update success.
//     */
//    @Test
//    void updateSuccess() {
//        String newQuestName = "Cursed to Wither";
//        Quest questToUpdate = (Quest)questDAO.getById(1);
//        questToUpdate.setQuestName(newQuestName);
//        logger.info("new quest name: " + newQuestName);
//        questDAO.saveOrUpdate(questToUpdate);
//        Quest retrievedQuest = (Quest)questDAO.getById(1);
//        assertEquals(newQuestName, retrievedQuest.getQuestName());
//    }

    /**
     * Verifies update success.
     */
    @Test
    void updateSuccess() {
        String newQuestName = "Cursed to Wither";
        QuestAPI questToUpdate = (QuestAPI) questDAO.getById(25500);
        questToUpdate.setTitle(newQuestName);
        logger.info("new quest name: " + newQuestName);
        questDAO.saveOrUpdate(questToUpdate);
        QuestAPI retrievedQuest = (QuestAPI) questDAO.getById(25500);
        assertEquals(newQuestName, retrievedQuest.getTitle());
    }

//    /**
//     * Verify successful get by property (equal match)
//     */
//    @Test
//    void getByPropertyEqualSuccess() {
//        List<Quest> quests = questDAO.getByPropertyEqual("questName", "A Dying World");
//        assertEquals(1, quests.size());
//        assertEquals(1, quests.get(0).getQuestId());
//    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<QuestAPI> quests = questDAO.getByPropertyEqual("title", "Honor Students");
        assertEquals(1, quests.size());
        assertEquals(6387, quests.get(0).getId());
    }

//    /**
//     * Verify successful get by property (like match)
//     */
//    @Test
//    void getByPropertyLikeSuccess() {
//        List<Quest> quests = questDAO.getByPropertyLike("questName", "the");
//        assertEquals(3, quests.size());
//    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<QuestAPI> quests = questDAO.getByPropertyLike("title", "the");
        assertEquals(17, quests.size());
    }

    /**
     * Verifies getByQuestName success.
     */
    @Test
    void getByQuestNameSuccess() {
        List<QuestAPI> quests = dao.getByQuestName("the");
        assertEquals(17, quests.size());
    }
}