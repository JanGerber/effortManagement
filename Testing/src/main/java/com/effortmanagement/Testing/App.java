package com.effortmanagement.Testing;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
    	Scanner input = new Scanner(System.in);
    	Calculator calc = new Calculator();
    	
       while (true){
    	String operator;
    	double param1, param2, result;
    	System.out.println( "Rechenoperation eingeben:" );
    	operator = input.nextLine();
    	System.out.println( "Erster Parameter eingeben:" );
    	param1 = input.nextDouble();
    	System.out.println( "Zweiten Parameter eingeben:" );
    	param2 = input.nextDouble();
    	
    	if(operator.equals("+")){ 
    		result = calc.plus(param1, param2);
    		System.out.println("Ergebnis:" + result);
    		
    	}else if(operator.equals("*")){
    		result = calc.multi(param1, param2);
    		System.out.println("Ergebnis:" + result);
    		
    	}else if(operator.equals("/")){
    		result = calc.divide(param1, param2);
    		System.out.println("Ergebnis:" + result);
    		
    	}else if(operator.equals("-")){
    		result = calc.minus(param1, param2);
    		System.out.println("Ergebnis:" + result);
    		
    	}else if(operator.equals("^")){
    		result = calc.square(param1, param2);
    		System.out.println("Ergebnis:" + result);
    	}else {
    		System.out.println("Fehler!");
    	}
    	
       }
       
    }
    
    
}
