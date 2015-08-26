package in.witsolapur.sysproapp;



import in.witsolapur.sysproapp.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ExitActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exit);
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ExitActivity.this);
	     
		 alertDialogBuilder.setTitle(this.getTitle()+ " decision");
		 alertDialogBuilder.setMessage("Are you sure?");
		 // set positive button: Yes message
		 alertDialogBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// go to a new activity of the app
finish();
				}
			  });
		 
		// set negative button: No message
				 alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							// cancel the alert box and put a Toast to the user
							dialog.cancel();
							//Toast.makeText(getApplicationContext(), "You chose a negative answer", 
								//	Toast.LENGTH_LONG).show();
						}
					});
	}

}
