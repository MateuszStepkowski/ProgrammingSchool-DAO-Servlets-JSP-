package pl.coderslab.controller.admin.groupsManager;

import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.entity.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminGroupsController", urlPatterns = {"/adminPanel/groups"})
public class AdminGroupsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<UserGroup> allGroups = UserGroupDao.loadAll();
            request.setAttribute("allGroups", allGroups);
            getServletContext().getRequestDispatcher("/META-INF/views/admin/groupsManager.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
