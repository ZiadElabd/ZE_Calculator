/**
 * 
 */
package com.ZECalculator.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ZECalculator.service.Calculator;
/**
 * 
 * @author ZiadElabd
 *
 */
@CrossOrigin(origins="http://localhost:8080")
@RestController
public class CalculatorController {
	
	@GetMapping("/{num1}/{operation}/{num2}")
	public double operation(@PathVariable double num1 ,@PathVariable String operation ,@PathVariable double num2) {
		return Calculator.operation(num1, operation, num2);
	}
	
	@GetMapping("/{num}/{operation}")
	public double single_operation(@PathVariable double num ,@PathVariable String operation ) {
		return Calculator.single_operation(num, operation);
	}
}
