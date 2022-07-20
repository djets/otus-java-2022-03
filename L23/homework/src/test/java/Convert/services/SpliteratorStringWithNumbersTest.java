package Convert.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Convert.exception.DoubleInputException;

public class SpliteratorStringWithNumbersTest {
    private List<String> testListString;
    private List<Integer> testListInteger;

    @BeforeAll
    public static void setUpAll() {
        System.out.println("Запуск тестирования класса SpliteratorStringWithNumbers");
    }

    @Test
    public void testNumberParseIntExceptionThrown() throws Exception {
        testListString = new ArrayList<>(Arrays.asList("test", "1.", "1,"));
        testListString.forEach(v -> assertTrue(assertThrows(DoubleInputException.class, () -> 
            SpliteratorStringWithNumbers.numberParseInt(v)).getMessage()
            .contains("Ввод не целого числа.")));
    }

    @Test
    void testNumberParseInt() {
        testListString = new ArrayList<>(Arrays.asList("1", "5", "99"));
        testListInteger= new ArrayList<>(Arrays.asList(1, 5, 99));
        testListString.forEach(v -> {
            try {
                assertThat(SpliteratorStringWithNumbers.numberParseInt(v))
                .isEqualTo(testListInteger.get(testListString.indexOf(v)));
            } catch (DoubleInputException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    void testSpliterator() {
        testListString = new ArrayList<>(Arrays.asList("1", "555", "99"));
        List<ArrayDeque<Integer>> testListArrayQueue = new ArrayList<>();
        testListArrayQueue.add(new ArrayDeque<>(List.of(1)));
        testListArrayQueue.add(new ArrayDeque<>(Arrays.asList(5, 5, 5)));
        testListArrayQueue.add(new ArrayDeque<>(Arrays.asList(9, 9)));
        
        testListString.forEach(v -> assertThat(SpliteratorStringWithNumbers.spliterator(v)).isNotEmpty()
        .containsSequence(testListArrayQueue.get(testListString.indexOf(v))));
    }
}
