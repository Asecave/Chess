package com.asecave;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Res {

	public static BufferedImage wPawn;
	public static BufferedImage bPawn;
	public static BufferedImage wRook;
	public static BufferedImage bRook;
	public static BufferedImage wKnight;
	public static BufferedImage bKnight;
	public static BufferedImage wBishop;
	public static BufferedImage bBishop;
	public static BufferedImage wQueen;
	public static BufferedImage bQueen;
	public static BufferedImage wKing;
	public static BufferedImage bKing;

	public static void loadAll() {
		try {
			wPawn = ImageIO.read(Res.class.getResourceAsStream("assets/white_pawn.png"));
			bPawn = ImageIO.read(Res.class.getResourceAsStream("assets/black_pawn.png"));
			wRook = ImageIO.read(Res.class.getResourceAsStream("assets/white_rook.png"));
			bRook = ImageIO.read(Res.class.getResourceAsStream("assets/black_rook.png"));
			wKnight = ImageIO.read(Res.class.getResourceAsStream("assets/white_knight.png"));
			bKnight = ImageIO.read(Res.class.getResourceAsStream("assets/black_knight.png"));
			wBishop = ImageIO.read(Res.class.getResourceAsStream("assets/white_bishop.png"));
			bBishop = ImageIO.read(Res.class.getResourceAsStream("assets/black_bishop.png"));
			wQueen = ImageIO.read(Res.class.getResourceAsStream("assets/white_queen.png"));
			bQueen = ImageIO.read(Res.class.getResourceAsStream("assets/black_queen.png"));
			wKing = ImageIO.read(Res.class.getResourceAsStream("assets/white_king.png"));
			bKing = ImageIO.read(Res.class.getResourceAsStream("assets/black_king.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
