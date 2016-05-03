package com.adanac.fakeweixin.slideview.yp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class YP02Activity extends Activity {
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_two_yp_02);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtyp02);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;古琴声声</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：视觉文化网                    时间：2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;古琴，亦称瑶琴、玉琴、七弦琴，是中国最古老的弹拨乐器之一，古琴是在孔子时期就已经盛行的乐器，到现在至少也有三千多年的历史了。本世纪初才被称作“古琴”。琴在中国有着悠久的历史，《诗经·关雎》有“窈窕淑女，琴瑟友之”，《诗经·小雅》亦有“琴瑟击鼓，以御田祖”等记载。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\""
				+ R.drawable.two_yp_gq01
				+ "\"/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>古琴</small><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;古琴的形制，意义丰富而深远。古人对此曾有论述，说:“琴制长三尺六寸五分，象周天三百六十五度，年岁之三百六十五日也；广六寸，象六合也；有上下，象天地之气相呼吸也。其底上曰池,下曰沼,池者水也,水者平也，沼者伏也,上平则下伏。前广而后狭，象尊卑有差也。上圆象天，下方法地。龙池长八寸，以通八风；凤沼长四寸，以合四气。其弦有五，以按五音，象五行也。大弦者君也，缓和而隐；小弦者臣也，清廉而不乱。追文武加二弦，所以雅合君臣之恩也。宫为君，商为臣，角为民，微为事，羽为物。五音画正，天下和平，而兆民。”((五知斋琴谱·上古琴论》)这些说法是否可靠，姑且不论，但至少体现了古人对古琴形制的看法。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;古琴的名曲我们最为熟悉的就属《高山流水》了吧。传说先秦的琴师伯牙一次在荒山野地弹琴，樵夫钟子期竟能领会到是在描绘“巍巍乎志在高山”和“洋洋乎志在流水”。伯牙惊道：“善哉，子之心而与吾心同。”钟子期死后，伯牙痛失知音，摔琴绝弦，终身不操，故有高山流水之曲。</body>"
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
