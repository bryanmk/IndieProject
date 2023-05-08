package questie.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import quest.api.Quest;
//import questie.entity.QuestAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Properties;

import org.json.JSONObject;
import questie.utilities.PropertiesLoader;
import service.TokenGenerator;

public class QuestApiDAO implements PropertiesLoader {

    Properties properties;
    public static String BASE_URL;
    public static String TEST_PATH;
    public static String NAMESPACE;
    public static String LOCALE;
    private final Logger logger = LogManager.getLogger(this.getClass());
    TokenGenerator tokenGenerator = new TokenGenerator();

    /**
     * Load Properties for correct URI
     */
    private void loadProperties() {
        try {
            properties = loadProperties("questie.api.properties");
            BASE_URL = properties.getProperty("baseURL");
            NAMESPACE = properties.getProperty("namespace");
            LOCALE = properties.getProperty("locale");
            TEST_PATH = properties.getProperty("testPath");
        } catch (Exception e) {
            logger.error("Error loading properties..." + e);
        }
    }

    /**
     * Gets quests by quest name
     * @return quests by quest name
     */
    public Quest getByQuestTitle(String questTitle) throws IOException {

        JSONObject token = tokenGenerator.getToken();

        Client client = ClientBuilder.newClient();

        WebTarget target =
//                client.target(BASE_URL + TEST_PATH +"?namespace=" + NAMESPACE + "&locale=" + LOCALE + "&access_token=" + token.getString("access_token"));
                client.target("https://us.api.blizzard.com/data/wow/quest/2?namespace=static-us&locale=en_US&access_token="  + token.getString("access_token"));
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

    public Quest getAnswer(Integer number){

//        JSONObject token = tokenGenerator.getToken();
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://us.api.blizzard.com/data/wow/quest/" + number + "?namespace=static-us&locale=en_US&access_token=EUozqdnv06l32nuRreTP125XJK6kqCRMes");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Quest quest = null;
        try {
            quest = mapper.readValue(response, Quest.class);
        } catch (JsonProcessingException ignore) {
            logger.error("Error processing JSON... " + ignore);
        }
        return quest;
    }
}
