// Given an input stream of A of n characters consisting only of lower case
// alphabets. The task is to find the first non repeating character, each time a
// character is inserted to the stream. If there is no such character then
// append '#' to the answer.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1#

// Input: A = "aabc"
// Output: "a#bb"
// Explanation: For every character first non
// repeating character is as follow-
// "a" - first non-repeating character is 'a'
// "aa" - no non-repeating character so '#'
// "aab" - first non-repeating character is 'b'
// "aabc" - first non-repeating character is 'b'

// Input: A = "zz"
// Output: "z#"
// Explanation: For every character first non
// repeating character is as follow-
// "z" - first non-repeating character is 'z'
// "zz" - no non-repeating character so '#'

class Solution {
    public String FirstNonRepeating(String A) {
        int[] hash = new int[26];
        Queue<Character> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        // Process the first character
        queue.add(A.charAt(0)); // add to queue
        hash[A.charAt(0) - 'a'] = 1; // set frequency to 1
        res.append(A.charAt(0)); // append to res

        for (int i = 1; i < A.length(); i++) {

            // If frequency is less than 1, there is a possibility that it can be a
            // non-repeating character. So add to queue
            if (hash[A.charAt(i) - 'a'] <= 1)
                queue.add(A.charAt(i));

            // Increment frequency
            hash[A.charAt(i) - 'a']++;

            // If queue is not empty and queue front's frequency is greater than 1, it cant
            // be a non-repeating character. So remove from queue
            while (!queue.isEmpty() && hash[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            // If queue is empty, there is no non-repeating character. So append #
            if (queue.isEmpty()) {
                res.append("#");
            }
            // Else queue front is the non-repeating character
            else {
                res.append(queue.peek());
            }

        }

        return res.toString();
    }
}