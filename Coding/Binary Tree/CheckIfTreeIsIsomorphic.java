// Given two Binary Trees. Check whether they are Isomorphic or not.

// Note:
// Two trees are called isomorphic if one can be obtained from another by a
// series of flips, i.e. by swapping left and right children of several nodes.
// Any number of nodes at any level can have their children swapped. Two empty
// trees are isomorphic.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1/

class Solution {
    // Return True if the given trees are isomotphic. Else return False.
    boolean isIsomorphic(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if (root1.data != root2.data)
            return false;

        // Recur normally
        boolean normal = isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right);

        // Recur by flipping nodes of both trees
        boolean flip = isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);

        return normal || flip;
    }

}