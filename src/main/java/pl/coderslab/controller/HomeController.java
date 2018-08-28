package pl.coderslab.controller;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.entity.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns ={"/homepage", "/"})
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Solution> recentSolutions = null;
        try {
            recentSolutions = SolutionDao.load5();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("recentSolutions", recentSolutions);
        getServletContext().getRequestDispatcher("/META-INF/views/homepage.jsp").forward(request,response);
    }
}
