package org.educatiom.lesson03_JUnit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/*Despues de crear la Clase Calculator vamos a probar sus métodos, para ello creamos otra clase del mismo mombre
 * pero con el sufijo Test y ponemos los nombres de los métodos que nos retornen un void y los decoramos con la
 * anotación @Test cada uno. */
class CalculatorTest {

    private Calculator calculator; //Se declara la instancia calculator ya que los méthos la llaman em su totalidad

    @BeforeAll //Method que se ejecuta UNA SOLA VEZ antes de TODAS las pruebas

    static void init() {
        System.out.println("El metodo init se llama antes de todo.");
    }

    @BeforeEach   // Method que se ejecuta antes de CADA prueba
    void setup() {
        calculator = new Calculator(); //Instancia creada.
    }

    @AfterAll   // Method que se ejecuta UNA SOLA VEZ después de TODAS las pruebas
    static void finish() {
        System.out.println("El metodo finish se llama despues de todo.");
    }

    @Test
    void add() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Disabled // Permite desactivar una prueba específica para que JUnit no la llame.
    @Test
    void sub() {
        int result = calculator.sub(5, 2);
        assertEquals(3, result);
    }

    @Test
    void mul() {
        int result = calculator.mul(4, 2);
        assertEquals(8, result);
    }

    @Test
    void div() {
        int result = calculator.div(8, 2);
        assertEquals(4, result);

        //Si los parámetros pasados a assertEquals() no son iguales, el method generará una excepción y la
        // prueba fallará. Esta excepción no evitará que se ejecuten otras pruebas.

    }
}