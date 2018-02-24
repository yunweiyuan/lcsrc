/*
 * [289] Game of Life
 *
 * https://leetcode.com/problems/game-of-life/description/
 *
 * algorithms
 * Medium (37.17%)
 * Total Accepted:    63K
 * Total Submissions: 169.2K
 * Testcase Example:  '[[]]'
 *
 * 
 * According to the Wikipedia's article: "The Game of Life, also known simply
 * as Life, is a cellular automaton devised by the British mathematician John
 * Horton Conway in 1970."
 * 
 * 
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal,
 * vertical, diagonal) using the following four rules (taken from the above
 * Wikipedia article):
 * 
 * 
 * 
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by
 * under-population.
 * Any live cell with two or three live neighbors lives on to the next
 * generation.
 * Any live cell with more than three live neighbors dies, as if by
 * over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if
 * by reproduction.
 * 
 * 
 * 
 * 
 * Write a function to compute the next state (after one update) of the board
 * given its current state.
 * 
 * 
 * Follow up: 
 * 
 * Could you solve it in-place? Remember that the board needs to be updated at
 * the same time: You cannot update some cells first and then use their updated
 * values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the
 * board is infinite, which would cause problems when the active area
 * encroaches the border of the array. How would you address these problems?
 * 
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
class Solution {
    public void gameOfLife(int[][] board) {
		if(board == null || board.length == 0) return;
		int m = board.length, n = board[0].length;

		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				int neighbors = surround(board, m, n, i, j);
				if(board[i][j] == 1 && neighbors >= 2 && neighbors <= 3)
					board[i][j] = 3;
				if(board[i][j] == 0 && neighbors == 3)
					board[i][j] = 2;
			}
		}

		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				board[i][j] >>= 1;
			}
		}
    }

	int surround(int[][] board, int m, int n, int i, int j){
		int neighbors = 0;
		for(int k=Math.max(0, i-1); k<=Math.min(i+1,m-1); k++){
			for(int l=Math.max(0, j-1); l<=Math.min(j+1,n-1); l++){
				neighbors += board[k][l] & 1;
			}
		}
		neighbors -= board[i][j];
		return neighbors;
	}
}
