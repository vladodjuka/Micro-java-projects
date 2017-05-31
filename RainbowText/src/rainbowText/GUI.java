package rainbowText;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField myTxt;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JPanel myPanel;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getMyTxt());
		contentPane.add(getComboBox());
		contentPane.add(getBtnNewButton());
		contentPane.add(getMyPanel());
		frame = this;
	}

	private JTextField getMyTxt() {
		if (myTxt == null) {
			myTxt = new JTextField();
			myTxt.setBounds(10, 11, 210, 20);
			myTxt.setColumns(10);
		}
		return myTxt;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(250, 11, 118, 20);
			comboBox.addItem("fast");
			comboBox.addItem("medium");
			comboBox.addItem("slow");
		}
		return comboBox;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Start");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (myTxt.getText().equals("") || myTxt.getText() == null) {
						JOptionPane.showMessageDialog(frame, "Invalid input",
								"error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					int speed = 2000;
					switch (comboBox.getSelectedIndex()) {
					case 0:
						speed = 100;
						break;
					case 1:
						speed = 500;
						break;
					case 2:
						speed = 1000;
						break;

					}

					MyThread m = new MyThread(myTxt.getText(), speed, myPanel);
					m.start();
					
				}
			});
			btnNewButton.setBounds(397, 10, 89, 23);
		}
		return btnNewButton;
	}

	private JPanel getMyPanel() {
		if (myPanel == null) {
			myPanel = new JPanel();
			myPanel.setBounds(10, 42, 476, 209);
			myPanel.setLayout(null);
		}
		return myPanel;
	}
}
