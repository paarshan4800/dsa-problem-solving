// Given a string S with repeated characters. The task is to rearrange
// characters in a string such that no two adjacent characters are the same.
// Note: The string has only lowercase English alphabets and it can have
// multiple solutions. Return any one of them.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/rearrange-characters4649/1/

// Input :
// str = "geeksforgeeks"
// Output: 1
// Explanation:
// All the repeated characters of the
// given string can be rearranged so
// that no adjacent characters in the
// string is equal. Any correct
// rearrangement will show a output of 1.

class Solution {
    static class HeapNode {
        char letter;
        int count;

        HeapNode(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }

        public String toString() {
            return String.format("(%c,%d)", letter, count);
        }
    }

    static class PriorityQueueComparator implements Comparator<HeapNode> {
        public int compare(HeapNode x, HeapNode y) {
            return y.count - x.count;
        }
    }

    public static String rearrangeCharacters(String str) {
        HashMap<Character, Integer> hash = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);

            if (hash.containsKey(key))
                hash.put(key, hash.get(key) + 1);
            else
                hash.put(key, 1);
        }

        PriorityQueue<HeapNode> maxHeap = new PriorityQueue<>(new PriorityQueueComparator());

        for (Map.Entry<Character, Integer> entry : hash.entrySet()) {
            maxHeap.add(new HeapNode(entry.getKey(), entry.getValue()));
        }

        StringBuilder res = new StringBuilder();

        while (maxHeap.size() > 1) {
            HeapNode pop1 = maxHeap.poll();
            res.append(pop1.letter);
            pop1.count--;

            HeapNode pop2 = maxHeap.poll();
            res.append(pop2.letter);
            pop2.count--;

            if (pop1.count > 0)
                maxHeap.add(pop1);

            if (pop2.count > 0)
                maxHeap.add(pop2);
        }

        if (maxHeap.isEmpty())
            return res.toString();

        HeapNode temp = maxHeap.poll();

        if (temp.count > 1)
            return "-1";

        res.append(temp.letter);

        return res.toString();
    }
}