import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import quest.api.Quest;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testswapiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =

                client.target("https://us.api.blizzard.com/data/wow/quest/2?namespace=static-us&locale=en_US&access_token=EUvdZqoMbYkioJhUHNkvp678nJ1mvtMeZ5");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Quest quest = mapper.readValue(response, Quest.class);
        assertEquals("Sharptalon's Claw", quest.getTitle());
    }
}
