package com.github.fazraal;

import java.util.ArrayList;

public interface AllStudents {
    public ArrayList<Learner> getStudents();
    public void setStudents(ArrayList<Learner> students);
    public void addStudent(Learner student);
    public void deleteStudent(int index);
    public void setStudent(Learner student, int index);
    public  Learner getStudent(int index);
    public int getStudentsCount();


}
