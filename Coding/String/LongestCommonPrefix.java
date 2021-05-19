// Write a function to find the longest common prefix string amongst an array of
// strings. If there is no common prefix, return an empty string "".
// Leetcode - https://leetcode.com/problems/longest-common-prefix/

// Input: strs = ["flower","flow","flight"]
// Output: "fl"

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.

// Instead of [row][column] traversal, do [column][row] traversal (Vertical Scanning)
// Time Complexity - O(n*m) where n is number of strings and m is size of shortest string
// Space Complexity - O(1)
class Solution {
    public String longestCommonPrefix(String[] strs) {

        int size = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            size = Math.min(size, strs[i].length());
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    return res.toString();
                }
            }
            res.append(strs[0].charAt(i));
        }

        return res.toString();

    }
}

// Another approach
// Take two strings at at time and compare and find
// res(res(res(0,1),2),3)

// Another approach
// Divide and Conquer
// Divide till we reach sub problems
// Conquer by finding solutions for subproblems