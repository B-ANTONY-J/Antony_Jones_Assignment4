package com.coderscampus.assignmen4.sort;

public class Sorted implements Comparable<Sorted> {
    private String id;
    private String name;
    private String course;
    private int grade;

    public Sorted(String id, String name, String course, int grade) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Sorted other) {
        return Integer.compare(other.grade, this.grade); // Sort in descending order
    }

    @Override
    public String toString() {
        return id + "," + name + "," + course + "," + grade;
    }
}
