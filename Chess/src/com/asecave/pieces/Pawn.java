package com.asecave.pieces;

import java.util.ArrayList;

import com.asecave.BoardPos;

public class Pawn implements Piece {

	@Override
	public boolean isValidMove(BoardPos start, BoardPos end, int[][][] board) {
		
		
		
		return false;
	}

	@Override
	public BoardPos[] getValidMoves(BoardPos pieceStart, int[][][] board) {
		ArrayList<BoardPos> pos = new ArrayList<>();
		
		BoardPos p1 = new BoardPos(pieceStart).add(0, -1, 0);
		if (p1.isInBounds(board) && p1.isFree(board)) {
			pos.add(p1);
		}
		BoardPos p2 = new BoardPos(pieceStart).add(0, 0, -1);
		if (p2.isInBounds(board) && p2.isFree(board)) {
			pos.add(p2);
		}
		
		BoardPos[] arr = new BoardPos[pos.size()];
		return pos.toArray(arr);
	}

}
