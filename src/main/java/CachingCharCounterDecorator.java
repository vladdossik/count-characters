import java.util.HashMap;
import java.util.Map;

class CachingCharCounterDecorator implements CharCounter {
    private final CharCounter counter;
    private final Map<String, String> cache;

    CachingCharCounterDecorator(CharCounter source) {
        this(source, new HashMap<>());
    }

    CachingCharCounterDecorator(CharCounter source, Map<String, String> cache) {
        this.counter = source;
        this.cache = cache;
    }


    @Override
    public String count(String text) {
        if (!cache.containsKey(text)) {
            cache.put(text, counter.count(text));
        }
        return cache.get(text);
    }
    public Map<String,String> getcache(){
        return cache;
    }

}
