package com.github.fazraal.information;

import com.github.fazraal.AllStudents;
import com.github.fazraal.Learner;

import java.io.Serializable;
import java.util.ArrayList;

public class Students implements Serializable  , AllStudents {


    private ArrayList<Learner> students;

    public Students(Learner[] students){
        ArrayList<Learner> st = new ArrayList<>(students.length);
        for(int i =0; i<students.length ; i++){
            st.add(i,students[i]);
        }
        this.students = st;
    }

    public  Students (ArrayList<Learner> students){
        this.students = students;
    }

    public Students(){
        this.students = null;
    }


   /* public Students(Student student){
        this.students.add(student);
    }*/

    public ArrayList getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Learner> students) {
        for (int i = 0; i < students.size(); i++) {
            this.students.add(students.get(i));
        }
    }

    public void addStudent(Learner student){
      // students.ensureCapacity(students.size() +1);
        this.students.add(student);
    }

    public void deleteStudent(int index){
        this.students.remove(index);
    }

    public void setStudent(Learner student, int index){
        this.students.set(index,student);
    }

    public  Learner getStudent(int index){
        return (Student) this.students.get(index);
    }

    public int getStudentsCount(){
       return students.size();
    }

    @Override
    public String toString() {
        String st = new String();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < students.size(); i++) {
            stringBuffer.append(getStudent(i).getSurname());
            stringBuffer.append(" " + getStudent(i).getName());
            stringBuffer.append(" " + getStudent(i).getPatronymic());
            stringBuffer.append(" " + getStudent(i).getGroup().toString());
            stringBuffer.append(" " + getStudent(i).getDateOfEnrollment());
        }
        st = String.valueOf(stringBuffer);
        return st;
    }
}
