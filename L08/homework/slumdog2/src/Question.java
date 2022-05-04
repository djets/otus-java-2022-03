import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
class Question {
    //Номера правильных ответы.
    private final static int[] rightAnswerIndex = {1,1,4,1,3,1,4,4,1};

    static boolean ask(int index) {
        //Получаем список ответов
        Answer.showAnswer(index);
        //Вызываем метод ввода ответа.
        int answer = inputAnswer();
        return answer == rightAnswerIndex[index];
    }

    //Загружаем файл ответов.
    static String[] loadQuestion() {
        //Используем try catch для вывода сообщения об ошибке.
        try {
            //Считываем файл вопросов по строчно.
            List<String> listOfQuestions = Files.readAllLines(Paths.get("src/question.txt"), StandardCharsets.UTF_8);
            //Преобразуем в массив типа String.
            return listOfQuestions.toArray(new String[0]);
        } catch (IOException e) {
            System.out.println("Не найден путь к файлам вопросов.");
        }
        return new String[0];
    }

    //Получение ответа
    static int inputAnswer() throws InputMismatchException {
        System.out.println("\nВведите номер ответа: ");
        boolean err = false;
        do {
            Scanner s = new Scanner(System.in);
            try {
                while (s.hasNext()){
                    int item = s.nextInt();
                    if (item >= 1 && item <= Test.NUMBER_OF_POSSIBLE_ANSWER){
                        System.out.println("Принято.");
                        return item;
                    } else {
                        System.out.println("Попробуйте что то от 1 до " + Test.NUMBER_OF_POSSIBLE_ANSWER + ".");
                    }
                }
            }
            catch(InputMismatchException e) {
                err = true;
                System.out.println("Букафки сюда не надо вводить. Еще разок.");
            }
        } while(err);
        return 0;
    }
}
