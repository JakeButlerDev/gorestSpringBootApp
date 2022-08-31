package com.careerdevs.gorestSpringBootApp.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

//    {
//            "id": 4008,
//            "name": "Prof. Daksha Varman",
//            "email": "varman_daksha_prof@nitzsche.name",
//            "gender": "female",
//            "status": "active"
//    },

    private String name;
    private String email;
    private String gender;
    private String status;

    public int getId() {
        return id;
    }

    public void removeId() {
        id = 0;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }
}
