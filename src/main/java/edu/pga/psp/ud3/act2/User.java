package edu.pga.psp.ud3.act2;

public class User {
    int id;
    String username;
    String fullName;

    @Override
    public String toString() {
        return String.format("%s (%s)", fullName, username);
    }
}
