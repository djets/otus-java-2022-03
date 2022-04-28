import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Resources {
    //Инициализируем пустые массивы
    static String[] arrayQuestionsStrings = new String[0];
    static String[] arrayAnswersStrings = new String[0];

    static void loadAnswer() throws IOException{
        //String[] arrayAnswerStrings;
        //Пробуем подтянуть файлы.
        //Используем try catch для вывода сообщения об ошибке.
        try {
            //Считываем файл вопросов по строчно.
            //List<String> listOfQuestions = Files.readAllLines(Paths.get("src/question.txt"), StandardCharsets.UTF_8);
            //Преобразуем в массив типа String.
            //arrayQuestionsStrings = listOfQuestions.toArray(new String[0]);
            //Считываем файл ответов по строчно.
            List<String> listOfAnswer = Files.readAllLines(Paths.get("src/answer.txt"), StandardCharsets.UTF_8);
            arrayAnswersStrings = listOfAnswer.toArray(new String[0]);
            //return arrayAnswerStrings;
        } catch (IOException e) {
            System.out.println("Не найден путь к файлам ответов.");
        }
        //return new String[0];
    }

    //getArrayAnswerString()

    static void loadQuestion() throws IOException{
        //String[] arrayQuestionsStrings;
        //Пробуем подтянуть файлы.
        //Используем try catch для вывода сообщения об ошибке.
        try {
            //Считываем файл вопросов по строчно.
            List<String> listOfQuestions = Files.readAllLines(Paths.get("src/question.txt"), StandardCharsets.UTF_8);
            //Преобразуем в массив типа String.
            arrayQuestionsStrings = listOfQuestions.toArray(new String[0]);
            //Считываем файл ответов по строчно.
            //List<String> listOfAnswer = Files.readAllLines(Paths.get("src/answer.txt"), StandardCharsets.UTF_8);
            //arrayAnswerStrings = listOfAnswer.toArray(new String[0]);
            //return arrayQuestionsStrings;
        } catch (IOException e) {
            System.out.println("Не найден путь к файлам вопросов.");
        }
        //return new String[0];
    }
}
