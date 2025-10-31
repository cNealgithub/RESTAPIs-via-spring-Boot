package com.cNealgithub.RESTAPIs.service.IMPL;

import com.cNealgithub.RESTAPIs.DTO.studentDTO;
import com.cNealgithub.RESTAPIs.entity.student;
import com.cNealgithub.RESTAPIs.repository.studentRepository;
import com.cNealgithub.RESTAPIs.service.studentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
@RequiredArgsConstructor
public class studentServieImpl implements studentService {

    private final studentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<studentDTO> grtAllStudents() {
        List<student> allStudnts = studentRepository.findAll();
        List<studentDTO> allStudentDTO = allStudnts
                .stream()
                .map(student -> new studentDTO(student.getId(), student.getName(), student.getEmail()))
                .toList();
        return allStudentDTO;
    }

    @Override
    public studentDTO getStudentById( int id) {
        student std = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student with id: " + id + " is not present"));
        return modelMapper.map(std, studentDTO.class);
    }
}
