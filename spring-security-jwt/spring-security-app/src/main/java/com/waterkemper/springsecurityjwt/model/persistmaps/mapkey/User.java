//package com.waterkemper.springsecurityjwt.model.persistmaps.mapkey;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.validation.constraints.Size;
//
//@Entity
//public class User {
//    @Id
//    @Column(length = 3)
//    private String firstName;
//
//    @Size(min = 3, max = 15)
//    private String middleName;
//
//    private String lastName;
//
//    @Column(length = 5)
//    @Size(min = 3, max = 5)
//    private String city;
//
//    public User(String firstName, String middleName, String lastName, String city) {
//        super();
//        this.firstName = firstName;
//        this.middleName = middleName;
//        this.lastName = lastName;
//        this.city = city;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getMiddleName() {
//        return middleName;
//    }
//
//    public void setMiddleName(String middletName) {
//        this.middleName = middletName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//}
