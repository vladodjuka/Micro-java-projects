package rainbowText;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyThread extends Thread {

	private String text;
	private int speed;
	private JPanel lePanel;
	private JLabel[] labels;

	public MyThread(String text, int speed, JPanel lePanel) {
		super();
		this.text = text;
		this.speed = speed;
		this.lePanel = lePanel;
		prepareGUI();
	}

	@Override
	public void run() {

		for (int i = 0; i < labels.length; i++) {
			labels[i].setVisible(true);
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				return;
			}
		}

	}

	public void prepareGUI() {
		lePanel.removeAll();
		int xOffset = 0;
		int yOffset = 0;
		int counter = 0;
		Color[] colors = { Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA,
				Color.CYAN };
		labels = new JLabel[text.length()];

		for (int i = 0; i < labels.length; i++) {
			JLabel l = new JLabel("" + text.charAt(i));
			if (xOffset + 10 > lePanel.getBounds().getWidth()) {
				yOffset += 20;
				xOffset = 0;
			}

			l.setBounds(10 + xOffset, 10 + yOffset, 15, 15);
			l.setForeground(colors[counter++]);

			if (counter == (colors.length - 1)) {
				counter = 0;
			}
			lePanel.add(l);
			l.setVisible(false);
			labels[i] = l;

			xOffset += 20;
		}

	}
}
