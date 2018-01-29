/*
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (35.93%)
 * Total Accepted:    153.1K
 * Total Submissions: 423.8K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 11110110101100000000
 * Answer: 1
 * Example 2:
 * 11000110000010000011
 * Answer: 3
 * 
 * Credits:Special thanks to @mithmatt for adding this problem and creating all
 * test cases.
 */
class Solution {
    public int numIslands(char[][] grid) {
		int count = 0;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(grid[i][j] == '1'){
					count += 1;
					fillIsland(grid, i, j);
				}
			}
		}
		return count;
    }

	public void fillIsland(char[][] grid, int i, int j){
		if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1'){
			grid[i][j] = '0';
			fillIsland(grid, i-1, j);
			fillIsland(grid, i+1, j);
			fillIsland(grid, i, j-1);
			fillIsland(grid, i, j+1);
		}
	}
}
