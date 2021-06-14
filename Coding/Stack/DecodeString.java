// Given an encoded string, return its decoded string.

// The encoding rule is: k[encoded_string], where the encoded_string inside the
// square brackets is being repeated exactly k times. Note that k is guaranteed
// to be a positive integer.

// You may assume that the input string is always valid; No extra white spaces,
// square brackets are well-formed, etc.

// Furthermore, you may assume that the original data does not contain any
// digits and that digits are only for those repeat numbers, k. For example,
// there won't be input like 3a or 2[4].

// Leetcode - https://leetcode.com/problems/decode-string/

// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"

// Input: s = "3[a2[c]]"
// Output: "accaccacc"

// Input: s = "2[abc]3[cd]ef"
// Output: "abcabccdcdcdef"

// Input: s = "abc3[cd]xyz"
// Output: "abccdcdcdxyz"

class Solution {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();

        int i = 0;
        String res = "";

        while (i < s.length()) {
            char cur = s.charAt(i);
            // If char is a digit
            if (Character.isDigit(cur)) {
                int num = 0;
                // Find the entire number
                while (Character.isDigit(cur)) {
                    num = num * 10 + (cur - '0');
                    i++;
                    cur = s.charAt(i);
                }
                countStack.push(num); // push into stack
            }
            // If char is [ , push cur string i.e res into stack and reset res;
            else if (cur == '[') {
                strStack.push(res);
                res = "";
                i++;
            }
            // If char is ] , pop str and count from both stacks. append res to str count
            // times
            else if (cur == ']') {
                StringBuilder temp = new StringBuilder(strStack.pop());
                int num = countStack.pop();

                for (int j = 0; j < num; j++) {
                    temp.append(res);
                }

                res = temp.toString(); // update cur str i.e res also
                i++;
            }
            // If char is a alphabet
            else {
                res += cur; // update res
                i++;
            }

        }

        return res;
    }
}