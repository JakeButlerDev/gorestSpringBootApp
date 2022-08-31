package com.careerdevs.gorestSpringBootApp.models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class PostModel {


//    {
//            "id": 1963,
//            "user_id": 4006,
//            "title": "Arbitro aut solitudo adaugeo quis adulatio corrigo vulariter patrocinor appositus conculco abeo adduco et valens tot.",
//            "body": "Crur utrimque decimus. Sufficio ambitus assentator. Centum fugiat tondeo. Dolor careo aeneus. Iure censura est. Vilis tutamen provident. Vociferor omnis conservo. Cauda inventore alii. Quos cubicularis uterque. Consequatur tero tener. Tripudio hic officia. Vestrum et alter. Acceptus fuga velut. Volaticus delectus qui. Est adimpleo vinum. Sophismata cetera stillicidium. Voluptas molestias adulescens."
//    },
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private int userId;
    private String title;

    @Column(length = 300)
    private String body;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
