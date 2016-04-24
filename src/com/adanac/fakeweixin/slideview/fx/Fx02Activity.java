package com.adanac.fakeweixin.slideview.fx;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.adanac.fakeweixin.R;

public class Fx02Activity extends Activity {

	private static final String TAG = "Rabbit";

	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_fx_02);
		// ��ʼ���ؼ�
		initView();
		// ��ӡ��־
		Log.i(TAG, "1----------onCreate");
	}

	private void initView() {
		imageView = (ImageView) findViewById(R.id.imgfx02);
	}

}
