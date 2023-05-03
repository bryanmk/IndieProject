package service;

import questie.entity.Quest;
import questie.persistence.GenericDAO;
import questie.persistence.QuestApiDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/quest")
public class QuestieService {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDAO genericDao = new GenericDAO(Quest.class);
    QuestApiDAO dao = new QuestApiDAO();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllQuests() {
        List<Quest> questList = genericDao.getAll();
        return Response.status(200).entity(questList.toString()).build();
    }

    // For testing purposes using localhost
    @GET
    @Path("/getById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuestByID(@PathParam("id") int id) {
        Quest quest = (Quest)genericDao.getById(id);
        return Response.status(200).entity(quest.toString()).build();
    }
//    GetByPropertyEqual takes a string value, need to create a new class in GenericDAO that takes an int to do this
//    @GET
//    @Path("/query")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getQuestByID(@QueryParam("id") int id) {
//        List<Quest> result = genericDao.getByPropertyEqual("id", id);
//        logger.debug("   **** List size: " + result.size());
//        if (result.size() < 1) {
//            return Response.status(200).entity("Oops! There might not be a quest with the id you selected").build();
//        }
//        return Response.status(200).entity(result.get(0).toString()).build();
//    }

}

