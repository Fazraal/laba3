package com.github.fazraal;

import com.github.fazraal.information.Group;
import com.github.fazraal.information.Student;
import com.github.fazraal.information.Students;

import javax.imageio.IIOException;
import java.io.*;

public class Generation {
    public static void main(String[] args) {
        com.github.fazraal.information.Group group = new com.github.fazraal.information.Group(3, "technical");
        com.github.fazraal.information.Group group1 = new Group(2, "tec");
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

    }

}
