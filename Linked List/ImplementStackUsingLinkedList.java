// Let's give it a try! You have a linked list and you have to implement the
// functionalities push and pop of stack using this given linked list. Your task
// is to use the class as shown in the comments in the code editor and complete
// the functions push() and pop() to implement a stack.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/implement-stack-using-linked-list/1/

// Push and pop at the start of linked list
class MyStack {
    StackNode top;

    // Function to push an integer into the stack.
    void push(int a) {
        StackNode newNode = new StackNode(a);
        newNode.next = top;
        top = newNode;
    }

    // Function to remove an item from top of the stack.
    int pop() {
        if (top == null)
            return -1;

        int ret = top.data;
        top = top.next;
        return ret;

    }
}