package com.adanac.fakeweixin.slideview.sp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class SP02Activity extends Activity {
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_two_sp_02);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtsp02);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>教学微视频之《媒介素养的内涵》</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：视觉文化网                    时间：2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;微视频的主要目的是辅助“视觉文化与媒介素养”课程的课外学习，如果您对其中的某一个知识点不理解或者有疑惑可以通过观看本知识点的微视频。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;为方便课下学习，南京师范大学2014届视觉文化研究所成员将教学资源在张舒予导师的配合下，拍摄录制并编辑制作出微视频教学作品，方便同学们课下随时观看。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本知识点的主要内容有：<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;媒介就是承载信息的一切中介物。而媒介素养则是面对各种媒介信息时的选择能力、理解能力、质疑能力、评价能力、应用能力。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;媒介素养可以成为帮助我们理解媒介文化的“新眼镜”。通过对具体媒介作品的解读训练，可以在感知、体验、沟通与交流的过程中逐步唤醒自觉意识，增强评价能力，为今后的媒介表达奠定扎实基础。</body>"
				+ "</html>";
		textView.setMovementMethod(ScrollingMovementMethod.getInstance());// 滚动

		ImageGetter imageGetter = new ImageGetter() {
			@Override
			public Drawable getDrawable(String source) {
				int id = Integer.parseInt(source);

				// 根据id从资源文件中获取图片对象
				Drawable d = getResources().getDrawable(id);
				d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
				return d;
			}
		};

		textView.append(Html.fromHtml(html, imageGetter, null));

	}
}
