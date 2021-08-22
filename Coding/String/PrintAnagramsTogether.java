// Given an array of strings, return all groups of strings that are anagrams.
// The groups must be created in order of their appearance in the original
// array. Look at the sample case for clarification.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/print-anagrams-together/1/

// N = 5
// words[] = {act,god,cat,dog,tac}
// Output:
// god dog
// act cat tac
// Explanation:
// There are 2 groups of
// anagrams "god", "dog" make group 1.
// "act", "cat", "tac" make group 2.

// Input:
// N = 3
// words[] = {no,on,is}
// Output:
// no on
// is
// Explanation:
// There are 2 groups of
// anagrams "no", "on" make group 1.
// "is" makes group 2.

class Solution {

    public String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public List<List<String>> Anagrams(String[] string_list) {
        List<List<String>> res = new ArrayList<>();

        // Linked hashmap maintains the insertion order
        LinkedHashMap<String, ArrayList<String>> hash = new LinkedHashMap<>();

        for (String str : string_list) {
            // Sorted string will be the key of the hashmap
            String key = sortString(str);

            if (hash.containsKey(key)) {
                hash.get(key).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);

                hash.put(key, list);
            }
        }

        for (Map.Entry<String, ArrayList<String>> entry : hash.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}
