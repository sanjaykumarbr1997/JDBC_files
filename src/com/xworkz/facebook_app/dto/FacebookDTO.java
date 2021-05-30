package com.xworkz.facebook_app.dto;

public class FacebookDTO {
    private int id;
    private String name;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "FacebookDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

