package com.asecave;

import java.awt.Color;
import java.awt.Graphics2D;

public class Game {

	private byte[][] board = {
			{2, 1, 0, 0, 0, 0, 7, 8},
			{3, 1, 0, 0, 0, 0, 7, 9},
			{4, 1, 0, 0, 0, 0, 7, 10},
			{6, 1, 0, 0, 0, 0, 7, 11},
			{5, 1, 0, 0, 0, 0, 7, 12},
			{4, 1, 0, 0, 0, 0, 7, 10},
			{3, 1, 0, 0, 0, 0, 7, 9},
			{2, 1, 0, 0, 0, 0, 7, 8}
	};
	private int size = 50;
	private int offsetX, offsetY;

	public Game() {
		offsetX = 300;
		offsetY = 300;
	}

	public void render(Graphics2D g2d) {
		g2d.translate(-board.length * size / 2, -board[0].length * size / 2);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(-size / 5 + offsetX, -size / 5 + offsetY, board.length * size + (size / 5) * 2, board[0].length * size + (size / 5) * 2);
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if ((x + y) % 2 == 1) {
					g2d.setColor(Color.DARK_GRAY);
				} else {
					g2d.setColor(Color.WHITE);
				}
				g2d.fillRect(x * size + offsetX, y * size + offsetY, size, size);
			}
		}
		
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				switch (board[x][y]) {
				case 1:
					g2d.drawImage(Res.wPawn, x * size + offsetX, y * size + offsetY, size, size, null);
					break;
				case 2:
					g2d.drawImage(Res.wRook, x * size + offsetX, y * size + offsetY, size, size, null);
					break;
				case 3:
					g2d.drawImage(Res.wKnight, x * size + offsetX, y * size + offsetY, size, size, null);
					break;
				case 4:
					g2d.drawImage(Res.wBishop, x * size + offsetX, y * size + offsetY, size, size, null);
					break;
				case 5:
					g2d.drawImage(Res.wQueen, x * size + offsetX, y * size + offsetY, size, size, null);
					break;
				case 6:
					g2d.drawImage(Res.wKing, x * size + offsetX, y * size + offsetY, size, size, null);
					break;
				case 7:
					g2d.drawImage(Res.bPawn, x * size + offsetX, y * size + offsetY, size, size, null);
					break;
				case 8:
					g2d.drawImage(Res.bRook, x * size + offsetX, y * size + offsetY, size, size, null);
					break;
				case 9:
					g2d.drawImage(Res.bKnight, x * size + offsetX, y * size + offsetY, size, size, null);
					break;
				case 10:
					g2d.drawImage(Res.bBishop, x * size + offsetX, y * size + offsetY, size, size, null);
					break;
				case 11:
					g2d.drawImage(Res.bQueen, x * size + offsetX, y * size + offsetY, size, size, null);
					break;
				case 12:
					g2d.drawImage(Res.bKing, x * size + offsetX, y * size + offsetY, size, size, null);
					break;
				}
			}
		}
		
		g2d.translate(board.length * size / 2, board[0].length * size / 2);
	}

	public void drag(int dx, int dy) {
		offsetX += dx;
		offsetY += dy;
	}

	public void scroll(int unitsToScroll) {
		size += unitsToScroll;
		if (size < 10) {
			size = 10;
		}
	}
}
