package questie.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestApiDAOTest {

    @Test
    void getByQuestTitle() {
        QuestApiDAO dao = new QuestApiDAO();
        assertEquals(2, dao.getByQuestTitle("Sharptalon's Claw").getId());
        assertEquals("Sharptalon's Claw", dao.getByQuestTitle("Sharptalon's Claw").getTitle());
    }
}