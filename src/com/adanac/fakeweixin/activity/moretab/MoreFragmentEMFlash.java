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
 * ����� - Flash
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class MoreFragmentEMFlash extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_emflash);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_emflash_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_emflash_textView);
		textView.setTextSize(12);
		Drawable d = null;
		switch (tabIndex) {
		case 0:
			textView.setText(Html
					.fromHtml("һ��Flash����ʽ�ص�<br/>\t1.ע�ش���ı��<br/>\t2.ע�������Ľ��<br/>\t3.�����ŵ������������<br/>\t4.�����������趨����<br/>"
							+ "����Flash������ѡ��<br/>\t1.�������ԡ�����Ʒ<br/>\t2.����ʷ�ԡ����������ԡ�����Ʒ<br/>\t3.����ѧ�ԡ�����Ʒ<br/>\t4.�������ԡ�����Ʒ<br/>\t5.�������֮������Ʒ<br/>"
							+ "�������Flash��Ʒ����������<br/>\t���ȷ����������ʽ��������Ȼ���ע���ݣ����˼������ͨ�����Flash�����ʲô�����۵㡣"));

			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_flash_car);
			d.setBounds(0, 0, 500, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, d, null, null);
			textView.setMovementMethod(ScrollingMovementMethod.getInstance());
			break;
		case 2:
			textView.setText("1.Flash��Ʒ������ѡ��Χ��Ҫ����Щ��\n2.����ϲ����Flash�����ַ�����Ʒ��������������ĸ��ܣ�");
			break;
		default:
			textView.setText(Html
					.fromHtml(" Flash��Դ���ص�ַ��<br/>"
							+ " �������齫����<a href=\"http://download.pchome.net/game/card/10919.html\">http://download.pchome.net/game/card/10919.html</a><br/>"
							+ " ������û�и߸�Ь����<a href=\"http://www.f130.net/FLASH/music7255.htm\">http://www.f130.net/FLASH/music7255.htm</a><br/>"
							+ " ��С�ƺ�����<a href=\"http://www.f130.net/FLASH/music7255.htm\">http://www.f130.net/FLASH/music7255.htm</a><br/>"));
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
