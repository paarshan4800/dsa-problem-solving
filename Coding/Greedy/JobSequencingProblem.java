// Given a set of N jobs where each jobi has a deadline and profit associated
// with it. Each job takes 1 unit of time to complete and only one job can be
// scheduled at a time. We earn the profit if and only if the job is completed
// by its deadline. The task is to find the number of jobs done and the maximum
// profit.

// Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated
// with that Job.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

// Input:
// N = 4
// Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
// Output:
// 2 60
// Explanation:
// Job1 and Job3 can be done with
// maximum profit of 60 (20+40).

// Input:
// N = 5
// Jobs = {(1,2,100),(2,1,19),(3,2,27),
// (4,1,25),(5,1,15)}
// Output:
// 2 127
// Explanation:
// 2 jobs can be done with
// maximum profit of 127 (100+27).

class Solution {

    class MyComparator implements Comparator<Job> {
        public int compare(Job x, Job y) {
            return y.profit - x.profit;
        }
    }

    int getMaxDeadline(Job arr[]) {
        int max = -1;

        for (Job job : arr)
            max = Math.max(max, job.deadline);

        return max;
    }

    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        int[] res = new int[2];
        boolean[] slots = new boolean[getMaxDeadline(arr)];
        int numJobs = 0, maxProfit = 0;

        // Sort by profit
        Arrays.sort(arr, new MyComparator());

        for (Job job : arr) {
            for (int slot = job.deadline - 1; slot >= 0; slot--) {
                // If slot not available, check previous slots
                if (!slots[slot]) {
                    slots[slot] = true;
                    numJobs++;
                    maxProfit += job.profit;
                    break;
                }

            }
        }

        res[0] = numJobs;
        res[1] = maxProfit;
        return res;
    }
}