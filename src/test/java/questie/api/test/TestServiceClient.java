import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testswapiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
//                client.target("https://swapi.dev/api/planets/1");
                client.target("https://us.api.blizzard.com/data/wow/quest/2?namespace=static-us&locale=en_US&access_token=EUJ6fmBQkVBhH32BeeYwSEWATagy8RJoQ5");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("{\"_links\":{\"self\":{\"href\":\"https://us.api.blizzard.com/data/wow/quest/2?namespace=static-10.0.5_47621-us\"}},\"id\":2,\"title\":\"Sharptalon's Claw\",\"area\":{\"key\":{\"href\":\"https://us.api.blizzard.com/data/wow/quest/area/331?namespace=static-10.0.5_47621-us\"},\"name\":\"Ashenvale\",\"id\":331},\"description\":\"The mighty hippogryph Sharptalon has been slain, with the claw of the felled beast serving as a testament to your victory.\\n\\nSenani Thunderheart at the Silverwind Refuge will no doubt be interested in seeing this trophy as proof of your deeds.\",\"requirements\":{\"min_character_level\":7,\"max_character_level\":30,\"faction\":{\"type\":\"HORDE\",\"name\":\"Horde\"}},\"rewards\":{\"experience\":4100,\"reputations\":[{\"reward\":{\"key\":{\"href\":\"https://us.api.blizzard.com/data/wow/reputation-faction/76?namespace=static-10.0.5_47621-us\"},\"name\":\"Orgrimmar\",\"id\":76},\"value\":250}],\"money\":{\"value\":105000,\"units\":{\"gold\":10,\"silver\":50,\"copper\":0}}}}", response);
    }
}
