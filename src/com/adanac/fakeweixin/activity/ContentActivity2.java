package com.adanac.fakeweixin.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fakeweixin.view.DrawAppView_bak;

/**
 * @author adanac
 * @date 2015-11-28
 * @version 0.2
 */
public class ContentActivity2 extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_layout2);
		// init();
	}

	private void init() {
		TextView title = (TextView) findViewById(R.id.head_txt);
		title.setText("我的教育app");

		LinearLayout layoutContent = (LinearLayout) findViewById(R.id.content_content);
		final DrawAppView_bak view = new DrawAppView_bak(this);
		view.setMinimumHeight(1000);
		view.setMinimumWidth(1200);
		// 通知view组件重绘
		view.invalidate();
		layoutContent.addView(view);

		/*
		 * LinearLayout layoutContent = (LinearLayout)
		 * findViewById(R.id.content_area); layoutContent.setOnClickListener(new
		 * View.OnClickListener() { int i = 0;
		 * 
		 * @Override public void onClick(View view) { if (i == 0) { Intent
		 * intent = new Intent(ContentActivity.this,
		 * ContentFirstActivity.class); startActivity(intent); } } });
		 */

	}
}
