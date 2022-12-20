package br.com.infnet.alunoservice.service;

import org.springframework.stereotype.Service;

@Service
public class CalcularMediaService {
    public Double calculoMedia(Double nota1, Double nota2) {
        return (nota1 + nota2 / 2);
    }
}
