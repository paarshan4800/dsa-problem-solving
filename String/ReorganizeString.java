// Given a string s, rearrange the characters of s so that any two adjacent
// characters are not the same.

// Return any possible rearrangement of s or return "" if not possible.

// Leetcode - https://leetcode.com/problems/reorganize-string/

// Input: s = "aab"
// Output: "aba"

// Input: s = "aaab"
// Output: ""

// Input: s = "abbabbaaab"
// Output: "ababababab"

// Input: s = "vvvlo"
// Output: "vlvov"

// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();

        // Store frequency of characters in hash
        for (Character cur : s.toCharArray()) {
            if (hash.containsKey(cur))
                hash.put(cur, hash.get(cur) + 1);
            else
                hash.put(cur, 1);
        }

        // Max heap of pairs(char,int) inserted by comparing int
        PriorityQueue<Pair<Character, Integer>> maxHeap = new PriorityQueue<>(
                Collections.reverseOrder(Comparator.comparing(Pair::getValue)));

        // Insert all hash elements into maxHeap
        for (Map.Entry<Character, Integer> entry : hash.entrySet()) {
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }

        StringBuilder res = new StringBuilder();

        while (maxHeap.size() > 1) {
            // Pop two elements from maxHeap
            Pair<Character, Integer> temp1 = maxHeap.poll();
            Pair<Character, Integer> temp2 = maxHeap.poll();

            // Append those two characters into the res string
            res.append(temp1.getKey());
            res.append(temp2.getKey());

            // Push back those two into the maxHeap only if freq-1>0
            if (temp1.getValue() - 1 > 0) {
                maxHeap.add(new Pair(temp1.getKey(), temp1.getValue() - 1));
            }

            if (temp2.getValue() - 1 > 0) {
                maxHeap.add(new Pair(temp2.getKey(), temp2.getValue() - 1));
            }
        }

        // If maxHeap is empty, we have process all the characters. So return true
        if (maxHeap.isEmpty())
            return res.toString();

        // Pop from maxHeap. If freq is > 1, we cant place the characters such that no
        // adjacent characters are same. So return ""
        Pair<Character, Integer> temp = maxHeap.poll();
        if (temp.getValue() > 1)
            return "";

        // Else append the char to res and return
        return res.append(temp.getKey()).toString();

    }
}