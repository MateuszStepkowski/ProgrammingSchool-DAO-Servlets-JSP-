package pl.coderslab.sql;

public class servicedTables {

    String DataBase = "CREATE DATABASE ProgrammingSchool";

    String user_group_Table =
            "CREATE TABLE user_group(" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  name VARCHAR(255)," +
                    "  PRIMARY KEY(id));";
    String users_Table =
            "CREATE TABLE users("+
            "  id INT NOT NULL AUTO_INCREMENT,"+
            "  username VARCHAR(255),"+
            "  email VARCHAR(255) UNIQUE,"+
            "  password VARCHAR(255),"+
            "  user_group_id INT,"+
            "  PRIMARY KEY(id),"+
            "  FOREIGN KEY(user_group_id) REFERENCES user_group(id));";
    String exercise_Table =
            "CREATE TABLE exercise(" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  title VARCHAR(255)," +
                    "  description TEXT," +
                    "  PRIMARY KEY(id));";
    String solution_Table =
            "CREATE TABLE solution(" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  created DATETIME," +
                    "  updated DATETIME," +
                    "  description TEXT," +
                    "  exercise_id INT," +
                    "  users_id INT," +
                    "  PRIMARY KEY(id)," +
                    "  FOREIGN KEY(exercise_id) REFERENCES exercise(id)," +
                    "  FOREIGN KEY(users_id) REFERENCES users(id));";
}
