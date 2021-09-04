
// You are given N number of books. Every ith book has Ai number of pages.
// You have to allocate books to M number of students. There can be many ways or
// permutations to do so. In each permutation, one of the M students will be
// allocated the maximum number of pages. Out of all these permutations, the
// task is to find that particular permutation in which the maximum number of
// pages allocated to a student is minimum of those in all the other
// permutations and print this minimum value.

// Each book will be allocated to exactly one student. Each student has to be
// allocated at least one book.

// Note: Return -1 if a valid assignment is not possible, and allotment should
// be in contiguous order (see the explanation for better understanding).

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1/

// YT - https://www.youtube.com/watch?v=gYmWHvRHu-s

// Input:
// N = 4
// A[] = {12,34,67,90}
// M = 2
// Output:
// 113
// Explanation:
// Allocation can be done in following ways:
// {12} and {34, 67, 90} Maximum Pages = 191
// {12, 34} and {67, 90} Maximum Pages = 157
// {12, 34, 67} and {90} Maximum Pages =113
// Therefore, the minimum of these cases is
// 113, which is selected as the output.

class Solution {
    // Function to find minimum number of pages.
    public static int getSum(int[] A) {
        int sum = 0;

        for (int num : A)
            sum += num;

        return sum;
    }

    public static int getMin(int[] A) {
        int min = Integer.MAX_VALUE;

        for (int num : A)
            min = Math.min(min, num);

        return min;
    }

    public static boolean isAllocatable(int[] books, int M, int threshold) {
        int studentNum = 1, pages = 0;

        for (int book : books) {
            // If any of the book's pages > threshold. Not possible to allocate. So return
            // false
            if (book > threshold)
                return false;

            // If current allocation's pages + current book's pages exceeds the threshold.
            // Start the allocation for the next student
            if (pages + book > threshold) {
                studentNum++;
                pages = book;
            }
            // Else add the current book's pages to pages
            else {
                pages += book;
            }
        }

        // If number of students greater than given M, return false
        if (studentNum > M)
            return false;

        return true;
    }

    public static int findPages(int[] A, int N, int M) {
        // low = min(A[]) --> suppose len(A) == M, all students will get a book each.
        // high = sum(A[]) --> suppose M == 1, single student will get all the books
        int low = getMin(A), high = getSum(A);
        int res = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If allocatable, then for all numbers >mid are also allocatable. Reduce search
            // space and update res
            if (isAllocatable(A, M, mid)) {
                res = Math.min(res, mid);
                high = mid - 1;
            }
            // If not allocatable, then also not allocatable for numbers less than mid. So
            // reduce search space
            else {
                low = mid + 1;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
};