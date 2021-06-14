// Design your implementation of the circular queue. The circular queue is a
// linear data structure in which the operations are performed based on FIFO
// (First In First Out) principle and the last position is connected back to the
// first position to make a circle. It is also called "Ring Buffer".

// One of the benefits of the circular queue is that we can make use of the
// spaces in front of the queue. In a normal queue, once the queue becomes full,
// we cannot insert the next element even if there is a space in front of the
// queue. But using the circular queue, we can use the space to store new
// values.

// Leetcode - https://leetcode.com/problems/design-circular-queue/
class MyCircularQueue {

    ListNode front;
    ListNode rear;
    int capacity;
    int size;

    public MyCircularQueue(int k) {
        front = null;
        rear = null;
        capacity = k;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        if (front == null && rear == null) {
            front = new ListNode(value);
            rear = front;
        } else {
            rear.next = new ListNode(value);
            rear = rear.next;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (front == rear) {
            front = front.next;
            rear = front;
        } else {
            front = front.next;
        }

        size--;

        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return front.data;
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return rear.data;
    }

    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }

    public boolean isFull() {
        return (size == capacity) ? true : false;
    }

    class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
