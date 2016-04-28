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

public class Sy01Activity extends Activity {
	private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_four_sy_01);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtsy01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>阿尔弗雷德．艾森斯塔特之《时代广场的胜利日》</h2>"
				+ "<p align='center'><font color='#00bbaa'>来源：现代摄影网                    时间：2015.12.10</p>"
				+ "阿尔弗雷德．艾森斯塔特（Alfred Eisenstaedt）世界著名的纪实摄影家，被誉为“新闻摄影之父”(1898—1995)阿尔弗雷德?艾森斯塔特1898年生于西普鲁士。（今天的波兰境内）14岁时他拥有了自己的第一部达折叠胶片机，并开始拍摄，他最为著名的作品就是下面这幅《时代广场的胜利日》。<br/>"
				+ "<img src=\"http://adanac.qiniudn.com/imgsy01.png\"/><br/>"
				+ "《时代广场的胜利日》<br/>"
				+ "当二战结束的消息传到纽约的时代广场，一位狂喜的海军士兵搂过正在身旁的陌生护士热烈地亲吻着她。照片出现于《Times》杂志，是反映战争结束后人们轻松欢乐心情的优秀作品。这幅作品的主体是海军与护士，背景是纽约时代广场，将主体置于画面中心的位置，利用主体优美的身体线条和热烈的亲吻和川流的人群这一陪体对比。作品采用平拍的拍摄角度，采用顺光，更完美的表现了主体，反映战争结束后人们轻松欢乐的心情。"
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
