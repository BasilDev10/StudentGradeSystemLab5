package com.example.studentgradesystemlab5.Controller;

import com.example.studentgradesystemlab5.ApiResponse.ApiResponse;
import com.example.studentgradesystemlab5.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    ArrayList<Student> students = new ArrayList<>();

    public StudentController(){
        addDefaultStudent();
    }
    // default student
    public void addDefaultStudent(){
        students.add(new Student("101531153","Basil",27,4.5));
        students.add(new Student("123156322","Mohammed",26,4.9));
        students.add(new Student("165321565","Abdullah",24,4.3));
        students.add(new Student("135165328","Abdulrahman",22,3.5));
        students.add(new Student("154632123","Rayan",24,2.5));
        students.add(new Student("105648651","Anas",22,3.0));
    }

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student){
        students.add(student);
        return new   ApiResponse("Student Added Successfully");
    }

    @GetMapping("/get")
    public ArrayList<Student> getStudent(){
        return students;
    }
    @GetMapping("/get/student-great-then-average-gpa")
    public  ArrayList<Student> getStudentGreatThenAverageGPA(){
        ArrayList<Student> studentGreatThenAverageGPA = new ArrayList<>();
        double averageGPA = averageGPA();
        for(Student student : students){
            if(student.getGPA() > averageGPA)studentGreatThenAverageGPA.add(student);
        }
        return studentGreatThenAverageGPA;

    }

    public double averageGPA(){
        double sum = 0;
        for(Student student : students){
            sum+=student.getGPA();
        }
        return sum/students.size();
    }
    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@PathVariable int index , @RequestBody Student student){

        if(index >= students.size() || index < 0)return new ApiResponse("Student Not Found");

        students.set(index,student);
        return new ApiResponse("Student Updated Successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index){

        if(index >= students.size() || index < 0)return new ApiResponse("Student Not Found");

        students.remove(index);
        return new ApiResponse("Student Deleted Successfully");
    }
}
