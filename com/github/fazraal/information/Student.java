package com.github.fazraal.information;

import com.github.fazraal.Group;
import com.github.fazraal.Learner;

import java.io.Serializable;

public class Student implements Serializable , Learner {
    private String name;
    private String surname;
    private String patronymic;
    private Group group;
    private String dateOfEnrollment;

    public Student(String surname, String name, String patronymic, com.github.fazraal.information.Group group, String dateOfEnrollment) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.group = group;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Group getGroup() {
        return group;
    }

    public String getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setGroup(com.github.fazraal.information.Group group) {
        this.group = group;
    }

    public void setDateOfEnrollment(String dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }



    @Override
    public String toString() {
        String st = this.surname + ' ' + this.name  + ' ' + this.patronymic + ' ' + getGroup().toString() + ' ' + this.getDateOfEnrollment()  ;
        return st;
    }


    public boolean equals(Learner obj) {
        if(obj instanceof  Student == false){
            return  false;
        }
        else
            if (obj.getName() == this.name && obj.getSurname() == this.surname && obj.getPatronymic() == this.patronymic && obj.getDateOfEnrollment() == this.dateOfEnrollment && this.getGroup().equals(obj.getGroup()) == true){
                return  true;
            }

            return  false;
    }
}
