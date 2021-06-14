// Given an array arr containing N words consisting of lowercase characters.
// Your task is to find the most frequent word in the array. If multiple words
// have same frequency, then print the word whose first occurence occurs last in
// the array as compared to the other strings with same frequency.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/most-frequent-word-in-an-array-of-strings3528/1#

// Input:
// N = 3
// arr[] = {geeks,for,geeks}
// Output: geeks

// Input:
// N = 2
// arr[] = {hello,world}
// Output: world
// Explanation: "hello" and "world" both
// have 1 frequency. We print world as
// its first occurence comes last in the
// input array.

// Hashing
class Solution {
    // Function to find most frequent word in an array of strings.
    public String mostFrequentWord(String arr[], int n) {
        // Stores the frequency
        HashMap<String, Integer> freqHash = new HashMap<>();
        // Stores the first occuring index
        HashMap<String, Integer> indexHash = new HashMap<>();
        int maxFreq = 1; // maximum frequency

        for (int i = 0; i < arr.length; i++) {
            if (!freqHash.containsKey(arr[i])) {
                freqHash.put(arr[i], 1); // update freq
                indexHash.put(arr[i], i); // add the first occurence into index hash
            } else {
                freqHash.put(arr[i], freqHash.get(arr[i]) + 1);
                maxFreq = Math.max(maxFreq, freqHash.get(arr[i])); // update max freq
            }
        }

        int resIndex = 0;

        for (Map.Entry<String, Integer> entry : freqHash.entrySet()) {
            // For entries in freqHash with value of maxFreq
            if (entry.getValue() == maxFreq) {
                // set resIndex (if multiple words with same freq the answer is the last word
                // with that freq. so we do max)
                resIndex = Math.max(resIndex, indexHash.get(entry.getKey()));
            }
        }

        return arr[resIndex];
    }

}
