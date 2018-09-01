package pl.coderslab.controller.admin.userManager;

import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminUserDeleteController", urlPatterns = {"/adminPanel/userDelete"})
public class AdminUserDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userID"));
        User user = new User();
        user.setId(id);
        try {
            UserDao.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/adminPanel/users");
    }
}
