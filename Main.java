package com.company;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Group group = new Group(3,"technical");
        Student[] students = new Student[2];
        students[0] = new Student("Ivanov", "Ivan", "Ivanovich",group,"13.07.2016");
        students[1] = new Student("Sergeev","Sergey","Sergeevich",group,"13.08.2016");
        ControllerClass controllerClassOut = new ControllerClass(students);
        ControllerClass controllerClassIn = new ControllerClass();
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
            controllerClassIn = (ControllerClass) in.readObject();
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
            if(scanner.nextInt() == 1){
                System.out.println(controllerClassIn);

            }
        }


    }
}
