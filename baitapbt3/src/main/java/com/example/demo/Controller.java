package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;


import javax.swing.text.html.parser.Entity;

import static org.springframework.web.client.HttpClientErrorException.*;


@RestController
public class Controller {
    int x = 0;
    String data = "";

    @GetMapping("/User/{id}")
    public ResponseEntity<String> Entity(@PathVariable String id) {

        if (id.equals(data)) {
            x++;
        } else {
            data = id;
        }
        if (x > 2) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("too many request");
        } else

            return ResponseEntity.status(HttpStatus.OK).body(id);


    }
}

