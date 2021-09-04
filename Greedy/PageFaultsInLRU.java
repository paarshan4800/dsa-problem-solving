// In operating systems that use paging for memory management, page replacement algorithm is needed to decide which page needs to be replaced when the new page comes in. Whenever a new page is referred and is not present in memory, the page fault occurs and Operating System replaces one of the existing pages with a newly needed page.

// Given a sequence of pages in an array pages[] of length N and memory capacity C, find the number of page faults using Least Recently Used (LRU) Algorithm. 

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/page-faults-in-lru5603/1

// Input: N = 9, C = 4
// pages = {5, 0, 1, 3, 2, 4, 1, 0, 5}
// Output: 8
// Explaination: memory allocated with 4 pages 5, 0, 1, 
// 3: page fault = 4
// page number 2 is required, replaces LRU 5: 
// page fault = 4+1 = 5
// page number 4 is required, replaces LRU 0: 
// page fault = 5 + 1 = 6
// page number 1 is required which is already present: 
// page fault = 6 + 0 = 6
// page number 0 is required which replaces LRU 1: 
// page fault = 6 + 1 = 7
// page number 5 is required which replaces LRU 3: 
// page fault = 7 + 1  =8.

class Solution {
    static int pageFaults(int N, int C, int pages[]) {
        LinkedList<Integer> lru = new LinkedList<>();
        int res = 0;

        for (int page : pages) {

            // If not in LRU, page fault
            if (!lru.contains(page)) {
                // Add to LRU cache and increment res
                lru.addLast(page);
                res++;
            }
            // If page hit, remove and add to last
            else {
                lru.remove(new Integer(page));
                lru.addLast(page);
            }

            // Maintain LRU size
            if (lru.size() > C) {
                lru.removeFirst();
            }

        }

        return res;
    }
}