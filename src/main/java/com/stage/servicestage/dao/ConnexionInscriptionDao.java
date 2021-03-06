package com.stage.servicestage.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stage.servicestage.model.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ConnexionInscriptionDao extends JpaRepository <User,Integer>{


    @Query("SELECT password FROM User WHERE email = :email ")
    String authentificationUser(@Param ("email") String email);

    @Query("SELECT username FROM User WHERE email = :email ")
    String Username(@Param ("email") String email);

    @Query("SELECT type FROM User WHERE email = :email ")
    Integer Type(@Param ("email") String email);

    @Query("SELECT IDUser FROM User WHERE email = :email ")
    Integer idUser (@Param ("email") String email);

    @Modifying
    @Query("Update User  set username = :username, email = :email, password = :password  where id_user = :iduser")
    @Transactional
    void setUsername(@Param("username")String username, @Param("email")String email, @Param("password")String password, @Param("iduser") int iduser);

    @Modifying
    @Query("Update User  set email = :email where id_user = :iduser")
    @Transactional
    void setEmail(@Param("email")String email, @Param("iduser") int iduser);

    @Modifying
    @Query("Update User  set password = :password where id_user = :iduser")
    @Transactional
    void setPassword(@Param("password")String password, @Param("iduser") int iduser);


    User save(User user);
    List<User> findAll();
    List<User> findByType(int type);
    Optional<User> findById(int IDUser);
    void delete(User user);

}
