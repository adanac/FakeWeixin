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
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Sf03Activity extends Activity {
	private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_four_sf_03);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtsf03);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h1>元代赵孟頫行书《洛神赋》卷</h1>"
				+ "<p align='center'><font color='#00bbaa'>来源：中国书法家园                    时间：2015.12.18</p>"
				+ " 赵孟頫书，纸本，行书。纵29cm，横220.9cm。 全卷共80行，末署款“子昂”。后纸元员峤山人(李倜)，明高启，清王铎、曹溶题跋。前隔水王铎“戍子五月”又题。<br/>"
				+ "<img src='http://adanac.qiniudn.com/imgsf03.png' /><br/>"
				+ "元  《洛神赋》卷<br/>"
				+ "赵孟頫是元代著名书画家，不仅绘画创一代新风，书法更是元代第一人，如元代书法名家鲜于枢所评：“子昂篆、隶、真、行、颠草为当今第一。”赵氏所创书风，后人称之为“赵体”。赵孟頫师承也极广泛，初宗宋人，学赵构、黄庭坚，继而由智永上溯锺繇、二王，晚年又取法李邕。他模拟古法力求微肖，书写十分熟练，尤倾心于二王，元虞集在《道园学古录》中指出：“楷法深得《洛神赋》而揽其标；行书诣《圣教序》而入其室；至于草书，饱《十七帖》而变其形。”赵孟頫的书法成就突出表现在楷、行书方面，创遒劲姿媚新风，对元人和后世均产生极大影响。"
				+ "此卷《洛神赋》即为赵氏行书代表作。行中兼楷的结体、点画，深得二王遗意，尤其是王献之《洛神赋》的神韵，即妍美洒脱之风致。如端正匀称的结构、优美潇洒的字姿、圆润灵秀的运笔、密中有疏的布局等；同时，又呈现自身的追求，象比较丰腴的点画，轻捷的连笔，飘逸中见内敛的运锋，端美中具俯仰起伏的气势，都显示出他博取众长而自成一体的艺术特色。故后纸诸家题跋如是评述此卷，李倜曰：“大令好写洛神赋，人间合有数本，惜乎未见其全。此松雪书无一笔不合法，盖以兰亭肥本运腕而出之者，可云买王得羊矣。”高启云：“赵魏公行草写洛神赋，其法虽出入王氏父子间，然肆笔自得，则别有天趣，故其体势逸发，真如见矫若游龙之入于烟雾中也。”"
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
