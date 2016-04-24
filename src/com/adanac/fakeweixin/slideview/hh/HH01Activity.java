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
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class HH01Activity extends Activity {
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
				+ "<h1>顾闳中《韩熙载夜宴图》</h1>"
				+ "<p align='center'><font color='#00bbaa'>来源：百度百科                   时间：2015.10.10</p>"
				+ "五代顾闳中的《韩熙载夜宴图》，在图中，我们可以发现，每个人似乎不是一样大小的，为什么呢？图中似乎在坐榻中的人物画的比较大，歌伎相对画的小，这些人为什么在画中占的比例不同呢？我们可以发现，凡是身份重要的人物的尺寸远远大于其他人物。按西方的透视规律，简直是不可思议的。而中国画可以随艺术家的意象思维而度量时空，使客体的“科学性”屈服于主体的意象观念性，尤其在章法上强调“创辟意境”。<br/>"
				+ "<img src=\"http://adanac.qiniudn.com/imghh01.png\"/><br/>"
				+ "《韩熙载夜宴图》<br/>"
				+ "《韩熙载夜宴图》在艺术处理上，采取了传统的构图方式，打破时间概念，把不同时间中进行的活动组织在同一画面上。全画组织连贯流畅.，画幅情节复杂，人物众多，却安排得宾主有序，繁简得度。在场景之间，画家非常巧妙地运用屏风、几案、管弦乐品、床榻等之类的器物，使之既有相互连接性，又有彼此分离感；既独立成画，又是一幅画卷。"
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
							drawable.setBounds(0, 0,
									drawable.getIntrinsicWidth(),
									drawable.getIntrinsicHeight());
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
