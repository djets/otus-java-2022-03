package src.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

import src.domain.NumbersOfWords;
import src.services.ConvertNumberToWords;
import src.services.SpliteratorStringWithNumbers;

public class ConvertNumberToWordsTest {



    @Before
    public void setUp() throws Exception {
    }

    @AfterClass
    public static void afterClass() throws Exception {

    }

    @Test
    public void testConvert() {
        ConvertNumberToWords test = new ConvertNumberToWords();
        NumbersOfWords wordsTest = new NumbersOfWords();

        //List<Integer> numListTest = new ArrayList<>(Arrays.asList(5, 7, 11));
        //List<String> wordsListTest = new ArrayList<>(Arrays.asList("пять", "семь", "одинадцать"));
        List<Integer> numListTest = new ArrayList<>(Arrays.asList(5, 7, 11, 12, 13, 14, 20, 50, 90, 98, 40, 44, 16));
        List<String> wordsListTest = new ArrayList<>(Arrays.asList("пять", "семь", "одинадцать", "двенадцать", "тринадцать", "четырнадцать", "двадцать", "пятьдесят", "девяносто", "девяносто восемь", "сорок", "сорок четыре", "шестнадцать"));
        for (int i = 0; i < numListTest.size(); i++){
            SpliteratorStringWithNumbers splitTest = new SpliteratorStringWithNumbers();
            splitTest.spliteratorString(Integer.toString(numListTest.get(i)));
            String s = test.convert(splitTest.getListNumbers(), wordsTest.getWordsList());
            System.out.println(s);
            if(s.equals(wordsListTest.get(i))){
                System.out.println("Test number " + numListTest.get(i));
                System.out.println((char)27 + "[1;32m" + "TEST PASSED" + (char)27 + "[0m");
            } else {
                System.out.println("Test number " + numListTest.get(i));
                System.out.println((char)27 + "[1;31m" + "TEST FAIL " + (char)27 + "[0m" + s);
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
