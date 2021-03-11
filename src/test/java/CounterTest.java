import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CounterTest {
    private BasicCharCounter basic;

    @BeforeEach
    void setUp() throws Exception {
        basic = new BasicCharCounter();
    }

    @Test
    @DisplayName("empty value")
    void EmptyTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> basic.count(""));
        assertEquals("value cannot be empty", exception.getMessage());
    }

    @Test
    @DisplayName("simple count")
    void SimpleCounterTest() {
            String expected = "\"h\" - 1\n" +
                    "\"e\" - 1\n" +
                    "\"l\" - 3\n" +
                    "\"o\" - 2\n" +
                    "\" \" - 1\n" +
                    "\"w\" - 1\n" +
                    "\"r\" - 1\n" +
                    "\"d\" - 1\n" +
                    "\"!\" - 1\n";
        assertEquals(expected, basic.count("hello world!"));
    }

    @Test
    @DisplayName("Hard count")
    void HardCounterTest() {
        String expected = "\"q\" - 1\n" +
                "\"w\" - 1\n" +
                "\"e\" - 1\n" +
                "\"r\" - 1\n" +
                "\"t\" - 1\n" +
                "\"y\" - 1\n" +
                "\"u\" - 1\n" +
                "\"i\" - 1\n" +
                "\"o\" - 1\n" +
                "\"p\" - 1\n" +
                "\" \" - 1\n" +
                "\"a\" - 1\n" +
                "\"s\" - 1\n" +
                "\"d\" - 1\n" +
                "\"f\" - 1\n" +
                "\"g\" - 1\n" +
                "\"h\" - 1\n" +
                "\"j\" - 1\n" +
                "\"k\" - 1\n" +
                "\"l\" - 1\n";
        assertEquals(expected, basic.count("qwertyuiop asdfghjkl"));
    }
}
