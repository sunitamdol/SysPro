package in.witsolapur.sysproapp;

import in.witsolapur.adapter.TextViewAdapterLinker;
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

public class Game3ActivityLinker extends Activity {
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
	int nos[] = { 12, 28, 29, 30, 31, 32, 33, 46, 61, 62, 63, 64, 65, 66,
			      78, 80, 82, 87, 95, 97, 99, 104, 108, 112, 116, 121, 125, 129, 133,
			      137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 155, 159, 163,
			      172, 176, 193, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213,
			      227, 240, 241, 242, 243, 244, 245, 261};
	String chars[] = {"b", "l", "i", "n", "k", "e", "d", "n", "l", "o", "a", "d", "e", "r",
					  "i", "r", "n", "o", "n", "y", "t", "b", "t", "k", "r", "j", "r", "i", "y",
					  "r", "e", "l", "o", "c", "a", "t", "i", "o", "n", "c", "n", "g",
					  "t", "s", "l", "t", "r", "a", "n", "s", "l", "a", "t", "o", "r",
					  "t", "l", "i", "n", "k", "e", "r", "d"};
	private Button btnShow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_game3_linker);

		context = this;
		gdvWords = (GridView) findViewById(R.id.gdvWords);
		//txtWords = (TextView) findViewById(R.id.txtWordList);
		imgCrossWords = (ImageView) findViewById(R.id.imgCrossWords);
		gdvWords.setBackgroundColor(Color.WHITE);

		acrossWords = new HashMap<Integer, String>();

		acrossWords.put(2, "linked");
		acrossWords.put(3, "loader");
		acrossWords.put(7, "relocation");
		acrossWords.put(8, "translator");
		acrossWords.put(9, "linker");


		downWords = new HashMap<Integer, String>();

		downWords.put(1, "binary");
		downWords.put(3, "linking");
		downWords.put(4, "entry");
		downWords.put(5, "object");
		downWords.put(6, "translated");

		
		correctWords=new HashMap<Integer, String>();
		//correctWords.put(key, value);
		
		TextViewAdapterLinker adapter = new TextViewAdapterLinker(this, nos,chars, 16, 17);
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

