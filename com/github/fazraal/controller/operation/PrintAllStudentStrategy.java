package com.github.fazraal.controller.operation;

import com.github.fazraal.AllStudent;
import com.github.fazraal.Strategy;
import com.github.fazraal.controller.ControllerClass;



public class PrintAllStudentStrategy implements Strategy {


    @Override
    public void doOperation(AllStudent student, String type, int index) {
        ControllerClass.seeSortedOnStringType(student, type, index);
    }
}
