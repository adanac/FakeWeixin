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
 * 能力类-资源运用
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
					.fromHtml("·资源的运用过程——贯穿于解读-分析-沟通-表达的过程之中，实现透过现象，揭示本质，体现价值，表达观点的逐步深化。<br/>·资源的运用方法——研究性学习<br/>\t（1）体验的方法<br/>\t（2）发现问题和解决问题的方法<br/>\t（3）分析、利用信息的方法<br/>\t（4）合作的方法<br/>学生的体悟阐释：<br/>"));
			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_zyyy);
			d.setBounds(0, 0, 700, 500); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, d, null, null);
			break;
		case 2:
			d = getResources().getDrawable(R.drawable.map_zyyy_zuoye01);
			d.setBounds(0, 0, 300, 400); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, null, d, null);
			Drawable d1 = getResources().getDrawable(
					R.drawable.map_zyyy_zuoye02);
			d1.setBounds(0, 0, 300, 400); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, null, null, d1);
			textView.setText("1.背景奥运会的开幕式在资源开发中选用了哪些民族文化元素？进行了怎样的加工？采用了什么方法加以运用？");
			break;
		default:
			textView.setText(Html
					.fromHtml("相关链接：<br/>"
							+ "北京奥运会网站：<a href=\"http://www.beijing2008.cn/\">http://www.beijing2008.cn/</a><br/>"));
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
