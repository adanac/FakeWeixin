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
 * ������-��Դѡ��
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class MoreFragmentZYXZ extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_zyxz);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_zyxz_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_zyxz_textView);
		textView.setTextSize(12);
		switch (tabIndex) {
		case 0:
			textView.setText(Html.fromHtml("<b>��Դ��ѡ��</b><br/>"
					+ "1.�����������ģ�<br/>" + "2.��ʷ���뵱���ģ�<br/>" + "3.��ʵ��������ģ�<br/>"
					+ "4.����������ġ�"));
			break;
		case 1:
			Drawable d = getResources().getDrawable(R.drawable.map_zyxz);
			d.setBounds(0, 0, 700, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, d, null, null);
			break;
		case 2:

			textView.setText("1.���ѡ���м�ֵ����Դ�������ز���Ԫ�أ�");
			break;
		default:
			textView.setText(Html
					.fromHtml("�����Դ���ӣ�<br/>"
							+ "�������˻���վ��<a href=\"http://www.beijing2008.cn/\">http://www.beijing2008.cn/</a><br/>"));
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
