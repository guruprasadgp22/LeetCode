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
    public ListNode deleteMiddle(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        int mid = count/2;
        if(mid == 0) {
            return null;
        }
        curr = head;
        count = 0;
        ListNode prev = head;

        while(count < mid) {
            prev = curr;
            curr = curr.next;
            count++;
        }

        if(curr.next == null) {
            prev.next = null;
        } else {
            prev.next = curr.next;
        }

        return head;

    }
}
