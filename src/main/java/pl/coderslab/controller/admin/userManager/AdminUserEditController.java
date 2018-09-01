package pl.coderslab.controller.admin.userManager;

import pl.coderslab.dao.UserDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminUserEditController", urlPatterns = {"/adminPanel/userEdit"})
public class AdminUserEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = Integer.parseInt(request.getParameter("userID"));
        User user = new User();
        user.setId(userId);
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
        Integer id = Integer.parseInt(request.getParameter("userID"));
        request.setAttribute("userID", id);
        getServletContext().getRequestDispatcher("/META-INF/views/admin/forms/userEdit.jsp").forward(request, response);
    }
}