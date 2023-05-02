package questie.controller;

import questie.entity.Quest;
import questie.persistence.GenericDAO;
import questie.persistence.QuestDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet to search for quests.
 * @author mbryan
 */

@WebServlet(
        urlPatterns = {"/searchQuest"}
)

public class SearchQuest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        QuestDAO questDao = new QuestDAO();
        GenericDAO questGenericDao = new GenericDAO(Quest.class);

//        if (req.getParameter("submit").equals("search")) {
//            req.setAttribute("quests", questDao.getByQuestName(req.getParameter("questSearchTerm")));
//        } else {
//            req.setAttribute("quests", questGenericDao.getAll());
//        }

        req.setAttribute("quests", questGenericDao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/questSearchResults.jsp");
        dispatcher.forward(req, resp);
    }
}