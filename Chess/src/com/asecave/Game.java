package com.asecave;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import com.asecave.pieces.Bishop;
import com.asecave.pieces.King;
import com.asecave.pieces.Knight;
import com.asecave.pieces.Pawn;
import com.asecave.pieces.Piece;
import com.asecave.pieces.Queen;
import com.asecave.pieces.Rook;

public class Game {

	private static final int W_PAWN = 1;
	private static final int W_ROOK = 2;
	private static final int W_KNIGHT = 3;
	private static final int W_BISHOP = 4;
	private static final int W_QUEEN = 5;
	private static final int W_KING = 6;
	private static final int B_PAWN = 7;
	private static final int B_ROOK = 8;
	private static final int B_KNIGHT = 9;
	private static final int B_BISHOP = 10;
	private static final int B_QUEEN = 11;
	private static final int B_KING = 12;

	private int[][][] board;
	private int size = 50;
	private int boardDist;
	private int offsetX, offsetY;
	private int dragPiece;
	private int dragPosX, dragPosY;
	private BoardPos pieceStart;
	private static Pawn pawn = new Pawn();
	private static Rook rook = new Rook();
	private static Knight knight = new Knight();
	private static Bishop bishop = new Bishop();
	private static Queen queen = new Queen();
	private static King king = new King();
	private static Color whiteTile = new Color(0xFFCE9E);
	private static Color blackTile = new Color(0xD18B47);
	private BoardPos[] validMoves;

	public Game() {
		offsetX = 300;
		offsetY = 300;
		board = new int[5][5][5];

		board[0][0][0] = B_ROOK;
		board[1][0][0] = B_KNIGHT;
		board[2][0][0] = B_KING;
		board[3][0][0] = B_KNIGHT;
		board[4][0][0] = B_ROOK;
		board[0][0][1] = B_KNIGHT;
		board[1][0][1] = B_BISHOP;
		board[2][0][1] = B_QUEEN;
		board[3][0][1] = B_BISHOP;
		board[4][0][1] = B_KNIGHT;
		board[0][4][4] = W_ROOK;
		board[1][4][4] = W_KNIGHT;
		board[2][4][4] = W_KING;
		board[3][4][4] = W_KNIGHT;
		board[4][4][4] = W_ROOK;
		board[0][4][3] = W_KNIGHT;
		board[1][4][3] = W_BISHOP;
		board[2][4][3] = W_QUEEN;
		board[3][4][3] = W_BISHOP;
		board[4][4][3] = W_KNIGHT;
		for (int i = 0; i < board.length; i++) {
			board[i][1][0] = B_PAWN;
			board[i][1][1] = B_PAWN;
			board[i][3][3] = W_PAWN;
			board[i][3][4] = W_PAWN;
		}
	}

