package com.adanac.fakeweixin.slideview.ys;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class YS03Activity extends Activity {
	// private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_four_ys_01);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtys01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;《那山那人那狗》影评</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：奥尔华艺                    时间：2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;这是以一座山，俩代人，一只狗，一次送信的旅途为线索的故事，为我们演绎了俩代人的沟通与理解的故事。父亲作为邮递员常年外出送信，由于与儿子缺少沟通，俩人之间的理解微乎其微。在父亲即将退休，儿子继任父子的工作的时候，父亲与儿子共同踏上了送信的旅途。这次旅途为父子之间建起了一座桥梁，使得俩代人的心通过它融到了一起。这是父亲的最后一次送信，同时是儿子的第一次送信，在旅途中父子之间的距离渐渐拉近，积压20多年的隔阂得以消除，儿子终于理解了常年送信的艰苦和这份工作的意义，父亲也终于明白了儿子多年的等待与无奈，也在与儿子的交流中知道了妻子的多年在外陪伴在自己身边苦衷和想回乡看望的愿望。<br/>"
				+ "&nbsp;<img src='"
				+ R.drawable.imgys03
				+ "' /><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>《那山那人那狗》电影剧照</small><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该片在叙事风格上巧妙的通过层层递进的方式，让故事伴随着父子之间的矛盾的化解来安排。在影片开始，儿子与父亲走在山路上的距离，是隔得很远的，儿子走得飞快在前面，父亲拄着竹棍踉跄的跟在远远的后面，父亲说什么，儿子都说我知道，俩人之间很少交流，儿子心中充满了对父亲的不理解，然而通过途中发生的几次事件，这种距离慢慢消除了，预示着俩人的心慢慢走近，到了影片的后面，儿子与父亲之间的距离已经走得很近了。"
				+ "强光与景深的运用"
				+ "按常理农村的屋内应该是昏暗的，但是强光的巧妙运用，起到了强调人物表情和心理的作用，景深处的母亲在忙碌着，这组镜头轻而易举的让观众得以知道三人之间的关系。"
				+ "色彩的运用"
				+ "在影视作品中，色彩是一种重要的艺术表现手段。绿色象征生命力，活力，给人安宁稳定，和谐,真实,自然，和平的感觉，绿色的背景象征着对山水的爱，乡土的爱，绿色又意味着勃勃的生机与希望。影片中绿色的乡村风光随处可见：绿色的田野，绿色的树木，绿色的山川。无不体现了湘西山村精致的景色。"
				+ "画框的巧妙布局"
				+ "儿子放下父亲时，画面的左边突出的是健硕的儿子，右边是弱小的父亲，真个近景镜头中，画面的比例以儿子多余父亲。前景中的儿子的健壮身躯与中景里父亲弱小的身体形成对比，反映父亲的苍老与儿子的年轻力壮，同时也折射出父亲忙碌了一生以自己的衰老换来了儿子的健康成长，父爱的伟大在这副画面中得到了深层次的体现。"
				+ "</body>" + "</html>";

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
		//
		// // 因为从网上下载图片是耗时操作 所以要开启新线程
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
