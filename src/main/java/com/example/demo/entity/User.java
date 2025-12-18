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
}