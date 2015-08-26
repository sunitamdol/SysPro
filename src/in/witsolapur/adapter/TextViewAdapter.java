package in.witsolapur.adapter;

import in.witsolapur.sysproapp.R;

import java.util.ArrayList;
import java.util.HashMap;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Toast;

public class TextViewAdapter extends BaseAdapter {

	private static final String TAG = null;
	private ArrayList<Integer> nos;
	private HashMap<Integer, String> data;
	private int rows, columns;
	private Context context;
    private HashMap<Integer, String> chData;
	public TextViewAdapter(Context context, int[] nos,String chars[], int rows, int columns) {
		this.nos = new ArrayList<Integer>();
		
		data = new HashMap<Integer, String>();
		chData=new HashMap<Integer, String>();
		for (int i=0;i<nos.length;i++) {
			this.nos.add(nos[i]);
			chData.put(nos[i], chars[i]);
			//Log.i(TAG, "Addining : " + nos[i]);
			// data.put(x, "");
		}
		
		
		int n=nos.length;
		//Toast.makeText(context, "length : " +nos,1000).show();
		Log.i(TAG, "length : "+nos);
		this.rows = rows;
		this.columns = columns;
		this.context = context;
		
	}

	
	public int getCount() {
		// TODO Auto-generated method stub
		return rows * columns;
	}

	
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	ViewHolder holder;

	
	public View getView(final int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		holder = new ViewHolder();
		if (convertView == null) {
			// Toast.makeText(context, "New Holder at : " + position,
			// 1000).show();
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.view_textview, null);
			holder.txtChar = (EditText) convertView.findViewById(R.id.txtChar);
			// Log.i(TAG, "control at : "+position+" created");
			convertView.setTag(holder);
		} else {
			// Log.i(TAG, "control at : "+position+" used");
			holder = (ViewHolder) convertView.getTag();
			holder.txtChar.setText(data.get(position));
			//Log.i(TAG, "Using control at  " + position + " seting value "
					//+ data.get(position));
		}

		holder.txtChar.setBackgroundResource(R.drawable.text_border);
		if (nos.contains(position)) {

			holder.txtChar.setVisibility(View.VISIBLE);
			holder.txtChar.setText(data.get(position));
			int id = R.drawable.text_border;
			switch (position) {
			case 0:
				id = R.drawable.one;
				break;
			case 5:
				id = R.drawable.two;
				break;
			case 10:
				id = R.drawable.three;
				break;
			case 23:
				id = R.drawable.four;
				break;
			case 55:
				id = R.drawable.five;
				break;
			case 80:
				id = R.drawable.six;
				break;
			case 123:
				id = R.drawable.seven;
				break;
			case 151:
				id = R.drawable.eight;
				break;
			case 157:
				id = R.drawable.nine;
				break;
			case 187:
				id = R.drawable.ten;
				break;

			}

			holder.txtChar.setBackgroundResource(id);

		} else {
			holder.txtChar.setVisibility(View.INVISIBLE);

		}

		holder.txtChar.setOnFocusChangeListener(new OnFocusChangeListener() {

		
			public void onFocusChange(View view, boolean arg1) {
				if (arg1) {
					Log.i(TAG, "Got focus " + position);
				} else {
					String text = ((EditText) view).getText().toString();
					data.put(position, text);
					Log.i(TAG, "Lost focus " + position + " storing value "
							+ text);
					Log.i(TAG,"position : "+position+" entered text : "+text+" correct text:  "+chData.get(position));
					if(!chData.get(position).equals(text)){
						Toast.makeText(context, "Incorrect character",Toast.LENGTH_LONG).show();
					}
					else
					{
						Toast.makeText(context, "Correct character",Toast.LENGTH_LONG).show();
					}
				}
			}
		});

		return convertView;
	}

	static class ViewHolder {
		EditText txtChar;

	}
}
