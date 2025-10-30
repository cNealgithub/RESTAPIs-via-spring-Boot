package com.cNealgithub.RESTAPIs.repository;

import com.cNealgithub.RESTAPIs.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface studentRepository extends JpaRepository<student, Integer> {

}
