package photo;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

import menu.BasePanel;

public class VideoPanel extends BasePanel {
	private static final long serialVersionUID = 1L;
	public final static int width = 640;
	public final static int height = 480;
	private Image img;
	protected JFrame f;

	public VideoPanel(Image img, JFrame f) {
		super(width, height);
		this.img = img;
		this.f = f;
	}

	/** PRINT_IMAGE */
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, d.width, d.height, f);
	}

	/** PRINT_SCREEN */
	public void update(Graphics g) {
		paint(g);
	}
}
