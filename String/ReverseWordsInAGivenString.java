// Given a String S, reverse the string without reversing its individual words.
// Words are separated by dots.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1#l̥

// Input:
// S = i.like.this.program.very.much
// Output: much.very.program.this.like.i

// Input:
// S = pqr.mno
// Output: mno.pqr
class Solution {
    // Function to reverse words in a given string.
    // Helper method to reverse given char array
    char[] reverse(int i, int j, char[] str) {
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        return str;
    }

    String reverseWords(String S) {

        // Reverse each word. Then reverse the whole string
        char[] str = S.toCharArray();

        int start = 0, end = 0;

        while (end < str.length) {
            if (str[end] == '.') {
                str = reverse(start, end - 1, str);
                start = end + 1;
                end = start;
            } else {
                end++;
            }
        }
        str = reverse(start, end - 1, str);

        reverse(0, str.length - 1, str);

        return String.valueOf(str);
    }
}

// Split words
class Solution {
    String reverseWords(String S) {
        String[] words = S.split("\\.");
        StringBuilder res = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            res.append(words[i]);
            if (i != 0)
                res.append(".");
        }

        return res.toString();
    }
}