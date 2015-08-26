package in.witsolapur.sysproapp;
import in.witsolapur.sysproapp.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WordmatchLoader extends Activity implements OnClickListener {
	
	  EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wordmatch_loader1);

		Button btn1 = (Button)findViewById(R.id.button1);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button3);
        Button btn4 = (Button)findViewById(R.id.button4);
        Button btn5 = (Button)findViewById(R.id.button5);
        Button btn6 = (Button)findViewById(R.id.button6);
        Button btn7 = (Button)findViewById(R.id.button7);
        Button btn8 = (Button)findViewById(R.id.button8);
        Button btn9 = (Button)findViewById(R.id.button9);
        Button btn10 = (Button)findViewById(R.id.button10);
        Button btn11 = (Button)findViewById(R.id.button11);
        Button btn12 = (Button)findViewById(R.id.button12);
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
               
		
		
		e1 = (EditText) findViewById(R.id.editText1);
		e2 = (EditText)findViewById(R.id.editText2);
		e3 = (EditText)findViewById(R.id.editText3);
		e4 = (EditText)findViewById(R.id.editText4);
		e5 = (EditText) findViewById(R.id.editText5);
		e6 =(EditText) findViewById(R.id.editText6);
		e7 = (EditText) findViewById(R.id.editText7);
		e8 = (EditText)findViewById(R.id.editText8);
		e9 = (EditText)findViewById(R.id.editText9);
		e10 = (EditText)findViewById(R.id.editText10);
		e11 = (EditText)findViewById(R.id.editText11);
		e12 = (EditText)findViewById(R.id.editText12);

	}



	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			String  a =  e1.getText().toString();
			if(a.equals("b"))
			{
				Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(this, " Wrong Answer", Toast.LENGTH_SHORT).show();
			}
			break;
			
		case R.id.button2:
			String b =  e2.getText().toString();
			if(b.equals("g"))
			{
				Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(this, " Wrong Answer", Toast.LENGTH_SHORT).show();
			}
			
			break;
		case R.id.button3:
			
			
			String c =  e3.getText().toString();
			if(c.equals("d"))
			{
				Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(this, " Wrong Answer", Toast.LENGTH_SHORT).show();
			}
			
			break;
			
		case R.id.button4:
			
			
			String d =  e4.getText().toString();
			if(d.equals("k"))
			{
				Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(this, " Wrong Answer", Toast.LENGTH_SHORT).show();
			}
			
			break;
		case R.id.button5:
			
			
			String e =  e5.getText().toString();
			if(e.equals("i"))
			{
				Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(this, " Wrong Answer", Toast.LENGTH_SHORT).show();
			}
			
			
			break;
			
			
		case R.id.button6:
			String f =  e6.getText().toString();
			if(f.equals("l"))
			{
				Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(this, " Wrong Answer", Toast.LENGTH_SHORT).show();
			}
	
			break;
			
		case R.id.button7:
			String g =  e7.getText().toString();
			if(g.equals("j"))
			{
				Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(this, " Wrong Answer", Toast.LENGTH_SHORT).show();
			}
		
			break;	
	
	
		case R.id.button8:
			String h =  e8.getText().toString();
			if(h.equals("e"))
			{
				Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(this, " Wrong Answer", Toast.LENGTH_SHORT).show();
			}
			
			break;
	
	
	
		case R.id.button9:
			String i =  e9.getText().toString();
			if(i.equals("a"))
			{
				Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(this, " Wrong Answer", Toast.LENGTH_SHORT).show();
			}
	
			break;
	
	
		case R.id.button10:
			String j =  e10.getText().toString();
			if(j.equals("h"))
			{
				Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(this, " Wrong Answer", Toast.LENGTH_SHORT).show();
			}
				
			break;
	
	
		case R.id.button11:
			String k =  e11.getText().toString();
			if(k.equals("c"))
			{
				Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(this, " Wrong Answer", Toast.LENGTH_SHORT).show();
			}
				
			break;
	
	
		case R.id.button12:
			String l =  e12.getText().toString();
			if(l.equals("f"))
			{
				Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(this, " Wrong Answer", Toast.LENGTH_SHORT).show();
			}
			
			
			break;
	

			
		}
		
	}

	
			
				
				
}

	
