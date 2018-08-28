package pl.coderslab.dao;

import pl.coderslab.entity.Solution;
import pl.coderslab.service.DbService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SolutionDao {


    public static void save(Solution solution) throws Exception {
        if (solution.getId() == null) {
            addNew(solution);
        } else {
            update(solution);
        }
    }

    public static void delete(Solution solution) throws Exception {
        if (solution.getId() != 0) {
            List<String> queryParams = new ArrayList<>();

            String sqlQuery = "DELETE FROM solution WHERE id = ?";
            queryParams.add(String.valueOf(solution.getId()));

            DbService.executeQuery(sqlQuery, queryParams);
        }
    }


    private static void update(Solution solution) throws Exception {
        String query = "UPDATE solution SET updated=?, description=? WHERE id =?";
        List<String> queryParams = new ArrayList<>();
        queryParams.add(solution.getUpdated().toString() );
        queryParams.add(solution.getDescription());
        queryParams.add(String.valueOf(solution.getId()));
        DbService.executeQuery(query, queryParams);
    }

    private static Solution create(Map<String, String> row) throws Exception {
        Solution solution = new Solution();
        solution.setId(Integer.parseInt(row.get("id")));
        solution.setCreated(Timestamp.valueOf(row.get("created")));
        solution.setUpdated(Timestamp.valueOf(row.get("updated")));
        solution.setDescription(row.get("description"));
        solution.setExercise( ExerciseDao.loadByID( Integer.parseInt( row.get("exercise_id") ) ) );
        solution.setUser(UserDao.loadByID( Integer.parseInt( row.get("users_id") ) ) );

        return solution;
    }

    private static void addNew(Solution solution) throws Exception {
        String query = "INSERT INTO solution(created, exercise_id, users_id) VALUES (?, ?, ?)";
        List<String> queryParams = new ArrayList<>();
        queryParams.add(solution.getCreated().toString());
        queryParams.add(String.valueOf(solution.getExercise().getId()));
        queryParams.add(String.valueOf(solution.getUser().getId()));
        Integer generatedID = DbService.insertIntoDataBase(query, queryParams);
        solution.setId(generatedID);
    }

    public static Solution loadByID(Integer id) throws Exception {
        List<String> queryParams = new ArrayList<>();

        String sqlQuery = "SELECT *  FROM solution WHERE id = ?";
        queryParams.add(String.valueOf(id));

        return create(DbService.getData(sqlQuery, queryParams).get(0));
    }

    public static List<Solution> loadAll() throws Exception {
        String sqlQuery = "SELECT * FROM solution";

        List<Solution> result = new ArrayList<>();
        List<Map<String, String>> loadedSolutions = DbService.getData(sqlQuery, null);
        for (Map<String, String> solution : loadedSolutions) {
            result.add(create(solution));
        }
        return result;
    }

    public static List<Solution> load5() throws Exception {

        String sqlQuery = "SELECT * FROM solution ORDER BY updated DESC LIMIT 5";

        List<Solution> result = new ArrayList<>();
        List<Map<String, String>> loadedSolutions = DbService.getData(sqlQuery, null );
        for (Map<String, String> solution : loadedSolutions) {
            result.add(create(solution));
        }
        return result;
    }

    public static List<Solution> loadByUserID(Integer userID) throws Exception {
        List<String> queryParams = new ArrayList<>();

        String sqlQuery = "SELECT *  FROM solution WHERE users_id = ? ORDER BY updated DESC";
        queryParams.add(String.valueOf(userID));

        List<Solution> result = new ArrayList<>();
        List<Map<String, String>> loadedSolutions = DbService.getData(sqlQuery, queryParams );
        for (Map<String, String> solution : loadedSolutions) {
            result.add(create(solution));
        }
        return result;
    }

    public static List<Solution> loadByExerciseID(Integer exerciseID) throws Exception {
        List<String> queryParams = new ArrayList<>();

        String sqlQuery = "SELECT *  FROM solution WHERE exercise_id = ? ORDER BY updated DESC";
        queryParams.add(String.valueOf(exerciseID));

        List<Solution> result = new ArrayList<>();
        List<Map<String, String>> loadedSolutions = DbService.getData(sqlQuery, queryParams );
        for (Map<String, String> solution : loadedSolutions) {
            result.add(create(solution));
        }
        return result;
    }
}
