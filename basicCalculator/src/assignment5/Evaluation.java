package assignment5;

import java.util.ArrayList;
import java.util.Stack;


/**
 * @author Ryan
 *This class is used to take in an expression, convert it
 *to postfix with the postfix method and then solved with the
 *solve method.
 */
public class Evaluation {

	private String expression;
	Stack<String> priority = new Stack<String>();
	ArrayList<String> operands = new ArrayList<String>();
	ArrayList<String> operators = new ArrayList<String>();

	
	
	/**
	 * Evaluation constructor.
	 * @param exp - expression
	 * 
	**/
	public Evaluation (String exp) {
		this.expression = exp;		
	}
	
	
	
	/**
	 * Evaluate method sends the expression to postfix
	 * method, then that postfix to be solved in the
	 * solve method.
	 * 
	 * @return - final solved answer
	**/
	public String evaluate() {
		String[] postfix = postfix(this.expression);
		double answer = solve(postfix);
		String stringAnswer = Double.toString(answer);
		
	return stringAnswer;
	}
	
	
	
	/**
	 * This method takes in the expression
	 * and converts it to postfix in the form of an array.
	 * 
	 * @param exp - expression
	 * @return postfix array
	**/
	public String[] postfix(String exp) {
		System.out.println("The expression is: " + exp);
		String[] result = exp.split("(?<=[-+*/])|(?=[-+*/])");
		int count = 0;
		String[] postArray = new String[result.length];
		
		for (int i = 0 ; i<result.length ; i++) {
			String item = result[i];
			//if not an operator, item added to array
			
			if (!isOperator(item)) {
				postArray[count]=item;
				count++;
			}
			
			//if equals operator and stack is empty, push to stack
			else if (isOperator(item) && priority.empty()==true) {

				priority.push(item);
			}
			
			//if equals operator and stack is not empty, compare operators
			else if (isOperator(item) && priority.empty()==false) {
				
				if (priority.peek().equals("*") || priority.peek().equals("/") &&
						item.equals("+") || item.equals("-")) {
					
					String pop = priority.pop();
					postArray[count] = pop;
					priority.push(item);
					count++;
				}
				
				else {
					priority.push(item);
				}	
			}
		}
		
		while (priority.empty()==false) {
			String pop = priority.pop();
			postArray[count] = pop;
			count++;
		}
		
		System.out.println("The expression in postfix is: " +java.util.Arrays.toString(postArray));
		return postArray;
	}
	
	
	
	/**
	 * This method takes in a string and 
	 * determines whether it is an operator or not.
	 * 
	 * @param s - number or operator string
	 * @return true if string is an operator, false if it is a number
	 */
	private static boolean isOperator(String s) {
		return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
	}
	
	
	
	/**
	 * This solve method takes in the postfix array,
	 * iterates through it is solved with the help of
	 * a stack of doubles. Method ends once the stack 
	 * down to one value.
	 * 
	 * @param in - postfix array
	 * @return finalAnswer - item left in the stack of one
	 */
	private double solve(String[] in) {
		
		Stack<Double> temp = new Stack<Double>();
		
		for (int i = 0 ; i<in.length ; i++) {
			/*
			 * numbers added to stack until the item is an operator
			 */
			if (!isOperator(in[i])) {
				double item = Double.parseDouble(in[i]); //converted to double to solve
				
				temp.push(item);
			}
			/*
			 * once the item is an operator, the previous two
			 * items are solved corresponding to the operator symbol
			 * and re-added to the stack
			 */
			else {
				double num2 = temp.pop();
				double num1 = temp.pop();
				String op = in[i];
				
				if (op.equals("+")) {
					temp.push(num1 + num2);
				} else if (op.equals("-")) {
					temp.push(num1 - num2);
				} else if (op.equals("*")) {
					temp.push(num1 * num2);
				} else {
					temp.push(num1 / num2);
				}
			}
		}
		double finalAnswer = temp.pop();
		System.out.println("The expression solved equals: " + finalAnswer);
		return finalAnswer;
	}
} 
