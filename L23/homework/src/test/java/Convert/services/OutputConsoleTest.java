package Convert.services;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat; 

public class OutputConsoleTest {

    @BeforeAll
    public static void setUpAll() {
        System.out.println("Запуск тестирования класса OutputConsole");
    }
   
    @Test
    void testOutputStrings() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        OutputConsole outputConsoleTest = new OutputConsole(ps);
        
        outputConsoleTest.outputStrings("output: " + "test_output");

        String outputText = byteArrayOutputStream.toString();
        String key = "output: ";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();
        
        assertThat(output).isEqualTo("test_output");
    }
}
