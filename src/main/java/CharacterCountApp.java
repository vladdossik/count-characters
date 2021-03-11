import java.util.HashMap;
import java.util.Map;

public class CharacterCountApp {
    public static void main(String[] args) {
        String text = "hello world!";
        CharCounter counter = new BasicCharCounter();
        CachingCharCounterDecorator decorator = new CachingCharCounterDecorator(counter);
        Map<String, String> res = new HashMap<>();
        System.out.println(decorator.count(text));

    }
}
