// Suppose there is a circle. There are N petrol pumps on that circle. You will
// be given two sets of data.
// 1. The amount of petrol that every petrol pump has.
// 2. Distance from that petrol pump to the next petrol pump.
// Find a starting point where the truck can start to get through the complete
// circle without exhausting its petrol in between.
// Note : Assume for 1 litre petrol, the truck can go 1 unit of distance.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/circular-tour-1587115620/1#

// Input:
// N = 4
// Petrol = 4 6 7 4
// Distance = 6 5 3 5
// Output: 1

// Deque like approach
// Time Complexity - O(n)
// Space Complexity - O(1)
class Solution {
    // Function to find starting point where the truck can start to get through
    // the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[]) {
        int start = 0, end = 1, n = petrol.length;
        int diff = petrol[0] - distance[0];

        while (start != end || diff < 0) {
            while (start != end && diff < 0) {
                diff -= (petrol[start] - distance[start]);
                start = (start + 1) % n;

                if (start == 0) {
                    return -1;
                }
            }

            diff += (petrol[end] - distance[end]);
            end = (end + 1) % n;
        }

        return start;
    }
}

class Solution {
    // Function to find starting point where the truck can start to get through
    // the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[]) {
        int deficit = 0, surplus = 0, start = 0;

        for (int i = 0; i < petrol.length; i++) {
            surplus = surplus + (petrol[i] - distance[i]);

            // If surplus is negative, then current start position is invalid. So update
            // deficit and reset surplus to 0. Update start to i+1
            if (surplus < 0) {
                deficit += surplus;
                surplus = 0;
                start = i + 1;
            }
        }

        // If deficit is more than surplus, circular tour is not possible
        return (surplus + deficit >= 0) ? start : -1;
    }
}