package com.adanac.fakeweixin.slideview.yp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class YP01Activity extends Activity {
	// private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_two_yp_01);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtyp01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;二胡鉴赏</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：视觉文化网                    时间：2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;二胡原先是北方少数民族的乐器，俗称胡琴，岑参《白雪歌送武判官归京》有“胡琴琵琶与羌笛”诗句，说明唐代就传入中原。到了宋代，又将胡琴取名为“嵇琴”。宋代末学者陈元靓在《事林广记》中这样记载：嵇琴本嵇康所制，故名“嵇琴”。后来沈括在《梦溪笔谈》中又记载“马尾胡琴随汉东，曲声犹自怨单于。弯弓莫射去中雁，归雁如今不寄出。”说明在北宋时已有了马尾的胡琴。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\""
				+ R.drawable.two_yp_eh01
				+ "\"/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>二胡</small><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;二胡是由琴筒、琴杆、琴皮、琴轴、琴弦、弓杆、弓毛、千斤以及琴码构成。将二胡的特色发挥的淋漓尽致的当属《二泉映月》了，这首乐曲自始至终流露的是一位饱尝人间辛酸和痛苦的盲艺人的思绪情感，作品展示了独特的民间演奏技巧与风格，以及无与伦比的深邃意境，显示了中国二胡艺术的独特魅力，它拓宽了二胡艺术的表现力，曾获“20世纪华人音乐经典作品奖”。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;<img src=\""
				+ R.drawable.two_yp_eh02
				+ "\"/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>二胡“道器”图</small><br/>"

				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;礼记·乐记》云：“凡音者，由人心者也。声成文，谓之音。”“音”是将“声”通过人的加工之后，参杂着人的感情的艺术之声，是由人的内心所发出的。“大音”就是“道”之音，“道”本无形无声。最完美的创造是不见形迹浑如天成的。“希声”是对违反自然规律的炫技雕琢的否定。最高境界的欣赏是能够超越感官感知，进入到对作品意蕴的品味，从而获得心灵的净化与精神的升华。"
				+ "刚虽坚硬，但易受损；柔虽软弱，但具韧性。刚与柔的两种不同性质，若采取“和”的方式融为一体，通过对立、互补、相融，产生一定的节奏韵律，将会形成既多样又统一的变化美感。脍炙人口的《二泉映月》表现了民间世俗对黑暗社会的不满情绪，演奏时，应用“刚柔相济”的手法。</body>"
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
		// handler = new Handler() {
		// @Override
		// public void handleMessage(Message msg) {
		// if (msg.what == 0x101) {
		// textView.setText((CharSequence) msg.obj);
		// }
		// super.handleMessage(msg);
		// }
		// };

		// 因为从网上下载图片是耗时操作 所以要开启新线程
		// Thread t = new Thread(new Runnable() {
		// Message msg = Message.obtain();
		//
		// @Override
		// public void run() {
		// /**
		// * 要实现图片的显示需要使用Html.fromHtml的一个重构方法：public static Spanned
		// * fromHtml (String source, Html.ImageGetterimageGetter,
		// * Html.TagHandler
		// * tagHandler)其中Html.ImageGetter是一个接口，我们要实现此接口，在它的getDrawable
		// * (String source)方法中返回图片的Drawable对象才可以。
		// */
		// ImageGetter imageGetter = new ImageGetter() {
		//
		// @Override
		// public Drawable getDrawable(String source) {
		// URL url;
		// Drawable drawable = null;
		// try {
		// url = new URL(source);
		// drawable = Drawable.createFromStream(
		// url.openStream(), null);
		// Log.e("width:", drawable.getIntrinsicWidth() + "");
		// Log.e("height:", drawable.getIntrinsicHeight() + "");
		// int[] res = ProcBoundUtil.procBound(
		// drawable.getIntrinsicWidth(),
		// drawable.getIntrinsicHeight());
		// drawable.setBounds(0, 0, res[0], res[1]);
		// } catch (MalformedURLException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// return drawable;
		// }
		// };
		// CharSequence test = Html.fromHtml(html, imageGetter, null);
		// msg.what = 0x101;
		// msg.obj = test;
		// handler.sendMessage(msg);
		// }
		// });
		// t.start();

	}
}
