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
    public ListNode doubleIt(ListNode head) {
       head=reverse(head);
       ListNode curr=head;
       int carry=0;
       while(curr!=null){
        int val=curr.val*2+carry;
        curr.val=val%10;
        carry=val/10;
        if(curr.next==null && carry!=0){
            curr.next=new ListNode(carry);
            carry=0;
            break;
        }
        curr=curr.next;
       }
       return reverse(head);
        
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}