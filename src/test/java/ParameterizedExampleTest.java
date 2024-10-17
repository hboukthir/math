import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ParameterizedExampleTest {
    @ParameterizedTest
    @CsvFileSource(resources="/data.csv", numLinesToSkip = 1) //charger le fichier csv
    public void testAdd(int a, int b, int expected) {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.add(a, b));
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
