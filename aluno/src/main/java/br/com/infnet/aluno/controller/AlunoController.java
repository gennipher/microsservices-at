package br.com.infnet.aluno.controller;

import br.com.infnet.aluno.model.Aluno;
import br.com.infnet.aluno.model.Pendencia;
import br.com.infnet.aluno.service.AlunoService;
import br.com.infnet.aluno.service.PendenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class AlunoController {
    @Autowired
    AlunoService alunoService;

    @Autowired
    PendenciaService pendenciaService;

    @GetMapping
    public List<Aluno> getAll() {
        return alunoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        Optional<Aluno> byId = alunoService.getById(id);
        if(byId.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("Message", "Not Found"));
        }

        return ResponseEntity.ok(byId.get());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        alunoService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Aluno aluno) {
        alunoService.create(aluno);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Message", "Created"));
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Aluno aluno) {

        alunoService.update(aluno);
    }

    @GetMapping("/pendencia/{id}")
    public ResponseEntity getPendencias(@PathVariable Long id) {
        List<Pendencia> pendencias = pendenciaService.findByAlunoId(id);
        return ResponseEntity.ok(pendencias);
    }
}
