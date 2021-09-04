// Given a doubly linked list of n elements. The task is to reverse the doubly
// linked list.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1/

// Input:
// LinkedList: 75 <--> 122 <--> 59 <--> 196
// Output: 196 59 122 75

public static Node reverseDLL(Node  head)
{
    //Your code here
    Node cur = head, prev = null;
    
    while(cur != null) {
        prev = cur.prev;
        cur.prev = cur.next;
        cur.next = prev;
        cur = cur.prev;
    }
    
    // If zero or one element, no need to change the head
    if(prev != null) {
        head = prev.prev;
    }
    
    return head;
}
