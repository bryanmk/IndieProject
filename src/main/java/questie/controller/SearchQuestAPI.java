package questie.controller;

import quest.api.Quest;
import questie.persistence.GenericDAO;
import questie.persistence.QuestApiDAO;


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
        urlPatterns = {"/searchQuestAPI"}
)

public class SearchQuestAPI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        QuestApiDAO questApiDao = new QuestApiDAO();
        GenericDAO questGenericDao = new GenericDAO(Quest.class);

        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("quests", questApiDao.getByQuestTitle(req.getParameter("questApiSearchTerm")));
        } else {
            req.setAttribute("quests", questGenericDao.getAll());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/questApiSearchResults.jsp");
        dispatcher.forward(req, resp);
    }
}