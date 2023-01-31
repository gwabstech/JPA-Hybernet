package com.gwabstech.JPA.Hybernet.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseJdbcRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Course course){
        String INSERT_INTOtABLE =
                """
                  insert into course (id, name, author)
                  values (?,?,?);
                """;
       // jdbcTemplate.update(INSERT_INTOtABLE);
        jdbcTemplate.update(INSERT_INTOtABLE,course.getId(),course.getName(),course.getAuthor());
   }

   public void deleteById(long id){
      String deletebyId = """
            delete from course
             where id = ? 
       """;
      jdbcTemplate.update(deletebyId,id);
   }

   public Course getCoursesById(long id){
        String getAll =
                """
                    select * from course where id = ?
                """;

       return jdbcTemplate.queryForObject(getAll,new BeanPropertyRowMapper<>(Course.class),id );
   }

   public List<Course> getCourses(){
      String  getCourses = """
              select * from course 
        """;
        return jdbcTemplate.query(getCourses,new BeanPropertyRowMapper<>(Course.class),null);
   }

}
