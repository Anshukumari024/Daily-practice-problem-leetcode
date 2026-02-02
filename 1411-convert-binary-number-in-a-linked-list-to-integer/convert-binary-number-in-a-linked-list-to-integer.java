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
    public int getDecimalValue(ListNode head) {
        ListNode temp=head;
        int sum=0;
        int c=0;
        while(temp!=null){
            temp=temp.next;
            c++;
        }
        int i=c-1;
        temp=head;
        while(temp!=null  && i>=0){
            sum+=(temp.val*(Math.pow(2,i)));
            i--;
            temp=temp.next;
        }
        return sum;
        
    }
}