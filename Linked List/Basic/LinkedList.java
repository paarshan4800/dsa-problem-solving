public class LinkedList {
    Node root;

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        } else {
            Node temp = root;
            for (; temp.next != null; temp = temp.next) {
            }
            temp.next = newNode;
        }
    }

    public void display() {
        for (Node temp = root; temp != null; temp = temp.next) {
            System.out.println(temp.data);
        }
    }
}
