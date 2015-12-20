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
public class MoreFragmentMJSY extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_mjsy);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_mjsy_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_mjsy_textView);
		textView.setTextSize(12);
		switch (tabIndex) {
		case 0:
			textView.setText("\t\t媒介就是承载信息的一切中介物。而媒介素养则是面对各种媒介信息时的选择能力、理解能力、质疑能力、评价能力、应用能力。\n\t\t媒介素养可以成为帮助我们理解媒介文化的“新眼镜”。通过对具体媒介作品的解读训练，可以在感知、体验、沟通与交流的过程中逐步唤醒自觉意识，增强评价能力，为今后的媒介表达奠定扎实基础。");
			break;
		case 1:
			Drawable d = getResources().getDrawable(R.drawable.map_mjsynh);
			d.setBounds(0, 0, 700, 500); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(d, null, null, null);
			// textView.setText("setCompoundDrawables");
			break;
		case 2:
			textView.setText("1、你认为身临其境的直接观看和借助于媒体的间接观看有什么不同？\n2、下图是一位感动中国的摄影师解海龙的摄影作品 《我要读书》，这个作品表达了“大眼睛”与“希望工程”的关系，你看到了什么？看懂了什么？想到了什么？");
			d = getResources().getDrawable(R.drawable.ireadbook);
			d.setBounds(0, 0, 300, 300); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, null, null, d);
			// textView.append("\t\t\t\t\t\t\t\t\t图  摄影作品《我要读书》");
			break;
		default:

			textView.setText(Html
					.fromHtml("\"大眼睛\"是这样造就的：一位感动了整个中国的摄影师——解海龙。<br/>"
							+ "访问\"解海龙与希望工程网站\":<a href=\"http://news.qq.com/photon/zaixianyingzhan/xiehailong.htm\">http://news.qq.com/photon/zaixianyingzhan/xiehailong.htm</a>"));
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
