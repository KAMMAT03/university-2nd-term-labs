package lab2.ex1;


import java.util.Iterator;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> implements Iterable<T> {
    Node<T> root;

    public void addNode(T value){
        Node<T> newNode = new Node<>(value);

        if(root==null){
            root=newNode;
        } else {
            Node<T> focusNode = root;
            Node<T> parent;

            while(true){
                parent=focusNode;
                if(value.compareTo(focusNode.value) < 0){
                    focusNode = focusNode.leftChild;

                    if(focusNode==null){
                        parent.leftChild = newNode;
                        return;
                    }

                } else {
                    focusNode = focusNode.rightChild;

                    if(focusNode==null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new TreeIterator<>(root);
    }

    private static class TreeIterator<T extends Comparable<T>> implements Iterator<T> {
        private Stack<Node<T>> stack = new Stack<>();

        public TreeIterator(Node<T> root) {
            if (root != null) {
                stack.push(root);
                while (root.leftChild != null) {
                    stack.push(root.leftChild);
                    root = root.leftChild;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            Node<T> node = stack.pop();
            T value = node.value;
            if (node.rightChild != null) {
                node = node.rightChild;
                stack.push(node);
                while (node.leftChild != null) {
                    stack.push(node.leftChild);
                    node = node.leftChild;
                }
            }
            return value;
        }
    }

    public static class Node<T extends Comparable<T>> {
        T value;

        Node<T> leftChild;
        Node<T> rightChild;

        Node(T value){
            this.value=value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
