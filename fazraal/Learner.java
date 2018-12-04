package com.github.fazraal;

public  interface Learner {
    public String getName();
    public String getSurname();
    public String getPatronymic();
    public Group getGroup();
    public String getDateOfEnrollment();
    public void setName(String name);
    public void setSurname(String surname);
    public void setPatronymic(String patronymic);
    public void setGroup(com.github.fazraal.information.Group group);
    public void setDateOfEnrollment(String dateOfEnrollment);
    public boolean equals(Learner obj);
}
