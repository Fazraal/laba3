package com.github.fazraal.controller.operation;

import com.github.fazraal.AllStudent;
import com.github.fazraal.Strategy;
import com.github.fazraal.controller.ControllerClass;
import com.github.fazraal.information.Students;

import java.util.Scanner;

public class PrintSortedOnGroupNumber implements Strategy {
    @Override
    public void doOperation(AllStudent student, Scanner scanner, int index) {
        AllStudent students2 = new Students();
        int number = scanner.nextInt();
        students2 = ControllerClass.getLearnerOnGroupNumber(student, number);
        for (int i = 0; i < students2.getStudentsCount(); i++) {
            System.out.println(students2.getStudent(i).toString());
        }
    }
}
