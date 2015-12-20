package com.adanac.fakeweixin.activity.moretab;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fragment.LazyFragment;

/**
 * ������ - ��Դת��
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class MoreFragmentZYZH extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_zyzh);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_zyzh_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_zyzh_textView);
		textView.setTextSize(12);
		switch (tabIndex) {
		case 0:
			textView.setText(Html
					.fromHtml("һ����Դ��ת�����ɡ�����ʲô��ת����ô���֡�����һ������ھ�����½������Ƕ�ԭ��Ʒ���زĵ�һ�ִ����Լ���������<br/>������Ҫ���֣�<br/>\t�����ӻ�<br/>\t�����Ż�<br/>\t���ṹ��<br/>\t����̬��<br/>\t����ý�廯<br/>\t��������"));
			break;
		case 1:
			Drawable d = getResources().getDrawable(R.drawable.map_zyzh);
			d.setBounds(0, 0, 700, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, d, null, null);
			break;
		case 2:

			textView.setText("1.ʲô����Դ�Ŀ��ӻ���\n2.���Ĳ��˽���ӻ��������ڱ�");
			break;
		default:
			textView.setText(Html
					.fromHtml("������ӣ�<br/>"
							+ "���ӻ��������ڱ�<a href=\"http://www.visual-literacy.org/periodic_table/periodic_table.html\">http://www.visual-literacy.org/periodic_table/periodic_table.html</a><br/>"));
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
