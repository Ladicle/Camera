package photo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

import javax.swing.JFrame;

import tools.DrawTools;
import tools.TimeStamp;

import camera.Camera;

public class CanvasPanel extends VideoPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	static BufferedImage img = null;
	private Point p;
	private String day;
	private DrawTools dt;
	private static Graphics g2;

	public CanvasPanel(Image img, JFrame f) {
		super(img, f);
		addMouseListener(this);
		TimeStamp t = new TimeStamp();
		dt = new DrawTools();
		day = t.getYear() + "/" + t.getMonth() + "/" + t.getDay();
	}

	@Override
	public void paint(Graphics g) {

		if (p != null) {
			dt.font(20, g2);
			dt.color(170, 170, 170, g2);
			g2.drawString(day, (int) p.getX(), (int) p.getY());
		}
		g.drawImage(img, 0, 0, d.width, d.height + 40, this);
	}

	public static void setImage() {
		img = (BufferedImage) Camera.getImage();
		g2 = img.getGraphics();
	}

	public static RenderedImage getImage() {
		return (java.awt.image.BufferedImage) img;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		p = e.getPoint();
		System.out.println("ok" + p.getX());
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
}
