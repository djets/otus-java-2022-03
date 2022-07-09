package src.services;

import java.util.Scanner;

import src.appService.InputService;

public class InputConsole implements InputService {
private final Scanner in;

public InputConsole() {
    in = new Scanner(System.in);
}

    @Override
    public String inputString() {
        try (in) {
            return new String(in.nextLine());       
        } catch (Exception e) {
            return e.getMessage();
        }   
    }
}
