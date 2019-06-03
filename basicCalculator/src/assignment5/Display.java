package assignment5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;
/**
 * This class creates the display for the calculator
 * 
 *
 */
public class Display extends JComponent {
	private int width;
	private JTextField tf;
	/**
	 * This is the display constructor. It uses a brought in width and
	 * set height. It then creates a text field for the calculator.
	 * @param w - width
	 */
	public Display(int w) {
		width = w;
		
		setPreferredSize(new Dimension(width = 20, 50));
		setLayout(new FlowLayout());
		
		tf = new JTextField(" ", 25);
		add(tf);
		
		setBorder(BorderFactory.createLineBorder(Color.blue,2));
	}
	/**
	 * This displays the brought in string to the calculator
	 * text field.
	 * @param exp - expression(jbutton values or answer value)
	 */
	public void showValue(String exp) {
		tf.setText(exp);
	}
	/**
	 * clears the display area 
	 */
	public void clear() {
		tf.setText("");
	}
}
