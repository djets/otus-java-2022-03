package src.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersOfWords {
    private final List <String> wordsList = new ArrayList<>(Arrays.asList(
        "ноль","один","два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
        "десять", "одна", "две", "на", "сорок", "дцать", "но","сто","ста", "сти", "тысяч", "милион", "миллиард", "трилион",
        "ых"
        ));

    public List<String> getWordsList() {
        return wordsList;
    }
}
