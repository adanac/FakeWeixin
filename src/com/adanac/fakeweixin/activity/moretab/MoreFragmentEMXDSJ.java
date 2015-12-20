package com.adanac.fakeweixin.activity.moretab;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fragment.LazyFragment;

/**
 * ����� - �ִ����
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class MoreFragmentEMXDSJ extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_emxdsj);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_emxdsj_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_emxdsj_textView);
		textView.setTextSize(12);
		Drawable d = null;
		switch (tabIndex) {
		case 0:
			textView.setText(Html.fromHtml("1.����Ҫ��Ӧ�����ִ��������������ͨ��˾��־��"));
			d = getResources().getDrawable(R.drawable.map_emxdsj_know);
			d.setBounds(0, 0, 300, 200); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, null, null, d);
			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_emxdsj_zp01);
			d.setBounds(0, 0, 300, 310); // ��������ͼƬ��С��������ʾ

			Drawable d1 = getResources()
					.getDrawable(R.drawable.map_emxdsj_zp02);
			d1.setBounds(0, 0, 300, 250); // ��������ͼƬ��С��������ʾ

			Drawable d2 = getResources()
					.getDrawable(R.drawable.map_emxdsj_zp03);
			d2.setBounds(0, 0, 300, 300); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(d, d1, d2, null);
			textView.setMovementMethod(ScrollingMovementMethod.getInstance());
			break;
		case 2:
			textView.setText("1.����˵�����º����������Ӧ�õ�������Ԫ�أ�����һ��������ں���");
			d = getResources().getDrawable(R.drawable.map_emxdsj_sk);
			d.setBounds(0, 0, 400, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, null, null, d);
			break;
		default:
			textView.setText(Html
					.fromHtml("������ӣ�<br/>"
							+ "������ƽ���רҵ��վ��<a href=\"http://www.fanstart.com\">http://www.fanstart.com</a><br/>"));
			break;
		}
		handler.sendEmptyMessageDelayed(1, 1000);
	}

	@Override
	public void onDestroyViewLazy() {
		super.onDestroyViewLazy();
		handler.removeMessages(1);
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			progressBar.setVisibility(View.GONE);
			textView.setVisibility(View.VISIBLE);
		}
	};
}
