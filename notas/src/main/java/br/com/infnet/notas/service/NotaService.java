package br.com.infnet.notas.service;

import org.springframework.stereotype.Service;

@Service
public class NotaService {
    public void geraNota(Integer id) {
        System.out.println("Gerando a nota...");
    }
}
