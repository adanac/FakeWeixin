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
 * @version 0.1
 */
public class ContentActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_layout);
		init();
	}

	private void init() {
		TextView title = (TextView) findViewById(R.id.head_txt);
		title.setText("�ҵĽ���app");

		// TODO Ҫ�Ѳ�ͬ��ͼ��д����ͬ��view�У����������ӵ��ܵ�content��
		LinearLayout layoutContent = (LinearLayout) findViewById(R.id.content_content);
		final DrawAppView_bak view_one = new DrawAppView_bak(this);
		view_one.setMinimumHeight(1000);
		view_one.setMinimumWidth(1200);
		// ֪ͨview����ػ�
		view_one.invalidate();
		layoutContent.addView(view_one);

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
