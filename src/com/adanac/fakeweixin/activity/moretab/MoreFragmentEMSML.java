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
 * 情感类-水墨画
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
			textView.setText(Html.fromHtml("1.对表现因素的分析<br/>"
					+ " 南齐谢赫在《画品录》中提到的品评绘画技法的主要依据——六法："
					+ " 气韵生动、骨法用笔、应物象形、随类赋彩、经营位置、传移模写<br/>"
					+ "2.对非表现因素的分析<br/>" + " 思想内容——找倾向、抓关键<br/>"
					+ " 时代背景——把握时代特点"));
			break;
		case 1:
			Drawable d = getResources().getDrawable(R.drawable.map_emsml_zp01);
			d.setBounds(0, 0, 450, 290); // 必须设置图片大小，否则不显示

			Drawable d1 = getResources().getDrawable(R.drawable.map_emsml_zp02);
			d1.setBounds(0, 0, 450, 290); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, d, null, d1);
			textView.setMovementMethod(ScrollingMovementMethod.getInstance());
			break;
		case 2:
			textView.setText("1.在日常生活中你还在哪些媒体传播或场合中见到或感受到中国绘画元素 ?\n"
					+ "2.试用Photoshop、Flash等媒体编辑工具完成一个带有中国画元素的小作品。");
			break;

		default:
			textView.setText(Html
					.fromHtml(" 相关资源链接：<br/>"
							+ " 华夏书画网：<a href=\"http://www.shu-hua.com\">http://www.shu-hua.com</a><br/>"));
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
