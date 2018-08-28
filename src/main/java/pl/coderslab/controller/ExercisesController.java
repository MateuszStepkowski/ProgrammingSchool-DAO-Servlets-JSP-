package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.entity.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ExercisesController", urlPatterns = {"/exercises"})
public class ExercisesController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Exercise> exercises = ExerciseDao.loadAll();
            request.setAttribute("exercises", exercises);
            getServletContext().getRequestDispatcher("/META-INF/views/exercises.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
