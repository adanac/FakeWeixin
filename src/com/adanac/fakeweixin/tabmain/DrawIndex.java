package com.adanac.fakeweixin.tabmain;

import android.app.Activity;
import android.os.Bundle;

import com.adanac.fakeweixin.view.DrawAppView;

public class DrawIndex extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.fragment_tabmain_item);

		// 初始化控件
		initView();
	}

	private void initView() {
		// 在第1个页面画图形
		final DrawAppView view_one = new DrawAppView(this);
		view_one.setMinimumHeight(600);
		view_one.setMinimumWidth(800);
		// 通知view组件重绘
		view_one.invalidate();

	}

}
