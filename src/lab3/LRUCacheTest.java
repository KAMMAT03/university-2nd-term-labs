package lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    LRUCache<Integer, String> cache;

    @BeforeEach
    void setUp() {
        cache = new LRUCache<>(3);
    }

    @Test
    void testPutAndGet() {
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.get(1);
        cache.put(4, "four");
        assertThrows(NoSuchElementException.class, () -> cache.get(2));
        assertEquals("one", cache.cache.get(1));
        assertEquals("three", cache.cache.get(3));
        assertEquals("four", cache.cache.get(4));
    }

}
