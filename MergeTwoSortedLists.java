/**
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
*/



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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode listHead = new ListNode();
        ListNode dummy = listHead;
        boolean flag = true;

        // Condense code a bit.
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Set the two initial ListNode values.
        if (list1.val >= list2.val) {
            dummy.val = list2.val;
            list2 = list2.next;
        }
        else {
            dummy.val = list1.val;
            list1 = list1.next;
        }

        // Do the rest while list1 and list2 are not both empty.
        while (list1 != null || list2 != null) {
            System.out.println("Current Value: " + dummy.val);
            // If list1 is empty, get next from list2.
            if (list1 == null) {
                dummy.next = new ListNode(list2.val);
                dummy = dummy.next;
                list2 = list2.next;
            }
            // Else if list2 is empty, get next from list1.
            else if (list2 == null) {
                dummy.next = new ListNode(list1.val);
                dummy = dummy.next;
                list1 = list1.next;
            }
            // Else if neither list is empty, see which is smaller and add that.
            else {
                if (list1.val <= list2.val) {
                    dummy.next = new ListNode(list1.val);
                    dummy = dummy.next;
                    list1 = list1.next;
                }
                else {
                    dummy.next = new ListNode(list2.val);
                    dummy = dummy.next;
                    list2 = list2.next;
                }
            }
        }

        return listHead;
    }
}






// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         ListNode listHead = new ListNode();
//         ListNode dummy = listHead;
//         boolean flag = true;

//         // DEAL WITH LISTS BEING EMPTY
//         if (list1 == null && list2 == null) {
//             return list1;
//         }
//         else if (list1 == null) {
//             dummy.val = list2.val;
//             list2 = list2.next;
//         }
//         else if (list2 == null) {
//             dummy.val = list1.val;
//             list1 = list1.next;
//         }
//         // Set the two initial ListNode values.
//         if (list1.val >= list2.val) {
//             dummy.val = list2.val;
//             list2 = list2.next;
//         }
//         else {
//             dummy.val = list1.val;
//             list1 = list1.next;
//         }

//         // Do the rest while list1 and list2 are not both empty.
//         while (list1 != null || list2 != null) {
//             System.out.println("Current Value: " + dummy.val);
//             // If list1 is empty, get next from list2.
//             if (list1 == null) {
//                 dummy.next = new ListNode(list2.val);
//                 dummy = dummy.next;
//                 list2 = list2.next;
//             }
//             // Else if list2 is empty, get next from list1.
//             else if (list2 == null) {
//                 dummy.next = new ListNode(list1.val);
//                 dummy = dummy.next;
//                 list1 = list1.next;
//             }
//             // Else if neither list is empty, see which is smaller and add that.
//             else {
//                 if (list1.val <= list2.val) {
//                     dummy.next = new ListNode(list1.val);
//                     dummy = dummy.next;
//                     list1 = list1.next;
//                 }
//                 else {
//                     dummy.next = new ListNode(list2.val);
//                     dummy = dummy.next;
//                     list2 = list2.next;
//                 }
//             }
//         }

//         return listHead;
//     }
// }
