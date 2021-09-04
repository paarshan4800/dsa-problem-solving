// Give a binary string s, return the number of non-empty substrings that have
// the same number of 0's and 1's, and all the 0's and all the 1's in these
// substrings are grouped consecutively.

// Substrings that occur multiple times are counted the number of times they
// occur.

// GeeksForGeeks - https://leetcode.com/problems/count-binary-substrings/

// Input: s = "00110011"
// Output: 6
// Explanation: There are 6 substrings that have equal number of consecutive 1's
// and 0's: "0011", "01", "1100", "10", "0011", and "01".
// Notice that some of these substrings repeat and are counted the number of
// times they occur.
// Also, "00110011" is not a valid substring because all the 0's (and 1's) are
// not grouped together.

// Input: s = "10101"
// Output: 4
// Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal
// number of consecutive 1's and 0's.

// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public int countBinarySubstrings(String s) {

        // Group the count of consecutive same characters

        int res = 0;
        ArrayList<Integer> groups = new ArrayList<>();
        groups.add(1); // For Initial character at index 0, the count is 1

        for (int i = 1; i < s.length(); i++) {
            // If the current character is same as the previous character
            if (s.charAt(i) == s.charAt(i - 1)) {
                // Increment the current group size
                groups.set(groups.size() - 1, groups.get(groups.size() - 1) + 1);
            }
            // Else start a new group with count 1
            else {
                groups.add(1);
            }
        }

        // Add the minimum of consecutive groups to res
        for (int i = 1; i < groups.size(); i++) {
            res += Math.min(groups.get(i), groups.get(i - 1));
        }

        return res;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(1)
class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        int prev = 0, cur = 1;

        for (int i = 1; i < s.length(); i++) {
            // If the current character is same as the previous character
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++; // Increment cur
            } else {
                // Add the minimum of cur and prev to res
                res += Math.min(cur, prev);
                prev = cur; // Set prev to cur
                cur = 1; // Reset cur to 1
            }
        }

        return res += Math.min(cur, prev);
    }
}