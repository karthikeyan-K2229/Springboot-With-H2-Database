package org.example.Controller;

import org.example.Entity.Student;
import org.example.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student)
    {
        return studentService.SaveStudent(student);
    }

    @GetMapping("/getstudent")
    public List<Student> getAllStudent()
    {
        return studentService.getAllstudents();
    }

    @DeleteMapping("/deletebyid/{id}")
    public String deletebyId(@PathVariable int id)
    {
         studentService.deletebyId(id);
         return "deleted successfully";
    }
    @GetMapping("/getbyId/{id}")
    public Optional<Student> getbyId(@PathVariable int id)
    {
        return studentService.getbyid(id);
    }

    @PutMapping("/update/{id}")
    public Student updatestudent(@PathVariable int id, @RequestBody Student student)
    {
      return studentService.updatestudent(id,student);
    }
}
