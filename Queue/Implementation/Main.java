class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class Queue {
    Node front;
    Node rear;

    Queue() {
        this.front = null;
        this.rear = null;
    }

    void push(int data) {
        Node newNode = new Node(data);

        // Queue is empty
        if (front == null) {
            front = newNode;
            rear = front;
        }

        // Add to the rear and move rear
        rear.next = newNode;
        rear = rear.next;
    }

    int pop() {
        // Empty queue
        if (front == null)
            return -1;

        // Store data to be returned and move front
        int ret = front.data;
        front = front.next;

        // Queue is empty. Make rear also empty
        if (front == null)
            rear = null;

        return ret;
    }

    int peek() {
        if (front == null)
            return -1;

        return front.data;
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        queue.push(40);
        queue.push(50);
        System.out.println(queue.pop());

        queue.push(60);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }
}
