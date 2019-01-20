package com.stage.servicestage.dao;

import com.stage.servicestage.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StageDao extends JpaRepository<Stage,Integer>{

    Stage save(Stage stage);
    List<Stage> findAllByOrderByIdStageDesc();
    List<Stage> findByPoste(String poste);
    List<Stage> findByEntreprise(String entreprise);
    List<Stage> findByPosteAndEntreprise(String poste, String entreprise);
    List<Stage> findAllByOrderByGratificationDesc();
    List<Stage> findAllByOrderByNoteDesc();
    List<Stage> findByIdUser(int id_user);
    Optional<Stage> findById(int id_stage);
    void delete(Stage stage);

}

