package edu.pga.psp.ud3.act2;

public class Comment {
    int id;
    String body;
    int postId;
    int likes;
    User user;

    @Override
    public String toString() {
        return String.format(
                "[%d] %s \n\t- Autor: %s \n\t- Likes: %d",
                id, body, (user != null ? user : "Anónimo"), likes
        );
    }
}
