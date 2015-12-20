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
 * ������ָ���ͼ
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class MoreFragmentEZGX extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_ezgx);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_ezgx_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_ezgx_textView);
		textView.setTextSize(12);
		switch (tabIndex) {
		case 0:
			textView.setText("1.�Ӿ��������ۿ�����������\n\n2.ý��������ͨ��ý��ۿ������Ӧ�õ�����\n\n3.����֮��Ĺ�ϵ��ˮ���ཻ�����Էָ�");
			break;
		case 1:
			Drawable d = getResources().getDrawable(R.drawable.map_ezgx);
			d.setBounds(0, 0, 700, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, d, null, null);
			break;
		case 2:

			textView.setText("1.�����Լ���������ý���������Ӿ���������Ҫ����");
			break;
		default:
			textView.setText(Html
					.fromHtml("������ӣ�<br/>"
							+ "�Ӿ��Ļ�����<a href=\"http://www.fromeyes.cn/\">http://www.fromeyes.cn/</a><br/>"
							+ "ý������������Ŀ��Դ���ܣ�<a href=\"http://interact.uoregon.edu/medialit/MLR/home/\">http://interact.uoregon.edu/medialit/MLR/home/</a>"));
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
