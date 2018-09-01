package pl.coderslab.controller.admin.exercisesManager;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.entity.Exercise;
import pl.coderslab.entity.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminExercisesController", urlPatterns = {"/adminPanel/exercises"})
public class AdminExercisesController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Exercise> allExercises = ExerciseDao.loadAll();
            request.setAttribute("allExercises", allExercises);
            getServletContext().getRequestDispatcher("/META-INF/views/admin/exercisesManager.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
