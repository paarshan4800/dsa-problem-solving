// There are a total of numCourses courses you have to take, labeled from 0 to
// numCourses - 1. You are given an array prerequisites where prerequisites[i] =
// [ai, bi] indicates that you must take course bi first if you want to take
// course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to
// first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

// Leetcode - https://leetcode.com/problems/course-schedule/

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take.
// To take course 1 you should have finished course 0, and to take course 0 you
// should also have finished course 1. So it is impossible.

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take.
// To take course 1 you should have finished course 0, and to take course 0 you
// should also have finished course 1. So it is impossible.

// Cycle Detection in directed graph problem
// Can find using BFS or DFS

// Kahn's Algorithm - Cycle Detection
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<Integer>());

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i);

                indegree[v]--;

                if (indegree[v] == 0)
                    queue.add(v);
            }

            count++;
        }

        return count != numCourses ? false : true;

    }
}