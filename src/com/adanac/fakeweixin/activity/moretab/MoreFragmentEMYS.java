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
 * ����� - Ӱ��
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class MoreFragmentEMYS extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_emys);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_emys_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_emys_textView);
		textView.setTextSize(12);
		Drawable d = null;
		switch (tabIndex) {
		case 0:
			textView.setText(Html
					.fromHtml("��Ӱ����ƷԴ�������ʵ <br/>\tӰ����Ʒ�Ƕ������زĵ���ѡ�����к��������Ƕ��������µĳ�Խ��ӹ����졣<br/>\t��Ӱ�ӵ�ý������Ӱ�Ӷ���ʵ����ĸ��־����Ƕ�����Ļ�е�հᣬ���Ƕ������زĵ������������۴��졣<br/>\t��Ӱ����Ʒ�Ľ�����ֵ<br/>\t��֪���ܣ�<br/>\t  ����֪ʶ���� <br/>\t   ���������Ļ����У������Ļ��Ĵ��������Ļ��Ĵ���<br/>\t��������:Ӱ������������������Ҫ��ָ����ͨ��Ӱ����Ʒ���ͻ���봴</br>"
							+ "���߲�������ϵĹ�������ᴴ����������������Ʒʱ����˼���� "));
			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_emys_zp01);
			d.setBounds(0, 0, 230, 300); // ��������ͼƬ��С��������ʾ

			Drawable d1 = getResources().getDrawable(R.drawable.map_emys_zp02);
			d1.setBounds(0, 0, 230, 300); // ��������ͼƬ��С��������ʾ

			Drawable d2 = getResources().getDrawable(R.drawable.map_emys_zp03);
			d2.setBounds(0, 0, 230, 300); // ��������ͼƬ��С��������ʾ

			Drawable d3 = getResources().getDrawable(R.drawable.map_emys_zp01);
			d3.setBounds(0, 0, 230, 300); // ��������ͼƬ��С��������ʾ

			textView.setCompoundDrawables(d, d1, d2, d3);
			textView.setMovementMethod(ScrollingMovementMethod.getInstance());
			break;
		case 2:
			textView.setText("�κ�ۿ�ӰƬ�����Ӣ�۴������Ƚ��������Ӿ�Ԫ�أ�ɫ�ʡ���Ӱ����ͼ�����𡢽Ƕȡ��˶�����̫��ȣ�����Ĳ��죬��˼����η��������Ļ�Ԫ���ڵ�Ӱ�е����á�");
			d = getResources().getDrawable(R.drawable.map_emys_sk);
			d.setBounds(0, 0, 700, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, null, null, d);
			break;
		default:
			textView.setText(Html.fromHtml("��زο����ף�<br/>"
					+ "������.���������񻰡���ӰƬ����18��[M].�й������ѧ�����磬2004.<br/>"
					+ "����.Ӱ����ѧ[M].������ѧ�����磬2002.<br/>"
					+ "�޽�.Ӱ�������е���������Ԫ��.��Ӱ����[J].2007��2��<br/>"));
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
