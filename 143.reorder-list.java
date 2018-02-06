/*
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (26.31%)
 * Total Accepted:    106.9K
 * Total Submissions: 403.6K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
		if(head==null || head.next==null || head.next.next==null) return;

		ListNode dummy = head;
		ListNode tailBackHalf = reverse(null, getMid(head));
		merge(head, tailBackHalf);
    }

	void merge(ListNode l1, ListNode l2){
		ListNode dummy = l1;
		while(l2 != null){
			ListNode temp1 = l1.next;
			ListNode temp2 = l2.next;
			l1.next = l2;
			l2.next = temp1;
			l1 = temp1;
			l2 = temp2;
		}
		l1 = dummy;
	}

	ListNode reverse(ListNode pre, ListNode cur){
		ListNode next = cur.next;
		cur.next = pre;
		if(next == null) return cur;
		return reverse(cur, next);
	}
	
	ListNode getMid(ListNode head){
		ListNode slow = head, fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode newHead = slow.next;
		slow.next = null;
		return newHead;
	}
}
