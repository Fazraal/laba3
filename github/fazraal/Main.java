package com.github.fazraal;

import com.github.fazraal.controller.ControllerClass;
import com.github.fazraal.information.Group;
import com.github.fazraal.information.Student;
import com.github.fazraal.information.Students;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - Получить список студентов");
            System.out.println("2 - Получить список студентов по имени ");
            System.out.println("3 - Получить список студентов по фамилии");
            System.out.println("4 - Получить студентов по номеру группы");
            System.out.println("5 - Получить студентов по факультету");
            System.out.println("6 - Добавить данные из другого файла");
            System.out.println("7 - Получить студентов по дате зачисления");
            int index = scanner.nextInt();
            scanner.nextLine();
            switch (index) {
                case (1): {
                    for (int i = 0; i < students1.getStudentsCount(); i++) {
                        System.out.println(students1.getStudent(i).toString());
                    }
                    break;
                }

                case (2): {
                    System.out.println("Введите имя студента (Вместо букв можно использовать *)");
                    String name = scanner.nextLine();
                    ControllerClass.seeSortedOnStringType(students1, name, 1);
                    break;
                }

                case (3): {
                    System.out.println("Введите имя Фамилию (Вместо букв можно использовать *)");
                    String s = scanner.nextLine();
                    ControllerClass.seeSortedOnStringType(students1, s, 2);
                    break;
                }

                case (4): {
                    System.out.println("Введите номер группы ");
                    int number = scanner.nextInt();
                    AllStudent students2 = new Students();
                    students2 = ControllerClass.getLearnerOnGroupNumber(students1, number);
                    for (int i = 0; i < students2.getStudentsCount(); i++) {
                        System.out.println(students2.getStudent(i).toString());
                    }
                    break;
                }

                case (5): {
                    System.out.println("Введите название факультета ");
                    String fu = scanner.nextLine();
                    AllStudent students2 = new Students();
                    students2 = ControllerClass.getLearnerOnFaculty(students1, fu);
                    System.out.println(students2.getStudentsCount());
                    for (int i = 0; i < students2.getStudentsCount(); i++) {
                        System.out.println(students2.getStudent(i).toString());
                    }
                    break;
                }
                case (6): {
                    System.out.println("Введите название файла");
                    String file1 = scanner.nextLine();
                    File file2 = new File(file1);
                    ControllerClass.loadInformationFromOtherFile(file2, students1);
                }
                case (7) :
                    {
                    System.out.println("Введите дату зачисления");
                    AllStudent student = new Students();
                    String stg = scanner.nextLine();
                    student = ControllerClass.getLearnerOnName(students1 , stg , 4);
                    System.out.println(student.toString());
                }
            }
        }
    }

}


