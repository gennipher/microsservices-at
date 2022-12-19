package br.com.infnet.aluno.service.impl;

import br.com.infnet.aluno.model.Pendencia;
import br.com.infnet.aluno.service.PendenciaService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PendenciaServiceImpl implements PendenciaService {

    @Override
    public List<Pendencia> findByAlunoId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://localhost:8081/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Pendencia>>() {}
        ).getBody();
    }
}
