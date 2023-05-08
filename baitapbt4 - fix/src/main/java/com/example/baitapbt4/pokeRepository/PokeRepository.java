package com.example.baitapbt4.pokeRepository;

import com.example.baitapbt4.entity.PokeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokeRepository extends CrudRepository<PokeEntity, String>, JpaRepository<PokeEntity,String> {

     @Query("SELECT p FROM PokeEntity p WHERE " + "p.Name LIKE CONCAT('%', :name, '%')")
     PokeEntity findByName(String name);

     @Query("SELECT p FROM PokeEntity p WHERE " + "p.Generation LIKE CONCAT('%', :gen, '%')")
     List<PokeEntity> findPokeEntitiesByGeneration(String gen);

//     @Query("SELECT p FROM PokeEntity p WHERE p.Total < ?5")
     List<PokeEntity> findByTotalLessThan(Double Total);

//     @Query("SELECT p FROM PokeEntity p")
//     Page<PokeEntity> findPokeEntity(Pageable pageable);
}
