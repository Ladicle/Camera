package menu;

import java.awt.Dimension;
import java.awt.Panel;

public class BasePanel extends Panel {
	private static final long serialVersionUID = 1L;
	private static int count = 0;
	private int id;
	protected Dimension d;
	{
		id = count;
		count++;
	}

	/** SETTING_PANELSIZE */
	public BasePanel(int width, int height) {
		d = new Dimension(width, height);
		setSize(d);
	}

	/** GET_NO.FRAME */
	public int getID() {
		return id;
	}

	/** GET_PANELSIZE */
	public Dimension getSize() {
		return d;
	}
}
