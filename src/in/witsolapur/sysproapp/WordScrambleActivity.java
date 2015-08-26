package in.witsolapur.sysproapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import in.witsolapur.adapters.ScrambledWordAdapter;
import in.witsolapur.sysproapp.R;
import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

public class WordScrambleActivity extends Activity {
	private static final String TAG = null;
//	Bundle feature;
	private ScrambledWordAdapter adapter;
String feature="";

String file_name="";
private ListView lstscramble;
	private ArrayList<String> list, scrambleList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wordscramble);
		lstscramble = (ListView) findViewById(R.id.lstscramble);
 feature=getIntent().getExtras().getString("file_name");
		String st;
//		String file_name = "game_word_scramble.txt";

		openFile();
/*		if(feature.equals("scramble_lp")){
			file_name="game_word_scramble.txt";
		}
		if(feature.equals("scramble_assem")){
			file_name="mac_word_scramble.txt";
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
	
		*/
		AssetManager assetManager = getAssets();
		InputStream in = null;

		try {

			in = assetManager.open(file_name);
			list = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			while ((st = br.readLine()) != null) {

				list.add(st);
			}
			Log.i("Words", "Words-" + list.toString());

			scrambleList = new ArrayList<String>();

			for (int i = 0; i < list.size(); i++) {
				String word = list.get(i);

				List<Character> charList = new ArrayList<Character>();
				for (int j = 0; j < word.length(); j++) {
					charList.add(word.charAt(j));
				}

				Collections.shuffle(charList);
				String scrambleWord = "";
				for (int j = 0; j < charList.size(); j++)
					scrambleWord += charList.get(j);
				Log.i("Scrambled Words", "New Sc Words-" + scrambleWord);

				scrambleList.add(scrambleWord);

			}
			//Collections.shuffle(scrambleList);
			Log.i("Words", "Scramble Words-" + scrambleList.toString());

			Log.i(TAG, "Calling adapter const");
			adapter = new ScrambledWordAdapter(getApplicationContext(), list, scrambleList);
			lstscramble.setAdapter(adapter);
			
			Log.i(TAG, "Finish");

		} catch (IOException e) {
			Log.e(TAG, e.toString());
		}

	}

	private void openFile() {
		// TODO Auto-generated method stub
		if(feature.equals("scramble_lp")){
			file_name="game_word_scramble.txt";
		}
		else if(feature.equals("scramble_assem")){
			file_name="assem_word_scramble.txt";
		}
		
		else if(feature.equals("scramble_mac")){
			file_name="mac_word_scramble.txt";
		}
		
		else if(feature.equals("scramble_com")){
			file_name="com_word_scramble.txt";
		}
		
		else if(feature.equals("scramble_lnk")){
			file_name="lnk_word_scramble.txt";
		}	
		
		else if(feature.equals("scramble_ldr")){
			file_name="ldr_word_scramble.txt";
		}
	
		
	}

}
