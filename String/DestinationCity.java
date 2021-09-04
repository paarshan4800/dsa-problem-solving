// You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. 
// Return the destination city, that is, the city without any path outgoing to another city.

// It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.

// Leetcode - https://leetcode.com/problems/destination-city/

// Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
// Output: "Sao Paulo" 
// Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. 
// Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".

// Input: paths = [["B","C"],["D","B"],["C","A"]]
// Output: "A"
// Explanation: All possible trips are: 
// "D" -> "B" -> "C" -> "A". 
// "B" -> "C" -> "A". 
// "C" -> "A". 
// "A". 
// Clearly the destination city is "A".

// Using Set
class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> hash = new HashSet<>();

        // Store all the starting destination of all paths to the hash set
        for (List<String> path : paths) {
            if (!hash.contains(path.get(0))) {
                hash.add(path.get(0));
            }
        }

        // Answer is the destination which is not in the hash set (As they have given
        // that the destination city is, the city without any path outgoing to another
        // city.)
        for (List<String> path : paths) {
            if (!hash.contains(path.get(1))) {
                return path.get(1);
            }
        }

        return null;
    }
}