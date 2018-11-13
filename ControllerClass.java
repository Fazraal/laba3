package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class ControllerClass implements Serializable {
    private ArrayList<Student> students;

    public ControllerClass(Student[] students){
        ArrayList<Student> st = new ArrayList<Student>(students.length);
        for(int i =0; i<students.length ; i++){
            st.add(i,students[i]);
        }
        this.students = st;
    }

    public ControllerClass(){
        this.students = null;
    }


    public ControllerClass(Student student){
        this.students.add(student);
    }

    public ArrayList getStudents() {
        return students;
    }

    public void setStudents(ArrayList students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void deleteStudent(int index){
        this.students.remove(index);
    }

    public void setStudent(Student student, int index){
        this.students.set(index,student);
    }

    public  Student getStudent(int index){
        return (Student) this.students.get(index);
    }

    @Override
    public String toString() {
        String st = new String();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < students.size(); i++) {
            stringBuffer.append(getStudent(i).getSurname());
            stringBuffer.append(" " + getStudent(i).getName());
            stringBuffer.append(" " + getStudent(i).getSurname());
            stringBuffer.append(" " + getStudent(i).getGroup().toString());
            stringBuffer.append(" " + getStudent(i).getDateOfEnrollment());
        }
        st = String.valueOf(stringBuffer);
        return st;
    }
}
