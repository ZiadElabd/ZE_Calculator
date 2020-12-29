/**
 * 
 */
package com.ZECalculator.service;

/**
 * @author Ziad Elabd
 *
 */
public class Calculator {
	
	public static double operation(double numOne , String operation , double numTwo) {
		if(operation.equals("+"))
			return numOne + numTwo;
		else if(operation.equals("-"))
			return numOne - numTwo;
		else if(operation.equals("*"))
			return numOne * numTwo;
		else if(operation.equals("div"))
			return numOne / numTwo;
		else if(operation.equals("mod"))
			return numOne % numTwo;
		return Double.MAX_VALUE;
	}
	
	public static double single_operation(double num , String operation) {
		if(operation.equals("pow"))
			return Math.pow(num, 2);
		else if(operation.equals("sqrt"))
			return Math.sqrt(num);
		else if(operation.equals("inverse"))
			return 1/num;
		return Double.MAX_VALUE;
	}

}
