package lab2.ex1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Iterator;

public class BinaryTreeTest {

    @Test
    public void testAddNode() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(7);
        tree.addNode(1);
        tree.addNode(9);
        assertTrue(tree.root.value == 5);
        assertTrue(tree.root.leftChild.value == 3);
        assertTrue(tree.root.leftChild.leftChild.value == 1);
        assertTrue(tree.root.rightChild.value == 7);
        assertTrue(tree.root.rightChild.rightChild.value == 9);
    }

    @Test
    public void testIterator() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(7);
        tree.addNode(1);
        tree.addNode(9);
        Iterator<Integer> iterator = tree.iterator();
        assertTrue(iterator.next() == 1);
        assertTrue(iterator.next() == 3);
        assertTrue(iterator.next() == 5);
        assertTrue(iterator.next() == 7);
        assertTrue(iterator.next() == 9);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testEmptyTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        Iterator<Integer> iterator = tree.iterator();
        assertFalse(iterator.hasNext());
    }

}
