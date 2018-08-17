package pl.coderslab.dao;

import pl.coderslab.entity.Exercise;
import pl.coderslab.service.DbService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExerciseDao {

    public static void save(Exercise exercise) throws Exception {
        if (exercise.getId() == null) {
            addNew(exercise);
        } else {
            update(exercise);
        }
    }

    public static void delete(Exercise exercise) throws Exception {
        if (exercise.getId() != 0) {
            List<String> queryParams = new ArrayList<>();

            String sqlQuery = "DELETE FROM exercise WHERE id = ?";
            queryParams.add(String.valueOf(exercise.getId()));

            DbService.executeQuery(sqlQuery, queryParams);
        }
    }


    private static void update(Exercise exercise) throws Exception {
        String query = "UPDATE exercise SET title=?, description=? WHERE id =?";
        List<String> queryParams = new ArrayList<>();
        queryParams.add(exercise.getTitle());
        queryParams.add(exercise.getDescription());
        queryParams.add(String.valueOf(exercise.getId()));
        DbService.executeQuery(query, queryParams);
    }

    private static Exercise create(Map<String, String> row) {
        Exercise exercise = new Exercise();
        exercise.setId(Integer.parseInt(row.get("id")));
        exercise.setTitle(row.get("title"));
        exercise.setDescription(row.get("description"));

        return exercise;
    }

    private static void addNew(Exercise exercise) throws Exception {
        String query = "INSERT INTO exercise(title, description) VALUES(?,?)";
        List<String> queryParams = new ArrayList<>();
        queryParams.add(exercise.getTitle());
        queryParams.add(exercise.getDescription());
        Integer generatedID = DbService.insertIntoDataBase(query, queryParams);
        exercise.setId(generatedID);
    }

    public static Exercise loadByID(Integer id) throws Exception {
        List<String> queryParams = new ArrayList<>();

        String sqlQuery = "SELECT *  FROM exercise WHERE id = ?";
        queryParams.add(String.valueOf(id));

        return create(DbService.getData(sqlQuery, queryParams).get(0));
    }

    public static List<Exercise> loadAll() throws Exception {
        String sqlQuery = "SELECT * FROM exercise";

        List<Exercise> result = new ArrayList<>();
        List<Map<String, String>> loadedExercises = DbService.getData(sqlQuery, null);
        for (Map<String, String> exercise : loadedExercises) {
            result.add(create(exercise));
        }
        return result;
    }
}
