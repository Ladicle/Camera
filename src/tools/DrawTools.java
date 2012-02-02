package tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class DrawTools {
	// FONT_STYLE
	protected static final int BOLD = 0;
	protected static final int ITALIC = 1;

	/** CHANGE_FONT */
	public void font(int size, Graphics g) {
		Font font = new Font("Dialog", Font.PLAIN, size);
		g.setFont(font);
	}

	public void font(int size, int style, Graphics g) {
		switch (style) {
		case BOLD:
			Font font = new Font("Dialog", Font.BOLD, size);
			g.setFont(font);
			break;
		case ITALIC:
			Font font2 = new Font("Dialog", Font.ITALIC, size);
			g.setFont(font2);
			break;
		}
	}

	/** CHANGE_COLOR */
	public void color(int R, int G, int B, Graphics g) {
		Color color = new Color(R, G, B);
		g.setColor(color);
	}
}
