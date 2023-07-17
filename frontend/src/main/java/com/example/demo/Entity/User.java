package com.example.demo.Entity;


public class User {

    private  int id;
    private String name;
    private String email;
    private String street;
    private String city;
    private int zipcode;
    private String tel;
    private String password;



    public User(String name, String email, String street, String city, int zipcode, String tel, String password) {
        this.name = name;
        this.email = email;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.tel = tel;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
