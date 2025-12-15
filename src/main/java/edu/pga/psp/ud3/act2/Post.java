package edu.pga.psp.ud3.act2;

import java.util.List;

class Post {
    int id;
    String title;
    String body;
    List<String> tags;
    Reactions reactions;
    int views;
    int userId;


    public Post() {
    }


    public Post(String title, String body, int userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.tags = List.of("java", "test");
        this.reactions = new Reactions();
    }

    @Override
    public String toString() {
        return String.format(
                "[%d] %s \n\t- Tags: %s \n\t- Reacciones: %s \n\t- Vistas: %d",
                id, title, tags, reactions, views
        );
    }
}

