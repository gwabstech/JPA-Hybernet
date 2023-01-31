package com.gwabstech.JPA.Hybernet.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.lang.System.*;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

    @Autowired
    private CourseSpringDataJpaRepo repo;
    // private CourseJpaRepo repo;

    @Override
    public void run(String... args) throws Exception {
        repo.save(new Course(1,"Learn JAVA now","Abdullahi"));
        repo.save(new Course(2,"Learn JAVA now","Aliyu"));
        repo.save(new Course(3,"Learn JAVA now","Abubakar"));
        repo.save(new Course(4,"Learn JAVA now","Abubakar"));

        //repo.deleteById(1l);
        out.println(repo.findById(2l));
        out.println(repo.findById(3l));
        out.println(repo.findAll());
        out.println("the course count is "+repo.count());
        out.println(repo.findByAuthor("Abdullahi"));
        out.println(repo.findByAuthor("Aliyu"));




    }


}
