package pl.coderslab.controller.admin.userManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import pl.coderslab.dao.UserDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.entity.User;


@WebServlet(name = "AdminUserAddController", urlPatterns = {"/adminPanel/userAdd"})
public class AdminUserAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        try {
            user.setUserGroup(UserGroupDao.loadByID(Integer.parseInt(request.getParameter("group"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        try {
            UserDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/adminPanel/users");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}