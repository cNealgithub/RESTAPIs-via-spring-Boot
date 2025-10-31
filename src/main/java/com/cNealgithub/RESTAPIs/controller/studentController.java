package com.cNealgithub.RESTAPIs.controller;

import com.cNealgithub.RESTAPIs.DTO.addStudentDTO;
import com.cNealgithub.RESTAPIs.DTO.studentDTO;
import com.cNealgithub.RESTAPIs.entity.student;
import com.cNealgithub.RESTAPIs.service.studentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class studentController {

    private final studentService studentService;

    @GetMapping("/Student")
    public student getStudent(){
        return new student(1, "Neal chakravarty", "neal@gmail.com");
    }
    @GetMapping("/allStudent")
    public ResponseEntity<List<studentDTO>> getAllStudent(){
        return ResponseEntity.ok(studentService.grtAllStudents());
    }
    @GetMapping("/Student/{id}")
    public ResponseEntity<studentDTO> getStudentById(@PathVariable int id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
    @PostMapping("/addStudent")
    public ResponseEntity<studentDTO> addStudent(@RequestBody addStudentDTO addStudentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(addStudentDTO));
    }
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Void> deletetudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
