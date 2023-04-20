package lab3;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PathTest {

    @Test
    void testInvalidStart() {
        List<List<Integer>> result = Path.findPath(7,24,45,5);
        assertEquals(0, result.size());
    }

    @Test
    void testInvalidEnd() {
        List<List<Integer>> result = Path.findPath(3,16,1,1);
        assertEquals(0, result.size());
    }

    @Test
    void testValidPathExists() {
        List<List<Integer>> result = Path.findPath(3,16,45,5);
        assertFalse(result.isEmpty());
    }

    @Test
    void testPathDoesNotExist() {
        List<List<Integer>> result = Path.findPath(3,16,41,36);
        assertTrue(result.isEmpty());
    }
}
