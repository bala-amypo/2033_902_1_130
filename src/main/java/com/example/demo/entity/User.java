package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.*;
@Entity
public class User{
    @Id
    @GeneratedValue=(strategy=Generartion.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;

    public int getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public 
}