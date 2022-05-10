public class ConsoleUserOutput implements UserOutput{
    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
