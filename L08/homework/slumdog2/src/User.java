public class User {
    protected String name;
    public void setNameUser(){
        UserInput userInput = new ConsoleUserInput();
        name = userInput.read();
    }
    public String getNameUser(){
        return name;
    }
}
