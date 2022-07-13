import src.appService.ConvertService;
import src.appService.InputService;
import src.appService.OutputService;
import src.appService.Spliterator;
import src.services.ConvertToRusOld;
import src.services.ConvertToRus;
import src.services.InputConsole;
import src.services.OutputConsole;
import src.services.SpliteratorStringWithNumbers;
import src.test.ConvertToRusTest;


class Convert {

public static void main(String[] args) {
    //InputConsole inputConsole = new InputConsole();
    //OutputService outConsole = new OutputConsole();
    //Spliterator split = new SpliteratorStringWithNumbers();
    //split.spliterator(inputConsole.inputString());
    //split.getListNumbers();
    //ConvertToRus convertToRus = new ConvertToRus(split.getListNumbers());
    //outConsole.outputStrings(convertToRus.convert() + Currency.RUB.declination(split.getListNumbers().peekLast())); 
    
    
    
    //ConvertToRusNew convertRu = new ConvertToRusNew();
    //outConsole.outputStrings(convertRu.convert(split.getListNumbers()));
    //outConsole.outputStrings(convertRu.convert(split.getListNumbers()) + Currency.RUB.declination(split.getListNumbers().peekLast())); 
    //System.out.println(split.getListNumbers().get(split.getListNumbers().size() - 1));
 

    ConvertToRusTest t = new ConvertToRusTest();
    t.testConvert();
}


enum Currency {
    RUB{
        public String declination(int lastNumber) {
            if(lastNumber == 1)
                return new String(" рубль");
            if(lastNumber >= 2 && lastNumber <= 4)
                return new String(" рубля");
            if(lastNumber >=5 || lastNumber <=9 || lastNumber == 0)
                return new String(" рублей");
            return new String(" руб.");
        }
    },
    DOLLAR{
        public String declination(int lastNumber) {
            if(lastNumber == 1)
                return new String(" доллар");
            if(lastNumber >= 2 || lastNumber <= 4)
                return new String(" доллара");
            if(lastNumber >=5 || lastNumber <=9 || lastNumber == 0)
                return new String(" долларов");
            return new String(" млн.");
        };
    };
        public abstract String declination(int lastNumber);   
    } 
    
    
}




