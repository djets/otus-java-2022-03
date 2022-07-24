package Convert.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputConsoleTest {

    @BeforeAll
    public static void setUpAll() {
        System.out.println("Запуск тестирования класса InputConsole");
    }

    @Test
    void testInputString() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("test_input".getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        InputConsole inputConsoleTest = new InputConsole(inputStream);

        ps.println("output: " + inputConsoleTest.inputString());

        String outputText = byteArrayOutputStream.toString();
        String key = "output: ";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        assertThat(output).isEqualTo("test_input");
    }
}
