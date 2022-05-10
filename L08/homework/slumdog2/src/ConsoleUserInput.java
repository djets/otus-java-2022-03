import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUserInput implements UserInput{
    @Override
    public int read(int index) throws InputMismatchException {
        UserOutput userOutput = new ConsoleUserOutput();
        userOutput.print("\nВведите номер ответа: ");
        boolean err = false;
        do {
            Scanner s = new Scanner(System.in);
            try {
                while (s.hasNext()){
                    int item = s.nextInt();
                    if (item >= 1 && item <= TestedItem.numberOfPossibleAnswer[index]){
                        userOutput.print("Принято.");
                        return item;
                    } else {
                        userOutput.print("Попробуйте что то от 1 до " + TestedItem.numberOfPossibleAnswer[index] + ".");
                    }
                }
            }
            catch(InputMismatchException e) {
                err = true;
                userOutput.print("Букафки сюда не надо вводить. Еще разок.");
            }
        } while(err);
        return 0;
    }
    @Override
    public String read() {
        UserOutput userOutput = new ConsoleUserOutput();
        Scanner n = new Scanner(System.in);
        userOutput.print("\nНазови себя: ");
        String name = n.nextLine();
        return name;
    }

}
