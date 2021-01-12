import java.util.Map;
import java.util.LinkedHashMap;


class LRUMap<Key, Value> extends LinkedHashMap<Key, Value> {
    
    private int capacity;
    
    public LRUMap(int capacity) {
        super(capacity);
        this.capacity = capacity;
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > this.capacity;
    }
    
}


class LRUCache {
    
    private LRUMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        assert capacity_constraint(capacity);
        this.map = new LRUMap<Integer, Integer>(capacity);
    }
    
    public int get(int key) {
        assert key_constraint(key);
        if (!this.map.containsKey(key)) {
            return -1;
        }
        int value = this.map.get(key);
        this.map.remove(key);
        this.put(key, value);
        return value;
    }
    
    public void put(int key, int value) {
        assert key_constraint(key);
        assert value_constraint(value);
        if (this.map.containsKey(key)) {
            this.map.remove(key);
        }
        this.map.put(key, value);
    }
    
    private boolean capacity_constraint(int capacity) {
        return 1 <= capacity && capacity <= 3000;
    }
    
    private boolean key_constraint(int key) {
        return 0 <= key && key <= 3000;
    }
    
    private boolean value_constraint(int value) {
        return 0 <= value && value <= 10000;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */