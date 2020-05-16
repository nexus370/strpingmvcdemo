package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.model.DemoObject;
import com.demo.model.StudentVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.DemoDAO;

import javax.transaction.Transactional;

@Service
public class DemoServiceImpl implements DemoService {

    private static final Logger logger = LogManager.getLogger(DemoServiceImpl.class);

    @Autowired
    DemoDAO demoDAO;

    @Transactional
    public List<StudentVO> getAllStudents() throws Exception {
        List<StudentVO> studentsList = new ArrayList<StudentVO>();
        try{
            studentsList = demoDAO.getAllStudents();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return studentsList;
    }

    @Transactional
    public List<DemoObject> getDemoObject(String genreId){
        List<DemoObject> demoObjectList = new ArrayList<DemoObject>();
        try{
            demoObjectList = demoDAO.getDemoObject(genreId);
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }

        return demoObjectList;
    }
}