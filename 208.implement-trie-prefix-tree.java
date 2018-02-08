/*
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (29.98%)
 * Total Accepted:    101.5K
 * Total Submissions: 334.7K
 * Testcase Example:  '["Trie","search"]\n[[],["a"]]'
 *
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * 
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 */

class TrieNode{
	char val;
	boolean isWord;
	TrieNode[] children;
	public TrieNode(char c){
		val = c;
		isWord = false;
		children = new TrieNode[26];
	}
}

public class Trie {
	TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
		root = new TrieNode(' ');	        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode curNode = root;
		for(int i=0; i<word.length(); i++){
			int idx = word.charAt(i) - 'a';
			if(curNode.children[idx] == null)
				curNode.children[idx] = new TrieNode((char)('a'+idx));
			curNode = curNode.children[idx];
		}
		curNode.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	int depth = 0;
		TrieNode curNode = root;
		for(int i=0; i<word.length(); i++){
			int idx = word.charAt(i) - 'a';
			if(curNode.children[idx] != null){
				depth++;
				curNode = curNode.children[idx];
			}else return false;
		}
		return curNode.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode curNode = root;
		for(int i=0; i<prefix.length(); i++){
			int idx = prefix.charAt(i) - 'a';
			if(curNode.children[idx] == null) return false;
			curNode = curNode.children[idx];
		}
		return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
