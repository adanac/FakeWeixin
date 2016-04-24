package com.adanac.fakeweixin.slideview.xz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.adanac.fakeweixin.R;

public class Xz01Activity extends Activity {

	private static final String TAG = "Rabbit";

	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_xz_01);
		// 初始化控件
		initView();
		// 打印日志
		Log.i(TAG, "1----------onCreate");
	}

	private void initView() {
		imageView = (ImageView) findViewById(R.id.imgxz01);
	}

}
