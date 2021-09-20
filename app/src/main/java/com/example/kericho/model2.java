package com.example.kericho;

public class model2 {
    String title, stand, description,members;

    public model2() {
    }
    public model2(String title, String stand, String description) {
        this.title = title;
        this.stand = stand;
        this.description =description;
        this.members=members;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public  String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }
}
