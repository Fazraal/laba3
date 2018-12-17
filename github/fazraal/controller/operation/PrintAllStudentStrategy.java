package com.github.fazraal.controller.operation;

import com.github.fazraal.AllStudent;
import com.github.fazraal.Strategy;
import com.github.fazraal.controller.ControllerClass;

import java.util.Scanner;


public class PrintAllStudentStrategy implements Strategy {


    @Override
    public void doOperation(AllStudent student, Scanner scanner, int index) {
        String type = scanner.nextLine();
        ControllerClass.seeSortedOnStringType(student, type, index);
    }
}
