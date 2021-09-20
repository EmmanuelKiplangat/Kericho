package com.example.kericho;

public class Commodel {
    String constituency,name, email, image;


    public Commodel() {
    }

    public Commodel(String constituency, String name, String email) {
        this.constituency = constituency;
        this.name = name;
        this.email = email;
        this.image=image;
    }

    public String getConstituency() {
        return constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
