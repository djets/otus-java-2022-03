import src.appService.InputService;
import src.appService.OutputService;
import src.appService.SpliteratorString;
import src.services.InputConsole;
import src.services.OutputConsole;
import src.services.SpliteratorStringWithNumbers;
import src.test.ConvertNumberToWordsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Convert {

private String number;

private final List <String> one = new ArrayList<>(Arrays.asList("ноль","один","два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"));
private final List <String> ten = new ArrayList<>(Arrays.asList("десять","одинадцать","двенадцать","тринадцать", "четырнадцать", "пятьнадцать", "шестьнадцать", "семнадцать", "восемнадцать", "девятнадцать"));
public List<String> getTen() {
    return ten;
}

private final List <String> ten1 = new ArrayList<>(Arrays.asList(null, "дцать","дцать","дцать", "дцать", "дцать", "дцать", "дцать", "дцать", "дцать"));




public List<String> getTen1() {
    return ten1;
}

Convert () {
    number = inString();    
}

public String getNumber() {
    return number;
}

public void setNumber(String number) {
    this.number = number;
}
public List<String> getOne() {
    return one;
}



    
public static void main(String[] args) {
    //Convert convert = new Convert();
    //int num = Integer.parseInt(convert.getNumber());
   
    //System.out.println(convert.getNumber().contains("."));
    
    //System.out.println(convert.getNumber().length());
    
    
   //System.out.println(isDouble(convert.getNumber()));
   //System.out.println(Double.parseDouble(convert.getNumber()));
   /* 
   if(num <= convert.getOne().size())
    System.out.println(convert.getOne().get(num));
    if (convert.getNumber().length() > 1 && convert.getNumber().length() < 3)
    System.out.println(convert.getOne().get(num) + "цать");
    
    List<String> myList = new ArrayList<String>(Arrays.asList(convert.getNumber().split("")));
    myList.forEach((v) -> System.out.println(v));
    myList.forEach
    (
        (v) -> System.out.println(convert.getOne().get((Integer.parseInt(v))))
    );
    CurrencyRubles rubles = new CurrencyRubles("рубль", "руб.");

    if (myList.size() == 2) { 
        if(Integer.parseInt(myList.get(0)) == 1) {
            System.out.println(convert.getTen().get(Integer.parseInt(myList.get(1))));
        } else {
            String one = convert.getOne().get(Integer.parseInt(myList.get(0)));
            String two = convert.getTen1().get(Integer.parseInt(myList.get(0)));
            String three = convert.getOne().get(Integer.parseInt(myList.get(1)));
            System.out.println(one + two + " " + three + " " + rubles.getShortName());
            OutputService outConsole = new OutputConsole();
            outConsole.outputStrings(one + two + " " + three + " " + rubles.getShortName());
            
        }
    }
     */
    
    InputService inputConsole = new InputConsole();
    OutputService outConsole = new OutputConsole();
    SpliteratorString split = new SpliteratorStringWithNumbers();

    ConvertNumberToWordsTest t = new ConvertNumberToWordsTest();
    t.testConvert();

    /*
    outConsole.outputStrings();
    split.spliteratorString(inputConsole.inputString());
    split.getListNumbers();
    outConsole.outputStrings(new ConvertNumberToWords().convert(split.getListNumbers(), new NumbersOfWords().getWordsList())); */
    //split.spliteratorString(inputConsole.inputString()).forEach(v -> outConsole.outputStrings(v.toString()));

   
    //System.out.println(((SpliteratorStringWithNumbers) split).getLinkedHashMapNumbers().size());
//((SpliteratorStringWithNumbers) split).getLinkedHashMapNumbers().forEach((k, v) -> outConsole.outputStrings(k.toString() +"--" + v.toString()));

    
    
    
    
}






static boolean isDouble(String str) {
    try {
        Double.parseDouble(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

static boolean isInteger(String str) {
    try {
        Integer.parseInt(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

static String inString(){
    try (Scanner scanner = new Scanner(System.in)) {
        return new String(scanner.nextLine());       
    } catch (Exception e) {
        //TODO: handle exception
        return e.getMessage();
    }
    
}

}


