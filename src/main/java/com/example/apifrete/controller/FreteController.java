package com.example.apifrete.controller;

import com.example.apifrete.model.Frete;
import com.example.apifrete.service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fretes")
public class FreteController {

    @Autowired
    private FreteService freteService;

    @GetMapping
    public ResponseEntity<List<Frete>> getAllFretes() {
        return ResponseEntity.ok(freteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Frete> getFreteById(@PathVariable Long id) {
        return freteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Frete> createFrete(@RequestBody Frete frete) {
        Frete savedFrete = freteService.save(frete);
        return ResponseEntity.ok(savedFrete);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Frete> updateFrete(@PathVariable Long id, @RequestBody Frete frete) {
        if (freteService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        frete.setId(id);
        return ResponseEntity.ok(freteService.update(frete));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFrete(@PathVariable Long id) {
        if (freteService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        freteService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
