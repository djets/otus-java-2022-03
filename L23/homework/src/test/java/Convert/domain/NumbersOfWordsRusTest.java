package Convert.domain;

import java.util.Comparator;
import org.junit.jupiter.api.Test;

public class NumbersOfWordsRusTest {
    
    @Test
    void testGetWordsList() throws Exception{
        NumbersOfWordsRus.getWordsList().stream().max(Comparator.naturalOrder())
        .orElseThrow((() ->new NullPointerException("List of numbers is empty")));  
    }

}
