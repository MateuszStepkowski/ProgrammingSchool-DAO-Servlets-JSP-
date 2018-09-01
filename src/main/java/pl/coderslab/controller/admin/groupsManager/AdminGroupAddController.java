package pl.coderslab.controller.admin.groupsManager;

import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.entity.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminGroupAddController", urlPatterns = {"/adminPanel/groupAdd"})
public class AdminGroupAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserGroup userGroup = new UserGroup();

        userGroup.setName(request.getParameter("name"));

        try {
            UserGroupDao.save(userGroup);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/adminPanel/groups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
