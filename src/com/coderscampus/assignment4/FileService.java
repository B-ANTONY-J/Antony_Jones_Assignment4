package com.coderscampus.assignment4;

import java.io.*;
import java.util.Arrays;

public class FileService {

    private static final int INITIAL_CAPACITY = 100;

    public Sorted[] readMasterList(String inputFile) {
        Sorted[] students = new Sorted[INITIAL_CAPACITY];
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line = reader.readLine(); // Skip header line

            while ((line = reader.readLine()) != null) {
                if (count == students.length) {
                    students = Arrays.copyOf(students, students.length * 2); // Resize array if needed
                }
                String[] parts = line.split(",");
                if (parts.length < 4) {
                    continue; // Skip lines with insufficient data
                }
                String id = parts[0].trim();
                String name = parts[1].trim();
                String course = parts[2].trim();
                int grade = Integer.parseInt(parts[3].trim());

                Sorted student = new Sorted(id, name, course, grade);
                students[count++] = student;
                System.out.println("Read student: " + student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Arrays.copyOf(students, count); // Trim array to actual size
    }

    public void writeCSV(String outputFile, Sorted[] students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("Student ID,Student Name,Course,Grade\n");
            for (Sorted student : students) {
                if (student != null) {
                    writer.write(student.toString() + "\n");
                    System.out.println("Writing student to file: " + student);
                }
             }
            System.out.println("      ************************************            ");
            System.out.println("All above Student files Written to document: " + outputFile + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void separateAndSortStudents(String inputFile) {
        Sorted[] students = readMasterList(inputFile);
        Sorted[] compSciStudents = new Sorted[students.length];
        Sorted[] apMathStudents = new Sorted[students.length];
        Sorted[] statStudents = new Sorted[students.length];

        int compSciCount = 0;
        int apMathCount = 0;
        int statCount = 0;

        for (Sorted student : students) {
            if (student != null) {
                if (student.getCourse().contains("COMPSCI")) {
                    compSciStudents[compSciCount++] = student;
                } else if (student.getCourse().contains("APMTH")) {
                    apMathStudents[apMathCount++] = student;
                } else if (student.getCourse().contains("STAT")) {
                    statStudents[statCount++] = student;
                }
            }
        }

        // Trim arrays to actual size to avoid null values during sorting
        compSciStudents = Arrays.copyOf(compSciStudents, compSciCount);
        apMathStudents = Arrays.copyOf(apMathStudents, apMathCount);
        statStudents = Arrays.copyOf(statStudents, statCount);

        // Sorting the arrays
        Arrays.sort(compSciStudents);
        Arrays.sort(apMathStudents);
        Arrays.sort(statStudents);

        // Debug output
        System.out.println("\nCOMPSCI Students after sorting:");
        for (Sorted student : compSciStudents) {
            System.out.println(student);
        }

        System.out.println("\nAPMATH Students after sorting:");
        for (Sorted student : apMathStudents) {
            System.out.println(student);
        }

        System.out.println("\nSTAT Students after sorting:");
        for (Sorted student : statStudents) {
            System.out.println(student);
        }
        System.out.println();
        // Writing the sorted data to CSV files
        writeCSV("course1.csv", compSciStudents);
        writeCSV("course2.csv", apMathStudents);
        writeCSV("course3.csv", statStudents);
    }
}