package com.adanac.fakeweixin.activity.moretab;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
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
public class MoreFragmentFHNH extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_fhnh);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_fhnh_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_fhnh_textView);
		textView.setTextSize(12);
		Drawable d = null;
		switch (tabIndex) {
		case 0:
			textView.setMovementMethod(ScrollingMovementMethod.getInstance());
			d = getResources().getDrawable(R.drawable.map_fhnh_zuoye);
			d.setBounds(0, 10, 450, 300); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, null, null, d);
			textView.setMovementMethod(LinkMovementMethod.getInstance());
			textView.setText(Html.fromHtml("<b>���ŵ�ʵ���빦��</b><br/>"
					+ "1.���ŵ�ʵ���Ǵ������ѷ��Ŷ���Ϊ�ɴ�������������ĳ�ֶ�������<br/>"
					+ "2.�����š��Ĺ��ܡ���������<br/>" + "������=�����ߡ�<br/>" + "��������=�������ߡ�"));

			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_fhnh);
			d.setBounds(0, 0, 700, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(d, null, null, null);
			// textView.setText("setCompoundDrawables");
			break;
		case 2:
			d = getResources().getDrawable(R.drawable.map_fhnh_taolun);
			d.setBounds(0, 10, 350, 200); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, d, null, null);
			textView.setMovementMethod(LinkMovementMethod.getInstance());
			textView.setText("\t\t\t\t\t\t\t\t\t\tͼ���Ӿ��Ļ���վLOGO\n\n");
			textView.append(Html
					.fromHtml("�۲��Ӿ��Ļ���վ��LOGO���ͣ����LOGO�Ƿ��������ܶԴ˽��н����?"));
			break;
		case 3:
			textView.setText("\t\t\t\t\t��ҵ����");
			break;
		default:
			textView.setText(Html
					.fromHtml("<b>������ӣ�</b><br/>"
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
