package com.example.baitapbt4.pokeController;

import com.example.baitapbt4.entity.PokeEntity;
import com.example.baitapbt4.pokeService.PokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokeController {

    @Autowired
    private PokeService pokeService;

    @GetMapping("/")
    public String homepage() {
        return "haha";
    }

    @GetMapping("/pokemon/{id}")
    public PokeEntity findById(@PathVariable Integer id) {
        return pokeService.findById(id);
    }

    @GetMapping("/pokemon")
    public Iterable<PokeEntity> findAll() {
        return pokeService.findAll();
    }

    @GetMapping("/pokemon/name")
    public ResponseEntity<List<PokeEntity>> getPokemonByName(@RequestParam String name) {
        return new ResponseEntity((List<PokeEntity>) pokeService.findByName(name), HttpStatus.OK);
    }

}