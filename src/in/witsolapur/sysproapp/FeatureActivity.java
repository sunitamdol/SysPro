package in.witsolapur.sysproapp;

import in.witsolapur.pojo.Question;
import in.witsolapur.sysproapp.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;


import net.sf.andpdf.pdfviewer.PdfViewerActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class FeatureActivity extends Activity {
	private static final String TAG = null;
	String feature="";
	WebView wv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feature);

		feature = getIntent().getExtras().getString("feature");
		Toast.makeText(this, feature + " is selected", Toast.LENGTH_SHORT)
				.show();
	}

	
	public void onclick(View v) throws FileNotFoundException, IOException {
		switch (v.getId()) {
		case R.id.imgnotes:

			openPDFActivity();

			break;

		case R.id.imgppt:
			
			openPptActivity();

			break;

		case R.id.imggames:
			
			
			Toast.makeText(this, feature + " games is selected",
					Toast.LENGTH_SHORT).show();
			
			openWord();
			
           	break;

		case R.id.imgquiz: openQuizActivity();
		   break;

		case R.id.imgqbank:openQBActivity();
		
			break; 

		}
	}

	private void openWord() {
		// TODO Auto-generated method stub
		Intent i3 = new Intent(FeatureActivity.this, GamesActivity.class);
		if (feature.equals("LP")) {
			file_name = "scramble_lp";
			i3.putExtra("file_name", "scramble_lp");
			
		}
		else if (feature.equals("Assembler"))  {
			file_name = "scramble_assem";
			i3.putExtra("file_name", "scramble_assem");
		}
		
		else if (feature.equals("Mac"))  {
			file_name = "scramble_mac";
			i3.putExtra("file_name", "scramble_mac");
		}
		
		else if (feature.equals("Com"))  {
			file_name = "scramble_com";
			i3.putExtra("file_name", "scramble_com");
		}
		else if (feature.equals("Lin"))  {
			file_name = "scramble_lnk";
			i3.putExtra("file_name", "scramble_lnk");

		}
		
		else if (feature.equals("Loa"))  {
			file_name = "scramble_ldr";
			i3.putExtra("file_name", "scramble_ldr");
		}
					
		startActivity(i3);
		
	}

	
	private void openQBActivity() {
		
		if (feature.equals("LP")) {
			file_name = "langprocessorbank.pdf";
		}

		else if (feature.equals("Assembler")) {
			file_name = "assemblerqbank.pdf";
		}

		else if (feature.equals("Mac")) {
			file_name = "macroqbank.pdf";
		}

		else if (feature.equals("Com")) {
			file_name = "compilerqbank.pdf";
		}

		else if (feature.equals("Lin")) {
			file_name = "linkerqbank.pdf";
		}

		else if (feature.equals("Loa")) {
			file_name = "loaderqbank.pdf";
		}
		
		

	    File fileBrochure = new File("/sdcard/SysPro/"+file_name);
	    if (!fileBrochure.exists())
	    {
	         CopyAssetsbrochure1();
	    } 

	    /** PDF reader code */
	    File file = new File("/sdcard/SysPro/"+file_name);        

	    Intent intent = new Intent(Intent.ACTION_VIEW);
	    intent.setDataAndType(Uri.fromFile(file),"application/pdf");
	    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    try 
	    {
	        getApplicationContext().startActivity(intent);
	    } 
	    catch (ActivityNotFoundException e) 
	    {
	         Toast.makeText(this, "NO Pdf Viewer", Toast.LENGTH_SHORT).show();
	    }
	}

	//method to write the PDFs file to sd card
	    private void CopyAssetsbrochure1()
	    {
	        AssetManager assetManager = getAssets();
	        String[] files = null;
	        try 
	        {
	            files = assetManager.list("");
	        } 
	        catch (IOException e)
	        {
	            Log.e("tag", e.getMessage());
	        }
	        for(int i=0; i<files.length; i++)
	        {
	            String fStr = files[i];
	            if(fStr.equalsIgnoreCase(file_name))
	            {
	                InputStream in = null;
	                OutputStream out = null;
	                try 
	                {
	                  in = assetManager.open(files[i]);
	                  out = new FileOutputStream("/sdcard/SysPro/" + files[i]);
	                  copyFile1(in, out);
	                  in.close();
	                  in = null;
	                  out.flush();
	                  out.close();
	                  out = null;
	                  break;
	                } 
	                catch(Exception e)
	                {
	                    Log.e("tag", e.getMessage());
	                } 
	            }
	        }
	    }

	 private void copyFile1(InputStream in, OutputStream out) throws IOException {
	        byte[] buffer = new byte[1024];
	        int read;
	        while((read = in.read(buffer)) != -1){
	          out.write(buffer, 0, read);
	        }
		
				
		
		// TODO Auto-generated method stub
		/*if (feature.equals("LP")) 
		{
			wv.loadUrl("file:///android_res/raw/lp_qbank.html");

		}
		else if (feature.equals("Assembler")) {
		
			wv.loadUrl("file:///android_res/raw/assem_qbank.html");
		}

		else if (feature.equals("Mac")) {
			
			wv.loadUrl("file:///android_res/raw/mac_qbank.html");
		}

		else if (feature.equals("Com")) {
			
			wv.loadUrl("file:///android_res/raw/comp_qbank.html");
		}

		else if (feature.equals("Lin")) {
			
			wv.loadUrl("file:///android_res/raw/link_qbank.html");

		}

		else if (feature.equals("Loa")) {
			file_name = "loaderqbank.pdf";
			wv.loadUrl("file:///android_res/raw/load_qbank.html");

		}*/

	}

	private void openPptActivity() {
		// TODO Auto-generated method stub
		if (feature.equals("LP")) 
		{
			
			file_name = "Chp1LP.pdf";
		}
		else if (feature.equals("Assembler")) {
			
			file_name = "Chp2Ass.pdf";
			
		}

		else if (feature.equals("Mac")) {
			
			file_name = "Chp3Macro.pdf";
		
		}

		else if (feature.equals("Com")) {
			file_name = "Chp4Compiler.pdf";
		}

		else if (feature.equals("Lin")) {
			file_name = "Chp5Linker.pdf";
		}

		else if (feature.equals("Loa")) {
			file_name = "Chp6Loaders.pdf";
		}

		 File fileBrochure = new File("/sdcard/SysPro/"+file_name);
		    if (!fileBrochure.exists())
		    {
		         CopyAssetsbrochures();
		    } 

		    /** Ppt reader code */
		    File file = new File("/sdcard/SysPro/"+file_name);        

		    Intent intent = new Intent(Intent.ACTION_VIEW);
		    intent.setDataAndType(Uri.fromFile(file),"application/pdf");
		    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		    try 
		    {
		        getApplicationContext().startActivity(intent);
		    } 
		    catch (ActivityNotFoundException e) 
		    {
		         Toast.makeText(this, "NO Ppt Viewer", Toast.LENGTH_LONG).show();
		    }
		}

		//method to write the Ppt file to sd card
		    private void CopyAssetsbrochures()
		    {
		        AssetManager assetManager = getAssets();
		        String[] files = null;
		        try 
		        {
		            files = assetManager.list("");
		        } 
		        catch (IOException e)
		        {
		            Log.e("tag", e.getMessage());
		        }
		        for(int i=0; i<files.length; i++)
		        {
		            String fStr = files[i];
		            if(fStr.equalsIgnoreCase(file_name))
		            {
		                InputStream in = null;
		                OutputStream out = null;
		                try 
		                {
		                  in = assetManager.open(files[i]);
		                  out = new FileOutputStream("/sdcard/SysPro/" + files[i]);
		                  copyFile1(in, out);
		                  in.close();
		                  in = null;
		                  out.flush();
		                  out.close();
		                  out = null;
		                  break;
		                } 
		                catch(Exception e)
		                {
		                    Log.e("tag", e.getMessage());
		                } 
		            }
		        }
		    }

		 private void copyFiles(InputStream in, OutputStream out) throws IOException {
		        byte[] buffer = new byte[1024];
		        int read;
		        while((read = in.read(buffer)) != -1){
		          out.write(buffer, 0, read);
		        }
		    }

		/*Intent i2 = new Intent(FeatureActivity.this, PptActivity.class);
		i2.putExtra("fileuri", file_name);
		startActivity(i2);
		Toast.makeText(this, feature + " ppt is selected", Toast.LENGTH_SHORT)
				.show();*/
	

	private String file_name = "";

	private void openPDFActivity() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		if (feature.equals("LP")) {
			file_name = "langproc.pdf";
		}

		else if (feature.equals("Assembler")) {
			file_name = "assembler.pdf";
		}

		else if (feature.equals("Mac")) {
			file_name = "macro.pdf";
		}

		else if (feature.equals("Com")) {
			file_name = "compiler.pdf";
		}

		else if (feature.equals("Lin")) {
			file_name = "linker.pdf";
		}

		else if (feature.equals("Loa")) {
			file_name = "loader.pdf";
		}
		
		

	    File fileBrochure = new File("/sdcard/SysPro/"+file_name);
	    if (!fileBrochure.exists())
	    {
	         CopyAssetsbrochure1();
	    } 

	    /** PDF reader code */
	    File file = new File("/sdcard/SysPro/"+file_name);        

	    Intent intent = new Intent(Intent.ACTION_VIEW);
	    intent.setDataAndType(Uri.fromFile(file),"application/pdf");
	    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    try 
	    {
	        getApplicationContext().startActivity(intent);
	    } 
	    catch (ActivityNotFoundException e) 
	    {
	         Toast.makeText(this, "NO Pdf Viewer", Toast.LENGTH_SHORT).show();
	    }
	}

	//method to write the PDFs file to sd card
	    private void CopyAssetsbrochure()
	    {
	        AssetManager assetManager = getAssets();
	        String[] files = null;
	        try 
	        {
	            files = assetManager.list("");
	        } 
	        catch (IOException e)
	        {
	            Log.e("tag", e.getMessage());
	        }
	        for(int i=0; i<files.length; i++)
	        {
	            String fStr = files[i];
	            if(fStr.equalsIgnoreCase(file_name))
	            {
	                InputStream in = null;
	                OutputStream out = null;
	                try 
	                {
	                  in = assetManager.open(files[i]);
	                  out = new FileOutputStream("/sdcard/SysPro/" + files[i]);
	                  copyFile1(in, out);
	                  in.close();
	                  in = null;
	                  out.flush();
	                  out.close();
	                  out = null;
	                  break;
	                } 
	                catch(Exception e)
	                {
	                    Log.e("tag", e.getMessage());
	                } 
	            }
	        }
	    }

	 private void copyFile(InputStream in, OutputStream out) throws IOException {
	        byte[] buffer = new byte[1024];
	        int read;
	        while((read = in.read(buffer)) != -1){
	          out.write(buffer, 0, read);
	        }
	    }
	/*	 AssetManager assetManager = getAssets();
		 
		 copyFile(this.getAssets().open(file_name),new FileOutputStream(new File(getFilesDir(),"/sdcard/"+file_name)));

		 File pdfFile = new File(getFilesDir(),"/sdcard/"+file_name); 
		 					Uri path = Uri.fromFile(pdfFile);
		                     Intent intent = new Intent(Intent.ACTION_VIEW);
		                     intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		                     intent.setDataAndType(path,"application/pdf");
		                     startActivity(intent);
		                     
		 }

		 private void copyFile(InputStream in, OutputStream out) throws IOException {
		        byte[] buffer = new byte[1024];
		        int read;
		        while((read = in.read(buffer)) != -1){
		          out.write(buffer, 0, read);
		        }
		    }
*/
			 
private void openQuizActivity()
{
	Intent i4 = new Intent(FeatureActivity.this, QuestionsActivity.class);

	if (feature.equals("LP")) {
		file_name = "Quiz_lp";
		i4.putExtra("feature", file_name);
	}
	else if (feature.equals("Assembler"))  {
		file_name = "Quiz_assem";
		i4.putExtra("feature", file_name);
	}
	
	else if (feature.equals("Mac"))  {
		file_name = "Quiz_mac";
		i4.putExtra("feature", file_name);
	}
	
	else if (feature.equals("Com"))  {
		file_name = "Quiz_com";
		i4.putExtra("feature", file_name);
	}
	else if (feature.equals("Lin"))  {
		file_name = "Quiz_lnk";
		i4.putExtra("feature", file_name);
	}
	
	else if (feature.equals("Loa"))  {
		file_name = "Quiz_ldr";
		i4.putExtra("feature", file_name);
	}
	
	//i4.putExtra("feature", "file_name");
	startActivity(i4);
	Toast.makeText(this, feature + " quiz is selected",
			Toast.LENGTH_SHORT).show();
	
	}
		
	
	
	
}
    

