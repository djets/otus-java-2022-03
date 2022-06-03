import java.util.*;
import java.util.function.Supplier;

public class ExceptionExample {
    public static void main(String[] args) {
        testException();
    }
    static void testException() {
        Scanner scanner = new Scanner(System.in);
        /*String[] listTest = new String[]{"1. IndexExceptionExample", "2. EndlessLoopExample","3. RethrowExample","4. TryWithResourceExample"};
        for (String s : listTest) {
            System.out.println(s);
        }*/
        //method reference: bounded
        //PrintStream - public void println(String s)
        //Consumer<T> - void accept(T t);
        Arrays.asList("1. IndexExceptionExample", "2. EndlessLoopExample","3. RethrowExample","4. TryWithResourceExample").forEach(System.out::println);
        System.out.println("Выберите пример и введит его номер ниже:");
        int test = scanner.nextInt();
        switch (test){
            case 1:
                try {
                    Example testOne = new IndexExceptionExample();
                    testOne.somethingMethod();
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Exception AIOOBE");
                    throw e;
                }
                break;
            case 2:
                Example testTwo = new MainExceptionExample();
                testTwo.somethingMethod();
                break;
            case 3:
                Example testThree = new RethrowExample();
                try {
                    testThree.somethingMethod();
                } catch (NullPointerException e){
                    System.out.println("Rethrow exception NPE");
                }
                break;
            case 4:
                Example testFour = new TryWithResourceExample();
                try {
                    testFour.somethingMethod();
                } catch (InputMismatchException e){
                    System.out.println("Rethrow exception Scanner");
                }
                break;
        }
        scanner.close();
    }

    interface Example {
        void somethingMethod();
    }
    static class IndexExceptionExample implements Example{
        int[] hoursWorked = {7,6,8,10};
        int totalHours = 0;
        @Override
        public void somethingMethod() {
            for (int i = 0; i <= hoursWorked.length; i++) {
                totalHours += hoursWorked[i];
            }
                System.out.println(totalHours);
        }
    }

    static class MainException extends Exception {
        public MainException(String message){
            super(message);
        }
    }
    static class MainExceptionExample implements Example{
        @Override
        public void somethingMethod() {
            try {
                throwMainException();
            } catch (MainException e) {
                e.printStackTrace();
            }
        }
        void throwMainException() throws MainException {
            throw new MainException("Exception main");
        }
    }
    static class RethrowExample implements Example{
        String name = null;
        @Override
        public void somethingMethod() {
            try{
                System.out.println(name.equals("Who"));
            } catch (Exception e){
                System.out.println("Exception NPE");
                throw e;
            }
        }
    }
    static class TryWithResourceExample implements Example{
        @Override
        public void somethingMethod() {
            Supplier<SomethingInt> test = () -> {
              try (Scanner in = new Scanner(System.in)) {
                  System.out.println("Наберите что нибудь: ");
                  int n = in.nextInt();
                  return new SomethingInt(n);
              } catch (Exception e){
                  System.out.println("Сюда можно писать только int");
                  throw e;
              }
            };
            SomethingInt intOne = test.get();
        }
    }
    static class SomethingInt {
        int somethingInt;
        SomethingInt(int somethingInt){
            this.somethingInt = somethingInt;
        }
    }
}
