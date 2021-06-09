// Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
// (i) a next pointer to the next node,
// (ii) a bottom pointer to a linked list where this node is head.
// Each of the sub-linked-list is in sorted order.
// Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
// Note: The flattened list will be printed using the bottom pointer instead of next pointer

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1#

// Input:
// 5 -> 10 -> 19 -> 28
// |     |     |     | 
// 7     20    22   35
// |           |     | 
// 8          50    40
// |                 | 
// 30               45
// Output:  5-> 7-> 8- > 10 -> 19-> 20->
// 22-> 28-> 30-> 35-> 40-> 45-> 50.

// Input:
// 5 -> 10 -> 19 -> 28
// |          |                
// 7          22   
// |          |                 
// 8          50 
// |                           
// 30              
// Output: 5->7->8->10->19->20->22->30->50

/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */

// Time Complexity - O(m*n)
class GfG {

    // Merging part of merge sort (Recursive)
    Node merge(Node x, Node y) {

        if (x == null) {
            return y;
        }

        if (y == null) {
            return x;
        }

        Node res = null;

        if (x.data < y.data) {
            res = x;
            res.bottom = merge(x.bottom, y);
        } else {
            res = y;
            res.bottom = merge(x, y.bottom);
        }

        return res;
    }

    Node flatten(Node root) {
        // Base condition
        if (root == null || root.next == null) {
            return root;
        }

        // Recur till end of given list and merge.
        root = merge(root, flatten(root.next));
        return root;

    }
}