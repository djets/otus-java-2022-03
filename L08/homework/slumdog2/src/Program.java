import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Program {
    static int countCorrectAnswer = 0;
    static int countIncorrectAnswer = 0;
    final static int numberOfPossibleAnswer = 4;
    final static int[] correctAnswerArray = {1,1,4,1,3,1,4,4,1};
    //private static int idx;


    public static void main(String[] args) throws IOException {
        //Загружаем вопросы и ответы
        Resources.loadQuestion();
        Resources.loadAnswer();
        //System.out.println("В списке заданных есть вопрос. " + idx);
        int listOfQuestionsAsked[] = new int[Resources.arrayQuestionsStrings.length];
        for (int lqa = 0; lqa < Resources.arrayQuestionsStrings.length; lqa++){
            listOfQuestionsAsked[lqa] = -1;
        }

        //Главный цикл
        for (int i = 0; i < Resources.arrayQuestionsStrings.length; i++) { //Здесь мы получили поле класса = 0 Ошибка!
            //Получаем случайный номер вопроса
            int indexQuestion = randomNumber(Resources.arrayQuestionsStrings.length);
            //System.out.println(Resources.arrayQuestionsStrings.length);
            System.out.println(indexQuestion);
            //Проверяем был ли ранее задан вопрос
            System.out.println(linearSearch(listOfQuestionsAsked, indexQuestion));
            while (linearSearch(listOfQuestionsAsked, indexQuestion) == true){
                indexQuestion = randomNumber(Resources.arrayQuestionsStrings.length);
            }
            System.out.println(Arrays.toString(listOfQuestionsAsked));
            System.out.println(indexQuestion);
            int numberAnswer = indexQuestion * numberOfPossibleAnswer;
            //System.out.println(numberOfPossibleAnswer);
            System.out.println(numberAnswer);

            //System.out.println(Arrays.toString(listOfQuestionsAsked));
            //Присваиваем переменной номер вопроса и выводим на экран
            //String questionString = Resources.arrayQuestionsStrings[indexQuestion];

            //Выводим вопрос
            System.out.println("Вопрос №" + i + ": " + Resources.arrayQuestionsStrings[indexQuestion]);
            //Выводим варианты ответа
            String[] listAnswer = new String[numberOfPossibleAnswer];
            int an = 1;
            for (int a = 0; a < numberOfPossibleAnswer; a++){
                listAnswer[a] = Resources.arrayAnswersStrings[(numberAnswer)];
                System.out.println("Ответ №" + an + ": " + listAnswer[a]);
                numberAnswer++;
                an++;
            }

            //Объявляем новый массив String и передаем в него 4 варианта ответа из arrayAnswerString
            //String[] listAnswer = new String[]{Resources.arrayAnswerStrings[(numberAnswer)], Resources.arrayAnswerStrings[(numberAnswer++)], Resources.arrayAnswerStrings[(questionIndex * 4) + 2], Resources.arrayAnswerStrings[(questionIndex * 4) + 3]};

            //Выводим через метод toString
            //System.out.println(Arrays.toString(listAnswer));
            //Вызываем ввод ответа
            int answer = inputAnswer();
            if (answer == correctAnswerArray[indexQuestion]) {
                System.out.println("Правильный ответ.");
                countCorrectAnswer++;
            } else {
                countIncorrectAnswer++;
                System.out.println("Ваш ответ не верный.");
            }
            listOfQuestionsAsked[i] = indexQuestion;
        }
        //System.out.println(Arrays.toString(listOfQuestionsAsked));
        if (countCorrectAnswer == 9){
            System.out.println("Правильных ответов " + countCorrectAnswer + "!\n Вы МИЛЛИОНЕР!!!");
        }
        System.out.println("Правильных ответов " + countCorrectAnswer);
        System.out.println("Неправильных ответов " + countIncorrectAnswer);
        //System.out.println(Arrays.toString(listOfQuestionsAsked));
    }

    //Получение случайного числа
    static int randomNumber(int r) {
        Random random = new Random();
        int  randomIndex = random.nextInt(r);
        return randomIndex;
    }

    //Получение ответа
    static int inputAnswer() throws InputMismatchException {
        boolean err = false;
        do {
            //err = false;
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

        /*
        int answer = correctAnswerArray[index];
                        System.out.println(answer);
                        if (item == answer) {
                            //System.out.println("И это верно.");
                            //score = score + 1000*(index + 1);
                            break;
                        } else {
                            System.out.println("Ответ не верно.\n");
                            break;
                        }

        System.out.println("Введите число от 1 до 4:");
        Scanner inputNumberAnswer = new Scanner(System.in);
        for (int i = 1; i < 5; i++){
            System.out.println("Попытка ввода " + i + " из 4");

            //Проверям ввод на соответсвие шаблону
            //if (inputNumberAnswer.hasNext("^[1-4]{1}$]")){
            if (inputNumberAnswer.hasNextInt()){
                int numberAnswer = inputNumberAnswer.nextInt();
                //Проверяем на указанный диапазон
                if (numberAnswer >= 1 && numberAnswer <= 4) {
                    //System.out.println(numberAnswer);
                    int numberAnswerSet = numberAnswer;
                    return numberAnswerSet;
                    //break;
                }
                System.out.println("Не корректное число. Введите число от 1 до 4");
            }
            System.out.println("Вы ввели символ. Введите число от 1 до 4");
            if (i == 4){
                System.out.println("Вы использовали максимальное количество попыток. \n ВЫ ПРОИГРАЛИ!");
            }
            inputNumberAnswer.close();
        }
        */
        return 0;
    }

    static boolean linearSearch(int[] arr, int elementToSearch) {
        //System.out.println(Arrays.toString(arr));
        System.out.println("Длина массива " + arr.length);
        for (int n = 0; n < arr.length; n++) {
            System.out.println("Число " + arr[n]);
            System.out.println("Итерация " +n);
            if (arr[n] == elementToSearch) {
                return true;
            }
        }
        return false;
    }
}
