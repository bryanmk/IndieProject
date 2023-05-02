package service;

import questie.entity.Quest;
import questie.persistence.GenericDAO;
import questie.persistence.QuestApiDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/QuestieService")
public class QuestieService {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDAO genericDao = new GenericDAO(Quest.class);
    QuestApiDAO dao = new QuestApiDAO();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllWords() {
        List<Quest> wordList = genericDao.getAll();
        return Response.status(200).entity(wordList.toString()).build();
    }


    //    GET /WorldService/query?word_id={id}
    @GET
    @Path("/getById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWordByID(@QueryParam("quest_id") int id) {
        Quest quest = (Quest)genericDao.getById(id);
        return Response.status(200).entity(quest.toString()).build();
    }

}

