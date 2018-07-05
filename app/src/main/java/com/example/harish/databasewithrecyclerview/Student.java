package com.example.harish.databasewithrecyclerview;



public class Student {

    String name;
    String collegeName;
    int fees;
    long phoneNumber;
    int id;

    public Student(int id, String name, String collegeName, int fees, long phoneNumber) {
        this.id = id;
        this.name = name;
        this.collegeName = collegeName;
        this.fees = fees;
        this.phoneNumber = phoneNumber;
    }

    public Student(String name, String collegeName, int fees, long phoneNumber) {
        this.id = id;
        this.name = name;
        this.collegeName = collegeName;
        this.fees = fees;
        this.phoneNumber = phoneNumber;
    }

    public Student() {

    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public int getFees() {
        return fees;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }
}
