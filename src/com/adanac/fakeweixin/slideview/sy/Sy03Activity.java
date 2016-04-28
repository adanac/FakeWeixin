package com.adanac.fakeweixin.slideview.sy;

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

public class Sy03Activity extends Activity {
	private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_four_sy_03);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtsy03);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h1>曼．雷Man Ray之《泪珠》</h1>"
				+ "<p align='center'><font color='#00bbaa'>来源：现代摄影网                   时间：2015.12.18</p>"
				+ " 与其拍摄一个东西，不如拍摄一个意念；<br/>"
				+ "与其拍摄一个意念，不如拍摄一个幻梦。<br/>"
				+ "                              ——曼．雷<br/>"
				+ "在摄影史上，曼·雷以勇于探索、大胆创新而著称。曼·雷是世界上最早广泛运用摄影的特殊技法来进行摄影创作的艺术探索者,许多今天仍然流传不衰的摄影技法就是由他始创的。他大大扩展了摄影艺术的领域，开辟了一片前所未有的新天地，因而被认为是当代摄影史上最重要的先驱之一。<br/>"
				+ "<img src='http://adanac.qiniudn.com/imgsy03.png' /><br/>"
				+ "《泪珠》<br/>"
				+ "《泪珠》这幅照片是曼·雷一系列创作中最负盛名的一幅代表作。首先是大特写画面带给我们的视觉冲击：造型美丽的两只大眼睛，感伤的怅惘的眼神，滚滚发亮的泪珠。其次是我们对人物情绪的联想：为什么如此忧伤，是生活陷于困境？是爱情受到了欺骗？是对人生感到绝望？精彩的特写概括了丰富的内容。"
				+ "其实，曼·雷为了取得这样强烈的艺术效果，同样打破了传统的如实记录的方法。为了突出泪珠，他并没有真去拍摄泪珠，而是找来五粒晶莹欲滴的玻璃球，布好光拍摄下来，比真泪珠还要动人、漂亮。这是曼·雷的大胆探索，也是他的创作特色。"
				+ "同时，在这个特写镜头里，曼·雷大胆突破了当时普遍存在的摄影师与被摄者之间的距离，把相机推到了被摄者的身旁，甚至直逼被摄者的面孔。这摒弃了一切多余之物的大特写镜头，可以最大限度地突出表现某个细小的局部，在视觉上会产生强烈的冲击力，直至现在仍不断地在电影和摄影中运用。因为他的各种创新，曼?雷还得到了“现代摄影之父”的美称。"
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
