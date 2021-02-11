/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    
    public Node connect(Node root) {
        /* For a degenerate case of 0 or 1 node, we do nothing.
         * For the base case, connect root.left.next to root.right and we are done.
         * Now suppose we are at some level L that is already next-connected.
         *     Then we can next-connect level L + 1 by connecting each .left to .right
         *     and each .right to .next.left until .next is null.
         * We reach the end when we 
         * Since the root is already next-connected, we can start the iteration right away.
         */
        if (root == null || root.left == null) {
            return root;
        }
        Node currentNode = root;
        while (currentNode.left != null) {
            connectLevel(currentNode);
            currentNode = currentNode.left;
        }
        return root;
    }
    
    private void connectLevel(Node baseNode) {
        Node currentNode = baseNode;
        while (currentNode != null) {
            currentNode.left.next = currentNode.right;
            if (currentNode.next != null) {
                currentNode.right.next = currentNode.next.left;
            }
            currentNode = currentNode.next;
        }
    }
    
}