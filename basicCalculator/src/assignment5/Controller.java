package assignment5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class takes in the inputs of the jbuttons,
 * concatenating them into an expression, and 
 * sending it to the evaluation class to solve
 * once the "=" jbutton is registered.
 * It also clears once "AC" is registered or
 * adds the last saved answer to the expression 
 * if "Ans" is registered.
 * 
 * @author Ryan
 *
 */
public class Controller implements ActionListener {

	private String expression = "";
	private String savedAns = "";
	private Display display;
	/**
	 * Controller constructor.
	 * @param display
	 */
	public Controller(Display display) {
		this.display = display;
	}
	/**
	 * Different actions performed for each jbutton pressed.
	 * Actions for "=" - solves the expression.
	 * 			"AC" - clears the display and sets expression to ""
	 * 			"Ans" - concatenates the last answer to expression
	 */
	public void actionPerformed(ActionEvent arg0) {
		String command = arg0.getActionCommand();
		if (command == "=") {
			display.clear();
			Evaluation e = new Evaluation(expression);
			String answer = e.evaluate();
			display.showValue(answer);
			savedAns = answer;
			expression = "";
		}
		
		//if operator is first button pressed in expression, 
		//last answer is added to beginning of expression
		else if (command =="*" || command =="/" || command=="+"
				|| command =="-" && expression.equals("")) {
			expression+=savedAns + command;
		}
		
		//clears if ac pressed
		else if (command == "AC") {
			display.clear();
			expression = "";
			
		}
		
		//shows last answer and adds to expression if ans pressed
		else if (command == "Ans") {
			display.showValue(savedAns);
			expression+=savedAns;
		}
		
		else {
			expression += command;
			display.showValue(expression);
		}

	}
}
