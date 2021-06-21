package com.asecave.pieces;

import com.asecave.BoardPos;

public interface Piece {

	public boolean isValidMove(BoardPos start, BoardPos end, int[][][] board);

	public BoardPos[] getValidMoves(BoardPos pieceStart, int[][][] board);
}
