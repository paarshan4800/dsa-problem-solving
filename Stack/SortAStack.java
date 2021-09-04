// Given a stack, the task is to sort it such that the top of the stack has the
// greatest element.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/sort-a-stack/1#

// Input:
// Stack: 3 2 1
// Output: 3 2 1

// Input:
// Stack: 11 2 32 3 41
// Output: 41 32 11 3 2

// Using another stack - Iterative
// Time Complexity - O(n^2)
// Space Complexity - O(n)
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // Result stack
        Stack<Integer> res = new Stack<Integer>();

        // Till original stack is not empty
        while (!s.isEmpty()) {

            int ele = s.pop();

            // If res is empty, just push
            if (res.isEmpty()) {
                res.push(ele);
                continue;
            }

            // Till res is not empty and top of res > ele, pop that out and push back to
            // original stack. By doing this we make sure that in every iteration res has
            // elements in the result order
            while (!res.isEmpty() && res.peek() > ele) {
                s.push(res.pop());
            }

            // push ele to result stack
            res.push(ele);
        }

        return res;
    }
}

// Recursive Solution
// Time Complexity - O(n^2)
// Space Complexity - O(n) call stack
class GfG {

    public Stack<Integer> insertStack(Stack<Integer> s, int val) {
        // If stack is empty or val is greater than top of the stack, just push into
        // stack
        if (s.isEmpty() || val > s.peek()) {
            s.push(val);
            return s;
        }

        // else again pop from stack and hold it in temp
        int temp = s.pop();

        s = insertStack(s, val); // Recur s till val can be inserted into the stack

        s.push(temp); // Push temp into the stack

        // By doing so, s will be in sorted order
        return s;
    }

    public Stack<Integer> sort(Stack<Integer> s) {
        // If stack not empty
        if (!s.isEmpty()) {
            int temp = s.pop(); // Pop and hold it in temp

            s = sort(s); // Recur s till it gets empty

            // The popped out value will be stored in the recursion call stack

            s = insertStack(s, temp); // Insert temp into s

        }

        return s;
    }
}