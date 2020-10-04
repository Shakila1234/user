package com.example.myapplication;

public class UserFeedback {

    String name,feedback;

    public UserFeedback() {

    }

    public UserFeedback(String name, String feedback) {
        this.name = name;
        this.feedback = feedback;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
