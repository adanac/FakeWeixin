package com.adanac.fakeweixin.slideview.fx;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Fx01Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_fx_01);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtfx01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;《媒体融合新论》</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作者：万小广                   &nbsp;&nbsp;更新时间：2015.12.18</font></small><br/><br/>"
				+ "<img src=\""
				+ R.drawable.map_three_fx01
				+ "\"/>"
				+ "《媒体融合新论》一书由万小广编著，新华出版社于2015年7月出版。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在“互联网+”的新形势下，传统媒体应该如何推进媒体融合，以更强大的力量推动社会的发展与进步？这是值得每一个媒体人认真思考的时代课题。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;书关注和思考传统媒体在推进媒体融合过程中的“道”与“术”。具体而言，一方面从理论层面探究网络新媒体技术所催生的新传播生态，包括它的主要特征、对新闻人与新闻业的影响以及传统媒体的应对战略；另一方面从实践层面分析新闻报道、新闻伦理、新闻生产模式以及舆论引导应当如何创新，以适应新闻舆论场的新变化。本书还对“病毒式传播”“大数据”“自媒体”“物联网”等几个影响新闻业发展的大趋势进行深入分析，以期从更广阔的视野探究媒体融合的未来走向。<br/>	"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本书抓住了当下国内传媒领域普遍关注的一个热点问题，提供了许多新鲜而有价值的信息，也提供了许多富有启迪意义的思考，为学界人士认识媒体融合的必然性、媒体融合的形态及其机理、媒体融合的影响提供了崭新视角，有助于业界朋友在如何应对媒体融合大趋势时拓宽视野并打开思路。<br/>"
				+ "参考资料来源：<br/>"
				+ "[1]豆瓣读书[EB/OL]http://book.douban.com/subject/26438768/[2015-12-10]<br/>"
				+ "[2]京东[EB/OL]http://item.jd.com/11719363.html[2015-12-10]<br/>"
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
