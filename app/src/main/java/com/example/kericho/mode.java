package com.example.kericho;

public class mode {
    String constituency;
    String name;
    String email;

    public mode(String married) {
        this.married = married;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    String image;
    String party;
    String dob;
    String office;
    String home;
    String religion;
    String twitter;
    String facebook;
    String married;

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public mode() {
    }

    public mode(String constituency, String name, String email, String image,
                String party, String dob, String office, String home, String religion,
                String twitter, String facebook) {
        this.constituency = constituency;
        this.name = name;
        this.email = email;
        this.image = image;
        this.party = party;
        this.dob = dob;
        this.office = office;
        this.home = home;
        this.religion = religion;
        this.twitter = twitter;
        this.facebook = facebook;
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