package com.adanac.fakeweixin.activity;

import android.app.Activity;
import android.os.Bundle;

import com.adanac.fakeweixin.R;

public class ContentFirstActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_layout);
	}
}
