package com.adanac.fakeweixin.slideview.wz;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Wz01Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_wz_01);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtwz01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>泛媒介时代的全民媒介素养教育</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作者：陈昌凤                  更新时间：2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;传媒对我们的成长到底产生了怎样的影响？让我们从一项研究报告说起。2008年11月美国《儿科》（Pediatrics）杂志发表的报告显示：少年怀孕与看太多与性相关的电视节目有关。该研究对2003位12—17岁的少年调查后发现，观看较多与性相关的流行电视剧如《绯闻女孩》、《绝望主妇》的少男少女偷吃禁果的几率更高，怀孕的几率是较少看同类节目者的两倍。但电视并不是对青少年产生影响最大的媒体。美国国家广电业者协会的一位发言人认为，一般广播电视对青少年的直接影响，远小于有线电视、卫视和互联网带来的影响。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;传媒塑造“拟态世界”<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;现代人终生生存于一个媒介化的世界，传媒无所不在，为我们“塑造”出一个“拟态世界”，它不是现实世界的一种再现，而是传媒通过对象征性事件或信息进行选择加工，重新结构化以后向我们展示的世界。我们通常意识不到那个加工的过程，往往会把传媒展示的世界当成客观世界本身。我们常常据此对“拟态世界”作出反应——付诸实际行为，用我们的反应直接作用于现实世界。由于“拟态世界”与现实世界之间的偏差，造成了许多的问题甚至悲剧，而问题最多的阶段就是我们的青少年时期。舆论普遍认为，电视媒体造成孩子的早熟、消费主义、暴力、价值观混乱等等不良影响，传媒在少儿的身心不健康方面有着不可推卸的责任。2008年全国人大常委会进行的第一次执法检查显示，约10%的未成年网民、达400万之众的中国“网瘾少年”，其学习、生活和身心健康受到沉迷于网络的不良影响，网瘾还引发诸多社会问题，给家庭和社会带来危害。未成年人违法犯罪呈现暴力型、团伙化、低龄化、作案手段成人化的趋势，这其中就有传媒的重要影响。<br/>	"
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
