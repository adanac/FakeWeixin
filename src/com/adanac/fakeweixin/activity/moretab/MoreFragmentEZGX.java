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
 * 意义所指层次图
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class MoreFragmentEZGX extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_ezgx);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_ezgx_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_ezgx_textView);
		textView.setTextSize(12);
		switch (tabIndex) {
		case 0:
			textView.setText("1.视觉素养：观看与理解的能力\n\n2.媒介素养：通过媒介观看理解与应用的能力\n\n3.二者之间的关系：水乳相交、难以分割");
			break;
		case 1:
			Drawable d = getResources().getDrawable(R.drawable.map_ezgx);
			d.setBounds(0, 0, 700, 500); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, d, null, null);
			break;
		case 2:

			textView.setText("1.根据自己的理解表述媒介素养和视觉素养的主要区别。");
			break;
		default:
			textView.setText(Html
					.fromHtml("相关链接：<br/>"
							+ "视觉文化网：<a href=\"http://www.fromeyes.cn/\">http://www.fromeyes.cn/</a><br/>"
							+ "媒介素养在线项目资源汇总：<a href=\"http://interact.uoregon.edu/medialit/MLR/home/\">http://interact.uoregon.edu/medialit/MLR/home/</a>"));
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
