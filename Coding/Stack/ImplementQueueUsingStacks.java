// Implement a first in first out (FIFO) queue using only two stacks. The
// implemented queue should support all the functions of a normal queue (push,
// peek, pop, and empty).

// Leetcode - https://leetcode.com/problems/implement-queue-using-stacks/

// Using Two Stacks
// Either we can do push costly and pop costly.
// If push costly, for every push operation we pop all elements and store it in a 
// temporary stack. Push the new element to the main stack and then push all the 
// elements from the temp stack to main stack
// Same for pop costly

// Pop costly implementation
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> aux;

    public MyQueue() {
        stack = new Stack<>();
        aux = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (stack.size() > 1) {
            aux.push(stack.pop());
        }
        int ret = stack.pop();

        while (!aux.isEmpty()) {
            stack.push(aux.pop());
        }
        return ret;
    }

    /** Get the front element. */
    public int peek() {
        while (!stack.isEmpty()) {
            aux.push(stack.pop());
        }

        int ret = aux.peek();

        while (!aux.isEmpty()) {
            stack.push(aux.pop());
        }
        return ret;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */