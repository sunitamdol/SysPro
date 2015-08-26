package in.witsolapur.sysproapp;

import in.witsolapur.adapter.TextViewAdapterLanguageProcessor;
import in.witsolapur.sysproapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game3ActivityLanguageProcessor extends Activity {
	protected static final String TAG = null;
	private HashMap<Integer, String> acrossWords, downWords;
	private HashMap<Integer, String> correctWords;
	private GridView gdvWords;
	private ArrayAdapter<String> adapter;
	private Context context;
	private TextView txtWords;
	private ArrayList<TextView> tvSelected;
	private int txtCol = -1;
	private ArrayList<Integer> positions, tempPositions;;
	private ImageView imgCrossWords;
	int nos[] = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 28,
			     39, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 57, 64, 75, 82, 87,
			     90, 91, 92, 93, 94, 95, 96, 97, 100, 105, 111, 118, 123,
			     129, 136, 141, 147, 154, 159, 
			     163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 177,
			     183, 190, 195, 201, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214,
			     224, 226, 231, 242, 260, 278, 296, 314 };
	
	String chars[] = {"s", "e", "m", "a", "n", "t", "i", "c", "l", "e", "x", "i", "c", "a", "l", "p",
			          "n", "g", "e", "n", "e", "r", "a", "t", "i", "o", "n", "t", "c", "e", "i", "e",
			          "m", "i", "g", "r", "a", "t", "o", "r", "f", "x", "p", "i", "e",
			          "r", "c", "c", "e", "a", "u",
			          "d", "e", "t", "r", "a", "n", "s", "l", "a", "t", "o", "r", "t",
			          "e", "i","i", "r", "p", "r", "e", "p", "r", "o", "c", "e", "s", "s", "o", "r",
			          "a", "n", "n", "r", "s", "i", "n", "g"};
	
	private Button btnShow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_game3_language_processor);

		context = this;
		gdvWords = (GridView) findViewById(R.id.gdvWords);
		//txtWords = (TextView) findViewById(R.id.txtWordList);
		imgCrossWords = (ImageView) findViewById(R.id.imgCrossWords);
		gdvWords.setBackgroundColor(Color.WHITE);

		acrossWords = new HashMap<Integer, String>();

		acrossWords.put(1, "semantic");
		acrossWords.put(2, "lexical");
		acrossWords.put(4, "generation");
		acrossWords.put(6, "migrator");
		acrossWords.put(7, "detranslator");
		acrossWords.put(8, "preprocessor");


		downWords = new HashMap<Integer, String>();

		downWords.put(1, "specification");
		downWords.put(3, "interpreter");
		downWords.put(5, "execution");
		downWords.put(9, "parsing");
		

		
		correctWords=new HashMap<Integer, String>();
		//correctWords.put(key, value);
		
		TextViewAdapterLanguageProcessor adapter = new TextViewAdapterLanguageProcessor(this, nos,chars, 18, 18);
		gdvWords.setAdapter(adapter);

		btnShow = (Button) findViewById(R.id.btnShow);

	}

	public void onClick(View v) {

		if (v.getId() == R.id.btnShow) {
			if (btnShow.getText().toString().equals("Show Clues")) {
				btnShow.setText("Hide Clues");
				imgCrossWords.setVisibility(View.VISIBLE);
			} else {
				btnShow.setText("Show Clues");
				imgCrossWords.setVisibility(View.INVISIBLE);
			}
		} else {
			if (check()) {
				Toast.makeText(this, "All words are correct", Toast.LENGTH_LONG)
						.show();
			} else {
				Toast.makeText(this, "Please try again", Toast.LENGTH_LONG)
						.show();
			}
		}
	}

	private boolean check() {
		
		return true;
	}
}

