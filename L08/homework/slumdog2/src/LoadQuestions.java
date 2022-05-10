import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class LoadQuestions implements Load{
    @Override
    public List<String> load() {
        UserOutput userOutput = new ConsoleUserOutput();
        try {
            //Считываем файл вопросов по строчно.
            List<String> listOfQuestions = Files.readAllLines(Paths.get("src/question.txt"), StandardCharsets.UTF_8);
            //Преобразуем в массив типа String.
            return listOfQuestions;
        } catch (IOException e) {
            userOutput.print("Не найден путь к файлам вопросов");
        }
        return null;
    }
}