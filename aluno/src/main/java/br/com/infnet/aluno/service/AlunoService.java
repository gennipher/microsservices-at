package br.com.infnet.aluno.service;

import br.com.infnet.aluno.model.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoService {
    List<Aluno> getAll();
    Optional<Aluno> getById(Long id);
    void deleteById(Long id);
    void create(Aluno aluno);
    void update(Aluno aluno);
}
