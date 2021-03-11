import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CachingTest {

    @Mock
    Map<String, String> cache;
    @Mock
    CharCounter counter;

    @InjectMocks
    CachingCharCounterDecorator decorator;

    @Test
    void testWithCache() {
        String expected = "\"h\" - 1\n" +
                "\"e\" - 1\n" +
                "\"l\" - 3\n" +
                "\"o\" - 2\n" +
                "\" \" - 1\n" +
                "\"w\" - 1\n" +
                "\"r\" - 1\n" +
                "\"d\" - 1\n" +
                "\"!\" - 1\n";
        when(cache.containsKey("hello world")).thenReturn(true);
        when(decorator.count("hello world")).thenReturn(expected);
        assertSame(decorator.count("hello world"), expected);
        verify(counter, never()).count(anyString());
    }

    @Test
    void testWithoutCache() {
        String expected = "\"h\" - 1\n" +
                "\"e\" - 1\n" +
                "\"l\" - 3\n" +
                "\"o\" - 2\n" +
                "\" \" - 1\n" +
                "\"w\" - 1\n" +
                "\"r\" - 1\n" +
                "\"d\" - 1\n" +
                "\"!\" - 1\n";

        when(cache.containsKey("hello world!")).thenReturn(false);
        when(decorator.count("hello world!")).thenReturn(expected);
        assertSame(decorator.count("hello world!"), expected);
        verify(counter, atLeastOnce()).count(anyString());
    }
}
