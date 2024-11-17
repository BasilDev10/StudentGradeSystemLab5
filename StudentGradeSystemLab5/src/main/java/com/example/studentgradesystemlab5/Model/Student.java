package com.example.studentgradesystemlab5.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Student {
    private String id;
    private String name;
    private int age;
    private String degree;
    private double GPA;

    public Student(){

    }
    public Student(String id, String name, int age, double GPA) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.degree = getDegree();
        this.GPA = GPA;
    }

    public String getDegree(){


        if(this.getGPA() >= 4.8){

            return "summa cum laude";
        }else if(this.getGPA() >= 4.5){
            return "magna cum laude";
        }else {
            return "cum laude";
        }
    }
}




