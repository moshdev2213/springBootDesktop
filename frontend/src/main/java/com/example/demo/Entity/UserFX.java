package com.example.demo.Entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserFX {
    private IntegerProperty userId;
    private StringProperty name;
    private StringProperty email;
    private StringProperty street;
    private StringProperty city;
    private IntegerProperty zipcode;
    private StringProperty tel;
    private StringProperty password;

    public UserFX() {
        this.userId = new SimpleIntegerProperty(this,"userId");
        this.name = new SimpleStringProperty(this,"name");
        this.email = new SimpleStringProperty(this,"email");
        this.street = new SimpleStringProperty(this,"street");
        this.city = new SimpleStringProperty(this,"city");
        this.zipcode = new SimpleIntegerProperty(this,"zipcode");
        this.tel = new SimpleStringProperty(this,"tel");
        this.password = new SimpleStringProperty(this,"password");
    }

    public UserFX(int userId, String name,String email,String street,String city,int zip,String tel, String password) {
        this();
        setId(userId);
        setName(name);
        setEmail(email);
        setStreet(street);
        setCity(city);
        setZipcode(zip);
        setTel(tel);
        setPassword(password);
    }

    public int getId() {
        return userId.get();
    }

    public IntegerProperty idProperty() {
        return userId;
    }

    public void setId(int id) {
        this.userId.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public int getZipcode() {
        return zipcode.get();
    }

    public IntegerProperty zipcodeProperty() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode.set(zipcode);
    }

    public String getTel() {
        return tel.get();
    }

    public StringProperty telProperty() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }


}
