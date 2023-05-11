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


    @GetMapping("/poke/{id}")
    public PokeEntity findById(@PathVariable String id) {
        return pokeService.findById(id);
    }

    @GetMapping("/pokemon")
    public Iterable<PokeEntity> findAll() {
        return pokeService.findAll();
    }

    @GetMapping("/pokename")
    public ResponseEntity<PokeEntity> searchPokemon(@RequestParam("name") String name) {
        return ResponseEntity.ok(pokeService.findByName(name));
    }

    @GetMapping("/pokebygen")
    public Iterable<PokeEntity> findByGen(@RequestParam String gen) {
        return pokeService.findByGen(gen);
    }

    @GetMapping("/pokelessthan")
    public ResponseEntity<List<PokeEntity>> getPokeTotalLessThan (@RequestParam("total") Double Total) {
        return new ResponseEntity<List<PokeEntity>>(pokeService.lessthan(Total),HttpStatus.OK);
    }

    @GetMapping("/pokegreaterthan")
    public ResponseEntity<List<PokeEntity>> getPokeTotalGreaterThan (@RequestParam("total") Double Total) {
        return new ResponseEntity<List<PokeEntity>>(pokeService.greaterthan(Total),HttpStatus.OK);
    }

    @GetMapping("pokepage/{page}")
    public Iterable<PokeEntity> findPokemonWithPageSort (@PathVariable Integer page ) {
        return pokeService.pageSortPokemon(page);
    }
}