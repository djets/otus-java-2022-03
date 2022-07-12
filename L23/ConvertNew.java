import java.util.*;
public class ConvertNew {
    public static void main(String[] args) {
        convertingRus();
    }

    public static void convertingRus(){
        ArrayDeque<String> inputStringsNumber  = new ArrayDeque<>(Arrays.asList("1","2","3","4","5","6","7","8"));
        inputStringsNumber.size();
        //List<String> threeNumbers = new ArrayList<>();
        int remainsThreeNumbers = inputStringsNumber.size() % 3;
        int quantityIteration;
        int quantityThreeNumbers;
            if(remainsThreeNumbers > 0){
                quantityThreeNumbers = inputStringsNumber.size() / 3 + 1;
                quantityIteration = remainsThreeNumbers;
            } else {
                quantityThreeNumbers = inputStringsNumber.size() / 3;
                quantityIteration = 3;
            };
        for(int i = 0; i < quantityThreeNumbers; i++){
            List<String> threeNumbers = new ArrayList<>();
            for (int p = 1; p <= quantityIteration; p++) {
                threeNumbers.add(inputStringsNumber.pollFirst());
            }
            System.out.println("list " + i);
            quantityIteration = 3;
            threeNumbers.forEach(System.out::println);
        }


    }
}


