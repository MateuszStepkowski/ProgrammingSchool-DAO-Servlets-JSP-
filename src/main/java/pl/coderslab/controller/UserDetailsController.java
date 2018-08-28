package pl.coderslab.controller;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.Solution;
import pl.coderslab.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserDetailsController", urlPatterns = {"/userDetails"})
public class UserDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userID = Integer.parseInt(request.getParameter("userID") );
        User user = null;
        List<Solution> userSolutions = null;
        try {
            user = UserDao.loadByID(userID);
            userSolutions = SolutionDao.loadByUserID(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("user", user);
        request.setAttribute("userSolutions", userSolutions);
        getServletContext().getRequestDispatcher("/META-INF/views/userDetails.jsp").forward(request, response);
    }
}
