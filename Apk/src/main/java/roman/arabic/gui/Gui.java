package roman.arabic.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import roman.arabic.engine.Engine;

public class Gui extends JFrame implements ActionListener {
	private JLabel larabic, lroman;
	private JTextField tarabic, troman;
	private JButton Convert;
	private JRadioButton a2r, r2a;
	private ButtonGroup radioPanel;

	public Gui() {
		setLayout(null);
		setSize(400, 400);
		setTitle("Arabic and Roman numbers");

		larabic = new JLabel("Arabic");
		larabic.setBounds(30, 50, 150, 20);
		add(larabic);

		tarabic = new JTextField();
		tarabic.setBounds(180, 50, 150, 25);
		add(tarabic);
		tarabic.addActionListener(this);

		lroman = new JLabel("Roman");
		lroman.setBounds(30, 100, 150, 20);
		add(lroman);

		troman = new JTextField();
		troman.setBounds(180, 100, 150, 25);
		add(troman);
		troman.addActionListener(this);

		radioPanel = new ButtonGroup();
		a2r = new JRadioButton("arabic to roman");
		a2r.setBounds(50, 150, 150, 20);
		a2r.setSelected(true);
		add(a2r);
		radioPanel.add(a2r);

		r2a = new JRadioButton("roman to arabic");
		r2a.setBounds(200, 150, 150, 20);
		r2a.setSelected(true);
		add(r2a);
		radioPanel.add(r2a);

		Convert = new JButton("Convert");
		Convert.setBounds(120, 200, 150, 20);
		add(Convert);
		Convert.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == Convert && a2r.isSelected()) {
			troman.setText(Engine.arabic2roman(Integer.valueOf(tarabic.getText())));
		} else if (source == Convert && r2a.isSelected())
			tarabic.setText(String.valueOf(Engine.roman2arabic(troman.getText())));

	}

}
