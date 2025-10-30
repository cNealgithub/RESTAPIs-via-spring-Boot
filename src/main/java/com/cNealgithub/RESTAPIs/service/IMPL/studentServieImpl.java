package com.cNealgithub.RESTAPIs.service.IMPL;

import com.cNealgithub.RESTAPIs.DTO.studentDTO;
import com.cNealgithub.RESTAPIs.entity.student;
import com.cNealgithub.RESTAPIs.repository.studentRepository;
import com.cNealgithub.RESTAPIs.service.studentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class studentServieImpl implements studentService {

    private final studentRepository studentRepository;
    @Override
    public List<studentDTO> grtAllStudents() {
        List<student> allStudnts = studentRepository.findAll();
        List<studentDTO> allStudentDTO = allStudnts
                .stream()
                .map(student -> new studentDTO(student.getId(), student.getName(), student.getEmail()))
                .toList();
        return allStudentDTO;
    }
}
