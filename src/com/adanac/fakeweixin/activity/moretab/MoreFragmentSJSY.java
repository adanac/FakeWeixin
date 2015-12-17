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
 * @author adanac
 * @date 2015-11-27
 * @version 1.0
 */
public class MoreFragmentSJSY extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_mjsy);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_item_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_item_textView);
		switch (tabIndex) {
		case 0:
			textView.setTextSize(20);
			textView.setText("^_^");
			break;
		case 1:
			Drawable d = getResources().getDrawable(R.drawable.map_sjsy);
			d.setBounds(0, 0, 500, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(d, null, null, null);
			// textView.setText("setCompoundDrawables");
			break;
		case 2:
			textView.setTextSize(15);
			textView.setText("\n\n1����Ӱʦ���������Ӱ����Ʒ���Ӱ����ߵĹۿ���\n\n\n\n\n\nͼ1 ��Ӱʦ");
			d = getResources().getDrawable(R.drawable.map_sjsy_zuoye);
			d.setBounds(0, 0, 500, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(d, null, null, null);
			// textView.setText("ͼ  ��Ӱ��Ʒ����Ҫ���顷");
			break;
		default:
			textView.setTextSize(20);
			textView.setText("������ӣ�\n�����к����ġ����ס���http://baike.baidu.com/view/80043.htm?fr=aladdin");
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
