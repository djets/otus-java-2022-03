import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class LoadAnswers implements Load{
    @Override
    public List<String> load() {
        try {
            //Считываем файл ответов по строчно.
            List<String> listOfAnswer = Files.readAllLines(Paths.get("src/answer.txt"), StandardCharsets.UTF_8);
            //Преобразуем в массив типа String.
            //return listOfAnswer.toArray(new String[0]);
            return listOfAnswer;
        } catch (IOException e) {
            System.out.println("Не найден путь к файлам ответов.");
        }
        return null;
    }
}
