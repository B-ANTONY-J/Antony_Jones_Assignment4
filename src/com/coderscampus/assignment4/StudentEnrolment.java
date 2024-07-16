package com.coderscampus.assignment4;

public class StudentEnrolment {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.separateAndSortStudents("master_list.csv");
        System.out.println("Process completed.");
    }
}

