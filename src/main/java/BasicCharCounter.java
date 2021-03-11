import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasicCharCounter implements CharCounter {

    @Override
    public String count(String text) {
        if (text.isEmpty()) throw new IllegalArgumentException("value cannot be empty");
        return findUnique(text);
    }

    private String findUnique(String text) {
        return getAsString(Arrays.stream(text.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())));
    }

    private String getAsString(Map<String, Long> result) {
        return result.keySet().stream()
                .map(key -> "\"" + key + "\" - " + result.get(key) + "\n")
                .collect(Collectors.joining());
    }
}
