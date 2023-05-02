package questie.controller;

import questie.entity.User;
import questie.persistence.GenericDAO;
import questie.persistence.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDAO userDao = new UserDAO();
        GenericDAO userGenericDao = new GenericDAO(User.class);

//        if (req.getParameter("submit").equals("search")) {
//            req.setAttribute("users", userDao.getByLastName(req.getParameter("userSearchTerm")));
//        } else {
//            req.setAttribute("users", userGenericDao.getAll());
//        }

        req.setAttribute("users", userGenericDao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/userSearchResults.jsp");
        dispatcher.forward(req, resp);
    }
}