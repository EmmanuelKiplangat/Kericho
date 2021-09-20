package com.example.kericho;

public class motionModel {
    String motion, proposer,seconder, openDate, closeDate;

    public motionModel() {
    }

    public motionModel(String motion, String proposer, String seconder, String openDate, String closeDate) {
        this.motion = motion;
        this.proposer = proposer;
        this.seconder = seconder;
        this.openDate = openDate;
        this.closeDate = closeDate;
    }

    public String getMotion() {
        return motion;
    }

    public void setMotion(String motion) {
        this.motion = motion;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getSeconder() {
        return seconder;
    }

    public void setSeconder(String seconder) {
        this.seconder = seconder;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }
}