	public void render(Graphics2D g2d) {
		boardDist = board[0].length * size + size;
		for (int z = 0; z < board[0][0].length; z++) {
			g2d.setColor(Color.WHITE);
			g2d.fillRect(-size / 5 + offsetX, -size / 5 + offsetY + z * boardDist, board.length * size + (size / 5) * 2,
					board[0].length * size + (size / 5) * 2);
		}
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				for (int z = 0; z < board[0][0].length; z++) {
					if ((x + y) % 2 == 0) {
						g2d.setColor(whiteTile);
					} else {
						g2d.setColor(blackTile);
					}
					g2d.fillRect(x * size + offsetX, y * size + offsetY + z * boardDist, size, size);
				}
			}
		}

		for (int x = 0; x < board[0][0].length; x++) {
			for (int y = 0; y < board.length; y++) {
				for (int z = 0; z < board[0].length; z++) {
					drawPiece(g2d, board[y][z][x], y * size + offsetX, z * size + offsetY + x * boardDist);
				}
			}
		}
		if (validMoves != null) {
			g2d.setColor(new Color(1f, 1f, 1f, 0.4f));
			for (BoardPos p : validMoves) {
				g2d.fillRect(p.x * size + offsetX, p.y * size + offsetY + p.z * boardDist, size, size);
			}
		}
		if (dragPiece != 0) {
			drawPiece(g2d, dragPiece, dragPosX - size / 2, dragPosY - size / 2);
		}
	}

	private void drawPiece(Graphics2D g2d, int piece, int x, int y) {
		switch (piece) {
		case W_PAWN:
			g2d.drawImage(Res.wPawn, x, y, size, size, null);
			break;
		case W_ROOK:
			g2d.drawImage(Res.wRook, x, y, size, size, null);
			break;
		case W_KNIGHT:
			g2d.drawImage(Res.wKnight, x, y, size, size, null);
			break;
		case W_BISHOP:
			g2d.drawImage(Res.wBishop, x, y, size, size, null);
			break;
		case W_QUEEN:
			g2d.drawImage(Res.wQueen, x, y, size, size, null);
			break;
		case W_KING:
			g2d.drawImage(Res.wKing, x, y, size, size, null);
			break;
		case B_PAWN:
			g2d.drawImage(Res.bPawn, x, y, size, size, null);
			break;
		case B_ROOK:
			g2d.drawImage(Res.bRook, x, y, size, size, null);
			break;
		case B_KNIGHT:
			g2d.drawImage(Res.bKnight, x, y, size, size, null);
			break;
		case B_BISHOP:
			g2d.drawImage(Res.bBishop, x, y, size, size, null);
			break;
		case B_QUEEN:
			g2d.drawImage(Res.bQueen, x, y, size, size, null);
			break;
		case B_KING:
			g2d.drawImage(Res.bKing, x, y, size, size, null);
			break;
		}
	}

	public void rightDrag(int dx, int dy) {
		offsetX += dx;
		offsetY += dy;
	}

	public void leftDown(Point p) {
		int bx = (p.x - offsetX) / size;
		int by = (p.y - offsetY) % boardDist / size;
		int bz = (p.y - offsetY) / boardDist;
		if (bx >= 0 && bx < board.length && by >= 0 && by < board[0].length && bz >= 0 && bz < board[0][0].length) {
			dragPiece = board[bx][by][bz];
			if (dragPiece != 0) {
				board[bx][by][bz] = 0;
				pieceStart = new BoardPos(bx, by, bz);
				validMoves = getPiece(dragPiece).getValidMoves(pieceStart, board);
			}
		}
	}

	public void leftHold(MouseEvent e) {
		dragPosX = e.getX();
		dragPosY = e.getY();
	}

	public void leftRelease(Point p) {
		if (dragPiece != 0) {
			int bx = (p.x - offsetX) / size;
			int by = (p.y - offsetY) % boardDist / size;
			int bz = (p.y - offsetY) / boardDist;
			if (bx >= 0 && bx < board.length && by >= 0 && by < board[0].length && bz >= 0 && bz < board[0][0].length
					&& getPiece(dragPiece).isValidMove(pieceStart, new BoardPos(bx, by, bz), board)) {
				board[bx][by][bz] = dragPiece;
			} else {
				board[pieceStart.x][pieceStart.y][pieceStart.z] = dragPiece;
			}
			dragPiece = 0;
			validMoves = null;
		}
	}

	private Piece getPiece(int piece) {
		switch (piece) {
		case W_PAWN:
		case B_PAWN:
			return pawn;
		case W_ROOK:
		case B_ROOK:
			return rook;
		case W_KNIGHT:
		case B_KNIGHT:
			return knight;
		case W_BISHOP:
		case B_BISHOP:
			return bishop;
		case W_QUEEN:
		case B_QUEEN:
			return queen;
		case W_KING:
		case B_KING:
			return king;

		}
		return null;
	}

	public void scroll(int unitsToScroll) {
		size += unitsToScroll;
		if (size < 10) {
			size = 10;
		}
	}
}
