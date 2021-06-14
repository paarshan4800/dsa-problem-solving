class Solution {
    // Function to insert heap.
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void insertHeap(int x) {
        // add your code here
        if (maxHeap.isEmpty()) {
            maxHeap.add(x);
            getMedian();
            return;
        }

        if (x > maxHeap.peek()) {
            minHeap.add(x);
        } else {
            maxHeap.add(x);
        }

        balanceHeaps();
        getMedian();
    }

    // Function to balance heaps.
    public static void balanceHeaps() {
        // add your code here
        if (maxHeap.size() - minHeap.size() == 2) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() == 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    // Function to return Median.
    public static double getMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
        // add your code here
    }

}