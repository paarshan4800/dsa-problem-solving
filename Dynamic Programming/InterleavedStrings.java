// Given strings A, B, and C, find whether C is formed by an interleaving of A
// and B.

// An interleaving of two strings S and T is a configuration where they are
// divided into non-empty substrings such that:

// S = S1 + S2 + ... + SN
// T = T1 + T2 + ... + TM
// |N - M| <= 1
// The interleaving is S1 + T1+ S2 + T2 + S3 + T3 + ... or T1 + S1+ T2 + S2 + T3
// + S3 ...
// Note: a + b is the concatenation of strings a and b.

// Return true if C is formed by an interleaving of A and B, else return false.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/interleaved-strings/1/

// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
// Output: true

// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
// Output: false

// Without memoisation - Time Complexity O(2^(m+n))
// With memoisation - Time Complexity O(m*n)
class Solution {

    public boolean isInterLeave(String a, String b, String c, int aLen, int bLen, int cLen, int i, int j, int k,
            HashMap<String, Boolean> hash) {

        // If the whole c string is traversed, then the interleaved string has been
        // formed
        if (k == cLen)
            return true;

        String key = i + ";" + j + ";" + k;

        // Check for subproblem
        if (hash.containsKey(key))
            return hash.get(key);

        boolean aMatchC = false, bMatchC = false;

        // If string a not traversed completely and a[i] and c[k] matches
        if (i != aLen && a.charAt(i) == c.charAt(k))
            aMatchC = isInterLeave(a, b, c, aLen, bLen, cLen, i + 1, j, k + 1, hash);

        // If string b not traversed completely and b[j] and c[k] matches
        if (j != bLen && b.charAt(j) == c.charAt(k))
            bMatchC = isInterLeave(a, b, c, aLen, bLen, cLen, i, j + 1, k + 1, hash);

        hash.put(key, aMatchC || bMatchC);
        return hash.get(key);

    }

    public boolean isInterLeave(String a, String b, String c) {
        int aLen = a.length();
        int bLen = b.length();
        int cLen = c.length();

        // Required condition
        if (aLen + bLen != cLen)
            return false;

        HashMap<String, Boolean> hash = new HashMap<>();

        return isInterLeave(a, b, c, aLen, bLen, cLen, 0, 0, 0, hash);
    }
}
