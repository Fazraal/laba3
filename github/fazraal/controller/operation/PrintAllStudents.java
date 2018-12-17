package com.github.fazraal.controller.operation;

import com.github.fazraal.AllStudent;
import com.github.fazraal.Strategy;

import java.util.Scanner;

public class PrintAllStudents implements Strategy {
    @Override
    public void doOperation(AllStudent student, Scanner scanner, int index) {
        for (int i = 0; i < student.getStudentsCount(); i++) {
            System.out.println(student.getStudent(i).toString());
        }
    }
}
