package com.adanac.fakeweixin.slideview.fx;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Fx02Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_fx_02);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtfx02);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>《媒介素养读本》（Media Literacy Reading）</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作者：范红                  &nbsp;&nbsp;更新时间：2015.12.18</font></small><br/><br/>"
				+ "<img src=\""
				+ R.drawable.map_three_fx02
				+ "\"/>"
				+ "《媒介素养读本》（Media Literacy Reading）由范红主编，清华大学出版社2008年7月出版，属于新闻与传播系列教材。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该书主要由三大部分构成：媒介与社会文化、媒介语言与话语分析、研究方法与案例分析。在媒介与社会文化部分，主要探讨媒介对社会变迁与大众文化的影响，涉及传媒的现代性、媒介与大众文化、网络传播、新媒体、媒介全球化与消费主义、媒介与性别、媒介与跨文化交流等内容。媒介语言与话语分析，主要探讨新闻传播中的话语问题.研究方法与案例分析涉及了文本产业和受众的研究方法、媒介身份、符号学方法应用、西方“电视文化”研究的三种范式媒体女性形象等内容。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该书涵盖近年来优秀的媒体专题研究的读本，所收入文章主题丰富，强调中国视角，适合高年级本科生和研究生用作媒介素养课程的入门书籍。<br/>	"
				+ "参考资料来源：<br/>"
				+ "[1] 亚马逊.《媒介素养读本》简介[EB/OL].[2015-1-14].http://www.amazon.cn/新闻与传播系列教材•媒介素养读本/dp/B001CZJLPC/ref=sr_1_1?s=books&ie=UTF8&qid=1394697900&sr=1-1&keywords=媒介素养读本.<br/>"
				+ "[2] 清华大学出版社.《媒介素养读本》简介[EB/OL].[2015-1-14]. http://www.tup.tsinghua.edu.cn/book/Showbook.asp?CPBH=025602-01&DJ=34.<br/>"
				+ "</body></html>";
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
