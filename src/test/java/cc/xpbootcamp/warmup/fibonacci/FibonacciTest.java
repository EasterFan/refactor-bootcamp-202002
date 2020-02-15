package cc.xpbootcamp.warmup.fibonacci;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    void should_return_1_when_given_1() throws Exception {
        int index = 1;
        assertEquals(1, Fibonacci.fibonacci(index));
    }

    @Test
    void should_return_1_when_given_2() throws Exception {
        int index = 2;
        assertEquals(1, Fibonacci.fibonacci(index));
    }

    @Test
    void should_return_144_when_given_12() throws Exception {
        int index = 12;
        assertEquals(144, Fibonacci.fibonacci(index));
    }

    @Test
    void should_return_12586269025L_when_given_50() throws Exception {
        int index = 50;
        assertEquals(12586269025L, Fibonacci.fibonacci(index));
    }

    @Test
    void should_return_error_when_given_error_input() {
        int index = -1;
        Exception exception = assertThrows(Exception.class, () ->
                Fibonacci.fibonacci(index));
        assertEquals("Bad args", exception.getMessage());
    }
}
