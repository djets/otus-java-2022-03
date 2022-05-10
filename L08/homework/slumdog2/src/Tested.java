import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Tested {
    private static final Load loadQuestion = new LoadQuestions();
    private static final List<String> questions = (List<String>) loadQuestion.load();
    private final static HashSet<Integer> listOfQuestionsAsked = new HashSet<>();

    public static void main(String[] args) {
        UserOutput userOutput = new ConsoleUserOutput();
        userOutput.print("\nЗдравствуй ученик!");
        User newUser = new User();
        newUser.setNameUser();
        userOutput.print("\nДобро пожаловать в тест SLUMDOG2\n" + newUser.getNameUser() + "\n");

        int countCorrectAnswer = 0, countIncorrectAnswer = 0;
        TestedItem item = new TestedItem();

        for (int i = 0; i < questions.size(); i++) {
            int indexQuestion = getIndexQuestion();
            //Выводим вопрос.
            int s = i + 1;
            userOutput.print("Вопрос №" + s + ": " + questions.get(indexQuestion));
            //Проверяем ответ.
            if (item.ask(indexQuestion)){
                userOutput.print("Правильный ответ. \n");
                countCorrectAnswer++;
            } else {
                countIncorrectAnswer++;
                userOutput.print("Ваш ответ неверный. \n");
            }
            listOfQuestionsAsked.add(indexQuestion);
        }
        //Поздравляем если ученик ответил на все вопросы правильно.
        if (countCorrectAnswer == 9){
            userOutput.print("Правильных ответов " + countCorrectAnswer + "\nПоздравляю тебя " + newUser.getNameUser() + "!!!");
        }
        //Выводми количество верных и неверных ответов.
        userOutput.print("Правильных ответов " + countCorrectAnswer);
        userOutput.print("Неправильных ответов " + countIncorrectAnswer);
    }
    static int getIndexQuestion() {
        Random random = new Random();
        //Получаем случайный номер вопроса.
        int r = random.nextInt(questions.size());
        //Проверяем был ли ранее данный номер вопроса.
        while (listOfQuestionsAsked.contains(r)) {
            r = random.nextInt(questions.size());
        }
        return r;
    }
}
