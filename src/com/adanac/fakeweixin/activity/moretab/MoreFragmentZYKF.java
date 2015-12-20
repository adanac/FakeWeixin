package com.adanac.fakeweixin.activity.moretab;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fragment.LazyFragment;

/**
 * ������-��Դ����
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class MoreFragmentZYKF extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_zykf);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_zykf_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_zykf_textView);
		textView.setTextSize(12);
		switch (tabIndex) {
		case 0:
			textView.setText("��Դ������ѡ��ת����ʹ������ά��������á�");
			break;
		case 1:
			Drawable d = getResources().getDrawable(R.drawable.map_zykf);
			d.setBounds(0, 0, 700, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(d, null, null, null);
			break;
		case 2:
			textView.setText("1.���Լ������Բ�������������Դ������");
			break;
		case 3:
			textView.setText("��ҵ����");
		default:
			textView.setText(Html
					.fromHtml("<b>�����Դ���ӣ�</b><br/>"
							+ "�Ӿ��Ļ�����<a href=\"http://www.fromeyes.cn/\">http://www.fromeyes.cn/</a><br/>"));
			textView.setMovementMethod(LinkMovementMethod.getInstance());
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
