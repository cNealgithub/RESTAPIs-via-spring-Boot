package com.cNealgithub.RESTAPIs.service;

import com.cNealgithub.RESTAPIs.DTO.addStudentDTO;
import com.cNealgithub.RESTAPIs.DTO.studentDTO;

import java.util.List;

public interface studentService {

    List<studentDTO> grtAllStudents();
    studentDTO getStudentById(int id);
    studentDTO createStudent(addStudentDTO addStudentDTO);
    void deleteStudent(int id);
}
