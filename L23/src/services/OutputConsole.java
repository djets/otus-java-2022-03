package src.services;

import java.io.PrintStream;
import java.util.Arrays;

import src.appService.OutputService;

public class OutputConsole implements OutputService {

    private final PrintStream out;

    public OutputConsole() {
        out = System.out;
    }

    @Override
    public void outputStrings(String ... strings) {
       //System.out.println(strings);
       Arrays.asList(strings).forEach(out::println);
    } 
}