package br.com.infnet.presenca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PresencaController {
    @GetMapping("/{id}")
    public ResponseEntity<String> marcarPresenca(@PathVariable Long id) {
        System.out.println("Presença marcada para o aluno " + id);
        return ResponseEntity.ok("Presença marcada!");
    }
}
