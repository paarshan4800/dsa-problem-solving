// Given a string s and an integer k, the task is to reduce the string by
// applying the following operation:
// Choose a group of k consecutive identical characters and remove them.

// The operation can be performed any number of times until it is no longer
// possible.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/8c8f95810b05b4cab665f2997d36991bd58308a2/1/

// Input:
// k = 2
// s = "geeksforgeeks"
// Output:
// gksforgks
// Explanation:
// Modified String after each step:
// "geeksforgeeks" -> "gksforgks"

// Input:
// k = 2
// s = "geegsforgeeeks"
// Output:
// sforgeks
// Explanation:
// Modified String after each step:
// "geegsforgeeeks" -> "ggsforgeks" -> "sforgeks"

class Solution {
    static class StackNode {
        char letter;
        int count;

        StackNode(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }
    }

    public static String reduced_String(int k, String s) {

        // All the characters should get cancelled out
        if (k == 1)
            return "";

        Stack<StackNode> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            // If stack is empty or the current character doesn't match with stack's top's
            // character
            if (stack.isEmpty() || cur != stack.peek().letter) {
                // Push the new character with its count as 1
                stack.push(new StackNode(cur, 1));
            }
            // If stack is not empty and the current character matches with stack's top's
            // character
            else {
                // Increment the count
                int count = stack.peek().count + 1;

                // Push the character with incremented count
                stack.push(new StackNode(cur, count));

                // If count == k, pop from stack k times
                if (count == k) {
                    for (int j = 0; j < k; j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();

        while (!stack.isEmpty()) {
            res.append(stack.pop().letter);
        }

        return res.reverse().toString();
    }
}