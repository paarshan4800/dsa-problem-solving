// Given a string, Your task is to complete the function encode that returns the
// run length encoded string for the given string.
// eg if the input string is “wwwwaaadexxxxxx”, then the function should return
// “w4a3d1e1x6″.
// You are required to complete the function encode that takes only one argument
// the string which is to be encoded and returns the encoded string.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/run-length-encoding/1/

// Input:
// str = aaaabbbccc
// Output: a4b3c3
// Explanation: a repeated 4 times
// consecutively b 3 times, c also 3
// times.

// Input:
// str = abbbcdddd
// Output: a1b3c1d4

class GfG {
    String encode(String str) {
        int count = 1;
        StringBuilder res = new StringBuilder();
        int i;
        for (i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1))
                count++;

            else {
                res.append(str.charAt(i));
                res.append(count);
                count = 1;
            }
        }

        res.append(str.charAt(i));
        res.append(count);

        return res.toString();
    }

}