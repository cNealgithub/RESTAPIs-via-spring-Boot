package com.cNealgithub.RESTAPIs.service.IMPL;

import com.cNealgithub.RESTAPIs.DTO.addStudentDTO;
import com.cNealgithub.RESTAPIs.DTO.studentDTO;
import com.cNealgithub.RESTAPIs.entity.student;
import com.cNealgithub.RESTAPIs.repository.studentRepository;
import com.cNealgithub.RESTAPIs.service.studentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

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

    @Override
    public studentDTO createStudent(addStudentDTO addStudentDTO) {
        student std = modelMapper.map(addStudentDTO, student.class);
        student student = studentRepository.save(std);
        return modelMapper.map(student, studentDTO.class);
    }

    @Override
    public void deleteStudent(int id) {
        if(!studentRepository.existsById(id)){
             throw new IllegalArgumentException("Student does not exist with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public studentDTO updateStudent(int id, addStudentDTO addStudentDTO) {
        student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with id: " + id + " is not preset"));
        modelMapper.map(addStudentDTO , student);
         studentRepository.save(student);
        return modelMapper.map(student, studentDTO.class);
    }

    @Override
    public studentDTO updatePatchStudent(int id, Map<String, Object> updates) {
        student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
        updates.forEach((field, value) ->{
            switch(field){
                case "name": student.setName((String)value);
                break;

                case "email": student.setEmail((String)value);
                break;

                default:
                    throw new IllegalArgumentException("Invalid fields");
            }
        });
        student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, studentDTO.class);
    }
}
