package br.com.infnet.alunoservice.service;

import br.com.infnet.alunoservice.model.Pendencia;

import java.util.List;

public interface PendenciaService {
    List<Pendencia> findByAlunoId(Long id);
}
