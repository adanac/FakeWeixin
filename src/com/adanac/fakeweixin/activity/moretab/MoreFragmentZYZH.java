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
 * 能力类 - 资源转化
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class MoreFragmentZYZH extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_zyzh);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_zyzh_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_zyzh_textView);
		textView.setTextSize(12);
		switch (tabIndex) {
		case 0:
			textView.setText(Html
					.fromHtml("一、资源的转化：由“表现什么”转向“怎么表现”，是一种深度挖掘和重新建构，是对原作品或素材的一种创新性技术开发。<br/>二、主要体现：<br/>\t·可视化<br/>\t·符号化<br/>\t·结构化<br/>\t·动态化<br/>\t·多媒体化<br/>\t·本土化"));
			break;
		case 1:
			Drawable d = getResources().getDrawable(R.drawable.map_zyzh);
			d.setBounds(0, 0, 700, 500); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, d, null, null);
			break;
		case 2:

			textView.setText("1.什么是资源的可视化？\n2.查阅并了解可视化方法周期表。");
			break;
		default:
			textView.setText(Html
					.fromHtml("相关链接：<br/>"
							+ "可视化方法周期表：<a href=\"http://www.visual-literacy.org/periodic_table/periodic_table.html\">http://www.visual-literacy.org/periodic_table/periodic_table.html</a><br/>"));
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
