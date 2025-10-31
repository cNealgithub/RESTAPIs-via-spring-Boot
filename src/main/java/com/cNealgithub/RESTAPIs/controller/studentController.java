package com.cNealgithub.RESTAPIs.controller;

import com.cNealgithub.RESTAPIs.DTO.studentDTO;
import com.cNealgithub.RESTAPIs.entity.student;
import com.cNealgithub.RESTAPIs.service.studentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public List<studentDTO> getAllStudent(){
        return studentService.grtAllStudents();
    }
    @GetMapping("/Student/{id}")
    public studentDTO getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }
}
