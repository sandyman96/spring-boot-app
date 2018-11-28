package com.spring.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee extends BaseEntity {

    @Column(name = "EmiratesID", unique = true)
    private String emiratesID;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    public String getEmiratesID() {
        return emiratesID;
    }

    public void setEmiratesID(String emiratesID) {
        this.emiratesID = emiratesID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}