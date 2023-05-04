package com.example.baitapbt4.pokeService;

import com.example.baitapbt4.entity.PokeEntity;
import com.example.baitapbt4.pokeRepository.PokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokeService {
    @Autowired
    private PokeRepository pokeRepository;

    public PokeEntity findById(Integer id) {
        return pokeRepository.findById(id).get();
    }

    public PokeEntity findByName(String name) {
        return  pokeRepository.findByName(name);
    }

    public Iterable<PokeEntity> findAll() {
        return pokeRepository.findAll();
    }
}
