package com.adanac.fakeweixin.slideview.hh;

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

public class HH02Activity extends Activity {
	private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_four_qt_01);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtqt01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h1>黄公望的《富春山居图》</h1>"
				+ "<p align='center'><font color='#00bbaa'>来源：中国书法家园                    时间：2015.10.10</p>"
				+ "《富春山居图》是黄公望晚年的杰作，也是中国古代山水画的巅峰。让我们一起来欣赏这副杰作，试想是何原因使得这副画在电影中引得那么多人去争夺。<br/>"
				+ "<img src='http://adanac.qiniudn.com/imghh02.png' /><br/>"

				+ "黄公望的《富春山居图》<br/>"
				+ "画中描绘坡岸水色，远山隐约，接着是连绵起伏，群峰争奇的山峦，再下是茫茫江水，天水一色，最后则高峰突起，远岫渺茫。山间丛林茂密，点缀村舍、茅亭，水中则有渔舟垂钓。即使没有去过富春山，我们在画中仍然可以感受到画家希望通过《富春山居图》来展现的“象”，即山浩渺连绵的富春山水。"
				+ "画家运用线的虚实强弱和浓淡干湿的合理安排能体现物象空间的存在，能够感受到不能远近的山川；高古游丝描与铁线描分别代表着不同的质感，线条勾勒的运动与不同的结构方式能表现不同张力，给人不同的感受；线的穿梭、重叠、藏露能表现画面的层次，线的轻重缓急、抑扬顿挫能表现物象的节奏和韵律等等，在《富春山居图》中的能够感受到山峦的跌宕起伏的美感。"
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
