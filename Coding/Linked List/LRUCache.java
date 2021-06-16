
// The task is to design and implement methods of an LRU cache. The class has
// two methods get() and set() which are defined as follows.
// get(x) : Returns the value of the key x if the key exists in the cache
// otherwise returns -1.
// set(x,y) : inserts the value if the key x is not already present. If the
// cache reaches its capacity it should invalidate the least recently used item
// before inserting the new item.
// In the constructor of the class the size of the cache should be intitialized.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/lru-cache/1#

// Input:
// N = 2
// Q = 7
// Queries = SET 1 2 SET 2 3 SET 1 5
// SET 4 5 SET 6 7 GET 4 SET 1 2 GET 3
// Output: 5 -1
// Explanation: Cache Size = 2
// SET 1 2 SET 2 3 SET 1 5 SET 4 5
// SET 6 7 GET 4 SET 1 2 GET 1
// SET 1 2 : 1 -> 2
// SET 2 3 : 1 -> 2, 2 -> 3 (the most
// recently used one is kept at the
// rightmost position)
// SET 1 5 : 2 -> 3, 1 -> 5
// SET 4 5 : 1 -> 5, 4 -> 5 (Cache size
// is 2, hence we delete the least
// recently used key-value pair)
// SET 6 7 : 4 -> 5, 6 -> 7
// GET 4 : Prints 5
// (The cache now looks like
// 6 -> 7, 4->5)
// SET 1 2 : 4 -> 5, 1 -> 2
// (Cache size is 2, hence we delete
// the least recently used key-value
// pair)
// GET 1 : No key value pair having
// key = 3. Hence, -1 is printed.

class LRUCache {

    class Node {
        Node prev;
        int key;
        int data;
        Node next;

        Node(int key, int data) {
            this.key = key;
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Dummy head and tail node to avoid null checks
    Node cacheHead;
    Node cacheTail;
    int capacity;
    HashMap<Integer, Node> hash;

    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        capacity = cap;
        // Create two dummy nodes and attach them
        cacheHead = new Node(-1, -1);
        cacheTail = new Node(-1, -1);
        cacheHead.next = cacheTail;
        cacheTail.prev = cacheHead;
        hash = new HashMap<>();
    }

    public Node insertAtFront(int key, int data) {
        // System.out.printf("Inserting key %d and data %d in the front\n",key,data);
        Node newNode = new Node(key, data);

        newNode.next = cacheHead.next;
        newNode.next.prev = newNode;
        cacheHead.next = newNode;
        newNode.prev = cacheHead;

        return newNode;
    }

    public void remove(Node delNode) {
        // System.out.printf("Removing node with key %d\n",delNode.key);
        delNode.prev.next = delNode.next;
        delNode.next.prev = delNode.prev;
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        // System.out.printf("Getting key %d\n",key);
        if (!hash.containsKey(key)) {
            // System.out.printf("Key not in hash\n");
            return -1;
        }

        Node cacheKey = hash.get(key);

        remove(cacheKey);
        Node insKey = insertAtFront(key, cacheKey.data);
        hash.put(key, insKey);

        // System.out.printf("Returning value %d\n",insKey.data);
        return insKey.data;
    }

    // Function for storing key-value pair.
    public void set(int key, int value) {
        // System.out.printf("Setting key %d and value %d\n",key,value);
        if (hash.containsKey(key)) {
            // System.out.printf("Key is in hash\n");
            Node existingKey = hash.get(key);
            hash.remove(existingKey.key);
            remove(existingKey);
        }

        Node insKey = insertAtFront(key, value);
        hash.put(key, insKey);

        if (hash.size() > capacity) {
            // System.out.printf("Removing key %d from hash\n",cacheTail.prev.key);
            hash.remove(cacheTail.prev.key);
            remove(cacheTail.prev);
        }
    }
}