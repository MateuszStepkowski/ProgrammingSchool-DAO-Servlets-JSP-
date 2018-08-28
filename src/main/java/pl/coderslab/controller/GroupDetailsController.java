package pl.coderslab.controller;

import pl.coderslab.dao.UserDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GroupDetailsController", urlPatterns = {"/groupDetails"})
public class GroupDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int groupID = Integer.parseInt(request.getParameter("groupID"));

        try {
            UserGroup group = UserGroupDao.loadByID(groupID);
            request.setAttribute("group", group);

            List<User> groupUsers = UserDao.loadByGroupID(group.getId());
            request.setAttribute("groupUsers", groupUsers);
            getServletContext().getRequestDispatcher("/META-INF/views/groupDetails.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
