package in.witsolapur.sysproapp;

import in.witsolapur.pojo.Question;
import in.witsolapur.sysproapp.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import android.annotation.SuppressLint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("NewApi")
public class FinishActivity extends Activity {
TextView tq,ta,tc,ts;


	private ArrayList<Question> questions;
	HashMap<Integer, Integer> hm;
	Question q;
	int s=0;
	String ans;
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_finish);
		questions=(ArrayList<Question>) getIntent().getExtras().get("questions");
		hm=(HashMap<Integer, Integer>) getIntent().getExtras().get("hm");
		Log.i("question",questions.toString());
		Log.i("hm",hm.toString());
		
		tq = (TextView)findViewById(R.id.tq);
		ta = (TextView)findViewById(R.id.ta);
		tc = (TextView)findViewById(R.id.tc);
		ts = (TextView)findViewById(R.id.ts);

		
		for(int i=0;i<questions.size();i++)
		{
			q=questions.get(i);
			Log.i("question",q.getQno()+" "+q.getAns());
		//	ans=hm.get(q.getQno()).toString();
			if(hm.containsKey(q.getQno()))
			{
				Log.i("a","found answer"+hm.get(q.getQno()));
				
				if(q.getAns().equals(hm.get(q.getQno()))){
					
					
					Log.i("a","found correct answer");
					s++;
				}
			}
		}
		
		Log.i("a","Total marks"+s);
		
		tq.setText("Total No of questions:"+questions.size());
		ta.setText("Total Attempted:"+hm.size());
		tc.setText("Total Correct:"+s);
		ts.setText("Total Score:"+s);
		
		
		
	
		
		
		
	}
	
	
	
	
	
}
