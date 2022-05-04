import java.util.Random;
public class Test {
    private static String[] question;
    //Количество вариантов ответов.
    final static int NUMBER_OF_POSSIBLE_ANSWER = 4;
    static int[] listOfQuestionsAsked = new int[0];

    public static void main(String[] args) {
        int countCorrectAnswer = 0;
        int countIncorrectAnswer = 0;
        question = Question.loadQuestion();
        //Инициализируем новый массив задданых вопросов.
        int[] listOfQuestionsAsked = new int[question.length];
        //Заполняем его отрицательным значением.
        for (int lqa = 0; lqa < Test.question.length; lqa++){
            listOfQuestionsAsked[lqa] = -1;
        }
        for (int i = 0; i < question.length; i++) {
            int indexQuestion = getIndexQuestion();
            //Выводим вопрос.
            int s = i + 1;
            System.out.println("Вопрос №" + s + ": " + question[indexQuestion]);
            if (Question.ask(indexQuestion)){
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
        //Выводми количество верных и неверных ответов.
        System.out.println("Правильных ответов " + countCorrectAnswer);
        System.out.println("Неправильных ответов " + countIncorrectAnswer);
    }

    static int getIndexQuestion() {
        //Получаем случайный номер вопроса.
        int rn = randomNumber(question.length);
        //Проверяем был ли ранее данный номер вопроса.
        while (linearSearch(listOfQuestionsAsked, rn)) {
            rn = randomNumber(question.length);
        }
        return rn;
    }

    //Выбор случайного числа.
    static int randomNumber(int r) {
        Random random = new Random();
        return random.nextInt(r);
    }

    //Поиск по массиву.
    static boolean linearSearch(int[] arr, int elementToSearch) {
        for (int i : arr) {
            if (i == elementToSearch) {
                return true;
            }
        }
        return false;
    }
}
