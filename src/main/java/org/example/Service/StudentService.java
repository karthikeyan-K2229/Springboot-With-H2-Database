package org.example.Service;

import org.example.Entity.Student;
import org.example.Repository.StudentRepo;
import org.example.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private static final String NOTFOUND="id does not exist ";
    @Autowired
    StudentRepo studentRepo;


    public Student SaveStudent(Student student) {
       return studentRepo.save(student);
    }

    public List<Student> getAllstudents() {
        return (List<Student>) studentRepo.findAll();
    }

    public void deletebyId(int id) {
         studentRepo.deleteById(id);
    }

    public Optional<Student> getbyid(int id) {
        return studentRepo.findById(id);
    }

    public Student updatestudent(int id, Student student) {
        Student user=studentRepo.findById(id).orElseThrow(()->new NotFoundException(NOTFOUND +id));
        user.setEmail(student.getEmail());
        user.setName(student.getName());
        return studentRepo.save(user);
    }
}
