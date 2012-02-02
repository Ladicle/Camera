package menu;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import tools.TimeStamp;

import photo.CanvasPanel;

import camera.Camera;

public class MenuPanel extends BasePanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	public final static int width = 640;
	public final static int height = 100;
	private int count = 1;
	private String file = "jpg";
	private String day;
	private boolean state = true;
	Button sh, sv;
	JRadioButton jpg, png;

	public MenuPanel() {
		super(width, height);
		// DATE
		TimeStamp t = new TimeStamp();
		day = t.toString();
		// BUTTON'S
		sh = new Button("撮影");
		sv = new Button("保存");
		jpg = new JRadioButton("jpg", true);
		png = new JRadioButton("png", false);
		Label l1 = new Label("");
		setLayout(new GridLayout(1, 5));
		add(sh);
		add(sv);
		add(jpg);
		add(png);
		add(l1);
		ButtonGroup bg = new ButtonGroup();
		bg.add(jpg);
		bg.add(png);
		sh.addActionListener(this);
		sv.addActionListener(this);
		jpg.addActionListener(this);
		png.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sh) {
			if (state) {
				System.out.println(count + "shot");
				CanvasPanel.setImage();
				Camera.changeCard("filter");
				state = false;
			} else {
				Camera.changeCard("camera");
				state = true;
			}

		} else if (e.getSource() == sv) {
			if (state) {
				save();
			} else {
				save2();
			}
			System.out.println("save:" + count);
			++count;
		} else if (e.getSource() == jpg) {
			file = "jpg";
		} else if (e.getSource() == png) {
			file = "png";
		}
	}

	public void save() {
		try {
			java.io.File f = new java.io.File("[" + day + "]no" + count + "."
					+ file);
			javax.imageio.ImageIO.write(Camera.getImage(), file, f);
			f = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save2() {
		try {
			java.io.File f = new java.io.File("[" + day + "]no" + count + "."
					+ file);
			ImageIO.write(CanvasPanel.getImage(), file, f);
			f = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
