package com.stage.servicestage.dao;

import com.stage.servicestage.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.stage.servicestage.model.User;

@Repository
public interface StageDao extends JpaRepository<Stage,Integer>{

    /*@Modifying
    @Query(value ="INSERT INTO stage (id_stage, poste, entreprise, localisation) VALUES (:id_stage, :poste, :entreprise, :localisation)", nativeQuery =true)
    @Transactional
    void insertStageBdd(@Param ("id_stage") int ok, @Param ("poste") String string, @Param ("entreprise") String string1,@Param ("localisation") String string3);
*/

    Stage save(Stage stage);

    //@Query("SELECT poste, entreprise, localisation, date, duree, commentaire, gratification, parcours, note FROM Stage WHERE IDUser = :IDUser ")
    //List<Stage> findAllByIDUser (@Param ("IDUser") int IDUser);


    List<Stage> findAll();

    List<Stage> findByPoste(String poste);
    List<Stage> findByEntreprise(String entreprise);
    List<Stage> findByPosteAndEntreprise(String poste, String entreprise);
    List<Stage> findAllByOrderByGratificationDesc();
    List<Stage> findAllByOrderByNoteDesc();
    List<Stage> findByIdUser(int id_user);



}

