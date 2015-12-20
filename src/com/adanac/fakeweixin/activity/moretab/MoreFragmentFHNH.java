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
 * 意义所指层次图
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class MoreFragmentFHNH extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_fhnh);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_fhnh_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_fhnh_textView);
		textView.setTextSize(12);
		Drawable d = null;
		switch (tabIndex) {
		case 0:
			textView.setMovementMethod(ScrollingMovementMethod.getInstance());
			d = getResources().getDrawable(R.drawable.map_fhnh_zuoye);
			d.setBounds(0, 10, 450, 300); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, null, null, d);
			textView.setMovementMethod(LinkMovementMethod.getInstance());
			textView.setText(Html.fromHtml("<b>符号的实质与功能</b><br/>"
					+ "1.符号的实质是代表：“把符号定义为可代表其他东西的某种东西”。<br/>"
					+ "2.“符号”的功能——代表性<br/>" + "“符号=代表者”<br/>" + "“表达对象=被代表者”"));

			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_fhnh);
			d.setBounds(0, 0, 700, 500); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(d, null, null, null);
			// textView.setText("setCompoundDrawables");
			break;
		case 2:
			d = getResources().getDrawable(R.drawable.map_fhnh_taolun);
			d.setBounds(0, 10, 350, 200); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, d, null, null);
			textView.setMovementMethod(LinkMovementMethod.getInstance());
			textView.setText("\t\t\t\t\t\t\t\t\t\t图：视觉文化网站LOGO\n\n");
			textView.append(Html
					.fromHtml("观察视觉文化网站的LOGO造型，这个LOGO是符号吗？你能对此进行解读吗?"));
			break;
		case 3:
			textView.setText("\t\t\t\t\t作业讨论");
			break;
		default:
			textView.setText(Html
					.fromHtml("<b>相关链接：</b><br/>"
							+ "视觉文化网：<a href=\"http://www.fromeyes.cn/\">http://www.fromeyes.cn/</a><br/>"));
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
