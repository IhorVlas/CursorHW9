package com.company;

import java.time.LocalDate;
import java.util.Comparator;

public class User implements Comparator<User> {
    private String email, team;
    private LocalDate loginDate;

    public User(String email, String team, LocalDate loginDate) {
        this.email = email;
        this.team = team;
        this.loginDate = loginDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", team='" + team + '\'' +
                ", loginDate=" + loginDate +
                "}\n";
    }

    @Override
    public int compare(User o1, User o2) {
        return 0;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    public LocalDate getLoginDate() {
        return loginDate;
    }
}