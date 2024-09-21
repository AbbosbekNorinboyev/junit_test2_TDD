package uz.pdp.junit_test1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;
import java.util.Random;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Class For Calculator Class")
//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)  // () belgini olib tashlaydi
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)  // _ belgini olib tashlaydi
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
// Methodni nomini qo'shib chiqaradi belgini olib tashlaydi
//@TestMethodOrder(MethodOrderer.DisplayName.class) // Display name bo'yicha tartiblab chiqaradi
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {
    Calculator calculator;
    private static final Logger LOGGER = Logger.getLogger(CalculatorTest.class.getName());

    @BeforeEach
    void setUp() {
//        LOGGER.info("@BeforeEach(setUp method working)");
        calculator = new Calculator(); // 1
    }

    @AfterEach
    void tearDown() {
//        LOGGER.info("@AfterEach(tearDown method working)");
        calculator = null; // 1
    }

    @BeforeAll
    static void setUpAll() {
//        LOGGER.info("@BeforeAll(setUpAll method working)");
    }

    @AfterAll
    static void tearDownAll() {
//        LOGGER.info("@AfterAll(tearDownAll method working)");
    }

    @Test
    @DisplayName("testForSumMethod")
    @Order(5)
    void test_for_sum_method() {
        int expected = 5;
//        LOGGER.info("(testForSum method working[2 + 3 = 5])");
        int actual = calculator.sum(2, 3); // 2
        String message = "Expected Value and Actual Value Did not much [expected : %s, actual : %s]"
                .formatted(expected, actual);
        assertEquals(expected, actual, message); // 3
    }

    @Test
    @DisplayName("testForSumMethod2")
    @Order(4)
    void test_for_sum_method2() {
//        LOGGER.info("(testForSum2 method working[2 + 3 = 5])");
        int actual = calculator.sum(2, 3); // 2
        String message = "Expected Value and Actual Value Did not much [expected : %s, actual : %s]"
                .formatted(6, actual);
        assertNotEquals(6, actual, message); // 3
        assertEquals(10, calculator.sum(3, 7));
    }

    @Test
    @DisplayName("testForDivideMethod")
    @Order(3)
    void test_for_div_method() {
        int expected = 5;
//        LOGGER.info("(testForDivide method working[10 / 2 = 5])");
        int actual = calculator.div(10, 2); // 2
        assertEquals(expected, actual); // 3
    }

    @Test
    @DisplayName("testForDivideMethodWhichThrowsException")
    @Order(2)
    void test_for_div_method_which_throws_exception() {
//        ArithmeticException e = assertThrows(ArithmeticException.class, () -> calculator.div(10, 0));
//        e.printStackTrace();
    }

    @Test
    @DisplayName("testForDivideMethodWhichHasTimeout")
    @Order(1)
    void test_for_div_method_which_has_timeout() {
        assertTimeout(Duration.ofMillis(3000), () -> calculator.div(10, -2));
    }

    @Test
    @Disabled("This Test Method ignored disabled for checking @Disabled annotation")
    void ignored() {
    }

    @Test
    @DisabledIf(value = "testCondition", disabledReason = "Disabled Reason")
    void disabledWithCondition() {
    }

    @Test
    @EnabledIf(value = "testCondition", disabledReason = "Enabled Reason")
    void enabledWithCondition() {
    }

    boolean testCondition() {
        boolean b = new Random().nextBoolean();
        System.out.println(b);
        return b;
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void shouldWorkOnWindowsOnly() {
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void shouldWorkOnLinuxOnly() {
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.WINDOWS})
    void shouldWorkWindowsOrOnLinuxOnly() {
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void shouldNotWorkWindows() {
    }

    @Test
    @DisabledOnOs(OS.LINUX)
    void shouldNotWorkLinux() {
    }

    @Test
    @DisabledOnOs({OS.WINDOWS, OS.LINUX})
    void shouldNotWorkWindowsOrLinux() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void shouldWorkOnJRE_8_Only() {
    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    void shouldNotWorkOnJRE_8_Only() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void shouldWorkOnJRE_17_Only() {
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_20)
    void shouldWorkOnJRE_Between_8_and_20() {
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_14)
    void shouldWorkOnJRE_Between_8_and_14() {
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_20)
    void shouldNotWorkOnJRE_Between_8_and_20() {
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_15)
    void shouldNotWorkOnJRE_Between_8_and_15() {
    }
}
