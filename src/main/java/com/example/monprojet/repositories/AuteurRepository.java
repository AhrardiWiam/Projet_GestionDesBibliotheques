package com.example.monprojet.repositories;

import com.example.monprojet.entities.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long> {

    @Query("SELECT a FROM Auteur a WHERE a.auteursLivres IS EMPTY")
    List<Auteur> findAuteursSansLivres();
}