package br.com.infnet.financeiro.controller;

import br.com.infnet.financeiro.model.Pendencia;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class FinanceiroController {

    Map<Long, List<Pendencia>> pendencias = Map.of(
            1L, List.of(
                    Pendencia.builder().id(1L).mes("Janeiro").valor(new BigDecimal(300.02)).build(),
                    Pendencia.builder().id(2L).mes("Fevereiro").valor(new BigDecimal(250.02)).build()
                    ),
            2L, List.of(
                    Pendencia.builder().id(1L).mes("Março").valor(new BigDecimal(100.02)).build(),
                    Pendencia.builder().id(2L).mes("Abril").valor(new BigDecimal(450.02)).build()
            )
    );

    @GetMapping("/{id}")
    public List<Pendencia> getAllByAlunoId(@PathVariable Long id) {
        return pendencias.get(id);
    }
}
