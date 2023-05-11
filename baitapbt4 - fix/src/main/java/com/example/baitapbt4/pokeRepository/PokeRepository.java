package com.example.baitapbt4.pokeRepository;

import com.example.baitapbt4.entity.PokeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

     List<PokeEntity> findByTotalLessThan(Double Total);

     List<PokeEntity> findByTotalGreaterThan(Double Total);

//     @Query("SELECT p FROM PokeEntity p")
     Page<PokeEntity> findAllBy(Pageable pageable);

     @Query("SELECT P FROM PokeEntity p WHERE (:Attack is null or p.Attack = :Attack) and (:Defense is null or p.Defense= :Defense) and (:SpAtk is null or  p.SpAtk = :SpAtk) and (:SpDef is null or p.SpDef = :SpDef) and (:Hp is null or p.HP = :Hp) and (:total is null or p.total = :total)")
     Page<PokeEntity> findPokeEntityByAttackAndDefenseAndSpAtkAndSpDefaAndHPAndTotal(Pageable pageable);

}
