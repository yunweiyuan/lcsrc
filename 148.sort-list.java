/*
 * [148] Sort List
 *
 * https://leetcode.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (29.41%)
 * Total Accepted:    124.9K
 * Total Submissions: 422K
 * Testcase Example:  '[]'
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
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
    public ListNode sortList(ListNode head) {
		//merge sort
		return mergeSort(head);
    }
	
	ListNode mergeSort(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow=dummy, fast=head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow.next;
		slow.next = null;
		head = mergeSort(head);
		fast = mergeSort(fast);
		return merge(head, fast);
	}
	
	ListNode merge(ListNode node1, ListNode node2){
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while(node1 != null && node2 != null){
			if(node1.val < node2.val){
				dummy.next = node1;
				node1 = node1.next;
			}else{
				dummy.next = node2;
				node2 = node2.next;
			}
			dummy = dummy.next;
		}
		if(node2 != null) dummy.next = node2;
		if(node1 != null) dummy.next = node1;
		return head.next;
	}
}
