// Given an infix expression in the form of string str. Convert this infix
// expression to postfix expression.

// Infix expression: The expression of the form a op b. When an operator is
// in-between every pair of operands.
// Postfix expression: The expression of the form a b op. When an operator is
// followed for every pair of operands.
// â€‹Note: The order of precedence is: ^ greater than * equals to / greater
// than + equals to -.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1#

// Input: str = "a+b*(c^d-e)^(f+g*h)-i"
// Output: abcd^e-fgh*+^*+i-

// Input: str = "A*(B+C)/D"
// Output: ABC+*D/

class Solution {
    // Function to convert an infix expression to a postfix expression.

    // Helper method to get precedence of given character
    public static int getPrecedence(char ele) {
        if (ele == '^') {
            return 3;
        } else if (ele == '*' || ele == '/') {
            return 2;
        } else if (ele == '+' || ele == '-') {
            return 1;
        }
        // For '(' give lowest precedence
        else {
            return -1;
        }
    }

    public static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char cur = exp.charAt(i);
            // If letter, append to res string
            if ((cur >= 'a' && cur <= 'z') || (cur >= 'A' && cur <= 'Z')) {
                res.append(cur);
            }
            // If '(', push to stack
            else if (cur == '(') {
                stack.push(cur);
            }
            // If ')', pop from stack till '(' is there and append to res
            else if (cur == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res.append(stack.pop());
                }
                stack.pop();
            }
            // If operator, pop and append to res till precedence stack top element >=
            // precedence of cur element
            else {
                while (!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(cur)) {
                    res.append(stack.pop());
                }
                stack.push(cur); // push current element to stack
            }
        }

        // empty stack and append to res
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.toString();
    }
}