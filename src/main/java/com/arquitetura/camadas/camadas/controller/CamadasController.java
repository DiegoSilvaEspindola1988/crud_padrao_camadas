package com.arquitetura.camadas.camadas.controller;

import com.arquitetura.camadas.camadas.entities.Mensagem;
import com.arquitetura.camadas.camadas.service.CamadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/camadas")
@RestController
public class CamadasController {
    @Autowired
    public CamadasService camadasService;
    public final List<Mensagem>mensagens;
    public CamadasController(){
        this.mensagens = new ArrayList<>();
    }
    @GetMapping
    public List<Mensagem>findAll(@RequestParam (required = false) String mensagem){
        return camadasService.findAll(mensagem);
    }

    @GetMapping("/{id}")
    public Mensagem findById(@PathVariable("/{id}") Integer id){
        return camadasService.findById(id);
    }
    @PostMapping
    public ResponseEntity<Integer>add(@RequestBody Mensagem mensagem){
        Integer id = camadasService.add(mensagem);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity upDate(@RequestBody Mensagem mensagem){
        camadasService.upDate(mensagem);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id ){
        camadasService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
