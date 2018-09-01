package pl.coderslab.controller.admin.groupsManager;

import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.entity.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminGroupDeleteController", urlPatterns = {"/adminPanel/groupDelete"})
public class AdminGroupDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("groupID"));
        UserGroup userGroup = new UserGroup();
        userGroup.setId(id);
        try {
            UserGroupDao.delete(userGroup);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/adminPanel/groups");
    }
}
