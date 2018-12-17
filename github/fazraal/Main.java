package com.github.fazraal;

import com.github.fazraal.controller.Context;
import com.github.fazraal.controller.ControllerClass;
import com.github.fazraal.controller.operation.LoadInformation;
import com.github.fazraal.controller.operation.PrintAllStudentStrategy;
import com.github.fazraal.controller.operation.PrintAllStudents;
import com.github.fazraal.controller.operation.PrintSortedOnGroupNumber;
import com.github.fazraal.information.Group;
import com.github.fazraal.information.Student;
import com.github.fazraal.information.Students;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

public class Main {
    private static Context context = Context.instance();

    public static void main(String[] args) throws IllegalAccessException {
        Group group = new Group(3, "technical");
        Group group1 = new Group(2, "tec");
        Learner[] students = new Student[2];
        students[0] = new Student("Ivanov", "Ivan", "Ivanovich", group, "13.07.2016");
        students[1] = new Student("Sergeev", "Sergey", "Sergeevich", group1, "13.08.2016");
        AllStudent controllerClassOut = new Students(students);
        AllStudent students1 = new Students();
        ObjectOutputStream out = null;
        Learner[] st = new Student[1];
        st[0] = new Student("Nicolaev", "Nicolay", "Nicolaevich", group1, "13.06.2016");
        AllStudent stn = new Students(st);
        ObjectOutputStream out1 = null;
        File file = null;
        try {
            file = new File("student2.bin");

            out = new ObjectOutputStream(new FileOutputStream("students.bin"));
            out1 = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(controllerClassOut);
            out1.writeObject(stn);

        } catch (IIOException ex) {
            ex.getMessage();
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        } finally {
            if (out != null) {
                try {
                    out1.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(new FileInputStream("students.bin"));
            students1 = (Students) in.readObject();

        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Scanner scanner = new Scanner(System.in);
        init();

        while (true) {
            //Scanner scanner = new Scanner(System.in);
            System.out.println("1 - Получить список студентов");
            System.out.println("2 - Получить список студентов по имени ");
            System.out.println("3 - Получить список студентов по фамилии");
            System.out.println("4 - Получить список студентов по отчеству");
            System.out.println("5 -Получить студентов по дате зачисления ");
            System.out.println("6 - Получить студентов по факультету");
            System.out.println("7 - Получить студентов по номеру группы");
            System.out.println("8 - Добавить данные из другого файла");

            int index = scanner.nextInt();
            //System.out.println("Введите данные ");
            scanner.nextLine();
            context.getStrategy(index).doOperation(students1,  scanner, index);
            }
        }
        private static void  init(){
        PrintAllStudentStrategy printAllStudentStrategy = new PrintAllStudentStrategy();
        PrintAllStudents printAllStudents = new PrintAllStudents();
        PrintSortedOnGroupNumber printSortedOnGroupNumber = new PrintSortedOnGroupNumber();
        LoadInformation loadInformation = new LoadInformation();
        context.register(1, printAllStudents);
        context.register(2, printAllStudentStrategy);
        context.register(3, printAllStudentStrategy);
        context.register(4, printAllStudentStrategy);
        context.register(5, printAllStudentStrategy);
        context.register(6, printAllStudentStrategy);
        context.register(7 , printSortedOnGroupNumber);
        context.register(8 , loadInformation);

        }
    }




