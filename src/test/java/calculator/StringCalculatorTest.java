package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2=10",
            "1 + 1 + 1 + 1=4",
            "0 * 0 * 5 + 2=2",
    }, delimiter = '=')
    void calculate(String input, String expected) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.execute();

        assertEquals(expected, out.toString());
    }
}