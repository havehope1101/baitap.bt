package com.example.baitapbt4.pokeService;

import com.example.baitapbt4.entity.PokeEntity;
import com.example.baitapbt4.pokeRepository.*;
import com.example.baitapbt4.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokeService {
    @Autowired
    private PokeRepository pokeRepository;

    public PokeEntity findById(String id) {
        return pokeRepository.findById(id).get();
    }

    public PokeEntity findByName(String name) {
        return  pokeRepository.findByName(name);
    }

    public Iterable<PokeEntity> findAll() {
        return pokeRepository.findAll();
    }

    public Iterable<PokeEntity> findByGen(String gen) {
        return pokeRepository.findPokeEntitiesByGeneration(gen);
    }

    public List<PokeEntity> lessthan(Double Total) {
        return pokeRepository.findByTotalLessThan(Total);
    }

    public List<PokeEntity> greaterthan(Double Total) {
        return pokeRepository.findByTotalGreaterThan(Total);
    }

    public Iterable<PokeEntity> pageSortPokemon(Integer page) {
        return pokeRepository.findAllBy(PageRequest.of(page,5));
    }

    public Iterable<PokeEntity> findPokeBy(Integer page) {
        return pokeRepository.findPokeEntityByAttackAndDefenseAndSpAtkAndSpDefaAndHPAndTotal(PageRequest.of(page,5));
    }


}
