package Algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class Q146 {
}

// 使用Java SDK LinkedHashMap实现
class LRUCache {
    private int maxSize;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        maxSize = capacity;
        cache = new LinkedHashMap<Integer, Integer>(maxSize, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > maxSize;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */