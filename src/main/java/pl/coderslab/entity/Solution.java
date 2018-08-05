package pl.coderslab.entity;

import java.util.Date;

public class Solution {

    private Integer id;
    private  Date created;
    private Date updated;
    private String description;
    private Integer exercise_id;
    private Integer users_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Integer exercise_id) {
        this.exercise_id = exercise_id;
    }

    public Integer getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Integer users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "\nSolution id: " + id +
                "  | created: " + created +
                "  | updated: " + updated +
                "\ndescription:\n" + description + '\n' +
                "exercise_id: " + exercise_id +
                "  |  users_id: " + users_id;
    }
}
