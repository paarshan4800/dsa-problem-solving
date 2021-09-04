// You are given a linked list of N nodes. Remove the loop from the linked list,
// if present.
// Note: X is the position of the node to which the last node is connected to.
// If it is 0, then there is no loop.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1#

// Input:
// N = 3
// value[] = {1,3,4}
// X = 2
// Output: 1

// Input:
// N = 4
// value[] = {1,8,3,4}
// X = 0
// Output: 1
class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        HashSet<Node> hash = new HashSet<>();

        Node temp = head, prev = null;
        while (temp != null) {
            // If already in hash, it is a cycle. Cut off the link
            if (hash.contains(temp)) {
                prev.next = null;
                return;
            }

            // Else add to hash
            prev = temp;
            hash.add(temp);
            temp = temp.next;
        }
    }
}