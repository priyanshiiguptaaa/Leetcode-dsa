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
    public int count(ListNode head){
        ListNode curr = new ListNode();
        curr = head;
        int size = 0;
        while(curr != null){
            curr = curr.next;
            size++;
            
        }
        return size;
    }
    public ListNode deleteMiddle(ListNode head) {
        int n = count(head);
        int x = n/2;
        if (head == null || head.next == null) {
            return null;
        }
        ListNode curr = head.next;
        ListNode prev = head;
        for(int i = 0 ; i < x - 1 ; i++){
            curr = curr.next;
            prev = prev.next;
        }
        prev.next = curr.next;
        return head;
    }
}
