// The count-and-say sequence is a sequence of digit strings defined by the
// recursive formula:
// countAndSay(1) = "1"
// countAndSay(n) is the way you would "say" the digit string from
// countAndSay(n-1), which is then converted into a different digit string.
// Leetcode -
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/886/

// Input: n = 1
// Output: "1"

// Input: n = 4
// Output: "1211"

class Solution {
    public String countAndSay(int n) {
        // If n is invalid (<=0)
        if (n <= 0) {
            return "";
        }

        // When n=1, res will be "1"
        String res = "1";

        // For n-1 times
        for (int i = 1; i < n; i++) {
            // StringBuilder more efficient than String as latter is immutable
            StringBuilder temp = new StringBuilder();

            // Traverse res
            for (int j = 0; j < res.length(); j++) {
                int count = 1; // Counter

                // Increment count till res[j] == res[j+1] and j+1 doesn't exceeds the boundary
                while (j + 1 < res.length() && res.charAt(j) == res.charAt(j + 1)) {
                    count++;
                    j++;
                }

                // Append the count and num
                temp.append(count);
                temp.append(res.charAt(j));
            }
            // Update res
            res = temp.toString();

        }

        return res;
    }
}