package com.asecave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Game game;
	private Point point;
	private boolean drag;

	public static void main(String[] args) {
		new Frame();
	}

	public Frame() {
		
		Res.loadAll();

		frame = new JFrame("Chess");
		frame.setSize(1000, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);

		game = new Game();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		if (game != null) {
			game.render(g2d);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (drag) {
			int dx = e.getX() - point.x;
			int dy = e.getY() - point.y;
			point = e.getPoint();
			game.drag(dx, dy);
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3 || e.getButton() == MouseEvent.BUTTON2) {
			point = e.getPoint();
			drag = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		drag = false;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		game.scroll(-e.getUnitsToScroll());
		repaint();
	}
}
