/*
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Hard (19.04%)
 * Total Accepted:    160K
 * Total Submissions: 828K
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * 
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LRUCache cache = new LRUCache( 2 / capacity / );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 */

class Node{
	int key;
	int val;
	Node pre;
	Node next;

	public Node(int key, int val){
		this.key = key;
		this.val = val;
	}
}

public class LRUCache {

	private Map<Integer, Node> map;
	int capacity, count;
	Node head, tail;

    public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.pre = head;
		head.pre = null;
		tail.next = null;
		count = 0;
    }
    
	public void deleteNode(Node node){
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	public void addToHead(Node node){
		node.next = head.next;
		node.pre = head;
		head.next = node;
		node.next.pre = node;
	}

    public int get(int key) {
    	if(map.get(key) != null){
			Node node = map.get(key);
			int result = node.val;
			deleteNode(node);
			addToHead(node);
			return result;
		}
		return -1;
    }
    
    public void put(int key, int value) {
    	if(map.get(key) != null){
			Node node = map.get(key);
			node.val = value;
			deleteNode(node);
			addToHead(node);
		}else{
			Node node = new Node(key, value);
			map.put(key, node);
			if(count < capacity) {
				count++;
				addToHead(node);
			}else{
				map.remove(tail.pre.key);
				deleteNode(tail.pre);
				addToHead(node);
			}
		}
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
