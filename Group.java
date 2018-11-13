package com.company;

import java.io.Serializable;

public class Group implements Serializable {
    private int groupNumber;
    private String faculty;
    public Group(int groupNumber, String faculty){
        this.groupNumber =groupNumber;
        this.faculty = faculty;
    }

    public int getGroupNumber(){
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        String st =new String();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf(this.getGroupNumber()));
        stringBuffer.append(" " + this.getFaculty());
        st = String.valueOf(stringBuffer);
        return st;
    }
}
