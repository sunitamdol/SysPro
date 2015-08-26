package in.witsolapur.sysproapp;

import in.witsolapur.adapter.TextViewAdapterLoader;
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

public class Game3ActivityLoader extends Activity {
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
	int nos[] = { 10, 27, 44, 61, 62, 63, 64, 65, 66, 67, 78, 93, 
			      94, 95, 96, 97, 98, 99, 107, 112, 124, 129, 138, 139, 
			      140, 141, 142, 143, 144, 145, 146, 147, 156, 158, 163, 170, 
			      171, 172, 173, 174, 175, 177, 192, 194, 209, 211, 226, 228,
			      243, 245, 259, 260, 261, 262, 263, 264, 265, 266, 276, 279, 
			      293};
	String chars[] = { "a", "l", "l", "o", "v", "e", "r", "l", "a", "y", "c", "l",
			           "o", "a", "d", "i", "n", "g", "p", "t", "r", "i", "r", "e",
			           "l", "o", "c", "a", "t", "i", "o", "n", "s", "g", "n", "l",
			           "o", "a", "d", "e", "r", "l", "a", "i", "m", "n", "m", "k", 
			           "e", "i", "t", "r", "a", "n", "s", "f", "e", "r", "x", "g",
			           "t"};
	private Button btnShow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_game3_loader);

		context = this;
		gdvWords = (GridView) findViewById(R.id.gdvWords);
		//txtWords = (TextView) findViewById(R.id.txtWordList);
		imgCrossWords = (ImageView) findViewById(R.id.imgCrossWords);
		gdvWords.setBackgroundColor(Color.WHITE);

		acrossWords = new HashMap<Integer, String>();

		acrossWords.put(2, "overlay");
		acrossWords.put(3, "loading");
		acrossWords.put(5, "relocation");
		acrossWords.put(7, "loading");
		acrossWords.put(9, "transfer");

		downWords = new HashMap<Integer, String>();

		downWords.put(1, "allocation");
		downWords.put(4, "programmer");
		downWords.put(6, "esd");
		downWords.put(8, "linking");
		downWords.put(9, "txt");

		
		correctWords=new HashMap<Integer, String>();
		//correctWords.put(key, value);
		
		TextViewAdapterLoader adapter = new TextViewAdapterLoader(this, nos,chars, 18, 17);
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
