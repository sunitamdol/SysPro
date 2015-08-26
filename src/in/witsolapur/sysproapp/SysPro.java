package in.witsolapur.sysproapp;


import in.witsolapur.sysproapp.HomeActivity;
import in.witsolapur.sysproapp.SplashActivity;
import in.witsolapur.sysproapp.R;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SysPro extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);
new Handler().postDelayed(new Runnable() {
			
			
			public void run() {
				Intent intent=new Intent(SysPro.this,HomeActivity.class);
				startActivity(intent);
				finish();
			}
		}, 2000);
	}
	//	Intent i=new Intent(DemoActivity.this,HomeActivity.class);
		//startActivity(i);
	//}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_demo, menu);
		return true;
	}

}
