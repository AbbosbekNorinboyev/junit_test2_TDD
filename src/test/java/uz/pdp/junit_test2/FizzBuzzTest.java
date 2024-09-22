package uz.pdp.junit_test2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {
    FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    void testForNotNullValues() {
        assertNotNull(fizzBuzz.convert(1));
    }

    @Test
    void testForGivenNumber() {
        assertEquals("1", fizzBuzz.convert(1));
        assertEquals("2", fizzBuzz.convert(2));
    }

    @Test
    void testForFizz() {
        assertEquals("Fizz", fizzBuzz.convert(3));
    }

    @Test
    void testForBuzz() {
        assertEquals("Buzz", fizzBuzz.convert(5));
        assertEquals("Buzz", fizzBuzz.convert(10));
    }

//    @Test
//    void testForFizzBuzz() {
//        assertEquals("FizzBuzz", fizzBuzz.convert(15));
//    }

    @ParameterizedTest(name = "{displayName} => {index} : {arguments}")
    @CsvFileSource(resources = "/source.csv", useHeadersInDisplayName = true)
    void testForFizzBuzz(int a, String expected) {
        assertEquals(expected, fizzBuzz.convert(a));
    }
}
