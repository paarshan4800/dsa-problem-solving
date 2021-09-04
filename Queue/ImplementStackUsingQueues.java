// Implement a last in first out (LIFO) stack using only two queues. The
// implemented stack should support all the functions of a normal queue (push,
// top, pop, and empty).

// Leetcode-https://leetcode.com/problems/implement-stack-using-queues/

// Using Two Queues
// Either we can do push costly and pop costly.
// If push costly, for every push operation we pop all elements and store it in a 
// temporary queue. Push the new element to the main queue and then push all the 
// elements from the temp queue to main queue
// Same for pop costly

// Using One Queue
class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        // Pop size-1 times from the queue and add it back (like circular)
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.poll());
        }
        // First element of the queue is the desired element (top of the stack)
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        int ret = pop();
        push(ret);
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}