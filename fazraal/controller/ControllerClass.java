package com.github.fazraal.controller;

import com.github.fazraal.AllStudent;
import com.github.fazraal.information.Students;

import java.io.*;

public class ControllerClass {


    public static void serializeBuilding(AllStudent students, OutputStream out) throws IOException {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(students);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static AllStudent deserializeBuilding(InputStream in) throws ClassNotFoundException {
        AllStudent students = null;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(in);
            students = (Students) inputStream.readObject();
            inputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return students;
    }

    public static AllStudent getLearnerOnName(AllStudent students, String name) {
        AllStudent students1 = students;
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

        return students2;

    }

    public static AllStudent getLearnerOnSurname(AllStudent students , String surname){
        AllStudent students1 = new Students();
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

    public static AllStudent getLearnerOnPatronymic(AllStudent students , String patronymic){
        AllStudent students1 = new Students();
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

    public static AllStudent getLearnerOnDateOfEnrollment(AllStudent students , String dateOfEnrollment){
        AllStudent students1 = new Students();
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

    public static AllStudent getLearnerOnGroupNumber(AllStudent students, int groupNumber){
        AllStudent students1 = new Students();
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

    public static AllStudent getLearnerOnFaculty(AllStudent students , String faculty){
        AllStudent students1 = new Students();
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

    public  static  void loadInformationFromOtherFile(ObjectInputStream inputStream , AllStudent students){
        try {
            AllStudent students1 = (Students) inputStream.readObject();
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
