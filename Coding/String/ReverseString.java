// Write a function that reverses a string. The input string is given as an array of characters s.
// Leetcode - https://leetcode.com/problems/reverse-string/

// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]

class Solution {
    public void reverseString(char[] s) {

        // Two pointer approach
        int i=0,j=s.length-1;
        
        // Till two pointers meet each other, swap
        while(i<j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        
    }
}