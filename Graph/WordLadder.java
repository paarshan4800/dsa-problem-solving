// A transformation sequence from word beginWord to word endWord using a
// dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
// such that:

// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to
// be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, return the
// number of words in the shortest transformation sequence from beginWord to
// endWord, or 0 if no such sequence exists.

// Leetcode - https://leetcode.com/problems/word-ladder/

// YT - https://www.youtube.com/watch?v=ZVJ3asMoZ18

// Input: beginWord = "hit", endWord = "cog", wordList =
// ["hot","dot","dog","lot","log","cog"]
// Output: 5
// Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot"
// -> "dog" -> cog", which is 5 words long.

// Input: beginWord = "hit", endWord = "cog", wordList =
// ["hot","dot","dog","lot","log"]
// Output: 0
// Explanation: The endWord "cog" is not in wordList, therefore there is no
// valid transformation sequence.

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>();

        // Check whether the end word is present in the given wordlist
        boolean isEndWordPresent = false;

        for (String word : wordList) {
            if (word.equals(endWord))
                isEndWordPresent = true;

            set.add(word);
        }

        // If not present, return 0
        if (!isEndWordPresent)
            return 0;

        // Begin BFS
        Queue<String> queue = new LinkedList<>();
        int depth = 0;
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            // Increment depth as each level is passed
            depth++;
            int levelSize = queue.size();

            while (levelSize > 0) {

                String curWord = queue.poll();

                // For each letter in the current word
                for (int i = 0; i < curWord.length(); i++) {

                    StringBuilder temp = new StringBuilder(curWord);

                    // Try all 26 possible letter combinations
                    for (char c = 'a'; c <= 'z'; c++) {

                        temp.setCharAt(i, c);
                        String modified = temp.toString();

                        // If equal to current word, skip
                        if (curWord.equals(modified))
                            continue;

                        // If equal to end word, return depth + 1 (answer)
                        if (endWord.equals(modified))
                            return depth + 1;

                        // If in the set, add to queue and remove from the set (marking it as processed)
                        if (set.contains(modified)) {
                            queue.add(modified);
                            set.remove(modified);
                        }
                    }
                }

                levelSize--;
            }

        }

        return 0;

    }
}