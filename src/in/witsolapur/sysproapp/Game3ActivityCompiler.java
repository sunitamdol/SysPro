package in.witsolapur.sysproapp;

import in.witsolapur.adapter.TextViewAdapterCompiler;
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

public class Game3ActivityCompiler extends Activity {
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
	int nos[] = {7, 21, 26, 28, 33, 34, 35, 36, 37, 38, 39, 40, 41,
			     42, 49, 54, 56, 59, 60, 61, 62, 63, 64, 65, 68,
			     70, 77, 82, 84, 91, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107,
			     117, 119, 127, 128, 129, 130, 131, 132, 145, 159, 162,
			     172, 173, 174, 175, 176, 190, 204};
	String chars[] = {"a", "u", "s", "t", "a", "t", "t", "r", "i", "b", "u", "t", "e",
			          "r", "o", "a", "i", "d", "y", "n", "a", "m","i", "c", "c",
			          "p", "a", "k", "l", "t", "e", "x", "p", "r", "e", "s", "s", "i", "o", "n", 
			          "t", "c", "g", "l", "o", "b", "a", "l", "t", "i", "h",
			          "s", "c", "o", "p", "e", "a", "p"};
	private Button btnShow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_game3_compiler);

		context = this;
		gdvWords = (GridView) findViewById(R.id.gdvWords);
		//txtWords = (TextView) findViewById(R.id.txtWordList);
		imgCrossWords = (ImageView) findViewById(R.id.imgCrossWords);
		gdvWords.setBackgroundColor(Color.WHITE);

		acrossWords = new HashMap<Integer, String>();

		acrossWords.put(4, "attribute");
		acrossWords.put(5, "dynamic");
		acrossWords.put(6, "expression");
		acrossWords.put(8, "global");
		acrossWords.put(10, "scope");


		downWords = new HashMap<Integer, String>();

		downWords.put(1, "automatic");
		downWords.put(2, "stack");
		downWords.put(3, "triple");
		downWords.put(7, "static");
		downWords.put(9, "heap");

		
		correctWords=new HashMap<Integer, String>();
		//correctWords.put(key, value);
		
		TextViewAdapterCompiler adapter = new TextViewAdapterCompiler(this, nos,chars, 15, 14);
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

