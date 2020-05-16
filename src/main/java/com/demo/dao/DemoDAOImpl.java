package com.demo.dao;

import com.demo.model.DemoObject;
import com.demo.model.StudentVO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DemoDAOImpl implements DemoDAO {

    private static final Logger logger = LoggerFactory.getLogger(DemoDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public List<StudentVO> getAllStudents() throws Exception {
        Session session =  sessionFactory.getCurrentSession();
        List<StudentVO> stuudentsList = new ArrayList<StudentVO>();
        String queryString = "SELECT id as id, first_name as firstName, last_name as lastName, email as email FROM stud";
        try{
            Query query = session.createSQLQuery(queryString);
            stuudentsList = query.setResultTransformer(Transformers.aliasToBean(StudentVO.class)).list();
        }catch (HibernateException he){
            throw new Exception(he.getMessage());
        }

        return stuudentsList;
    }

    public List<DemoObject> getDemoObject(String genreId) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        List<DemoObject> demoOBjectList = new ArrayList<DemoObject>();
        String queryString = "SELECT s_id as id,\n" +
                "                            s_title as title,\n" +
                "                            genre.g_name as genreName,\n" +
                "                            accounts.ac_public_name as producerName,\n" +
                "                            s_price as price, \n" +
                "                            DATE_FORMAT(s_last_modified_date, '%d/%m/%Y %H:%i:%s') as lastModifiedDate,\n" +
                "                            DATE_FORMAT(s_added_date, '%d/%m/%Y %H:%i:%s')  as addedDate,\n" +
                "                            s_downloads as downloads,\n" +
                "                            s_sales as sales,\n" +
                "                            s_rating as rating,     \n" +
                "                            s_status as status\n" +
                "                            FROM song \n" +
                "                            JOIN accounts on accounts.ac_id = song.s_producer\n" +
                "                            JOIN genre on genre.g_id = song.s_genre\n" +
                "                            WHERE 1=1 ";

        if(genreId != ""){
            queryString +=  " AND genre.g_id = :genreId";
        }

        try{
            Query query = session.createSQLQuery(queryString);

            if(genreId != ""){
                query.setString("genreId", genreId);
            }
            logger.debug("SQL QUERY: " + queryString);
            demoOBjectList = query.setResultTransformer(Transformers.aliasToBean(DemoObject.class)).list();
        }catch (HibernateException he){
            logger.debug("exception: " + demoOBjectList);
            throw new Exception(he.getMessage());
        }

        return demoOBjectList;
    }

}