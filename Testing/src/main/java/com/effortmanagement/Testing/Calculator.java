package com.effortmanagement.Testing;

public class Calculator {

	public Calculator() {
		
	}

	public double plus(double param1, double param2){
		return param1 + param2;
	}
	
	public double minus(double param1, double param2){
		return param1 - param2;
	}
	
	public double multi(double param1, double param2){
		return param1 * param2;
	}
	
	public double divide(double param1, double param2){
		if (param2==0){
			throw new ArithmeticException("Teilen durch 0 nicht erlaubt");
		}
		return param1 / param2;
	}
	
	public double square(double param1, double param2){
		return Math.pow(param1, param2);
	}
	
	public double squareRoot(double param1){
		if(param1<0){
			throw new ArithmeticException("Wurzel von negativen Zahlen nicht erlaubt");
		}
		return Math.sqrt(param1);
	}
	
}
