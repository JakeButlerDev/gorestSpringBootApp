package com.careerdevs.gorestSpringBootApp.models;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class TodoModel {

//    {
//        "id": 888,
//            "user_id": 1737,
//            "title": "Veritatis culpo velit spes tersus cohaero.",
//            "due_on": "2022-09-02T00:00:00.000+05:30",
//            "status": "pending"
//    },

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private int userId;
    private String title;
    private String dueDate;
    private String status;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }
}
