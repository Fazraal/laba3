package com.github.fazraal.information;

import com.github.fazraal.AllStudent;
import com.github.fazraal.Learner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Students implements Serializable  , AllStudent {


    private ArrayList<Learner> students = null;

    public Students(Learner[] students){

       // this.students.addAll(Arrays.asList(students));

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
        this.students = new ArrayList<Learner>();
    }




    public ArrayList getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Learner> students) {

        this.students.addAll(students);

        /*  for (int i = 0; i < students.size(); i++) {
            this.students.add(students.get(i));
        }*/


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
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            stringBuilder.append(getStudent(i).getSurname());
            stringBuilder.append(" " + getStudent(i).getName());
            stringBuilder.append(" " + getStudent(i).getPatronymic());
            stringBuilder.append(" " + getStudent(i).getGroup().toString());
            stringBuilder.append(" " + getStudent(i).getDateOfEnrollment());
        }

        return stringBuilder.toString();
    }
}
