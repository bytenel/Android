package com.example.four.func.calc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;
import android.graphics.Color;

public class MainActivity extends Activity {
public String resultStr;
public String prevAnswr;
public EditText resultbox;
public Calc calculator;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		calculator = new Calc();
		
		//main layout
		LinearLayout layout = new LinearLayout(this);

		layout.setOrientation(LinearLayout.VERTICAL);  
	    layout.setLayoutParams(
	    		new LayoutParams(LayoutParams.FILL_PARENT,
	    						 LayoutParams.FILL_PARENT)); 
	    layout.setBackgroundColor(Color.BLACK);
	    
		//upper result box and current opr box container
		LinearLayout upper = new LinearLayout(this);
		
		upper.setOrientation(LinearLayout.HORIZONTAL);
		upper.setLayoutParams(
				new LayoutParams(LayoutParams.WRAP_CONTENT,
								 LayoutParams.WRAP_CONTENT));
		upper.setGravity(Gravity.TOP);
		//add the upper layout to the main layout
		layout.addView(upper);
		
		//result box
		resultbox = new EditText(this);
		resultbox.setEnabled(false);
		resultbox.setText(resultStr);
		upper.addView(resultbox);
		
		//middle tier layout
		LinearLayout middle = new LinearLayout(this);

		middle.setOrientation(LinearLayout.HORIZONTAL);  
	    middle.setLayoutParams(
	    		new LayoutParams(LayoutParams.WRAP_CONTENT,
	    						 LayoutParams.WRAP_CONTENT));  
	    
		//bottom button grid (numbers 0-9)
		TableLayout grid = new TableLayout(this);
		TableRow[] rows = new TableRow[5];
		
		int rownum = 0;
		for(int i = 0; i <= 12; i++)
		{
			//add a new row to the grid
			if( (i) % 3 == 0 || i == 0)
			{
				if(i != 0)
					rownum = (i)/3;
				else
					rownum = 0;
				
				rows[rownum] = new TableRow(this);
				//TODO: setup row params here
				grid.addView(rows[rownum]);
			}
			
			Button bttn = new Button(this);
			if (i < 10) {
				// integers
				bttn.setText(Integer.toString(i));
				final int _i = i;
				bttn.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						// set it so the click changes the string that
						// you send in the parser and changes the upper textbox
						if(resultStr != null && resultStr != "")
							resultStr = resultStr+Integer.toString(_i);
						else
							resultStr = Integer.toString(_i);
			    		resultbox.setText(resultStr);		
					}
				});
			} else if (i == 10) {
				// prev answer bttn
				bttn.setText(".");
				bttn.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						// set it so the click changes the string that
						// you send in the parser and changes the upper textbox
						if(resultStr != null && resultStr != "")
							resultStr = resultStr+".";
						else
							resultStr = ".";
						
			    		resultbox.setText(resultStr);	
					}
				});
			} else if (i == 11)
			{
				
				bttn.setText("Clear");
				bttn.setOnClickListener(new OnClickListener(){
				    public void onClick(View v) {
				    		//Clear the result string
				    		resultStr = "";
				    		resultbox.setText("");
			           }
				});				
			}
			else{
				// prev answer bttn
				bttn.setText("Ansr");
				bttn.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						// set it so the click changes the string that
						// you send in the parser and changes the upper textbox
						resultStr = prevAnswr;
			    		resultbox.setText(resultStr);	
					}
				});
			}	
			rows[rownum].addView(bttn);
		}
		middle.addView(grid);
		
		/*side button grid (+, -, =, parenthesis, * and %)*/
		LinearLayout rightside = new LinearLayout(this);
		
		rightside.setHorizontalGravity(RelativeLayout.ALIGN_PARENT_RIGHT);
		rightside.setVerticalGravity(RelativeLayout.CENTER_IN_PARENT);
	    rightside.setLayoutParams(
	    		new LayoutParams(LayoutParams.WRAP_CONTENT,
	    						 LayoutParams.WRAP_CONTENT));  
	    rightside.setOrientation(LinearLayout.VERTICAL);  
	    
		Queue<String> rightSymbols = new LinkedList<String>();
		String[] symbols = {"+","-","*","/","(",")"};
		List<String> l_symbols = Arrays.asList(symbols);
		rightSymbols.addAll(l_symbols);
		
		while(!rightSymbols.isEmpty())
		{
			final String symbol = rightSymbols.poll();
			Button bttn = new Button(this);
			bttn.setText(symbol);
			bttn.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					// TODO add the symbol to the string for submission into the parser
					if(resultStr != null && resultStr != "")
						resultStr = resultStr+symbol;
					else
						resultStr = symbol;
		    		resultbox.setText(resultStr);			
				}
			});
			rightside.addView(bttn);
		}
		middle.addView(rightside);
		
		//= button, on a bottom bar
		LinearLayout bottom = new LinearLayout(this);
		bottom.setOrientation(LinearLayout.HORIZONTAL);  
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
		            LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	    bottom.setLayoutParams(params);  
	    
	    bottom.setBackgroundColor(Color.BLUE);
	 

		Button eqbttn = new Button(this);
		LinearLayout.LayoutParams eqparams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		eqbttn.setLayoutParams(eqparams);
		eqbttn.setText("=");
		eqbttn.setOnClickListener(new OnClickListener(){
		    public void onClick(View v) {
		    		//send information to parser and return result as textbox string
		    		try {
		    			String result = calculator.createResult(resultStr);
						resultbox.setText(result);
						resultStr = result;
						prevAnswr = result;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						resultbox.setText(e.getMessage());
					}
	           }
		});
		bottom.addView(eqbttn);

		layout.addView(middle);
		layout.addView(bottom);
		
		setContentView(layout);
	}
	
}
