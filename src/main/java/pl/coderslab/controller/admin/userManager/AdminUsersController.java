package pl.coderslab.controller.admin.userManager;

import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminUsersController", urlPatterns = {"/adminPanel/users"})
public class AdminUsersController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> allUsers = UserDao.loadAll();
            request.setAttribute("allUsers", allUsers);
            getServletContext().getRequestDispatcher("/META-INF/views/admin/usersManager.jsp").forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}