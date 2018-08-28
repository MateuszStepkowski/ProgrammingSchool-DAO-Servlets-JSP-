package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.entity.Exercise;
import pl.coderslab.entity.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ExerciseDetailsController", urlPatterns = {"/exerciseDetails"})
public class ExerciseDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int exerciseID = Integer.parseInt(request.getParameter("exerciseID") );
        Exercise exercise = null;
        List<Solution> exerciseSolutions = null;
        try {
            exercise = ExerciseDao.loadByID(exerciseID);
            exerciseSolutions = SolutionDao.loadByExerciseID(exercise.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("exercise", exercise);
        request.setAttribute("exerciseSolutions", exerciseSolutions);
        getServletContext().getRequestDispatcher("/META-INF/views/exerciseDetails.jsp").forward(request, response);
    }
}
