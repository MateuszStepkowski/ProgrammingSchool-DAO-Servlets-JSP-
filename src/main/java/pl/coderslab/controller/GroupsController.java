package pl.coderslab.controller;

import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.entity.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GroupsController", urlPatterns = {"/groups"})
public class GroupsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            List<UserGroup> groups = UserGroupDao.loadAll();
            request.setAttribute("groups", groups);
            getServletContext().getRequestDispatcher("/META-INF/views/groups.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
