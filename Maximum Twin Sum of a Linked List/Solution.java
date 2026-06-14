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
    public int pairSum(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode curr = head;

        while(curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        int left = 0;
        int right = arr.size()-1;
        int max = 0;
        while(left < right) {
            int sum = arr.get(left) + arr.get(right);
            max = Math.max(max, sum);
            left++;
            right--;
        }

        return max;
    }
}
