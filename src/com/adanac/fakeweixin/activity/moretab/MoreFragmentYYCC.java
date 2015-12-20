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
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_yycc_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_yycc_textView);
		textView.setTextSize(12);
		Drawable d = null;
		switch (tabIndex) {
		case 0:
			textView.setMovementMethod(ScrollingMovementMethod.getInstance());
			d = getResources().getDrawable(R.drawable.map_yycc_know01);
			d.setBounds(0, 0, 300, 290); // ��������ͼƬ��С��������ʾ
			Drawable d1 = getResources()
					.getDrawable(R.drawable.map_yycc_know02);
			d1.setBounds(0, 0, 350, 230);
			Drawable d2 = getResources()
					.getDrawable(R.drawable.map_yycc_know03);
			d2.setBounds(0, 0, 350, 290);
			textView.setCompoundDrawables(d, d1, d2, null);

			// textView.setText("ͼ1\t\"�����ߡ�����������\"����ʽ");
			// textView.append("\n\nͼ2\t\"���š�����ָ������ָ\"����������\n\nͼ3\t��ָ������ͼ");

			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_yycc);
			d.setBounds(0, 0, 700, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(d, null, null, null);
			// textView.setText("setCompoundDrawables");
			break;
		case 2:
			d = getResources().getDrawable(R.drawable.map_yycc_zuoye);
			d.setBounds(0, 0, 450, 300); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, d, null, null);
			textView.setMovementMethod(LinkMovementMethod.getInstance());
			textView.append(Html
					.fromHtml("<b>���ѵ��������</b><br/>"
							+ "�Ӿ��Ļ���:<a href=\"http://www.fromeyes.cn/\">http://www.fromeyes.cn/</a><br/><br/>"
							+ "<b>˼����</b><br/>"
							+ "1.�۲���վ�ı�־LOGO�������ص㣬���Է�������ָ����ָ����֮��Ĺ�ϵ��<br/>"
							+ "2.�˱�־LOGO�����ͽṹ����������վ�������������ް�ʾ���ã�"));
			break;
		default:
			textView.setText(Html
					.fromHtml("<b>�����Դ���ӣ�</b><br/>"
							+ "�Ӿ��Ļ�����<a href=\"http://www.fromeyes.cn/\">http://www.fromeyes.cn/</a><br/>"
							+ "������ѧý������С�飺<a href=\"http://vr.theatre.ntu.edu.tw/fineart/\">http://vr.theatre.ntu.edu.tw/fineart/</a>"));
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
