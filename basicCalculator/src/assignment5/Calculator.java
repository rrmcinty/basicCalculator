package assignment5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class Calculator extends JComponent {
	private int width, height;
	private Display display;
	private Keypad keypad;
	
	public Calculator(int w, int h) {
		width = w;
		height = h;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(width, height));
		
		display = new Display(width);
		add(display, BorderLayout.NORTH);
		
		keypad = new Keypad(width, height, display);
		add(keypad, BorderLayout.CENTER);
		
		setBorder(BorderFactory.createLineBorder(Color.black, 5));
	}
}
