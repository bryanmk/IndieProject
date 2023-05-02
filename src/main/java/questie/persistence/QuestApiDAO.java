package questie.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import quest.api.Quest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class QuestApiDAO {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets quests by quest name
     * @return quests by quest name
     */
    public Quest getByQuestTitle(String questTitle) {

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://us.api.blizzard.com/data/wow/quest/2?namespace=static-us&locale=en_US&access_token=EUvdZqoMbYkioJhUHNkvp678nJ1mvtMeZ5");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Quest quest = null;
        try {
            quest = mapper.readValue(response, Quest.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return quest;
    }
}
