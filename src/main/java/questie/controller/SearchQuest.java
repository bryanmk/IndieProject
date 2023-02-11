package questie.controller;

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
        urlPatterns = {"/searchUser"}
)

public class SearchQuest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        QuestDAO questDao = new QuestDAO();

        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("quests", questDao.getByQuestName(req.getParameter("searchTerm")));
        } else {
            req.setAttribute("quests", questDao.getAll());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/questSearchResults.jsp");
        dispatcher.forward(req, resp);
    }
}