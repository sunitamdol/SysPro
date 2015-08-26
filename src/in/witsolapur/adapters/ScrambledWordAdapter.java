package in.witsolapur.adapters;


import in.witsolapur.sysproapp.R;

import java.util.ArrayList;
import java.util.Collections;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ScrambledWordAdapter extends BaseAdapter {

	
	private static final String TAG = "ScrambledWordAdapter";
	private Context context;
	private ArrayList<String> list;
	private ArrayList<String> scrambledList;

	public ScrambledWordAdapter(Context context, ArrayList<String> list,
			ArrayList<String> scrambledList) {
		this.context = context;
		this.list = list;
		this.scrambledList = scrambledList;
		Log.i(TAG, "Got : "+list+"\n"+scrambledList);
	}

	
	
	public int getCount() {
		// TODO Auto-generated method stub

		return scrambledList.size();
	}

	
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return scrambledList.get(arg0);
	}

	
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	
	public View getView(final int index, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder = new ViewHolder();
		if (convertView == null) {
			// Toast.makeText(context, "New Holder at : " + position,
			// 1000).show();
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.view_scramble, null);
			holder.txtWord = (TextView) convertView.findViewById(R.id.txtWord);
			holder.edtWord = (EditText) convertView.findViewById(R.id.edtWord);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();

		}


		holder.txtWord.setText(scrambledList.get(index));
		holder.edtWord.setOnFocusChangeListener(new OnFocusChangeListener() {
			
		
			public void onFocusChange(View arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if(!arg1)
				{
					String value =((EditText)arg0).getText().toString();
					if(value.length()>0)
					{
						if(value.equals(list.get(index))){
							Toast.makeText(context, "Correct",Toast.LENGTH_SHORT).show();
						}
						else
						{
							Toast.makeText(context, "incorect",Toast.LENGTH_SHORT).show();
						}
					}
					Toast.makeText(context, value,Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		return convertView;

	}

	static class ViewHolder {
		TextView txtWord;
		EditText edtWord;
	}

}
