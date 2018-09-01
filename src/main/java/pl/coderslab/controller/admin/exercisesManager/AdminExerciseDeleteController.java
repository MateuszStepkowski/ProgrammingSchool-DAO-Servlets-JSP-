package pl.coderslab.controller.admin.exercisesManager;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.entity.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminExerciseDeleteController", urlPatterns = {"/adminPanel/exerciseDelete"})
public class AdminExerciseDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("exerciseID"));
        Exercise exercise = new Exercise();
        exercise.setId(id);
        try {
            ExerciseDao.delete(exercise);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/adminPanel/exercises");
    }
}
