package Convert.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersOfWordsRus {
    private static final List <String> wordsList = new ArrayList<>(Arrays.asList(
        "ноль","один","два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
        "десять", "одна", "две", "на", "сорок", "дцать", "но","сто","ста", "сти", "сот", "тысяч", "милион", "миллиард", "трилион",
        "ых"
        ));

    public static List<String> getWordsList() {
        return wordsList;
    }

}
