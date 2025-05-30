package org.educatiom.lesson03_JUnit5;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        if (b != 0) return a / b;
        else throw new IllegalArgumentException("La división por cero no está permitida.");
    }

}
