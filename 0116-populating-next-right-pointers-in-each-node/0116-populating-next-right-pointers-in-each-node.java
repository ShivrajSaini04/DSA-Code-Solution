class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
       Node startLev = root;
       while(startLev.left != null) {
          Node curr = startLev;
        while(curr != null){
            
            curr.left.next = curr.right;

            if (curr.next != null)  curr.right.next = curr.next.left;

            curr = curr.next;
        }
        startLev = startLev.left;
       }
        return root;
    }
}