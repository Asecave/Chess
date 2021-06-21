package com.asecave.pieces;

import com.asecave.BoardPos;

public class King implements Piece {

	@Override
	public boolean isValidMove(BoardPos start, BoardPos end, int[][][] board) {
		return false;
	}

	@Override
	public BoardPos[] getValidMoves(BoardPos pieceStart, int[][][] board) {
		return null;
	}

}
