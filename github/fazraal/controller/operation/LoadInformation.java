package com.github.fazraal.controller.operation;

import com.github.fazraal.AllStudent;
import com.github.fazraal.Strategy;
import com.github.fazraal.controller.ControllerClass;

import java.io.File;
import java.util.Scanner;

public class LoadInformation implements Strategy {
    @Override
    public void doOperation(AllStudent student, Scanner scanner, int index) {
        String file1 = scanner.nextLine();
        File file2 = new File(file1);
        ControllerClass.loadInformationFromOtherFile(file2, student);
    }
}
