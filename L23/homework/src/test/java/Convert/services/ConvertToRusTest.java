package Convert.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat; 

public class ConvertToRusTest {

    @BeforeAll
    public static void setUpAll() {
        System.out.println("Запуск тестирования класса ConvertToRus");
    }
    
    @Test
    public void convertTest() {
        List<Integer> numListTest = new ArrayList<>(Arrays.asList(5, 7, 11, 12, 13, 14, 22, 50, 90, 98, 40, 44, 16, 328, 500, 748, 983565, 
        203000890, 401, 123456,15000));
        List<String> wordsListTest = new ArrayList<>(Arrays.asList("пять", "семь", "одинадцать", "двенадцать", "тринадцать", 
        "четырнадцать", "двадцать два", "пятьдесят", "девяносто", "девяносто восемь", "сорок", "сорок четыре", "шестнадцать", 
        "триста двадцать восемь", "пятьсот", "семьсот сорок восемь", "девятьсот восемьдесят три тысячи пятьсот шестьдесят пять",
        "двести три миллиона восемьсот девяносто", "четыреста один", "сто двадцать три тысячи четыреста пятьдесят шесть",
        "пятнадцать тысяч"));

        numListTest.forEach(v -> assertThat(new ConvertToRus().convert(SpliteratorStringWithNumbers.spliterator(Integer.toString(v))))
        .isNotNull().isEqualTo(wordsListTest.get(numListTest.indexOf(v)))
        );

    }
    
}
