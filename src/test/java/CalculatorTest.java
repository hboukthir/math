import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.example.service.MathService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.Calculator;

public class CalculatorTest {

    @Test
    public void testAdd() {
        MathService mockMathService = mock(MathService.class);
        when(mockMathService.add(2, 3)).thenReturn(5);

        Calculator calculator = new Calculator(mockMathService);
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testSubtract() {
        MathService mockMathService = mock(MathService.class);
        when(mockMathService.subtract(8, 3)).thenReturn(5);

        Calculator calculator = new Calculator(mockMathService);
        assertEquals(5, calculator.subtract(8, 3));
    }

    @Test
    public void testMultiply() {
        MathService mockMathService = mock(MathService.class);
        when(mockMathService.multiply(2, 3)).thenReturn(6);

        Calculator calculator = new Calculator(mockMathService);
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    public void testDivide() {
        MathService mockMathService = mock(MathService.class);
        when(mockMathService.divide(15, 3)).thenReturn(5);

        Calculator calculator = new Calculator(mockMathService);
        assertEquals(5, calculator.divide(15, 3));
    }

    @Test
    public void testDivideByZero() {
        MathService mockMathService = mock(MathService.class);
        when(mockMathService.divide(5, 0)).thenThrow( new ArithmeticException("Division par zéro"));

        Calculator calculator = new Calculator(mockMathService);
        assertThrows(ArithmeticException.class,()->calculator.divide(5, 0));
    }
}
