package Convert.services;

import Convert.appService.InputService;

import java.io.InputStream;
import java.util.Scanner;

public class InputConsole implements InputService<String> {
    private final Scanner in;

    public InputConsole(InputStream in) {
        this.in = new Scanner(in);
    }

    @Override
    public String inputString() {
        try (in) {
            String newString = in.nextLine();
            if (!newString.equalsIgnoreCase("exit")) {
                return newString;
            }
            System.exit(0);
            return "";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
