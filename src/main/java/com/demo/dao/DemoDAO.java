package com.demo.dao;

import com.demo.model.DemoObject;
import com.demo.model.StudentVO;

import java.util.List;

public interface DemoDAO
{
    List<StudentVO> getAllStudents() throws Exception;
    List<DemoObject> getDemoObject(String genreId) throws Exception;
}