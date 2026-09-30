package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @jakarta.persistence.Column(name = "username", nullable = false, unique = true)
    private String username;
    @jakarta.persistence.Column(name = "email", nullable = false, unique = true)
    private String email;
    @jakarta.persistence.Column(name = "password", nullable = false)
    private String password;
    @jakarta.persistence.Column(name = "phone", nullable = false)
    private int phone;
    @jakarta.persistence.Column(name = "date_age", nullable = false)
    private String date_age;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    public User(Long id, String username, String email, String password, int phone, String date_age, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.date_age = date_age;
        this.role = role;
    }

    public User(){
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public String getDate_age() {
        return date_age;
    }
    public void setDate_age(String date_age) {
        this.date_age = date_age;
    }
    public Role getRole(){
        return role;
    }
    public void setRole(Role role){
        this.role = role;
    }

}