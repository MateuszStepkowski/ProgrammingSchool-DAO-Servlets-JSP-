package pl.coderslab.controller.admin.exercisesManager;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.entity.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminExerciseEditController", urlPatterns = {"/adminPanel/exerciseEdit"})
public class AdminExerciseEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer exerciseId = Integer.parseInt(request.getParameter("exerciseID"));

        Exercise exercise = new Exercise();

        exercise.setId(exerciseId);
        exercise.setTitle(request.getParameter("title"));
        exercise.setDescription(request.getParameter("description"));
        try {
            ExerciseDao.save(exercise);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/adminPanel/exercises");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("exerciseID"));
        request.setAttribute("exerciseID", id);
        getServletContext().getRequestDispatcher("/META-INF/views/admin/forms/exerciseEdit.jsp").forward(request, response);
    }
}
