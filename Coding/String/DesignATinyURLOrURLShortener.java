// Design a system that takes big URLs like
// “http://www.geeksforgeeks.org/count-sum-of-digits-in-numbers-from-1-to-n/”
// and converts them into a short URL. It is given that URLs are stored in
// database and every URL has an associated integer id. So your program should
// take an integer id and generate a URL.

// A URL character can be one of the following

// A lower case alphabet [‘a’ to ‘z’], total 26 characters
// An upper case alphabet [‘A’ to ‘Z’], total 26 characters
// A digit [‘0′ to ‘9’], total 10 characters
// There are total 26 + 26 + 10 = 62 possible characters.

// So the task is to convert an integer (database id) to a base 62 number where
// digits of 62 base are "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMN
// OPQRSTUVWXYZ0123456789"

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/design-a-tiny-url-or-url-shortener2031/1/

// Input:
// N = 12345
// Output:
// dnh
// 12345
// Explanation: "dnh" is the url for id 12345

// Input:
// N = 30540
// Output:
// h6K
// 30540
// Explanation: "h6K" is the url for id 30540

class Solution {
    String idToShortURL(long n) {
        StringBuilder res = new StringBuilder();
        String mapping = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        while (n > 0) {
            res.append(mapping.charAt((int) (n % 62))); // Using remainder as index
            n = n / 62; // Update n
        }

        return res.reverse().toString();

    }

    // C++ code for tinyURL to ID
    int shortURLtoID(string shortURL)
    {
        long int id = 0;
     
        // A simple base conversion logic
        for (int i=0; i < shortURL.length(); i++)
        {
            if ('a' <= shortURL[i] && shortURL[i] <= 'z')
              id = id*62 + shortURL[i] - 'a';
            if ('A' <= shortURL[i] && shortURL[i] <= 'Z')
              id = id*62 + shortURL[i] - 'A' + 26;
            if ('0' <= shortURL[i] && shortURL[i] <= '9')
              id = id*62 + shortURL[i] - '0' + 52;
        }
        return id;
    }

}