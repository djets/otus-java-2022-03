import java.util.List;
class Answers {
    private final int numberOfAnswer;
    Answers(int numberOfAnswer) {
        this.numberOfAnswer = numberOfAnswer;
    }
    String AnswersOnQuestion() {
        Load loadAnswers = new LoadAnswers();
        List<String> answer = (List<String>) loadAnswers.load();
        return answer.get(numberOfAnswer);
    }

}
