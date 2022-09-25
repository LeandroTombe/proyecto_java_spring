package com.proyecto.Alkemy.controllers;

import com.proyecto.Alkemy.models.personaje;
import com.proyecto.Alkemy.service.personajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/characters")
public class personajeController {

    @Autowired
    personajeService personajeService;


    //Metodo para obtener todos los personajes
    @GetMapping("/all")
    ResponseEntity<List<personaje>> getAllPersonajes(){
        return ResponseEntity.ok(personajeService.getAllPersonajes());
    }

    //Metodo para obtener todos los personajes por nombre
    @GetMapping("/nombre")
    ResponseEntity<List<personaje>> getPersonajeByNombre(String nombre){
        return ResponseEntity.ok(personajeService.getPersonajeByNombre(nombre));
    }

    // metodo para buscar personaje por id
    @GetMapping("/{id}")
    ResponseEntity<personaje> getPersonajeById(@PathVariable("id") long id)  {
           if(!personajeService.existsById(id)){
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }
              return ResponseEntity.ok(personajeService.getPersonajeById(id));
    }
}
