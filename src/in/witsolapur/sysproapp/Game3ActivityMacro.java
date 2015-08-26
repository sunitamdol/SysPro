package in.witsolapur.sysproapp;

import in.witsolapur.adapter.TextViewAdapterMacro;
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
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game3ActivityMacro extends Activity {
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
	int nos[] = { 4, 16, 17, 18, 19, 20, 34, 40, 49, 51, 53, 55,
			      62, 64, 66, 68, 70, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86,
			      92, 94, 96, 98, 107, 111, 113, 122, 128, 137, 
			      141, 142, 143, 144, 145, 146, 147, 148, 149, 
			      152, 158, 167, 173, 178, 188, 189, 190, 191, 192, 193, 194,
			      208, 223, 238};
	String chars[] = {"k", "m", "o", "d", "e", "l", "y", "l", "w", "l", "p", "i",
			          "s", "o", "o", "o", "f", "p", "r", "e", "p", "r", "o", "c", "e", "s", "s", "o", "r",
			          "m", "d", "a", "i", "a", "l", "t", "n", "i", "t", 
			          "p", "r", "o", "t", "o", "t", "y", "p", "e",
			          "i", "n", "c", "a", "m", "l", "e", "x", "i", "c", "a", "l",
			          "c", "r", "o"};
	private Button btnShow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_game3_macro);

		context = this;
		gdvWords = (GridView) findViewById(R.id.gdvWords);
		//txtWords = (TextView) findViewById(R.id.txtWordList);
		imgCrossWords = (ImageView) findViewById(R.id.imgCrossWords);
		gdvWords.setBackgroundColor(Color.WHITE);

		acrossWords = new HashMap<Integer, String>();

		acrossWords.put(2, "model");
		acrossWords.put(7, "preprocessor");
		acrossWords.put(8, "prototype");
		acrossWords.put(10, "lexical");
		

		downWords = new HashMap<Integer, String>();

		downWords.put(1, "keyword");
		downWords.put(3, "lifo");
		downWords.put(4, "local");
		downWords.put(5, "positional");
		downWords.put(6, "semantic");
		downWords.put(9, "macro");

		
		correctWords=new HashMap<Integer, String>();
		//correctWords.put(key, value);
		
		TextViewAdapterMacro adapter = new TextViewAdapterMacro(this, nos,chars, 16, 15);
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
