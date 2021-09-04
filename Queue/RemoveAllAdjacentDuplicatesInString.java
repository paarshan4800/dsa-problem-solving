// You are given a string s consisting of lowercase English letters. A duplicate
// removal consists of choosing two adjacent and equal letters and removing
// them.

// We repeatedly make duplicate removals on s until we no longer can.

// Return the final string after all such duplicate removals have been made. It
// can be proven that the answer is unique.

// Leetcode -
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

// Input: s = "abbaca"
// Output: "ca"

// Input: s = "azxxzy"
// Output: "ay"

// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public String removeDuplicates(String s) {
        // Can use stack also
        LinkedList<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            // If queue is empty, push char
            if (queue.isEmpty()) {
                queue.add(cur);
                continue;
            }

            // If queue tail == cur, remove queue tail
            if (queue.getLast() == cur) {
                queue.removeLast();
            }
            // Else add
            else {
                queue.add(cur);
            }
        }

        // The queue has the result
        StringBuilder res = new StringBuilder();

        for (Character ele : queue) {
            res.append(ele);
        }

        return res.toString();
    }
}