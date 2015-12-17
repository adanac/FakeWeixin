package com.adanac.fakeweixin.activity.moretab;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
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
public class MoreFragmentYYCC extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_yycc);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_item_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_item_textView);
		switch (tabIndex) {
		case 0:
			Drawable d = getResources().getDrawable(R.drawable.map_yycc_know01);
			d.setBounds(0, 0, 200, 200); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(d, null, null, null);
			d = getResources().getDrawable(R.drawable.map_yycc_know02);
			d.setBounds(0, 0, 200, 200); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(d, null, null, null);
			d = getResources().getDrawable(R.drawable.map_yycc_know03);
			d.setBounds(0, 0, 200, 200); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(d, null, null, null);
			textView.setText("ͼ1 �������ߡ����������ߡ�����ʽ\nͼ2 �����š�����ָ������ָ������������\nͼ3 ��ָ������ͼ");
			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_yycc);
			d.setBounds(0, 0, 500, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(d, null, null, null);
			// textView.setText("setCompoundDrawables");
			break;
		case 2:
			textView.setTextSize(15);
			textView.setText("\n\n���ѵ��������\nͼ1 �Ӿ��Ļ���LOGO\n��ѯ�����Ӿ��Ļ���http://www.fromeyes.cn/��˼����\n1.�۲���վ�ı�־LOGO�������ص㣬���Է�������ָ����ָ����֮��Ĺ�ϵ��\n2.�˱�־LOGO�����ͽṹ����������վ�������������ް�ʾ���ã�");
			d = getResources().getDrawable(R.drawable.map_yycc_zuoye);
			d.setBounds(0, 0, 500, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(d, null, null, null);
			// textView.setText("ͼ  ��Ӱ��Ʒ����Ҫ���顷");
			break;
		default:
			textView.setTextSize(20);
			textView.setText("�����Դ���ӣ�\n�Ӿ��Ļ�����http://www.fromeyes.cn/\n������ѧý������С�飺http://vr.theatre.ntu.edu.tw/fineart/");
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
