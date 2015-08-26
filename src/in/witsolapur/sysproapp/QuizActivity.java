package in.witsolapur.sysproapp;

import in.witsolapur.sysproapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class QuizActivity extends Activity {
	Button test;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_quiz);
	
	test=(Button) findViewById(R.id.strttest);
	test.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(getApplicationContext(),QuestionsActivity.class);
			startActivity(i);
		}
	});
	
	
}
}
