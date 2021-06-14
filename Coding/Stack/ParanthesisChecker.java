// Given an expression string x. Examine whether the pairs and the orders of
// “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
// For example, the function should return 'true' for exp = “[()]{}{[()()]()}”
// and 'false' for exp = “[(])”.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1#

// Input:
// {([])}
// Output:
// true

// Input:
// ([]
// Output:
// false

class Solution {
    // Function to check if brackets are balanced or not.
    static boolean ispar(String x) {
        // add your code here
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < x.length(); i++) {
            char cur = x.charAt(i);

            // If open brace, just push
            if (cur == '{' || cur == '(' || cur == '[') {
                stack.push(cur);
            }
            // If closing brace
            else {
                // If stack is empty, only open brace should come to open a new one.
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                // If the type of opening brace at the top of the stack is equal to the type of
                // closing brace (cur), continue
                // Else return false
                if ((cur == '}' && top == '{') || (cur == ']' && top == '[') || (cur == ')' && top == '(')) {
                    continue;
                }

                return false;

            }

        }

        // After processing the given string, stack should be empty
        return stack.isEmpty() ? true : false;
    }
}