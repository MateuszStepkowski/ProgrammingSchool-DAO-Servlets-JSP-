package pl.coderslab.controller;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.entity.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SolutionDetailsController", urlPatterns = {"/solutionDetails"})
public class SolutionDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int solutionID = Integer.parseInt(request.getParameter("solutionID") );
        Solution solution = null;
        try {
            solution = SolutionDao.loadByID(solutionID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("solution", solution);
        getServletContext().getRequestDispatcher("/META-INF/views/solutionDetails.jsp").forward(request, response);
    }
}
