package in.witsolapur.sysproapp;

import in.witsolapur.pojo.Question;
import in.witsolapur.sysproapp.R;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.util.*;


public class QuestionsActivity extends Activity {
	String file_name = "";
	HashMap<Integer, Integer> hm;
	Button pr, nxt;
	RadioButton o1, o2, o3, o4;
	RadioGroup studentans;
    private int index;

	TextView tv1,ansres,crc;
	String feature="";
	private ArrayList<Question> questions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_questions);

 feature = getIntent().getExtras().getString("feature");

		o1 = (RadioButton) findViewById(R.id.op1);
		o2 = (RadioButton) findViewById(R.id.op2);
		o3 = (RadioButton) findViewById(R.id.op3);
		o4 = (RadioButton) findViewById(R.id.op4);
		studentans = (RadioGroup) findViewById(R.id.studentans);

		hm = new HashMap<Integer, Integer>();

		pr = (Button) findViewById(R.id.btnprev);
		nxt = (Button) findViewById(R.id.btnnext);

		tv1 = (TextView) findViewById(R.id.txt1);
		ansres=(TextView) findViewById(R.id.ansres);
		crc=(TextView) findViewById(R.id.crc);

		o1.setSelected(true);
		try {
			questions = loadQuestion();
			if (questions.size() == 0) {
				Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
				return;
			}
			index = 0;
			bindData();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * pr.setOnClickListener(new OnClickListener() {
	 * 
	 * @Override public void onClick(View arg0) { int selIndex = 0; if (index ==
	 * 0) { Toast.makeText(getApplicationContext(), "First question",
	 * 1000).show(); } else { index--; bindData();
	 */
	/*
	 * boolean flag = false; switch (studentans.getCheckedRadioButtonId()) {
	 * case R.id.op1: selIndex = 1; flag = true; break; case R.id.op2: selIndex
	 * = 2; flag = true; break;
	 * 
	 * case R.id.op3: selIndex = 3; flag = true; break;
	 * 
	 * case R.id.op4: selIndex = 4; flag = true; break;
	 * 
	 * default: break; } if (flag) { hm.put(index + 1, selIndex);
	 * 
	 * Toast.makeText(getApplicationContext(), "Answer stored", 1000).show(); }
	 */
	// }
	//
	// }
	// });

	/*
	 * nxt.setOnClickListener(new OnClickListener() {
	 * 
	 * 
	 * 
	 * @Override public void onClick(View arg0) { // Boolean checked =
	 * ((RadioButton) arg0).isChecked();
	 */

	/*
	 * if (hm.containsKey(index+1)) { int selecteIndex=hm.get(index+1);
	 * Log.i("tag", "selected previoualy "+selecteIndex);
	 * ((RadioButton)studentans.getChildAt(selecteIndex-1)).setSelected(true);
	 * //Toast.makeText(getApplicationContext(), //"Question attempted",
	 * Toast.LENGTH_SHORT).show(); } else {
	 * 
	 * //studentans.clearCheck(); //Toast.makeText(getApplicationContext(), //
	 * "Question not attempted", Toast.LENGTH_SHORT) // .show(); }
	 */
	/*
	 * boolean flag = false; switch (studentans.getCheckedRadioButtonId()) {
	 * 
	 * case R.id.op1: selIndex = 1; flag = true; break; case R.id.op2: selIndex
	 * = 2; flag = true; break;
	 * 
	 * case R.id.op3: selIndex = 3; flag = true; break;
	 * 
	 * case R.id.op4: selIndex = 4; flag = true; break;
	 * 
	 * default: break; }
	 * 
	 * // studentans.check(selIndex); if (flag) { hm.put(index + 1, selIndex);
	 * 
	 * Toast.makeText(getApplicationContext(), "Answer stored", 1000).show(); }
	 */
	/*
	 * if (index == questions.size() - 1) {
	 * Toast.makeText(getApplicationContext(), "Last question", 1000).show(); }
	 * else { index++; bindData(); studentans.clearCheck(); } Log.i("tag",
	 * "answers : " + hm.toString()); } });
	 */
	// }

	private void bindData() {
		Question q = questions.get(index);
		tv1.setText(q.getQno() + ") " + q.getQuestion());
		o1.setText(q.getOp1());
		o2.setText(q.getOp2());
		o3.setText(q.getOp3());
		o4.setText(q.getOp4());
		
			}

	public void onclick(View v) {
		
		switch (v.getId()) {

		case R.id.btnnext:
			o1.setClickable(true);
			o2.setClickable(true);
			o3.setClickable(true);
			o4.setClickable(true);


			if (index == questions.size() - 1) {
				Toast.makeText(getApplicationContext(), "Last question", 1000)
						.show();
			} else {
				index++;
				bindData();
				
			}
			
			break;
		case R.id.btnprev:
			o1.setClickable(false);
			o2.setClickable(false);
			o3.setClickable(false);
			o4.setClickable(false);

			if (index == 0) {
				Toast.makeText(getApplicationContext(), "First question", 1000)
						.show();
			} else {
				index--;
				bindData();
			}
			break;
			
		case R.id.btnfinish:
			Intent intent = new Intent(this, FinishActivity.class);
			intent.putExtra("questions", questions);
			intent.putExtra("hm", hm);
			
		Log.i("tag","student answers"+ hm.toString());
		
			startActivity(intent);
					
			break;
			
		default:
			break;
		}
		
		ansres.setText(" ");
		crc.setText("");
		studentans.clearCheck();
		int selecteIndex = 0;
		if (hm.containsKey(index + 1)) {
			selecteIndex = hm.get(index + 1);
			Log.i("tag", "selected previoualy " + selecteIndex);
			RadioButton rdb=((RadioButton) studentans.getChildAt(selecteIndex - 1));
			Log.i("tag","selected answer:"+ rdb.getText().toString());
			rdb.setChecked(true);
			if(selIndex==questions.get(index).getAns())
				
			{
				ansres.setText("ANSWER IS CORRECT");
			}
			else
			{
			 ansres.setText("WRONG ANSWER");
			 crc.setText("CORRECT ANSWER:"+questions.get(index).getAns().toString());
				
			}
		//	ansres.setText();
		//	crc.setText();
			
			// Toast.makeText(getApplicationContext(),
			// "Question attempted", Toast.LENGTH_SHORT).show();
		} else {

			Log.i("tag", "not selected  " + selecteIndex);
			studentans.clearCheck();
		}
		Log.i("tag", "answers : " + hm.toString());
	}
	int selIndex = 0;
	public void store(View v) {
		
		switch (v.getId()) {
		case R.id.op1:
			selIndex = 1;
			allow(selIndex);
			// Toast.makeText(getApplicationContext(), "Button 1 selected",
			// Toast.LENGTH_SHORT).show();
			break;
		case R.id.op2:
			selIndex = 2;
			allow(selIndex);
			// Toast.makeText(getApplicationContext(), "Button 2 selected",
			// Toast.LENGTH_SHORT).show();
			break;
		case R.id.op3:
			selIndex = 3;
			allow(selIndex);
			// Toast.makeText(getApplicationContext(), "Button 3 selected",
			// Toast.LENGTH_SHORT).show();
			break;
		case R.id.op4:
			selIndex = 4;
			allow(selIndex);
			// Toast.makeText(getApplicationContext(), "Button 4 selected",
			// Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}

		if(selIndex==questions.get(index).getAns())
			
		{
			ansres.setText("ANSWER IS CORRECT");
		}
		else
		{
		 ansres.setText("WRONG ANSWER");
		 crc.setText("CORRECT ANSWER:"+questions.get(index).getAns().toString());
			
		}
		Toast.makeText(getApplicationContext(), selIndex + " is selected",
				Toast.LENGTH_SHORT).show();
		hm.put(index + 1, selIndex);
		Log.i("ans:", "list : " + hm);
	}

	private void allow(int selIndex2) {
		// TODO Auto-generated method stub
		if(selIndex2==1){
			o1.setClickable(true);
			o2.setClickable(false);
			o3.setClickable(false);
			o4.setClickable(false);
			
		}
		else if(selIndex2==2){
			o1.setClickable(false);
			o2.setClickable(true);
			o3.setClickable(false);
			o4.setClickable(false);
		}
		else if(selIndex2==3){
			o1.setClickable(false);
			o2.setClickable(false);
			o3.setClickable(true);
			o4.setClickable(false);
		}
		else if(selIndex2==4){
			o1.setClickable(false);
			o2.setClickable(false);
			o3.setClickable(false);
			o4.setClickable(true);
		}
		
	}

	public ArrayList<Question> loadQuestion() throws FileNotFoundException {
	//String file_name = "";

		AssetManager assetManager = getAssets();
		InputStream in = null;

		String st;
		String[] parts = new String[7];

		ArrayList<Question> list = new ArrayList<Question>();
		try {
			
			if(feature.equals("Quiz_lp")){
				file_name="new.txt";
			}
			if(feature.equals("Quiz_assem")){
				file_name="asdf.txt";
			}
			
			if(feature.equals("Quiz_mac")){
				file_name="mnop.txt";
			}
			
			if(feature.equals("Quiz_com")){
				file_name="cmpl.txt";
			}
			
			if(feature.equals("Quiz_lnk")){
				file_name="lkr.txt";
			}	
			
			if(feature.equals("Quiz_ldr")){
				file_name="ldr.txt";
			}	
			
			in = assetManager.open(file_name);
			
	

			// File f=new File(getFilesDir(), file_name);
			// FileReader fr=new FileReader(f);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			while ((st = br.readLine()) != null) {
				parts = st.split("@");
				Question q = new Question();
				int p1=Integer.parseInt(parts[0]);
				int p2=Integer.parseInt(parts[6]);
				q.setQno(p1);
				q.setQuestion(parts[1]);
				q.setOp1(parts[2]);
				q.setOp2(parts[3]);
				q.setOp3(parts[4]);
				q.setOp4(parts[5]);
				q.setAns(p2);

				list.add(q);
				Log.i("question", "question-" + q.getQuestion());
				/*
				 * for(String s : parts) { System.out.println(s); }
				 */
		}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block

		}

		System.out.println("List : " + list);
		return list;

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_demo, menu);
		return true;
	}

}
