package com.adanac.fakeweixin.slideview.xz;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Xz02Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_xz_02);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtxz02);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;陆晔</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：复旦大学媒介素养小组                  时间：2015.12.18</font></small><br/><br/>"
				+ "<img src='"
				+ R.drawable.map_three_xz02
				+ "'/>"
				+ "陆晔，复旦大学新闻学院教授，复旦大学信息与传播研究中心“传播媒介与社会研究所”所长，中国新闻教育学会传播学研究分会秘书长,国际中华传播学会会员。主要研究领域为广播电视产业、新闻专业主义和中国媒体改革、媒介素养研究等。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1983年本科毕业于华中理工大学自动控制与计算机工程系，获工学学士学位；1987年毕业于北京广播学院新闻研究所，后获法学（新闻学）硕士学位；1994年在复旦大学获法学（新闻学）博士学位；1998年9月至1999年9月作为富布莱特高级访问学者在美国南加州大学安纳伯格传播学院进行访问研究；2000年2月至9月在香港中文大学新闻与传播学院从事博士后研究；2000年11月在英国诺丁汉特伦特大学英语与媒介系进行访问研究。2002年香港浸会大学传理学院进行学术访问。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1997年，香港中文大学新闻传播学院访问学者；1998至1999年，美国南加州大学安尼伯格传播学院，富布莱特高级访问学者；2000年，香港中文大学新闻传播学院从事博士后研究；2000年英国诺丁汉特伦特大学英语与媒介系，学术访问；2002年香港浸会大学传理学院，学术访问。<br/>	"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;由陆晔教授带头成立的“复旦大学媒介素养小组”是中国大陆地区最早组建的媒介素养研究和实践的团队之一，也是最早开始媒介素养研究和实践的学术研究小组之一。她一直努力地进行着媒介素养和媒介素养教育的研究与实践。<br/>"
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
