package com.example.baitapbt4.pokeService;

import com.example.baitapbt4.entity.PokeEntity;
import com.example.baitapbt4.pokeRepository.*;
import com.example.baitapbt4.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<PokeEntity> findByTotal(Double Total) {
        return pokeRepository.findByTotalLessThan(Total);
    }

//    public Iterable<PokeEntity> pageSortPokemon() {
//        return pokeRepository.findPokeEntity(Pageable.unpaged());
//    }


}
