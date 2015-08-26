package in.witsolapur.sysproapp;

import in.witsolapur.sysproapp.R;

import net.sf.andpdf.pdfviewer.PdfViewerActivity;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class QbankActivity extends Activity {
	WebView wv;
	String feature;
	//file_name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qbank);
		wv=(WebView)findViewById(R.id.wv);
		feature = getIntent().getExtras().getString("feature");
		if (feature.equals("LP")) 
		{
			
			wv.loadUrl("file:///android_res/raw/lp_qbank.html");

		}
		
		
	}
	}
