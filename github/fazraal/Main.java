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
        Group group = new Group(3,"technical");
        Student[] students = new Student[2];
        students[0] = new Student("Ivanov", "Ivan", "Ivanovich",group,"13.07.2016");
        students[1] = new Student("Sergeev","Sergey","Sergeevich",group,"13.08.2016");
        Students controllerClassOut = new Students(students);
        Students students1 = new  Students();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.bin"));
            out.writeObject(controllerClassOut);
            out.close();
        }
        catch (IIOException ex){
            ex.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.bin"));
            students1 = (Students) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - Получить список студентов");
            System.out.println("2 - Получить студента по имени ");
            int index = scanner.nextInt();
            if(index == 1){
                for (int i = 0 ; i<students1.getStudentsCount() ; i++){
                    System.out.println(students1.getStudent(i).toString());
                }

            }

            if ( index == 2){
                System.out.println("Введите имя студента (Вместо букв можно использовать *)");
                AllStudents students2 = new Students();
                students2 =  ControllerClass.getLearnerOnName(students1 , "Ivan");
                for ( int i = 0 ; i<students2.getStudentsCount() ; i++){
                    System.out.println(students2.getStudent(i).toString());
                }
            }
        }


    }
}
