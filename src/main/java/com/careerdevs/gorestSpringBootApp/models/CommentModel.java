package com.careerdevs.gorestSpringBootApp.models;


import javax.persistence.*;

@Entity
@Table(name = "comments")
public class CommentModel {

//    {
//            "id": 1224,
//            "post_id": 1232,
//            "name": "Mohan Jha",
//            "email": "jha_mohan@murphy.info",
//            "body": "Ut sunt saepe. Ipsa minus quasi. Ea ut atque. Aut adipisci quia."
//    },

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private int postId;
    private String name;
    private String email;
    private String body;

    public int getId() {
        return id;
    }

    public int getPostId() {
        return postId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
