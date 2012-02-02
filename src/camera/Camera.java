package camera;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.image.RenderedImage;

import javax.media.Buffer;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import javax.swing.JFrame;

import photo.CanvasPanel;
import photo.VideoPanel;

import menu.BasePanel;
import menu.MenuPanel;

public class Camera extends JFrame {
	private static final long serialVersionUID = 1L;
	private static CardLayout card;
	private static VideoPanel cp;
	// INITIALIZE
	private static Player player = null;
	private Image img = null;

	/**
	 * GET_INSRANCE
	 * 
	 * @param title
	 *            FRAME_NAME
	 */
	public Camera(String title) {
		// SETING_FRAME
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setResizable(false);
		setLocationRelativeTo(null);

		// SETING_PANEL
		BasePanel p1 = new BasePanel(640, 50);
		CanvasPanel p2 = new CanvasPanel(img, this);
		cp = new VideoPanel(img, this);
		MenuPanel mp = new MenuPanel();
		setSize(640, 530);

		// CONNECT_CAMERA
		try {
			player = Manager.createRealizedPlayer(new MediaLocator("vfw://0"));
			cp.setLayout(card = new CardLayout());
			cp.add("camera", player.getVisualComponent());
			cp.add("filter", p2);
			card.show(cp, "camera");
			player.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

		p1.setLayout(new BorderLayout());
		p1.add(mp, BorderLayout.CENTER);
		getContentPane().add(p1);
		getContentPane().add(cp);
	}

	public static void changeCard(String name) {
		card.show(cp, name);
	}

	/** GET_BUFFER_IMG */
	public static RenderedImage getImage() {
		FrameGrabbingControl frameGrabber = (FrameGrabbingControl) player
				.getControl("javax.media.control.FrameGrabbingControl");
		Buffer buf = frameGrabber.grabFrame();
		BufferToImage buffimg = new BufferToImage((VideoFormat) buf.getFormat());
		return (java.awt.image.BufferedImage) buffimg.createImage(buf);
	}
}
