// Given a linked list, the task is to complete the function maxPalindrome()
// which returns an integer denoting the length of the longest palindrome list
// that exist in the given linked list.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/length-of-longest-palindrome-in-linked-list/1#

// Input:
// 2
// 7
// 2 3 7 3 2 12 24
// 5
// 12 4 4 3 14

// Output:
// 5
// 2

// Time Complexity - O(n^2)
class GfG {

    // Compare the elements of left and right lists
    static int count(Node a, Node b) {
        int count = 0;

        for (; a != null && b != null; a = a.next, b = b.next) {

            if (a.data == b.data) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static int maxPalindrome(Node head) {
        int result = 0;
        Node prev = null, curr = head, next;

        // Reverse the list
        while (curr != null) {

            next = curr.next;
            curr.next = prev;

            // After the above two steps, left part would be reversed.
            result = Math.max(result, 2 * count(prev, next) + 1); // If the length of the list is odd, +1 adds for the
                                                                  // middle element

            result = Math.max(result, 2 * count(curr, next)); // If the length of the list is even

            prev = curr;
            curr = next;
        }
        return result;
    }
}