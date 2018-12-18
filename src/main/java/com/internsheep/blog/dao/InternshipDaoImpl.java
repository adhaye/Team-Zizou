/*package com.internsheep.blog.dao;

import com.internsheep.blog.Model.Internship;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class InternshipDaoImpl implements InternshipDao {

    public static List<Internship> internships = new ArrayList<>();

    static {

        internships.add(new Internship(1, new String("Ordinateur portable"), 350));

        internships.add(new Internship(2, new String("Aspirateur Robot"), 500));

        internships.add(new Internship(3, new String("Table de Ping Pong"), 750));

    }

    @Override
    public List<Internship> findAll() {
        return internships;
    }

    @Override
    public Internship findById(int id) {
        for (Internship internship : internships) {
            if(internship.getId() ==id){
                return internship;
            }
        }
        return null;
    }

    @Override
    public Internship save(Internship internship) {
        internships.add(internship);
        return internship;
    }
}
*/