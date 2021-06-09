// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

// Leetcode - https://leetcode.com/problems/merge-k-sorted-lists/

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]

class Solution {

    // Recursive merging portion of merge sort
    public ListNode merge(ListNode x, ListNode y) {
        if (x == null) {
            return y;
        }

        if (y == null) {
            return x;
        }

        ListNode res = null;

        if (x.val < y.val) {
            res = x;
            res.next = merge(x.next, y);
        } else {
            res = y;
            res.next = merge(x, y.next);
        }

        return res;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        // list[0] holds the final result
        for (int i = 1; i < lists.length; i++) {
            lists[0] = merge(lists[0], lists[i]);
        }

        return lists[0];
    }
}