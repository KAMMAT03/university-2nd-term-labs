package lab2.ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchContactTest {

    private SearchContact searchContact;

    @BeforeEach
    void setUp() {
        searchContact = new SearchContact();
        searchContact.add("Adam", "123-456-789");
        searchContact.add("Barbara", "987-654-321");
        searchContact.add("Cecylia", "111-222-333");
    }

    @Test
    void testAdd() {
        SearchContact.Node rootNode = searchContact.root;
        Assertions.assertEquals("Adam", rootNode.name);
        Assertions.assertEquals("123-456-789", rootNode.phoneNumber);
        Assertions.assertEquals("Barbara", rootNode.right.name);
        Assertions.assertEquals("987-654-321", rootNode.right.phoneNumber);
        Assertions.assertEquals("Cecylia", rootNode.right.right.name);
        Assertions.assertEquals("111-222-333", rootNode.right.right.phoneNumber);
    }

    @Test
    void testFind() {
        searchContact.find("A");
        searchContact.find("Ba");
    }
}