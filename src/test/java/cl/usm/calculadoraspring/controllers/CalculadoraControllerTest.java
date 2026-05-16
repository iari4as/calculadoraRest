package cl.usm.calculadoraspring.controllers;

import cl.usm.calculadoraspring.entities.CalculadoraRequest;
import cl.usm.calculadoraspring.services.CalculadoraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculadoraControllerTest {
    CalculadoraController calculadoraController;

    @Mock
    CalculadoraService calculadoraService;

    @BeforeEach
    void setup(){
        this.calculadoraController = new CalculadoraController(calculadoraService);
    }
    @Test
    void  calcularSumaOK(){
        CalculadoraRequest request = new CalculadoraRequest();
        request.setN1(1.0);
        request.setN2(2.0);
        request.setOperation("+");
        when(calculadoraService.calcular(anyString(),anyDouble(),anyDouble())).thenReturn(1.0);
        ResponseEntity<Object> res = this.calculadoraController.calcular(request);
        assertEquals(HttpStatus.OK,res.getStatusCode());
    }


    @Test
    void calcularSumaNotOK(){
        CalculadoraRequest request = new CalculadoraRequest();
        request.setN1(4.0);
        request.setN2(2.0);
        request.setOperation("+");
        when(calculadoraService.calcular(anyString(),anyDouble(),anyDouble())).thenThrow(new NullPointerException());
        ResponseEntity<Object> res = this.calculadoraController.calcular(request);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,res.getStatusCode());
    }
    @Test
    void calcularSumaBadRequest(){
        CalculadoraRequest request = new CalculadoraRequest();
        request.setN1(4.0);
        request.setN2(2.0);
        request.setOperation("%");
        when(calculadoraService.calcular(anyString(),anyDouble(),anyDouble())).thenThrow(new NumberFormatException());
        ResponseEntity<Object> res = this.calculadoraController.calcular(request);
        assertEquals(HttpStatus.BAD_REQUEST,res.getStatusCode());
    }

    @Test
    void calcularSumaExceptionGenerica(){
        CalculadoraRequest request = new CalculadoraRequest();
        request.setN1(4.0);
        request.setN2(2.0);
        request.setOperation("+");
        when(calculadoraService.calcular(anyString(),anyDouble(),anyDouble())).thenThrow(new RuntimeException("Generic error message"));
        ResponseEntity<Object> res = this.calculadoraController.calcular(request);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,res.getStatusCode());
        assertEquals("Generic error message", res.getBody());
    }
}
