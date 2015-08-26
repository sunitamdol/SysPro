package in.witsolapur.sysproapp;

import in.witsolapur.sysproapp.HomeActivity;
import in.witsolapur.sysproapp.R;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;

@SuppressLint("NewApi")
public class HelpActivity extends Activity {
	
	WebView wv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help1);
		
		
		wv=(WebView)findViewById(R.id.wv);
		wv.loadUrl("file:///android_res/raw/help.html");
		
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent i=new Intent(getApplicationContext(),HomeActivity.class);
		startActivity(i);
		
	}
		
}
