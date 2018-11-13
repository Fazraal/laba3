package com.company;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String surname;
    private String patronymic;
    private Group group;
    private String dateOfEnrollment;

    public Student(String surname, String name, String patronymic, Group group, String dateOfEnrollment) {
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

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setDateOfEnrollment(String dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }


}
