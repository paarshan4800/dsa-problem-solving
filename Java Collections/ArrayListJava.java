import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListJava {
    public static void main(String[] args) {

        // ArrayList implements List interface
        List<Integer> list = new ArrayList<>();

        // Add values
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Access item
        System.out.println(list.get(1));

        // Change item
        list.set(1, 20);

        // Remove an item
        // list.remove(2);

        // Clear list
        // list.clear();

        // Size of list
        System.out.println(list.size());

        // Loop through List (using index)
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " - ");
        }

        // Loop through List (using for-each)
        for (int val : list) {
            System.out.print(val + " - ");
        }

        // Sort list
        Collections.sort(list); // Time Complexity O(nlogn)
        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder()); // Time Complexity O(nlogn)
        System.out.println(list);
    }
}