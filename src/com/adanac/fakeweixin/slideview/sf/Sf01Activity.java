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

public class Sf01Activity extends Activity {
	private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_four_sf_01);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtsf01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;晋·王羲之《快雪时晴帖》</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：光明日报                    时间：2015.10.10</br></font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;《快雪时晴帖》是晋朝书法家王羲之的书法作品，以行书写成，现存此帖怀疑是唐代摹本，目前尚未定论。贴纵23cm；横14.8cm ，行书四行，二十八字。《快雪时晴帖》是一封书札，其内容是作者写他在大雪初晴时的愉快心情及对亲人的问候。<br/>"
				+ "<img src=\"http://adanac.qiniudn.com/imgsf01.png\"/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>《快雪时晴帖》</small><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;释文："
				+ "羲之顿首。快雪时晴，佳想安善。未果为结。力不次。王羲之顿首。山阴张侯。"
				+ "原文释义："
				+ "王羲之拜上：刚才下了一阵雪，现在天又转晴了，想必你那里一切都好吧！那件事情没能帮上忙，心里纠结至今。世上很多事情就是这么无奈。王羲之拜上，山阴张侯亲启。"
				+ "赏析："
				+ "大雪过后，天候转晴，王羲之以这件短札向友人表达问候之意。末行“山阴张侯”可能是收信人的名字，原本写在信笺的封面，在此与原迹一并摹在同一张纸上。"
				+ "这件书迹以圆笔藏锋为主，起笔与收笔，钩挑波撇都不露锋鋩，由横转竖也多为圆转的笔法，结体匀整安稳，显现气定神闲，不疾不徐的情态，明代鉴藏家詹景凤以 “圆劲古雅，意致优闲逸裕，味之深不可测”形容它的特色，并且认为赵孟頫受到这件书迹的影响。不过王羲之内敛沉潜，赵孟頫微有锋鋩外露，比较对幅赵孟頫的题跋，可以得到这样的印象。"
				+ "王羲之书法的特点在於优美的“体势”，“体”是指结字的形状和姿态，“势”是指笔画产生的律动感，以“快”字为例，左右相向的两部份，有著呼应的关系，“ 夬”的右肩略微高耸，末笔右顿，调和了倾斜的姿势。“雪”字也有类似的情形，上部向左倾斜，末一横画收笔有向右下的笔势，所以也调整了整个字的重心。第一行感觉上下的“行气”一贯，为什麼有这样的感觉呢？如果只看每个字横向的笔画，可以发现倾斜的角度大致相同，而同一行字的重心也都在同一中线上，第二行则有些变化，“果为”有连笔，其他的字间距较疏，重心也有偏右偏左的变化。这些变化显得很自然，也使得这短短的三行具有丰富的美感。"
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
