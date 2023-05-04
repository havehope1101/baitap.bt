package com.example.baitapbt4.pokeRepository;

import com.example.baitapbt4.entity.PokeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokeRepository extends CrudRepository<PokeEntity, Integer> {

     @Query("SELECT p FROM PokeEntity p WHERE " + "p.Name LIKE CONCAT('%', :name, '%')")
     public PokeEntity findByName(String name);
}
