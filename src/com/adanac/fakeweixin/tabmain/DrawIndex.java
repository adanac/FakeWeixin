package com.adanac.fakeweixin.tabmain;

import android.app.Activity;
import android.os.Bundle;

import com.adanac.fakeweixin.view.DrawAppView;

public class DrawIndex extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.fragment_tabmain_item);

		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		// �ڵ�1��ҳ�滭ͼ��
		final DrawAppView view_one = new DrawAppView(this);
		view_one.setMinimumHeight(600);
		view_one.setMinimumWidth(800);
		// ֪ͨview����ػ�
		view_one.invalidate();

	}

}
