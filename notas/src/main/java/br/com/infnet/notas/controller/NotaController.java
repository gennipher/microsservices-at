package br.com.infnet.notas.controller;

import br.com.infnet.notas.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NotaController {
    @Autowired
    NotaService notaService;

    @PostMapping
    public void enviaNotas(@RequestBody List<Integer> ids) {
        ids.stream().forEach(id -> {
            notaService.geraNota(id);
        });
    }
}
