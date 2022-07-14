package src.main.java.convert.services;

import java.util.Scanner;
import src.main.java.convert.appService.InputService;

public class InputConsole implements InputService<String> {
private final Scanner in;

public InputConsole() {
    in = new Scanner(System.in);
}
    @Override
    public String inputString() {
        try (in) {
            String newString = in.nextLine();
            if(!newString.equalsIgnoreCase("exit")){
                return newString;
            }
            System.exit(0);   
            return "";  
        } catch (Exception e) {
            return e.getMessage();
        }   
    }
}
