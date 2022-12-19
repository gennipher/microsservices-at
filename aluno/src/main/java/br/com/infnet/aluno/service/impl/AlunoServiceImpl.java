package br.com.infnet.aluno.service.impl;

import br.com.infnet.aluno.model.Aluno;
import br.com.infnet.aluno.service.AlunoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {
    List<Aluno> alunos = new ArrayList<>(List.of(
            Aluno.builder().id(1L).nome("Jennifer").build(),
            Aluno.builder().id(2L).nome("Marta").build(),
            Aluno.builder().id(3L).nome("Maria").build()
    ));

    @Override
    public List<Aluno> getAll() {
        return alunos;
    }

    @Override
    public Optional<Aluno> getById(Long id) {
        return alunos
                .stream()
                .filter(aluno -> aluno.getId() == id)
                .findFirst();
    }

    @Override
    public void deleteById(Long id) {
        alunos.removeIf(aluno -> aluno.getId() == id);
    }

    @Override
    public void create(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public void update(Aluno aluno) {
        deleteById(aluno.getId());
        create(aluno);
    }
}
