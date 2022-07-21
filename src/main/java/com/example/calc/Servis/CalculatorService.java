package ru.skypro.calculator.Servis;

import org.springframework.stereotype.Service;

@Service

public class CalculatorService {
    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }
    public double dividing(int a, int b) {
        return (double) a / b;
    }
}
