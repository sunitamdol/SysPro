package in.witsolapur.sysproapp;

import in.witsolapur.adapter.TextViewAdapter;
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

public class Game3Activity extends Activity {
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
	int nos[] = { 0, 5, 10, 16, 21, 23, 24, 25, 26, 27,
			32, 37, 42, 48, 53, 55,	58, 64, 69, 71, 
			74, 80, 81, 82, 83, 84, 85, 86, 87, 88,
			89, 90, 91,	101, 103, 117, 119, 123, 133, 135,
			139, 149, 151, 152, 153, 154,155, 156, 157, 158, 
			159, 167, 171, 173, 183, 187, 188, 189, 190,191, 
			199, 203, 205, 215, 219, 221, 235, 237, 253 };
	String chars[] = { "s", "i", "o", "y", "m", "l", "t", "o", "r", "g", 
			"m", "p","i", "t", "e", "d","g", "a", "r", "e", 
			"i", "b","a", "c", "k", "p", "a", "t", "c", "h", 
			"i", "n","g","t", "l", "i", "a", "s", "v", "r", 
			"y","e", "a", "s", "s", "e","m", "b", "l", "e", 
			"r", "t","b", "i", "i", "o", "p", "t", "a","b", 
			"v", "l", "e","e", "i", "r", "c", "a", "l" };
	private Button btnShow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_game3);

		context = this;
		gdvWords = (GridView) findViewById(R.id.gdvWords);
		//txtWords = (TextView) findViewById(R.id.txtWordList);
		imgCrossWords = (ImageView) findViewById(R.id.imgCrossWords);
		gdvWords.setBackgroundColor(Color.WHITE);

		acrossWords = new HashMap<Integer, String>();

		acrossWords.put(4, "ltorg");
		acrossWords.put(6, "backpatching");
		acrossWords.put(8, "assembler");
		acrossWords.put(10, "optab");

		downWords = new HashMap<Integer, String>();

		downWords.put(1, "symtab");
		downWords.put(2, "imperative");
		downWords.put(3, "origin");
		downWords.put(5, "declarative");
		downWords.put(7, "symbolic");
		downWords.put(9, "literal");

		
		correctWords=new HashMap<Integer, String>();
		//correctWords.put(key, value);
		
		TextViewAdapter adapter = new TextViewAdapter(this, nos,chars, 16, 16);
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
		
		return false;
	}
}
