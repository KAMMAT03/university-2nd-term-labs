package lab2.ex2;

public class SearchContact {
    public Node root;

    public static class Node {
        String name;
        String phoneNumber;
        Node left;
        Node right;

        public Node(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.left = null;
            this.right = null;
        }
    }

    public SearchContact() {
        root = null;
    }

    public void add(String name, String phoneNumber) {
        Node newNode = new Node(name, phoneNumber);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            while (true) {
                if (name.compareTo(current.name) < 0) {
                    if (current.left == null) {
                        current.left = newNode;
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = newNode;
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    private void find(Node node, String prefix) {
        if (node != null) {
            if (node.name.startsWith(prefix)) {
                System.out.println("Imie: " + node.name + "; Numer telefonu: " + node.phoneNumber);
            }
            find(node.left, prefix);
            find(node.right, prefix);
        }
    }
    public void find(String prefix) {
        find(root, prefix);
    }


    public static void main(String[] args) {
        SearchContact tree = new SearchContact();
        tree.add("Maria",  "111-222-333");
        tree.add("Katarzyna",  "444-555-666");
        tree.add("Kamila",  "777-888-999");
        tree.add("Darek",  "555-444-333");

        System.out.println("Kontakty zaczynające się na 'Ma': ");
        tree.find("Ma");
    }
}
