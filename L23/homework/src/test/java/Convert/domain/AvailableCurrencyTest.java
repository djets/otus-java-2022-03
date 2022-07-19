package Convert.domain;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat; 

public class AvailableCurrencyTest {

    @Test
    void testDeclinationCurrency() throws Exception{
        List<Integer> listLastNumberTest = new ArrayList<>(Arrays.asList(1, 2, 6, 0));
        List<String> listDeclinationTest = new ArrayList<>(Arrays.asList("рубль", "рубля", "рублей", "рублей"));
        listLastNumberTest.forEach(v -> {
            assertThat(AvailableCurrency.RUB.declinationCurrency(v).replace(" ", ""))
            .isEqualTo(listDeclinationTest.get(listLastNumberTest.indexOf(v)));
        });   
    }
}
