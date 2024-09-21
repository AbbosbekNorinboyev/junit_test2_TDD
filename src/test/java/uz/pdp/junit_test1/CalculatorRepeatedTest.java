package uz.pdp.junit_test1;

import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorRepeatedTest {
    Calculator calculator;
    Random random;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        random = new Random();
    }

    @AfterEach
    void tearDown() {
    }

    @RepeatedTest(value = 10, name = "Repetition {currentRepetition} For ({displayName}) : Repetitions : {totalRepetitions}")
    @DisplayName("Test method for sum")
    void sum() {
        int a = random.nextInt(20, 30);
        int b = random.nextInt(4, 12);
        int expected = a + b;
        assertEquals(expected, calculator.sum(a, b));
    }

    @RepeatedTest(value = 5, name = "{displayName}")
    @DisplayName("Test method for divide")
    void div() {
        int a = random.nextInt(100, 300);
        int b = random.nextInt(10, 50);
        int expected = a / b;
        assertEquals(expected, calculator.div(a, b));
    }
}