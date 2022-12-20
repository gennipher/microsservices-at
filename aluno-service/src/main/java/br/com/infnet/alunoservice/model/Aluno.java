package br.com.infnet.alunoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aluno {
    private Long id;
    private String nome;
    private String sobrenome;
    private Integer idade;
}
