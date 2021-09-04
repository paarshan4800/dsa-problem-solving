public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insertWord("abc");
        System.out.println(trie.searchWord("abc"));
        System.out.println(trie.searchWord("abcd"));
        System.out.println(trie.deleteWord("abcd"));
        System.out.println(trie.deleteWord("abc"));
        System.out.println(trie.searchWord("abc"));
    }
}
