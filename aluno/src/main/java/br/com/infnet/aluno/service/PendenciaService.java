package br.com.infnet.aluno.service;

import br.com.infnet.aluno.model.Pendencia;

import java.util.List;

public interface PendenciaService {
    List<Pendencia> findByAlunoId(Long id);
}
