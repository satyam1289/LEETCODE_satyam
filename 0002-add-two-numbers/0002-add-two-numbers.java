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
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode c = new ListNode(0); 
        ListNode d = c;
        int e = 0;

        while (a != null || b != null || e != 0) {
            int f = e;
            if (a != null) {
                f += a.val;
                a = a.next;
            }
            if (b != null) {
                f += b.val;
                b = b.next;
            }

            e = f / 10;
            d.next = new ListNode(f % 10);
            d = d.next;
        }

        return c.next; 
    }
}
