package com.demo.service;

import java.util.List;

import com.demo.model.DemoObject;
import com.demo.model.StudentVO;

public interface DemoService
{
    List<StudentVO> getAllStudents() throws Exception;
    List<DemoObject> getDemoObject(String genreId) throws Exception;
}