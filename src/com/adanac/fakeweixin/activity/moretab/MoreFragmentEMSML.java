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
 * �����-ˮī��
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class MoreFragmentEMSML extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_emsml);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_emsml_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_emsml_textView);
		textView.setTextSize(12);
		switch (tabIndex) {
		case 0:
			textView.setText(Html.fromHtml("1.�Ա������صķ���<br/>"
					+ " ����л���ڡ���Ʒ¼�����ᵽ��Ʒ���滭��������Ҫ���ݡ���������"
					+ " �����������Ƿ��ñʡ�Ӧ�����Ρ����ำ�ʡ���Ӫλ�á�����ģд<br/>"
					+ "2.�ԷǱ������صķ���<br/>" + " ˼�����ݡ���������ץ�ؼ�<br/>"
					+ " ʱ��������������ʱ���ص�"));
			break;
		case 1:
			Drawable d = getResources().getDrawable(R.drawable.map_emsml_zp01);
			d.setBounds(0, 0, 450, 290); // ��������ͼƬ��С��������ʾ

			Drawable d1 = getResources().getDrawable(R.drawable.map_emsml_zp02);
			d1.setBounds(0, 0, 450, 290); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, d, null, d1);
			textView.setMovementMethod(ScrollingMovementMethod.getInstance());
			break;
		case 2:
			textView.setText("1.���ճ��������㻹����Щý�崫���򳡺��м�������ܵ��й��滭Ԫ�� ?\n"
					+ "2.����Photoshop��Flash��ý��༭�������һ�������й���Ԫ�ص�С��Ʒ��");
			break;

		default:
			textView.setText(Html
					.fromHtml(" �����Դ���ӣ�<br/>"
							+ " �����黭����<a href=\"http://www.shu-hua.com\">http://www.shu-hua.com</a><br/>"));
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
