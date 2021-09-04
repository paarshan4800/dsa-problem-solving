
// Time Complexity - O(n^2)
// Space Complexity - O(1)
public class BubbleSort {

    public static void sort(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                // Repeatedly swap adjacent elements if they are in wrong order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
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

        sort(arr);

        display(arr);

    }
}