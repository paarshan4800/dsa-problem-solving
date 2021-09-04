// Given a 5x6 snakes and ladders board, find the minimum number of dice throws
// required to reach the destination or last cell (30th cell) from the source
// (1st cell).

// You are given an integer N denoting the total number of snakes and ladders
// and an array arr[] of 2*N size where 2*i and (2*i + 1)th values denote the
// starting and ending point respectively of ith snake or ladder. The board
// looks like the following.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/snake-and-ladder-problem4816/1#

// Input:
// N = 8
// arr[] = {3, 22, 5, 8, 11, 26, 20, 29,
// 17, 4, 19, 7, 27, 1, 21, 9}
// Output: 3
// Explanation:
// The given board is the board shown
// in the figure. For the above board
// output will be 3.
// a) For 1st throw get a 2.
// b) For 2nd throw get a 6.
// c) For 3rd throw get a 2.

class Solution {

    static int minThrow(int N, int arr[]) {

        class QueueEle {
            int cell;
            int numThrow;

            QueueEle(int cell, int numThrow) {
                this.cell = cell;
                this.numThrow = numThrow;
            }
        }

        boolean[] visited = new boolean[31];
        HashMap<Integer, Integer> hash = new HashMap<>();

        // Store the snakes and ladders info in hash map
        for (int i = 0; i < 2 * N - 1; i += 2) {
            int x = arr[i];
            int y = arr[i + 1];
            hash.put(x, y);
        }

        Queue<QueueEle> queue = new LinkedList<>();
        queue.add(new QueueEle(1, 0));

        while (!queue.isEmpty()) {
            QueueEle cur = queue.poll();

            // If destination
            if (cur.cell == 30) {
                return cur.numThrow;
            }

            // Since a die can give a maximum of 6, from a vertex we can go to six cells.
            for (int jump = 1; jump <= 6; jump++) {
                int nextCell = cur.cell + jump;
                if (nextCell > 30)
                    break;

                if (!visited[nextCell]) {
                    visited[nextCell] = true;

                    // If the cell has a ladder or a snake, user will go where the ladder or snake
                    // leads them to
                    if (hash.containsKey(nextCell)) {
                        queue.add(new QueueEle(hash.get(nextCell), cur.numThrow + 1));
                    }
                    // Else they'll go to the next cell
                    else {
                        queue.add(new QueueEle(nextCell, cur.numThrow + 1));
                    }
                }
            }
        }

        return -1;
    }
}