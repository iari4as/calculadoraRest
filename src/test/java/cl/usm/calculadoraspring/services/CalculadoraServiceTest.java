package cl.usm.calculadoraspring.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {

    @Test
    void calcularSumaOk() {
        CalculadoraService calculadoraService = new CalculadoraService();
        double res = calculadoraService.calcular("+",1,2);
        assertEquals(3,res);
    }

    @Test
    void calcularRestaOK(){
        CalculadoraService calculadoraService = new CalculadoraService();
        double res = calculadoraService.calcular("-",2,2);
        assertEquals(0,res);
    }
    @Test
    void calcularmultiOK(){
        CalculadoraService calculadoraService = new CalculadoraService();
        double res = calculadoraService.calcular("*",3,2);
        assertEquals(6,res);
    }

    @Test
    void calcularDivisionOK(){
        CalculadoraService calculadoraService = new CalculadoraService();
        double res = calculadoraService.calcular("/",4,2);
        assertEquals(2,res);
    }

    @Test
    void calcularDivisionNotOK(){
        CalculadoraService calculadoraService = new CalculadoraService();

        Exception ex = assertThrows(NumberFormatException.class,()-> {
            double res = calculadoraService.calcular("/",5,0);
        });
        assertEquals("can´t divide by zero",ex.getMessage());

    }
    @Test
    void calcularOperacionNotOK(){
        CalculadoraService calculadoraService = new CalculadoraService();

        Exception ex = assertThrows(NumberFormatException.class,()-> {
            calculadoraService.calcular("fake",0,0);
        });
        assertEquals("Invalid operation",ex.getMessage());

    }
}