public class TestedItem {
    private final int[] rightAnswerIndex = {1,1,4,1,3,1,4,4,1};
    protected static final int[] numberOfPossibleAnswer = {4,4,4,4,4,4,4,4,4};
    boolean ask(int index){
        UserOutput userOutput = new ConsoleUserOutput();
        int numberAnswer = index * numberOfPossibleAnswer[index];
        int an = 1;
        for (int a = numberAnswer; a < numberAnswer + numberOfPossibleAnswer[index]; a++){
            userOutput.print("Ответ №" + an + ": " + new Answers(a).AnswersOnQuestion());
            an++;
        }
        UserInput answer = (UserInput) new ConsoleUserInput();
        return answer.read(index) == rightAnswerIndex[index];
    }
}
