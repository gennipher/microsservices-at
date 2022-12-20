package br.com.infnet.alunoservice.service.impl;

import br.com.infnet.alunoservice.model.Aluno;
import br.com.infnet.alunoservice.service.AlunoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    List<Aluno> alunos = new ArrayList<>(List.of(
            Aluno.builder().id(1L).nome("Jennifer").sobrenome("Omena").idade(28).build(),
            Aluno.builder().id(2L).nome("Marta").sobrenome("Omena").idade(58).build(),
            Aluno.builder().id(3L).nome("Wanir").sobrenome("Estevez").idade(88).build()
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
