package pl.coderslab.dao;

import pl.coderslab.entity.UserGroup;
import pl.coderslab.service.DbService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserGroupDao {


    public static void save(UserGroup userGroup) throws Exception {
        if (userGroup.getId() == null) {
            addNew(userGroup);
        } else {
            update(userGroup);
        }
    }

    public static void delete(UserGroup userGroup) throws Exception {
        if (userGroup.getId() != 0) {
            List<String> queryParams = new ArrayList<>();

            String sqlQuery = "DELETE FROM user_group WHERE id = ?";
            queryParams.add(String.valueOf(userGroup.getId()));

            DbService.executeQuery(sqlQuery, queryParams);
        }
    }


    private static void update(UserGroup userGroup) throws Exception {
        String query = "UPDATE user_group SET name=? WHERE id =?";
        List<String> queryParams = new ArrayList<>();
        queryParams.add(userGroup.getName());
        queryParams.add(String.valueOf(userGroup.getId()));
        DbService.executeQuery(query, queryParams);
    }

    private static UserGroup create(Map<String, String> row) {
        UserGroup userGroup = new UserGroup();
        userGroup.setId(Integer.parseInt(row.get("id")));
        userGroup.setName(row.get("name"));

        return userGroup;
    }

    private static void addNew(UserGroup userGroup) throws Exception {
        String query = "INSERT INTO user_group(name) VALUES(?)";
        List<String> queryParams = new ArrayList<>();
        queryParams.add(userGroup.getName());
        Integer generatedID = DbService.insertIntoDataBase(query, queryParams);
        userGroup.setId(generatedID);
    }

    public static UserGroup loadByID(Integer id) throws Exception {
        List<String> queryParams = new ArrayList<>();

        String sqlQuery = "SELECT *  FROM user_group WHERE id = ?";
        queryParams.add(String.valueOf(id));

        return create(DbService.getData(sqlQuery, queryParams).get(0));
    }

    public static List<UserGroup> loadAll() throws Exception {
        String sqlQuery = "SELECT * FROM user_group";

        List<UserGroup> result = new ArrayList<>();
        List<Map<String, String>> loadedGroups = DbService.getData(sqlQuery, null);
        for (Map<String, String> group : loadedGroups) {
            result.add(create(group));
        }
        return result;
    }
}



    
