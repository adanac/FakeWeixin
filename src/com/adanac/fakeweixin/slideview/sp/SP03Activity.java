package com.adanac.fakeweixin.slideview.sp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class SP03Activity extends Activity {
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_two_sp_03);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtsp03);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;学生微电影作品《平凡与价值》</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：视觉文化网                    时间：2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;《平凡与价值：一只杯子的自述》是南京师范大学视觉文化团队原创的DV作品，该作品获2014年江苏省第四届大学生艺术展演活动为电影展暨省第三届“阳光校园”优秀DV作品大赛一等奖；南京师范大学第二届“阳光校园”优秀DV作品大赛三等奖。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该作品主要是以一只杯子的视角叙述了她一生的主要经历：作为杯子家族中最平凡的一员，她永远是那个最不起眼的。她曾跟从两位主人，第一位主人对她嗤之以鼻，而第二位主人对她倍加珍惜。而她也最终有幸被放置陈列馆作为储藏，因为她的第二位主人最后成为了一位名人。通过杯子一生的境遇，我们不仅看到了杯子的故事，也看到了两位主人的故事。同时也告诉我们任何平凡的东西都有其自身的价值，关键在于我们要有善于一双发现的眼睛和一颗敏感的心。当我们拥有了这些以后，我们会对生活有更多的发现、观察、思考，也会收获不同的成长，不同的人生。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在张舒予教授的指导下，视觉文化研究所成员群策群力，从DV作品的创意到作品的制作，每个人都献出了自己的力量，借传媒之“手”，表达思想，传递正能量。</body>"
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
