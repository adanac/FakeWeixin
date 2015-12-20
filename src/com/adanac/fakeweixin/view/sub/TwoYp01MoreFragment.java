package com.adanac.fakeweixin.view.sub;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fragment.LazyFragment;

/**
 * 使用媒介 - 图文
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class TwoYp01MoreFragment extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_two_yp);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_two_yp_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_two_yp_textView);
		textView.setTextSize(12);
		Drawable d = null;
		switch (tabIndex) {
		case 0:
			d = getResources().getDrawable(R.drawable.map_two_yp);
			d.setBounds(0, 0, 800, 1010);
			textView.setCompoundDrawables(null, null, null, d);
			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_two_yp_gq);
			d.setBounds(0, 0, 800, 1010); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, null, null, d);
			break;
		default:
			d = getResources().getDrawable(R.drawable.map_two_yp_pp);
			d.setBounds(0, 0, 800, 1010); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, null, null, d);
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
