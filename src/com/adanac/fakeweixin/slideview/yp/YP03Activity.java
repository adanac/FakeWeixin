package com.adanac.fakeweixin.slideview.yp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class YP03Activity extends Activity {
	private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_two_yp_03);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtyp03);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;琵琶无相</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：视觉文化网                    时间：2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;琵琶由历史上的直项琵琶及曲项琵琶演变而来，据史料记载，直项琵琶在我国出现得较早，秦、汉时期的“秦汉子”，是直柄圆形共鸣箱的直项琵琶（共鸣箱两面蒙皮），它是由秦末的弦鼗发展而来的。“阮咸”或“阮”是直柄木制圆形共鸣箱，四弦十二柱，竖抱用手弹奏的琵琶。晋代阮咸善奏此乐器，故以其名相称，即今天的阮。琵琶的种类是多种多样的，有五弦琵琶、南音琵琶、电琵琶<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\""
				+ R.drawable.two_yp_pp01
				+ "\"/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>琵琶种类图</small><br/>"
				+ "以及水晶琵琶等等。琵琶也有诸多派系，有浦东派、平湖派、无锡派、汪派等。 <br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;琵琶的十大名曲有：《塞上曲》、《阳春白雪》、<br/>《霸王卸甲》、《昭君出塞》、《十面埋伏》等。<br/>其中《阳春白雪》以清新流畅的旋律、活泼轻快的节奏，生动地体现了冬去春来，大地复苏，万物向荣，生气勃勃的初春景象。它分为七段：1.<br/>"
				+ "&nbsp;<img src=\""
				+ R.drawable.two_yp_pp02
				+ "\"/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>《阳春白雪》的“起承转合”</small><br/>"

				+ "独占鳌头；2.风摆荷花；3.一轮明月；4.玉版参禅；5.铁策板声；6.道院琴声；7.东皋鹤鸣。</body>"
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
