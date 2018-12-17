package com.github.fazraal.controller;

import com.github.fazraal.AllStudent;
import com.github.fazraal.Learner;
import com.github.fazraal.information.Students;

import java.io.*;
import java.util.ArrayList;

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

    public static AllStudent getLearnerOnName(AllStudent students, String name , int index) {
        AllStudent students1 = students;
        char chars = 042;
        Students students2 = new Students();
        for (int i = 0; i < students.getStudentsCount(); i++) {
            String type = null;
            if(index == 2 ){
                type = students.getStudent(i).getName();
            }
            if(index == 3){
                type =students.getStudent(i).getSurname();
            }
            if (index == 4){
                type = students.getStudent(i).getPatronymic();
            }
            if (index == 5){
                AllStudent result = new Students();
                for (Learner student : students.getStudents()) {
                    if (!student.getDateOfEnrollment().matches(name)) {
                        continue;
                    }
                    result.addStudent(student);
                }
                return result;
            }
            if(index == 6){
                AllStudent result = new Students();
                for (Learner student : students.getStudents()) {
                    if (!student.getGroup().getFaculty().matches(name)) {
                        continue;
                    }
                    result.addStudent(student);
                }
                return result;
            }
            boolean equality = false;
            if (type.length() == name.length()) {
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

   /* public static AllStudent getLearnerOnFaculty(AllStudent students , String faculty){
        AllStudent result = new Students();
        for (Learner student : students.getStudents()) {
            if (!student.getGroup().getFaculty().matches(faculty)) {
                continue;
            }
            result.addStudent(student);
        }
        return result;
    }*/

    public  static  void loadInformationFromOtherFile(File inputStream , AllStudent students)  {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(inputStream));
                AllStudent students1 = new Students();
                students1 = (AllStudent) objectInputStream.readObject();
                System.out.println(students1.toString());
                if(students.getStudentsCount() == 0){
                    students.getStudents().addAll(students1.getStudents());
                }

                    for (int i = 0; i < students1.getStudentsCount(); i++) {
                        boolean equality = false;
                        for (int g = 0; g < students.getStudentsCount(); g++) {
                            if (students.getStudent(g).equals(students1.getStudent(i)) == true) {
                                equality = false;
                                break;
                            } else
                                equality = true;
                        }

                        if (equality == true) {
                            students.addStudent(students1.getStudent(i));
                        }
                    }
        } catch (IOException e) {
            e.getMessage();

        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
        finally {
            try {
                objectInputStream.close();
            }
            catch ( IOException e){
                e.getMessage();
            }
        }

    }

    public static void  seeSortedOnStringType(AllStudent students, String type, int index){
        AllStudent students2 = new Students();
        students2 = ControllerClass.getLearnerOnName(students, type, index);
        for (int i = 0; i < students2.getStudentsCount(); i++) {
            System.out.println(students2.getStudent(i).toString());
        }
    }
}
