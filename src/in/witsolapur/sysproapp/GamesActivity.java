package in.witsolapur.sysproapp;

import in.witsolapur.adapters.ScrambledWordAdapter;
import in.witsolapur.sysproapp.SysPro;
import in.witsolapur.sysproapp.NavigationActivity;
import in.witsolapur.sysproapp.R;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class GamesActivity extends Activity {

	String file_name="";
	ListView listview;
	String feature="";
	/*	private ScrambledWordAdapter adapter;
		private ListView lstscramble;
		private ArrayList<String> list, scrambleList;		*/

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_games);
		 // Get ListView object from xml
        listview = (ListView) findViewById(R.id.list);
        feature=getIntent().getExtras().getString("file_name");
        
        //Toast.makeText(getApplicationContext(), feature, Toast.LENGTH_LONG).show();
		
        // Defined Array values to show in ListView
        String[] values = new String[] { "Word Scramble", 
                                         "Cross Word",
                                        // "Word Search",
                                         "Word Match"
                                       };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listview.setAdapter(adapter); 
        
        // ListView Item Click Listener
        listview.setOnItemClickListener(new OnItemClickListener() {

              public void onItemClick(AdapterView<?> parent, View view,
                 int position, long id) {
                
               // ListView Clicked item index
               int itemPosition     = position;
               
               
               // ListView Clicked item value
               String  itemValue    = (String) listview.getItemAtPosition(position);
                  
                // Show Alert 
                /*Toast.makeText(getApplicationContext(),
                  "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                  .show();*/
             if(position==0){
            	 Intent i=new Intent(getApplicationContext(),WordScrambleActivity.class);
                 if (feature.equals("scramble_lp")) {
         			file_name = "scramble_lp";
         			i.putExtra("file_name", "scramble_lp");
         		}
                 else  if (feature.equals("scramble_assem")) {
          			file_name = "scramble_assem";
          			i.putExtra("file_name", "scramble_assem");
          		}
                 else   if (feature.equals("scramble_mac")) {
           			file_name = "scramble_mac";
           			i.putExtra("file_name", "scramble_mac");
           		}
                 else  if (feature.equals("scramble_com")) {
            			file_name = "scramble_com";
            			i.putExtra("file_name", "scramble_com");
            		}
                 else  if (feature.equals("scramble_lnk")) {
            			file_name = "scramble_lnk";
            			i.putExtra("file_name", "scramble_lnk");
            		}
                 else  if (feature.equals("scramble_ldr")) {
            			file_name = "scramble_ldr";
            			i.putExtra("file_name", "scramble_ldr");
            		}
            	 startActivity(i);
             }
             else if(position==1){
            	  if (feature.equals("scramble_lp")) {
                 	 Intent i=new Intent(getApplicationContext(),Game3ActivityLanguageProcessor.class);
                 	 startActivity(i);
          			
          		}
                  else  if (feature.equals("scramble_assem")) {
                 	 Intent i=new Intent(getApplicationContext(),Game3Activity.class);
                 	 startActivity(i);
           		}
                  else   if (feature.equals("scramble_mac")) {
                 	 Intent i=new Intent(getApplicationContext(),Game3ActivityMacro.class);
                 	 startActivity(i);
            		}
                  else  if (feature.equals("scramble_com")) {
                 	 Intent i=new Intent(getApplicationContext(),Game3ActivityCompiler.class);
                 	 startActivity(i);
             		}
                  else  if (feature.equals("scramble_lnk")) {
                 	 Intent i=new Intent(getApplicationContext(),Game3ActivityLinker.class);
                 	 startActivity(i);
             		}
                  else  if (feature.equals("scramble_ldr")) {
                 	 Intent i=new Intent(getApplicationContext(),Game3ActivityLoader.class);
                 	 startActivity(i);
             		}
             }
         /*  else if(position==2){
            	 Intent i=new Intent(GamesActivity.this,WordSearchActivity.class);
         		startActivity(i);
            	
             }*/
            
             else if(position==2){
            	  if (feature.equals("scramble_lp")) {
                 	 Intent i=new Intent(getApplicationContext(),WordmatchLanguageProcessor.class);
                 	 startActivity(i);
          			
          		}
                  else  if (feature.equals("scramble_assem")) {
                 	 Intent i=new Intent(getApplicationContext(),WordmatchAssembler.class);
                 	 startActivity(i);
           		}
                  else   if (feature.equals("scramble_mac")) {
                 	 Intent i=new Intent(getApplicationContext(),WordmatchMacro.class);
                 	 startActivity(i);
            		}
                  else  if (feature.equals("scramble_com")) {
                 	 Intent i=new Intent(getApplicationContext(),WordmatchCompiler.class);
                 	 startActivity(i);
             		}
                  else  if (feature.equals("scramble_lnk")) {
                 	 Intent i=new Intent(getApplicationContext(),WordmatchLinker.class);
                 	 startActivity(i);
             		}
                  else  if (feature.equals("scramble_ldr")) {
                 	 Intent i=new Intent(getApplicationContext(),WordmatchLoader.class);
                 	 startActivity(i);
             		}
             }
              }

         }); 
	
	}

}
