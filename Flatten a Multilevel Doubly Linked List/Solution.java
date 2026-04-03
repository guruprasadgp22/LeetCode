/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr = head;

        while(curr != null) {
            if(curr.child != null) {
                Node next = curr.next;
                Node temp = flatten(curr.child);
                
                curr.next = temp;
                temp.prev = curr;

                curr.child = null;

                while(curr.next != null) {
                    curr = curr.next;
                }

                if(next != null) {
                    curr.next = next;
                    next.prev = curr;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}
