// Given a string s. Return all the words vertically in the same order in which
// they appear in s.
// Words are returned as a list of strings, complete with spaces when is
// necessary. (Trailing spaces are not allowed).
// Each word would be put on only one column and that in one column there will
// be only one word.

// Leetcode - https://leetcode.com/problems/print-words-vertically/

// Input: s = "HOW ARE YOU"
// Output: ["HAY","ORO","WEU"]

// Input: s = "TO BE OR NOT TO BE"
// Output: ["TBONTB","OEROOE"," T"]
// Explanation: Trailing spaces is not allowed.
// "TBONTB"
// "OEROOE"
// " T"

// Input: s = "CONTEST IS COMING"
// Output: ["CIC","OSO","N M","T I","E N","S G","T"]

// Time Complexity - O(number of words * maxLength(word))

class Solution {
    public List<String> printVertically(String s) {
        String[] words = s.split(" "); // Split the string by " "

        // Find the word with max length
        int maxIndex = 0;
        for (String word : words) {
            maxIndex = Math.max(maxIndex, word.length());
        }

        List<String> res = new ArrayList<>();

        // Do reverse matrix traversal (instead of [row][col], do [col][row])

        // Input: s = "HOW ARE YOU"
        // HOW
        // ARE
        // YOU

        // Traverse till the maxIndex
        for (int i = 0; i < maxIndex; i++) { // col
            StringBuilder temp = new StringBuilder();
            // Start from end of each word (will be easier to process spaces)
            for (int j = words.length - 1; j >= 0; j--) { // row
                // If the word has been traversed completely
                if (i >= words[j].length()) {
                    // If some other letter in the same col of diff row is there, add " "
                    if (temp.length() != 0)
                        temp.append(" ");
                    else // If no other letter in the same col of diff row is there, skip
                        continue;
                }
                // If the word hasn't been traversed completely
                else {
                    temp.append(words[j].charAt(i)); // append the char to temp
                }
            }
            // Reverse temp and to result list
            res.add(temp.reverse().toString());
        }

        return res;
    }
}