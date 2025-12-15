package edu.pga.psp.ud3.act2;

public class Reactions {
    int likes;
    int dislikes;

    @Override
    public String toString() {
        return String.format("Likes: %d, Dislikes: %d", likes, dislikes);
    }
}
