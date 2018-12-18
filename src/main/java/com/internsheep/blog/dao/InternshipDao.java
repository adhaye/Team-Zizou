package com.internsheep.blog.dao;

import com.internsheep.blog.Model.Internship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternshipDao extends JpaRepository<Internship, Integer> {

    public List<Internship> findAll();

    public Internship findById (int id);

    public Internship save(Internship internship);
}
