package com.asecave;

public class BoardPos {

	public int x, y, z;
	
	public BoardPos(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public BoardPos(BoardPos pos) {
		x = pos.x;
		y = pos.y;
		z = pos.z;
	}
	
	public boolean isInBounds(int[][][] board) {
		boolean vx = x >= 0 && x < board.length;
		boolean vy = y >= 0 && y < board[0].length;
		boolean vz = z >= 0 && z < board[0][0].length;
		
		return vx && vy && vz;
	}
	
	public BoardPos add(int x, int y, int z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public boolean isFree(int[][][] board) {
		return board[x][y][z] == 0;
	}
}
