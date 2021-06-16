// You are given N elements and your task is to Implement a Stack in which you can get minimum element in O(1)time.

// GeeksForGeeks - https:practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1#

class GfG {
    int minEle;
    Stack<Integer> s;

    GfG() {
        minEle = Integer.MAX_VALUE;
        s = new Stack<>();
    }

    /* returns min element from stack */
    int getMin() {
        // If stack is empty, return -1. Else return minEle
        return (!s.isEmpty()) ? minEle : -1;
    }

    /* returns poped element from stack */
    int pop() {
        // If stack is empty, return -1
        if (s.isEmpty())
            return -1;

        int prevMin = s.pop();
        int ret = s.pop();

        // If popped out minEle == minEle, update minEle
        if (prevMin == minEle) {
            minEle = (s.isEmpty()) ? Integer.MAX_VALUE : s.peek();
        }
        return ret;
    }

    /* push element x into the stack */
    void push(int x) {
        // If x < minEle, update minEle
        if (x < minEle)
            minEle = x;

        // Push both x and minEle into the stack
        s.push(x);
        s.push(minEle);

    }
}
