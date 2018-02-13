/*
 * [406] Queue Reconstruction by Height
 *
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 *
 * algorithms
 * Medium (56.49%)
 * Total Accepted:    39.2K
 * Total Submissions: 69.1K
 * Testcase Example:  '[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]'
 *
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * 
 * Note:
 * The number of people is less than 1,100.
 * 
 * 
 * 
 * 
 * Example
 * 
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * 
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
		int[][] res = new int[people.length][2];

		Arrays.sort(people, new Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				if(a[0] == b[0]) return a[1] - b[1];
				return b[0] - a[0];
			}
		});

		ArrayList<int[]> temp = new ArrayList<>();
		for(int i=0; i<people.length; i++){
			temp.add(people[i][1], people[i]);
		}

		for(int i=0; i<res.length; i++){
			res[i][0] = temp.get(i)[0];
			res[i][1] = temp.get(i)[1];
		}
		return res;
    }
}
