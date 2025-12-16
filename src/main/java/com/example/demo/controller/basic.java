package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
@RestController
public class basic{
    @GetMapping("/home")
public String name(){
 return "hello";
}
}