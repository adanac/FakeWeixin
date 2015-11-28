package com.adanac.fakeweixin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fakeweixin.view.DrawAppView_bak;

/**
 * @author adanac
 * @date 2015-11-28
 * @version 0.3
 */
public class ContentActivity3 extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_layout3);
		init();
	}

	private void init() {
		TextView title = (TextView) findViewById(R.id.head_txt);
		title.setText("我的教育app");

		// TODO 要把不同的图形写到不同的view中，最后才逐个添加到总的content中
		LinearLayout layoutContent = (LinearLayout) findViewById(R.id.content_layout3);
		final DrawAppView_bak view = new DrawAppView_bak(this);
		view.setMinimumHeight(1000);
		view.setMinimumWidth(1200);
		// 通知view组件重绘
		view.invalidate();
		layoutContent.addView(view);

		LinearLayout content_layout2 = (LinearLayout) findViewById(R.id.content_layout2);
		LinearLayout content_layout2_one = (LinearLayout) findViewById(R.id.content_layout2_one);
		LinearLayout content_layout2_two = (LinearLayout) findViewById(R.id.content_layout2_two);

		layoutContent.setOnClickListener(new View.OnClickListener() {
			int i = 0;

			@Override
			public void onClick(View view) {
				if (i == 0) {
					Intent intent = new Intent(ContentActivity3.this,
							ContentFirstActivity.class);
					startActivity(intent);
				}
			}
		});

	}
}
