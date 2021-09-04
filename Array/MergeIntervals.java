// Given an array of intervals where intervals[i] = [starti, endi], merge all
// overlapping intervals, and return an array of the non-overlapping intervals
// that cover all the intervals in the input.

// Leetcode - https://leetcode.com/problems/merge-intervals/

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.

class Solution {

    public class SortIntervals implements Comparator<Interval> {
        public int compare(Interval x, Interval y) {
            return x.start - y.start;
        }
    }

    public class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> temp = new LinkedList<>();

        ArrayList<Interval> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new Interval(interval[0], interval[1]));
        }

        // Sort based on the starting time
        Collections.sort(list, new SortIntervals());

        Interval cur = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            Interval next = list.get(i);
            // If the starting of the next interval is within the current interval range
            if (next.start >= cur.start && next.start <= cur.end) {
                // And ending of the next interval is greater than the ending of current
                // interval.
                if (next.end > cur.end) {
                    // Extend the ending of the current interval
                    cur.end = next.end;
                }

                continue;
            }

            // If the starting of the next interval is not within the current interval
            // range.
            // Add the current interval to the res and set the next interval as the current
            // interval
            temp.add(new Interval(cur.start, cur.end));
            cur.start = next.start;
            cur.end = next.end;
        }

        temp.add(new Interval(cur.start, cur.end));

        int[][] res = new int[temp.size()][2];
        int index = 0;
        for (Interval interval : temp) {
            res[index][0] = interval.start;
            res[index][1] = interval.end;
            index++;
        }

        return res;
    }
}