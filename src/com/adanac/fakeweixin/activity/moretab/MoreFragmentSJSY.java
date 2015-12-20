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
		setContentView(R.layout.fragment_tabmain_sjsy);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_sjsy_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_sjsy_textView);
		textView.setTextSize(12);
		switch (tabIndex) {
		case 0:
			textView.setText("^_^");
			break;
		case 1:
			Drawable d = getResources().getDrawable(R.drawable.map_sjsy);
			d.setBounds(0, 0, 700, 500); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(d, null, null, null);
			// textView.setText("setCompoundDrawables");
			break;
		case 2:
			d = getResources().getDrawable(R.drawable.map_sjsy_zuoye);
			d.setBounds(0, 0, 700, 400); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, d, null, null);
			textView.setText("\t\t\t\t\t\t\t\t\t\t\t\t图1 摄影师");
			textView.append("\n1、摄影师、照相机和影像作品如何影响读者的观看？");
			break;
		default:
			textView.setText(Html
					.fromHtml("<b>相关链接：</b><br/>罗立中和他的《父亲》："
							+ "<a href=\"http://baike.baidu.com/view/80043.htm?fr=aladdin\">http://baike.baidu.com/view/80043.htm?fr=aladdin</a>"));
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
