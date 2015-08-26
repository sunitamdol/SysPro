package in.witsolapur.sysproapp;

import in.witsolapur.sysproapp.HelpActivity;
import in.witsolapur.sysproapp.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings.System;
import android.view.View;
import android.webkit.WebView;

public class HomeActivity extends Activity {
	
	WebView wv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		File w=new File("sdcard/SysPro");
		w.mkdirs();
		String filename="";
		File of=new File(w,filename);
		try {
			FileOutputStream fos=new FileOutputStream(of);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onClick(View v){
		Intent intent=new Intent(HomeActivity.this, FeatureActivity.class);
		
		
		switch (v.getId()) {
		case R.id.btnLP:
			intent.putExtra("feature", "LP");
			break;
		case R.id.btnAss:
			intent.putExtra("feature", "Assembler");
			break;
		case R.id.btnMac:
			intent.putExtra("feature", "Mac");
			break;
			
		case R.id.btnCom:
			intent.putExtra("feature", "Com");
			break;
			
		case R.id.btnLin:
			intent.putExtra("feature", "Lin");
			break;
			
		case R.id.btnloa:
			intent.putExtra("feature", "Loa");
			break;
			
		case R.id.btnHel:
			Intent i=new Intent(getApplicationContext(),HelpActivity.class);
			startActivity(i);
		
			
			
			
		case R.id.btnExi:
			finish();
			java.lang.System.exit(0);
				
		
		}

		
		startActivity(intent);
	}
	
	
	

	
}
