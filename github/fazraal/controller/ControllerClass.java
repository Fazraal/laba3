package com.github.fazraal.controller;

import com.github.fazraal.AllStudents;
import com.github.fazraal.information.Students;

import java.io.*;

public class ControllerClass {


    public static void serializeBuilding(AllStudents students, OutputStream out) throws IOException {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(students);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static AllStudents deserializeBuilding(InputStream in) throws ClassNotFoundException {
        AllStudents students = null;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(in);
            students = (Students) inputStream.readObject();
            inputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return students;
    }

    public static AllStudents getLearnerOnName(AllStudents students, String name) {
        AllStudents students1 = students;
        char chars = 042;
        Students students2 = new Students();
        for (int i = 0; i < students.getStudentsCount(); i++) {
            boolean equality = false;
            if (students.getStudent(i).getName().length() == name.length()) {
                for (int g = 0; g < name.length(); g++) {
                    if (students.getStudent(i).getName().charAt(g) == name.charAt(g) || students.getStudent(i).getName().charAt(g) == chars) {
                        equality = true;
                    } else
                        equality = false;
                    break;
                }
            }

            if (equality == true) {
                students2.addStudent(students.getStudent(i));
            }
        }

        for (int i = 0; i<students2.getStudentsCount() ; i++){
            students1.addStudent(students2.getStudent(i));
        }

        return students1;

    }

    public static AllStudents getLearnerOnSurname(AllStudents students , String surname){
        AllStudents students1 = new Students();
        char chars = 042;
        for (int i = 0; i < students.getStudentsCount(); i++) {
            boolean equality = false;
            if (students.getStudent(i).getSurname().length() == surname.length()) {
                for (int g = 0; g < surname.length(); g++) {
                    if (students.getStudent(i).getSurname().charAt(g) == surname.charAt(g) || students.getStudent(i).getSurname().charAt(g) == chars) {
                        equality = true;
                    } else
                        equality = false;
                    break;
                }
            }

            if (equality == true) {
                students1.addStudent(students.getStudent(i));
            }
        }

        return students1;

    }

    public static  AllStudents getLearnerOnPatronymic(AllStudents students , String patronymic){
        AllStudents students1 = new Students();
        char chars = 042;
        for (int i = 0; i < students.getStudentsCount(); i++) {
            boolean equality = false;
            if (students.getStudent(i).getPatronymic().length() == patronymic.length()) {
                for (int g = 0; g < patronymic.length(); g++) {
                    if (students.getStudent(i).getPatronymic().charAt(g) == patronymic.charAt(g) || students.getStudent(i).getPatronymic().charAt(g) == chars) {
                        equality = true;
                    } else
                        equality = false;
                    break;
                }
            }

            if (equality == true) {
                students1.addStudent(students.getStudent(i));
            }
        }

        return students1;
    }

    public static AllStudents getLearnerOnDateOfEnrollment(AllStudents students , String dateOfEnrollment){
        AllStudents students1 = new Students();
        char chars = 042;
        for (int i = 0; i < students.getStudentsCount(); i++) {
            boolean equality = false;
            if (students.getStudent(i).getDateOfEnrollment().length() == dateOfEnrollment.length()) {
                for (int g = 0; g < dateOfEnrollment.length(); g++) {
                    if (students.getStudent(i).getDateOfEnrollment().charAt(g) == dateOfEnrollment.charAt(g) || students.getStudent(i).getDateOfEnrollment().charAt(g) == chars) {
                        equality = true;
                    } else
                        equality = false;
                    break;
                }
            }

            if (equality == true) {
                students1.addStudent(students.getStudent(i));
            }
        }

        return students1;
    }

    public static  AllStudents getLearnerOnGroupNumber(AllStudents students, int groupNumber){
        AllStudents students1 = new Students();
        for (int i = 0; i < students.getStudentsCount(); i++) {
            boolean equality = false;
            if (students.getStudent(i).getGroup().getGroupNumber() == groupNumber) {
                equality = true;
            }
            else
                equality = false;

            if (equality == true) {
                students1.addStudent(students.getStudent(i));
            }
        }

        return students1;
    }

    public static  AllStudents getLearnerOnFaculty(AllStudents students , String faculty){
        AllStudents students1 = new Students();
        for (int i = 0; i < students.getStudentsCount(); i++) {
            boolean equality = false;
            if (students.getStudent(i).getGroup().getFaculty() == faculty) {
                equality = true;
            }
            else
                equality = false;

            if (equality == true) {
                students1.addStudent(students.getStudent(i));
            }
        }

        return students1;
    }

    public  static  void loadInformationFromOtherFile(ObjectInputStream inputStream , AllStudents students){
        try {
            AllStudents students1 = (Students) inputStream.readObject();
            for (int i = 0; i<students1.getStudentsCount() ; i++){
                boolean equality = false;
                for (int g = 0; g<students.getStudentsCount() ; g++){
                   if( students.getStudent(g).equals(students1.getStudent(i)) == true){
                       equality = false;
                       break;
                   }
                   else
                       equality = true;
                }

                if(equality == true){
                    students.addStudent(students1.getStudent(i));
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
