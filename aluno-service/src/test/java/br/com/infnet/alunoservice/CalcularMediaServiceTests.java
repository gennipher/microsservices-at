package br.com.infnet.alunoservice;

import br.com.infnet.alunoservice.service.CalcularMediaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalcularMediaServiceTests {

    @Autowired
    CalcularMediaService calcularMediaService;

    @Test
    @DisplayName("A média deve ser 12.55")
    public void calculoDaMedia() {

        Double media = calcularMediaService.calculoMedia(8.6, 7.9);
    }

    @Test
    public void hello() {
        Double media = calcularMediaService.calculoMedia(8.6, 7.9);
        System.out.println("\nMédia:" + media);
    }
}
