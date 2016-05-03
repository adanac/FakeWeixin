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

public class Sy02Activity extends Activity {
	private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_four_sy_02);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtsy02);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;解海龙作品《我要读书》</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：现代摄影网                    时间：2015.12.12</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;《我要读书》这个作品出自于我国著名摄影记者解海龙，而照片中的人物名叫苏明娟。20多年前，解海龙像往常一样寻找自己满意的形象和瞬间。瞄着瞄着，他看见了正在那儿低头写字的苏明娟，正巧苏明娟一抬头，瞬息间就把解海龙的心牢牢地抓住了，他这才发现这孩子的眼睛特别大，一张脸上好像一半都是眼睛，瞳孔里似乎有好多窗户反光的亮斑。假如没有这一对眼睛，她虽然长得很匀称秀气，可也就显不出有什么特别引人注意的地方了。而恰恰是这一双眼睛使她全身都灵动起来，那眼神有着很强的穿透性，能够进入到人们的心灵里，使人立刻被牢牢地吸引住。见过也拍过许许多多眼睛的解海龙，眼光历来十分挑剔，然而此刻却只有被征服、被震撼的感觉。<br/>"
				+ "<img src='http://adanac.qiniudn.com/imgsy02.png' />"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>解海龙 《我要读书》</small><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;苏明娟坐在教室的第二排，解海龙要费劲地从前排两个孩子肩膀的空档中掏过去拍摄。教室窗户透进来上午的光线，在她头发上雕刻出鲜明的轮廓，也照亮了女孩的小脸。解海龙迅速地换上了80-200mm变焦镜头，稳稳地端住相机，蹲在教室前面等待着，等待着。当她握着铅笔再次抬起眼睛向前凝视时，解海龙果断地摁下了快门。这一刹那，他只有一种感受，那就是创作的快感：结构画面的快感，抓取瞬间的快感，把握光线的快感。贯穿他整个创作过程的环节其实非常简单，前后只拍了两张底片，一横一竖，那幅竖画面就成了永恒。"
				+ "从此，当我们走遍全国的大街小巷，偶尔回首，常会发现一个农村的小女孩睁着一双忧郁大眼睛的照片，立在不经意的角落，每天看着我们来去匆匆。那是一双美丽的大眼睛，乌黑透澈；那是一双失神的大眼睛，隐约闪现若晶莹的泪光，流露出对知识的渴望与追求，对生活的无奈与叹息，对校园的留恋与惆怅。它怯怯灵灵地默默凝视，真真切切略带哀愁，善良的人几乎没有勇气跟她对视；它对心灵有着一种无可抗拒的威慑力，它召唤你却不轻许你，它震撼你又不惊动你，它让你在她渴求的眼神中沐浴，悄悄地触动你心坎上某根早已荒疏的弦。"
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
