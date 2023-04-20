package lab3;

import java.util.*;

class LRUCache <K, V>{

    LinkedHashMap<K, V> cache;
    int capacity;

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lRUCache = new LRUCache<>(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.display();
        lRUCache.get(1);
        lRUCache.display();
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.display();
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

    public void display(){
        List<Map.Entry<K, V>> list = new ArrayList<>(cache.entrySet());
        ListIterator<Map.Entry<K, V>> iterator = list.listIterator(list.size());
        System.out.print("[ ");
        while (iterator.hasPrevious()){
            Map.Entry<K, V> entry = iterator.previous();
            System.out.print("["+ entry.getKey() + ", " + entry.getValue() + "] ");
        }
        System.out.print("]\n");
    }

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
        this.capacity = capacity;
    }

    public void get(K key) {
        if (cache.containsKey(key)){
            V val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
            System.out.println(val);
        } else {
            throw new NoSuchElementException("This value is not present in cache");
        }
    }

    public void put(K key, V value) {
        cache.remove(key);
        cache.put(key, value);
    }
}