package pl.coderslab.dao;

import pl.coderslab.entity.User;
import pl.coderslab.service.DbService;
import pl.coderslab.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDao {


    public static void save(User user) throws Exception {
        if (user.getId() == null) {
            addNew(user);
        } else {
            update(user);
        }
    }

    public static void delete(User user) throws Exception {
        if (user.getId() != 0) {
            List<String> queryParams = new ArrayList<>();

            String sqlQuery = "DELETE FROM users WHERE id = ?";
            queryParams.add(String.valueOf(user.getId()));

            DbService.executeQuery(sqlQuery, queryParams);
        }
    }


    private static void update(User user) throws Exception {
        String query = "UPDATE users SET username=?, password=?, email=?, user_group_id=? WHERE id =?";
        List<String> queryParams = new ArrayList<>();
        queryParams.add(user.getUsername());
        queryParams.add(UserService.hashPassword( user.getPassword() ) );
        queryParams.add(user.getEmail());
        queryParams.add(String.valueOf( user.getUserGroup().getId() ) );
        queryParams.add(String.valueOf(user.getId()));

        DbService.executeQuery(query, queryParams);
    }

    private static User create(Map<String, String> row) throws Exception {
        User user = new User();
        user.setId(Integer.parseInt(row.get("id")));
        user.setUsername(row.get("username"));
        user.setPassword(row.get("password"));
        user.setEmail(row.get("email"));
        user.setUserGroup( UserGroupDao.loadByID( Integer.parseInt( row.get("user_group_id") ) ) );

        return user;
    }

    private static void addNew(User user) throws Exception {
        String query = "INSERT INTO users(username, password, email, user_group_id) VALUES(?,?,?,?)";
        List<String> queryParams = new ArrayList<>();
        queryParams.add(user.getUsername());
        queryParams.add(UserService.hashPassword( user.getPassword() ) );
        queryParams.add(user.getEmail());
        queryParams.add(String.valueOf( user.getUserGroup().getId() ) );
        Integer generatedID = DbService.insertIntoDataBase(query, queryParams);
        user.setId(generatedID);
    }

    public static User loadByID(Integer id) throws Exception {
        List<String> queryParams = new ArrayList<>();

        String sqlQuery = "SELECT *  FROM users WHERE id = ?";
        queryParams.add(String.valueOf(id));

        return create(DbService.getData(sqlQuery, queryParams).get(0));
    }

    public static List<User> loadAll() throws Exception {
        String sqlQuery = "SELECT * FROM users";

        List<User> result = new ArrayList<>();
        List<Map<String, String>> loadedUsers = DbService.getData(sqlQuery, null);
        for (Map<String, String> user : loadedUsers) {
            result.add(create(user));
        }
        return result;
    }

    public static List<User> loadByGroupID(Integer groupID) throws Exception {

        List<String> queryParams = new ArrayList<>();

        String sqlQuery = "SELECT *  FROM users WHERE user_group_id = ?";
        queryParams.add(String.valueOf(groupID));

        List<User> result = new ArrayList<>();
        List<Map<String, String>> loadedUsers = DbService.getData(sqlQuery,queryParams);
        for (Map<String, String> user : loadedUsers) {
            result.add(create(user));
        }
        return result;
    }
}
