package com.coderscampus.assignment4;

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

    public String getCourse() {
        return course;
    }

    @Override
    public int compareTo(Sorted other) {
        if (other == null) {
            return -1; // nulls are considered less than non-null values
        }
        return Integer.compare(other.grade, this.grade); // Descending order
    }

    @Override
    public String toString() {
        return id + "," + name + "," + course + "," + grade;
    }
}