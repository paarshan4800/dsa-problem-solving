class TrieNode {
    char letter;
    boolean isWordEnd = false;
    TrieNode[] trieNodes = new TrieNode[26];

    TrieNode() {

    }

    TrieNode(char letter) {
        this.letter = letter;
    }
}

public class Trie {
    TrieNode root = new TrieNode();

    public void insertWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int key = word.charAt(i) - 'a';
            if (cur.trieNodes[key] == null) {
                cur.trieNodes[key] = new TrieNode(word.charAt(i));
            }

            cur = cur.trieNodes[key];
        }

        cur.isWordEnd = true;
    }

    public boolean searchWord(String word) {

        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int key = word.charAt(i) - 'a';
            if (cur.trieNodes[key] == null) {
                return false;
            }

            cur = cur.trieNodes[key];
        }

        return cur.isWordEnd;

    }

    public boolean deleteWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int key = word.charAt(i) - 'a';
            if (cur.trieNodes[key] == null) {
                return false;
            }

            cur = cur.trieNodes[key];
        }

        if (!cur.isWordEnd)
            return false;

        cur.isWordEnd = false;
        return true;
    }
}