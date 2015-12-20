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
 * 情感类 - Flash
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
					.fromHtml("一、Flash的形式特点<br/>\t1.注重创意的表达<br/>\t2.注重视听的结合<br/>\t3.简洁夸张的人物造型设计<br/>\t4.多样的美术设定类型<br/>"
							+ "二、Flash的内容选择<br/>\t1.“纪事性”的作品<br/>\t2.“历史性”、“故事性”的作品<br/>\t3.“教学性”的作品<br/>\t4.“娱乐性”的作品<br/>\t5.“广而告之”的作品<br/>"
							+ "三、解读Flash作品的三个步骤<br/>\t首先分析其表现形式的特征，然后关注内容，最后思考作者通过这个Flash想表达出什么感情或观点。"));

			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_flash_car);
			d.setBounds(0, 0, 500, 500); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, d, null, null);
			textView.setMovementMethod(ScrollingMovementMethod.getInstance());
			break;
		case 2:
			textView.setText("1.Flash作品的内容选择范围主要有哪些？\n2.你最喜欢的Flash是哪种风格的作品？给你带来怎样的感受？");
			break;
		default:
			textView.setText(Html
					.fromHtml(" Flash资源下载地址：<br/>"
							+ " 《北京麻将》：<a href=\"http://download.pchome.net/game/card/10919.html\">http://download.pchome.net/game/card/10919.html</a><br/>"
							+ " 《天堂没有高跟鞋》：<a href=\"http://www.f130.net/FLASH/music7255.htm\">http://www.f130.net/FLASH/music7255.htm</a><br/>"
							+ " 《小破孩》：<a href=\"http://www.f130.net/FLASH/music7255.htm\">http://www.f130.net/FLASH/music7255.htm</a><br/>"));
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
