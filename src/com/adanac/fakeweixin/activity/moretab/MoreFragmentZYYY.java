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
 * ������-��Դ����
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class MoreFragmentZYYY extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_zyyy);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_zyyy_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_zyyy_textView);
		textView.setTextSize(12);
		Drawable d = null;
		switch (tabIndex) {
		case 0:
			textView.setText(Html
					.fromHtml("����Դ�����ù��̡����ᴩ�ڽ��-����-��ͨ-���Ĺ���֮�У�ʵ��͸�����󣬽�ʾ���ʣ����ּ�ֵ�����۵�������<br/>����Դ�����÷��������о���ѧϰ<br/>\t��1������ķ���<br/>\t��2����������ͽ������ķ���<br/>\t��3��������������Ϣ�ķ���<br/>\t��4�������ķ���<br/>ѧ����������ͣ�<br/>"));
			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_zyyy);
			d.setBounds(0, 0, 700, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, d, null, null);
			break;
		case 2:
			d = getResources().getDrawable(R.drawable.map_zyyy_zuoye01);
			d.setBounds(0, 0, 300, 400); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, null, d, null);
			Drawable d1 = getResources().getDrawable(
					R.drawable.map_zyyy_zuoye02);
			d1.setBounds(0, 0, 300, 400); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, null, null, d1);
			textView.setText("1.�������˻�Ŀ�Ļʽ����Դ������ѡ������Щ�����Ļ�Ԫ�أ������������ļӹ���������ʲô�����������ã�");
			break;
		default:
			textView.setText(Html
					.fromHtml("������ӣ�<br/>"
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
