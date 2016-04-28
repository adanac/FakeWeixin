package com.adanac.fakeweixin.slideview.sf;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fakeweixin.util.ProcBoundUtil;

public class Sf02Activity extends Activity {
	private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_four_sf_02);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtsf02);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h1>苏轼《寒食帖》</h1>"
				+ "<p align='center'><font color='#00bbaa'>来源：中国书法家园                    时间：2015.11.25</p>"
				+ "《黄州寒食诗帖》，纸本，25 行，共129字，是苏轼行书的代表作。这是一首遣兴的诗作，是苏轼被贬黄州第三年的寒食节所发的 人生之叹。诗写得苍凉多情，"
				+ "表达了苏轼此时惆怅孤独的心情。此诗的书法也正是在这种心情和境况下，有感 而出的。通篇书法起伏跌宕，光彩照人，气势奔放，而无荒率之笔。《黄州寒食诗帖》在书法史上影响很大，"
				+ " 被称为“天下第三行书”，也是苏轼书法作品中的上乘。正如黄庭坚在此诗后所跋：“此书兼颜鲁公，杨少师， 李西台笔意，试使东坡复为之，未必及此。<br/>"
				+ "<img src='http://adanac.qiniudn.com/imgsf02.png' /><br/>"

				+ "苏轼《黄州寒食诗帖》<br/>"
				+ "【释文】："
				+ "自我来黄州，已过三寒食。年年欲惜春，春去不容惜。 今年又苦雨，两月秋萧瑟。卧闻海棠花，泥污燕支雪。暗中偷负去，夜半真有力，何殊病少年，病起头已白。"
				+ "春江欲入户，雨势来不已。小屋如渔舟，蒙蒙水云里。空庖煮寒菜，破灶烧湿苇。那知是寒食，但见乌衔纸。君门深九重，坟墓在万里。也拟哭涂穷，死灰吹不起。"
				+ "诗中阴霾的意象如小屋、空庖、乌衔纸、 坟墓……渲染出一种沉郁、凄怆的意境。表达出了作者时运不济谪居黄州的灰暗烦闷的心境。 从文中“空庖煮寒菜，破灶烧湿苇”，可以想见他窘迫的生活。这两首诗放在苏轼三千多首诗词中，并非是其上乘之作。而当作者换用另一种艺术形式——书法表达出来的时候，那淋漓多姿、意蕴丰厚的书法意象酿造出来的悲凉意境，遂使《黄州寒食诗帖》成为千古名作。"
				+ "《黄州寒食诗帖》彰显动势，洋溢着起伏的情绪。诗写得苍凉惆怅，书法也正是在这种心情和境况下，有感而出的。通篇起伏跌宕，迅疾而稳健，痛快淋漓，一气呵成。苏轼将诗句心境情感的变化，寓于点画线条的变化中，或正锋，或侧锋，转换多变，顺手断联，浑然天成。其结字亦奇，或大或小，或疏或密，有轻有重，有宽有窄，参差错落，恣肆奇崛，变化万千。难怪黄庭坚为之折腰，叹曰：“东坡此诗似李太白，犹恐太白有未到处。此书兼颜鲁公、杨少师、李西台笔意，试使东坡复为之，未必及此。”(《黄州寒食诗跋》)董其昌也有跋语赞云：“余生平见东坡先生真迹不下三十馀卷，必以此为甲观”。《黄州寒食诗帖》是苏轼书法作品中的上乘，在书法史上影响很大，元朝鲜于枢把它称为继王羲之《兰亭序》、颜真卿《祭侄稿》之后的“天下第三行书”。"
				+ "</body>" + "</html>";

		textView.setMovementMethod(ScrollingMovementMethod.getInstance());// 滚动

		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (msg.what == 0x101) {
					textView.setText((CharSequence) msg.obj);
				}
				super.handleMessage(msg);
			}
		};

		// 因为从网上下载图片是耗时操作 所以要开启新线程
		Thread t = new Thread(new Runnable() {
			Message msg = Message.obtain();

			@Override
			public void run() {
				/**
				 * 要实现图片的显示需要使用Html.fromHtml的一个重构方法：public static Spanned
				 * fromHtml (String source, Html.ImageGetterimageGetter,
				 * Html.TagHandler
				 * tagHandler)其中Html.ImageGetter是一个接口，我们要实现此接口，在它的getDrawable
				 * (String source)方法中返回图片的Drawable对象才可以。
				 */
				ImageGetter imageGetter = new ImageGetter() {

					@Override
					public Drawable getDrawable(String source) {
						URL url;
						Drawable drawable = null;
						try {
							url = new URL(source);
							drawable = Drawable.createFromStream(
									url.openStream(), null);
							Log.e("width:", drawable.getIntrinsicWidth() + "");
							Log.e("height:", drawable.getIntrinsicHeight() + "");
							int[] res = ProcBoundUtil.procBound(
									drawable.getIntrinsicWidth(),
									drawable.getIntrinsicHeight());
							drawable.setBounds(0, 0, res[0], res[1]);
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						return drawable;
					}
				};
				CharSequence test = Html.fromHtml(html, imageGetter, null);
				msg.what = 0x101;
				msg.obj = test;
				handler.sendMessage(msg);
			}
		});
		t.start();

	}
}
