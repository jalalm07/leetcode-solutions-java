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
        ListNode dummyHead = new ListNode(0);
        ListNode tempHead = dummyHead;
        Stack<ListNode> stack = new Stack<>();

        ListNode curr = head;
        int itr = 0;
        while(curr != null){
            if(itr <= k){
                stack.push(curr);
                curr = curr.next;
                itr++;
            } 
            
            if(itr == k){
                while(itr != 0){
                    tempHead.next = stack.pop();
                    tempHead = tempHead.next;
                    itr--;
                }
            }
        }

        if(!stack.isEmpty()){
            while(stack.size() != 1){
                stack.pop();
            }
            tempHead.next = stack.pop();
        } else tempHead.next = null;

        return dummyHead.next;
    }
}