package com.github.fazraal;

import com.github.fazraal.information.Group;

public  interface Learner {
    public String getName();
    public String getSurname();
    public String getPatronymic();
    public Groups getGroup();
    public String getDateOfEnrollment();
    public void setName(String name);
    public void setSurname(String surname);
    public void setPatronymic(String patronymic);
    public void setGroup(Group group);
    public void setDateOfEnrollment(String dateOfEnrollment);
    public boolean equals(Learner obj);
}
