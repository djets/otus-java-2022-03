import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
class LoadAnswers implements Load{
    @Override
    public List<String> load() {
        UserOutput userOutput = new ConsoleUserOutput();
        try {
            //Считываем файл ответов по строчно.
            List<String> listOfAnswer = Files.readAllLines(Paths.get("src/answer.txt"), StandardCharsets.UTF_8);
            return listOfAnswer;
        } catch (IOException e) {
            userOutput.print("Не найден путь к файлам ответов.");
        }
        return null;
    }
}
