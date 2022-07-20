package Convert.services;

import Convert.appService.OutputService;

import java.io.PrintStream;
import java.util.Arrays;

public class OutputConsole implements OutputService {

    private PrintStream out;

    public OutputConsole(PrintStream out) {
        this.out = out;
    }

    @Override
    public void outputStrings(String ... strings) {
       Arrays.asList(strings).forEach(out::println);
    } 
}
