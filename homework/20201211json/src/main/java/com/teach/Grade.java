package com.teach;

import java.util.ArrayList;

public class Grade {
    private int id;
    private String name;
    private ArrayList<Student> members;
    public Grade(int id, String name, ArrayList<Student> members) {
        super();
        this.id = id;
        this.name = name;
        this.members = members;
    }
    public Grade() {
        super();
    }
    @Override
    public String toString() {
        return "Grade [id=" + id + ", name=" + name + ", members=" + members + "]";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Student> getMembers() {
        return members;
    }
    public void setMembers(ArrayList<Student> members) {
        this.members = members;
    }
}
