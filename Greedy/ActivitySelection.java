// Given N activities with their start and finish day given in array start[ ]
// and end[ ]. Select the maximum number of activities that can be performed by
// a single person, assuming that a person can only work on a single activity at
// a given day.
// Note : Duration of the activity includes both starting and ending day.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/activity-selection-1587115620/1#

// Input:
// N = 4
// start[] = {1, 3, 2, 5}
// end[] = {2, 4, 3, 6}
// Output:
// 3
// Explanation:
// A person can perform activities 1, 2
// and 4.

// To do maximum number of activities, do the activities with less finish time
// first
class Solution {
    // Function to find the maximum number of activities that can
    // be performed by a single person.

    static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class SortByFinish implements Comparator<Activity> {
        public int compare(Activity x, Activity y) {
            return x.end - y.end;
        }
    }

    public static int activitySelection(int start[], int end[], int n) {
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(start[i], end[i]);
        }

        Arrays.sort(activities, new SortByFinish());

        int res = 1;
        int i = 0;

        for (int j = 1; j < n; j++) {
            // The start time of the next activity should be greater than the end time of
            // the previous activity
            if (activities[j].start > activities[i].end) {
                res++;
                i = j;
            }
        }

        return res;
    }
}