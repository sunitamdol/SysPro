package in.witsolapur.sysproapp;

import in.witsolapur.sysproapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.R.color;
import android.R.integer;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;






import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;



public class NavigationActivity extends FragmentActivity {
  
	ImageView home;
	Fragment fragment = null;
	TextView appname;
	ExpandableListView expListView;
	HashMap<String, List<String>> listDataChild;
	
	List<String> listDataHeader;
	String id;
	String name;
	InputStream is=null;
	String result=null;
	String line=null;
	String sss="";
	String subcategory="";
	String catname="";
	TextView resultView;
	String name1;
	String imageseperator="";
	String Discountsaperator=""; 
	ImageButton login,area;
	Bitmap bitmap[]=new Bitmap[100];
	String ss;
	String idis1,ansis;
	String[][] itemidis;
	private LinearLayout myLInearLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		String fontPath = "fonts/Shadow Boxing.ttf";
		setContentView(R.layout.activity_navigation);
		 // Toast.makeText(NavigationActivity.this,"Start",Toast.LENGTH_LONG).show();
		
		itemidis=new String[30][30];
//Toast.makeText(NavigationActivity.this,"Baher"+imageseperator,Toast.LENGTH_LONG).show();


	       
	        name1 = "3";
	        
	    
	        myLInearLayout =(LinearLayout) findViewById(R.id.linearlayout12);
		   try {
				new ins().execute("http://localhost/DiscountDeal/Shopkeeper.php").get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  // Toast.makeText(NavigationActivity.this,"In"+imageseperator,Toast.LENGTH_LONG).show();
       	
		   try
		   {
			   //Typeface tf = Typeface.createFromAsset(this.getAssets(), fontPath);
				//appname.setTypeface(tf);
				String[] separated = sss.split("#");
				 
		  	     int xx=0;
		  	  Button  bb[] = new Button[100];
		  	final  	 EditText  e1[] = new EditText[100];
		  	ImageView img[]=new ImageView[100];
		  	 TableLayout tv=(TableLayout) findViewById(R.id.table);
			tv.removeAllViewsInLayout();
			int x=0;
			int ll=0;
			
				for (String item : separated)
				{
					String abcd=item;
					String[] separated1 = abcd.split(",");
					final  TableRow tr=new TableRow(NavigationActivity.this);
					 tr.setLayoutParams(new LayoutParams(
		                      LayoutParams.FILL_PARENT,
		                      LayoutParams.WRAP_CONTENT));
					 int cnt=0;
					  e1[xx]=new EditText(NavigationActivity.this);
				 	 	
				 	 	//b.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
						 e1[xx].setTextSize(15);
						 e1[xx].setId(Integer.parseInt(separated1[0]));
				    	 
				    	 tr.addView(e1[xx]);	
					for (String item1 : separated1)
					{
						
							TextView b=new TextView(NavigationActivity.this);
					 	 	 b.setText(item1);
					 	 	b.setTextColor(Color.rgb(46,139,87));
					 	 	//b.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
					    	 b.setTextSize(15);
					    	 b.setId(999);
					    	 b.setTypeface(null, Typeface.BOLD);
					    	 tr.addView(b);	
						
						
					}
					 int id=Integer.parseInt(separated1[0]);
					 bb[xx]=new Button(NavigationActivity.this);
					 bb[xx].setText("Ok");
					 bb[xx].setId(Integer.parseInt(separated1[0]));
					 tr.addView(bb[xx]);
					x++;
					 bb[xx].setOnClickListener(new OnClickListener() {
						
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							idis1=arg0.getId()+"";
							//String ab=xx;
							//ansis=e1[ab].getText()+"";
							//   Toast.makeText(getApplicationContext(),"after"+a , Toast.LENGTH_LONG).show();
							   try {
									new ins1().execute("http://localhost/DiscountDeal/Shopkeeper.php").get();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (ExecutionException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
						}
					});
		        tv.addView(tr);
		        final View vline1 = new View(NavigationActivity.this);
				   vline1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 1));
				   vline1.setBackgroundColor(Color.rgb(105,105,105));
				   tv.addView(vline1);		
		   	 
				   
				   xx=xx+1;
				} 
		   }
		   catch(Exception e)
		   {
			   Toast.makeText(this,"in try"+e.toString(), Toast.LENGTH_LONG).show();
				
		   }
		
	}



	 class ins extends AsyncTask<String, Integer, String>
		{
	    	
	    	@Override
			protected String doInBackground(String... arg0) {
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

		    	try
		    	{
				HttpClient httpclient = new DefaultHttpClient();
			        HttpPost httppost = new HttpPost("http://enotice.newsoft.co.in/match.php");
			        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			        HttpResponse response = httpclient.execute(httppost); 
			        HttpEntity entity = response.getEntity();
			        is = entity.getContent();
			        Log.e("pass 1", "connection success ");
			}
		        catch(Exception e)
			{
		        	Log.e("Fail 1", e.toString());
			    	
			}     
		        
		        try
		        {
		        		BufferedReader reader = new BufferedReader
						(new InputStreamReader(is,"iso-8859-1"),8);
		            	StringBuilder sb = new StringBuilder();
		            	while ((line = reader.readLine()) != null)
				{
		       		    sb.append(line + "\n");
		           	}
		            	is.close();
		            	result = sb.toString();
		            	
			        Log.e("pass 2", "connection success ");
			}
		        catch(Exception e)
		    	{
				Log.e("Fail 2", e.toString());
			}     
		       
		   	try
		    	{
		   		JSONArray jArray = new JSONArray(result);
		   		for(int i=0; i<jArray.length();i++)
		   		{
		   		 
		   			JSONObject json = jArray.getJSONObject(i);
		   			 
		   			sss += json.getString("ID")+","+json.getString("Question")+","+json.getString("Option")+"#"; 
		   			
		   		}
		   			 
		   		
		       
				
		    	}
		        catch(Exception e)
		    	{
		        	Log.e("Fail 3", e.toString());
		    	}
				// TODO Auto-generated method stub
		   	return "nn";
			}
			 protected void onPostExecute(Long result) {
				 Log.e("in Post ", "hiii");
				 //Toast.makeText(getApplicationContext(), "Invalid IP Address",
							//Toast.LENGTH_LONG).show();
		     }
	    	
		}

	 class ins1 extends AsyncTask<String, Integer, String>
		{
	    	
	    	@Override
			protected String doInBackground(String... arg0) {
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("Id", idis1));
				nameValuePairs.add(new BasicNameValuePair("Id", ansis));
		    	try
		    	{
				HttpClient httpclient = new DefaultHttpClient();
			        HttpPost httppost = new HttpPost("http://enotice.newsoft.co.in/check.php");
			        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			        HttpResponse response = httpclient.execute(httppost); 
			        HttpEntity entity = response.getEntity();
			        is = entity.getContent();
			        Log.e("pass 1", "connection success ");
			}
		        catch(Exception e)
			{
		        	Log.e("Fail 1", e.toString());
			    	
			}     
		        
		        try
		        {
		        		BufferedReader reader = new BufferedReader
						(new InputStreamReader(is,"iso-8859-1"),8);
		            	StringBuilder sb = new StringBuilder();
		            	while ((line = reader.readLine()) != null)
				{
		       		    sb.append(line + "\n");
		           	}
		            	is.close();
		            	result = sb.toString();
		            	
			        Log.e("pass 2", "connection success ");
			}
		        catch(Exception e)
		    	{
				Log.e("Fail 2", e.toString());
			}     
		       
		   	try
		    	{
		   		JSONArray jArray = new JSONArray(result);
		   		for(int i=0; i<jArray.length();i++)
		   		{
		   		 
		   			JSONObject json = jArray.getJSONObject(i);
		   			 
		   			sss += json.getString("ID")+","+json.getString("Question")+","+json.getString("Option")+"#"; 
		   			
		   		}
		   			 
		   		
		       
				
		    	}
		        catch(Exception e)
		    	{
		        	Log.e("Fail 3", e.toString());
		    	}
				// TODO Auto-generated method stub
		   	return "nn";
			}
			 protected void onPostExecute(Long result) {
				 Log.e("in Post ", "hiii");
				 //Toast.makeText(getApplicationContext(), "Invalid IP Address",
							//Toast.LENGTH_LONG).show();
		     }
	    	
		}
	 
	    
}
