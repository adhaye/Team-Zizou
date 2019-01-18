package com.stage.servicestage.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.stage.servicestage.model.User;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ConnexionInscriptionDao extends JpaRepository <User,Integer>{

    /*List<User> findByUsername (String username);
    List<User> findAll();

    @Query("SELECT username FROM User where id=:id")
    List<User> takeBdd(@Param ("id") int id);*/



    @Query("SELECT password FROM User WHERE email = :email ")
    String authentificationUser(@Param ("email") String email);

    @Query("SELECT username FROM User WHERE email = :email ")
    String Username(@Param ("email") String email);

    @Query("SELECT type FROM User WHERE email = :email ")
    Integer Type(@Param ("email") String email);

    @Query("SELECT IDUser FROM User WHERE email = :email ")
    Integer idUser (@Param ("email") String email);

    /*@Modifying
    @Query(value ="INSERT INTO user (id_user, email, password, username) VALUES (:id_user, :email, :password, :username)", nativeQuery =true)
    @Transactional
    void insertBdd(@Param ("id_user") int ok, @Param ("email") String string, @Param ("password") String string1,@Param ("username") String string3);
    */

    User save(User user);

    List<User> findAll();



}
