package uz.pdp.junit_test1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorParametrizedTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest(name = "{displayName} => {index} : [{arguments}]")
    @ValueSource(strings = {"PDP", "JAVA", "LEARN", "FIND", "HIGH", "PAYED", "JOB"})
    @DisplayName("Test Method For Parametrized Test TestMethod(String)")
    void testMethod(String message) {
        System.out.println(message);
        assertEquals(message, message.toUpperCase());
    }

    @ParameterizedTest(name = "{displayName} => {index} : [{arguments}]")
    @MethodSource("sumSource")
    void sum(SumArgument sumArgument) {
        assertEquals(sumArgument.excepted, calculator.sum(sumArgument.a, sumArgument.b));
    }

    @ParameterizedTest(name = "{displayName} => {index} : [{arguments}]")
    @CsvSource(value = {
            "a, b, sum",
            "2, 1, 3",
            "4, 2, 6"
    }, useHeadersInDisplayName = true)
    void sum(int a, int b, int excepted) {
        assertEquals(excepted, calculator.sum(a, b));
    }

    @ParameterizedTest(name = "{displayName} => {index} : [{arguments}]")
    @CsvFileSource(resources = "/source.csv", useHeadersInDisplayName = true, numLinesToSkip = 1)
    void sumCsvFile(int a, int b, int excepted) {
        assertEquals(excepted, calculator.sum(a, b));
    }

    /*@ParameterizedTest(name = "{displayName} => {index} : [{arguments}]")
    @MethodSource
    void div(DivArgument divArgument) {
        assertEquals(divArgument.excepted, calculator.div(divArgument.a, divArgument.b));
    }*/

    Stream<SumArgument> sumSource() {
        return Stream.of(
                new SumArgument(2, 3, 5),
                new SumArgument(1, -3, -2),
                new SumArgument(15, -30, -15)
        );
    }

    public static class SumArgument {
        int a;
        int b;
        int excepted;

        public SumArgument(int a, int b, int excepted) {
            this.a = a;
            this.b = b;
            this.excepted = excepted;
        }

        @Override
        public String toString() {
            return "SumArgument{" +
                    "a=" + a +
                    ", b=" + b +
                    ", excepted=" + excepted +
                    '}';
        }
    }
}