package assignment5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
/**
 * This class creates a the buttons for the calculator. 
 * 
 *
 */
public class Keypad extends JComponent {
	private int width, height;
	private Controller cc;
	private Display display;
	/**
	 * This is the keypad constructor. It creates the jbuttons 
	 * with the corresponding string labels. 
	 * @param w - width
	 * @param h - height
	 * @param d - display
	 */
	public Keypad(int w, int h, Display d) {
		width = w;
		height = h;
		display = d;
		cc = new Controller(display);
		
		String [] labels = new String [] {"Ans", "", "", "AC", "7",
											"8", "9", "/", "4", "5", 
											"6", "*", "1", "2", "3", "-",
											"0", ".", "=", "+"};
		
		setPreferredSize(new Dimension(width - 20, height = 55));
		setLayout(new GridLayout(5,4));
		/*
		 * creates new jbutton for each label
		 */
		for(int i=0 ; i < labels.length; i++) {
			JButton b = new JButton(labels[i]);
			b.addActionListener(cc);
			add(b);
		}
		setBorder(BorderFactory.createLineBorder(Color.red,2));
	}
}
