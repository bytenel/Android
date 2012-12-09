package com.example.four.func.calc;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;

//main logic for the calculator, all ran in the background
//uses the classes generated from our grammar Exp.g and the ANTLR library
//to parse the input string and return the result as a string
public class Calc {
	 public Calc()
	 {
		 
		 
	 }
	 
	 public String createResult(String expression) throws Exception {
	        ANTLRStringStream in = new ANTLRStringStream(expression);
	        ExpLexer lexer = new ExpLexer(in);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        ExpParser parser = new ExpParser(tokens);
	       // System.out.println(parser.eval());
	        return Double.toString(parser.eval());
	    }
}
