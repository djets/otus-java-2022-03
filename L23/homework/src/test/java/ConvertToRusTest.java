package src.test.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;
import src.main.java.convert.services.ConvertToRus;
import src.main.java.convert.services.SpliteratorStringWithNumbers;

public class ConvertToRusTest {

    @Before
    public void setUp() throws Exception {
        
    }

    @AfterClass
    public static void afterClass() throws Exception {

    }

    @Test
    public void testConvert() {
        List<Integer> numListTest = new ArrayList<>(Arrays.asList(5, 7, 11, 12, 13, 14, 22, 50, 90, 98, 40, 44, 16, 328, 500, 748, 983565, 
        203000890, 401, 123456,15000));
        List<String> wordsListTest = new ArrayList<>(Arrays.asList("пять", "семь", "одинадцать", "двенадцать", "тринадцать", 
        "четырнадцать", "двадцать два", "пятьдесят", "девяносто", "девяносто восемь", "сорок", "сорок четыре", "шестнадцать", 
        "триста двадцать восемь", "пятьсот", "семьсот сорок восемь", "девятьсот восемьдесят три тысячи пятьсот шестьдесят пять",
        "двести три миллиона восемьсот девяносто", "четыреста один", "сто двадцать три тысячи четыреста пятьдесят шесть",
        "пятнадцать тысяч"));
        
        for (int i = 0; i < numListTest.size(); i++){
            SpliteratorStringWithNumbers splitTest = new SpliteratorStringWithNumbers();
            splitTest.spliterator(Integer.toString(numListTest.get(i)));
            ConvertToRus test = new ConvertToRus();
            String s = test.convert(splitTest.getListNumbers());
            System.out.println("correct: " + wordsListTest.get(i));
            if(s.equals(wordsListTest.get(i))){
                System.out.println("Test number " + numListTest.get(i));
                System.out.println((char)27 + "[1;32m" + "TEST PASSED" + (char)27 + "[0m");
            } else {
                System.out.println("Test number " + numListTest.get(i));
                System.out.println((char)27 + "[1;31m" + "TEST FAIL " + (char)27 + "[0m" + s + s.length());
            }

        }

    }





    @After
    public void tearDown() throws Exception {

    }

    @BeforeClass
    public static void beforeClass() throws Exception {

    }
}
