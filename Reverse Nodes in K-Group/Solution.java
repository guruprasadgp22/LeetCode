/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while(count < k) {
            if(temp == null) {
                return head;
            }
            temp = temp.next;
            count++;
        }

        ListNode prevNode = reverseKGroup(temp, k);

        count = 0 ;
        temp = head;
        while(count < k) {
            ListNode next = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = next;
            count++;
        }

        return prevNode;
    }
}
