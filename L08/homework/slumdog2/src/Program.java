import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Program {
    private static int countCorrectAnswer = 0;
    private static int countIncorrectAnswer = 0;
    private final static int numberOfPossibleAnswer = 4;
    private final static int[] correctAnswerArray = {1,1,4,1,3,1,4,4,1};

    public static void main(String[] args) throws IOException {
        //Загружаем вопросы и ответы
        Resources.loadQuestion();
        Resources.loadAnswer();
        //Инициализируем новый массив задданых вопросов.
        int[] listOfQuestionsAsked = new int[Resources.arrayQuestionsStrings.length];
        //Заполняем его отрицательным значением.
        for (int lqa = 0; lqa < Resources.arrayQuestionsStrings.length; lqa++){
            listOfQuestionsAsked[lqa] = -1;
        }

        //Главный цикл
        for (int i = 0; i < Resources.arrayQuestionsStrings.length; i++) { //Здесь мы получили поле класса = 0 Ошибка!
            //Получаем случайный номер вопроса.
            int indexQuestion = randomNumber(Resources.arrayQuestionsStrings.length);
            //Проверяем был ли ранее задан вопрос.
            while (linearSearch(listOfQuestionsAsked, indexQuestion)){
                indexQuestion = randomNumber(Resources.arrayQuestionsStrings.length);
            }
            int numberAnswer = indexQuestion * numberOfPossibleAnswer;

            //Выводим вопрос.
            int s = i + 1;
            System.out.println("Вопрос №" + s + ": " + Resources.arrayQuestionsStrings[indexQuestion]);
            //Выводим варианты ответа.
            String[] listAnswer = new String[numberOfPossibleAnswer];
            int an = 1;
            for (int a = 0; a < numberOfPossibleAnswer; a++){
                listAnswer[a] = Resources.arrayAnswersStrings[(numberAnswer)];
                System.out.println("Ответ №" + an + ": " + listAnswer[a]);
                numberAnswer++;
                an++;
            }

            //Вызываем метод ввода ответа.
            int answer = inputAnswer();
            if (answer == correctAnswerArray[indexQuestion]) {
                System.out.println("Правильный ответ. \n");
                countCorrectAnswer++;
            } else {
                countIncorrectAnswer++;
                System.out.println("Ваш ответ неверный. \n");
            }
            listOfQuestionsAsked[i] = indexQuestion;
        }
        //Поздравляем если игрок ответил на все вопросы правильно.
        if (countCorrectAnswer == 9){
            System.out.println("Правильных ответов " + countCorrectAnswer + "!\nВы ВЫИГРАЛИ!!!");
        }
        //Выводми колличество венрых и неверных ответов.
        System.out.println("Правильных ответов " + countCorrectAnswer);
        System.out.println("Неправильных ответов " + countIncorrectAnswer);
    }

    //Получение случайного числа
    static int randomNumber(int r) {
        Random random = new Random();
        return random.nextInt(r);
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
                    if (item >= 1 && item <= numberOfPossibleAnswer){
                        System.out.println("Принято.");
                        return item;
                    } else {
                        System.out.println("Попробуйте что то от 1 до " + numberOfPossibleAnswer + ".");
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

    //Поиск по массиву заданных вопросов.
    static boolean linearSearch(int[] arr, int elementToSearch) {
        for (int i : arr) {
            if (i == elementToSearch) {
                return true;
            }
        }
        return false;
    }
}
