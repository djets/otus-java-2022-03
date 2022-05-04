import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
class Answer {
    private static String[] arrayAnswersStrings;
    static String[] loadAnswer() {
        // Используем try catch для вывода сообщения об ошибке.
        try {
            //Считываем файл ответов по строчно.
            List<String> listOfAnswer = Files.readAllLines(Paths.get("src/answer.txt"), StandardCharsets.UTF_8);
            //Преобразуем в массив типа String.
            return arrayAnswersStrings = listOfAnswer.toArray(new String[0]);
        } catch (IOException e) {
            System.out.println("Не найден путь к файлам ответов.");
        }
        return new String[0];
    }
    static void showAnswer(int index){
        loadAnswer();
        int numberAnswer = index * Test.NUMBER_OF_POSSIBLE_ANSWER;
        //Выводим варианты ответа.
        String[] listAnswer = new String[Test.NUMBER_OF_POSSIBLE_ANSWER];
        int an = 1;
        for (int a = 0; a < Test.NUMBER_OF_POSSIBLE_ANSWER; a++){
            listAnswer[a] = arrayAnswersStrings[(numberAnswer)];
            System.out.println("Ответ №" + an + ": " + listAnswer[a]);
            numberAnswer++;
            an++;
        }

    }
}
