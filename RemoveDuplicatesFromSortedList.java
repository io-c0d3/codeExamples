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
    public ListNode deleteDuplicates(ListNode head) {
        // Save the first node to return later.
        ListNode holdStart = head;
        // If the list is empty return it.
        if (head == null) {
            return head;
        }
        // While there is a next node in the list.
        while (head.next != null) {
            // If there is a duplicate, remove one by skipping it.
            if (head.val == head.next.val) {
                head.next = head.next.next;
            }
            // Otherwise move on to the next node.
            else {
                head = head.next;
            }
        }
        // Return the first node of the list.
        return holdStart;
    }
}
