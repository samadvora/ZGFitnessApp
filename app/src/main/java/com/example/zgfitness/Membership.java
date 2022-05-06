package com.example.zgfitness;

public class Membership {
    private String name;
    private String description;
    private String facilities;
    private int img;
    private String admissionFee;
    private String monthlyFee;
    private String commitment;

    public Membership(String name, String description, String facilities, int img, String admissionFee, String monthlyFee, String commitment) {
        this.name = name;
        this.description = description;
        this.facilities = facilities;
        this.img = img;
        this.admissionFee = admissionFee;
        this.monthlyFee = monthlyFee;
        this.commitment = commitment;
    }

    //Using Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getFacilities() { return facilities; }
    public void setFacilities(String facilities) { this.facilities = facilities; }

    public int getImg() { return img; }
    public void setImg(int img) { this.img = img; }

    public String getAdmissionFee() { return admissionFee; }
    public void setAdmissionFee(String admissionFee) { this.admissionFee = admissionFee; }

    public String getMonthlyFee() { return monthlyFee; }
    public void setMonthlyFee(String monthlyFee) { this.monthlyFee = monthlyFee; }

    public String getCommitment() { return commitment; }
    public void setCommitment(String commitment) { this.commitment = commitment; }
}
