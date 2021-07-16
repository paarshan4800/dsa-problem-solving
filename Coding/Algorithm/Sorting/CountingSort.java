
// Time Complexity - O(n+k)
// Space Complexity - O(n+k)
public class CountingSort {

    public static int[] sort(int[] arr) {
        int[] res = new int[arr.length];

        // Find the max element i.e 0 to ?
        int maxEle = -1;
        for (int num : arr) {
            maxEle = Math.max(maxEle, num);
        }

        // Maintain the count of all elements in the count array which is of size
        // maxEle+1
        int[] count = new int[maxEle + 1];
        for (int num : arr) {
            count[num]++;
        }

        // Update count array such that each element holds its cumulative sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Traverse array. The current element should be placed at
        // count[currentElement]-1 position in the result array. Decrement
        // count[currentElement] by one
        for (int num : arr) {
            res[count[num] - 1] = num;
            count[num]--;
        }

        return res;
    }

    public static void display(int[] arr) {
        for (int num : arr) {
            System.out.print(num + "; ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int[] arr = { 1, 0, 3, 1, 3, 1 };
        int[] arr = { 1, 4, 1, 2, 7, 5, 2 };

        int[] res = sort(arr);

        display(res);

    }
}