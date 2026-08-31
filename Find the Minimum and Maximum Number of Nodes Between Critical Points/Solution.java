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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head.next;
        ListNode prev = head;
        int i = 1;
        int firstCriticalPointPos = 0;
        int prevCriticalPointPos = 0;
        int minDist = Integer.MAX_VALUE;

        while(temp.next != null) {
            if((temp.val < prev.val && temp.val < temp.next.val) || (temp.val > prev.val && temp.val > temp.next.val)) {
                if(prevCriticalPointPos == 0) {
                    prevCriticalPointPos = i;
                    firstCriticalPointPos = i;
                } else {
                    minDist = Math.min(minDist, i - prevCriticalPointPos);
                    prevCriticalPointPos = i;
                }
            }
            i++;
            prev = temp;
            temp = temp.next;
        }

        if(minDist == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[] {minDist, prevCriticalPointPos - firstCriticalPointPos};
    }
}
