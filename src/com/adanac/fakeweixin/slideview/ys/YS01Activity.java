package com.adanac.fakeweixin.slideview.ys;

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

public class YS01Activity extends Activity {
	private Handler handler;
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
				+ "<h1>《红高粱》影评</h1>"
				+ "<p align='center'><font color='#00bbaa'>来源：奥尔华艺                   时间：2015.12.18</p>"
				+ "<img src=\"http://adanac.qiniudn.com/imgys01.png\"/><br/>"
				+ "《红高粱》电影剧照<br/>"
				+ "色彩和造型上获得不俗的效果"
				+ "张艺谋作为摄影出身的导演，色彩和造型一直是他所关注的。对于电影色彩和造型艺术的探索也显示了他在美学方面的天才，他的电影画面从来就不缺乏视觉冲击力。张艺谋不但善于使用适当的电影色彩以使观众产生心理刺激和视觉震撼，而且擅长使用独特的造型达到他所追求的隐喻和象征效果。"
				+ "色彩实际上是包含在造型艺术里的。在电影作品中，色彩和光线、画面构图等都具有视觉造型的功能。但是本文为了突出张艺谋独具特色的色彩运用，特别地将色彩单列出来进行论述。"
				+ "张艺谋惯于在他的电影中使用色彩斑斓的造型来烘托电影的气氛，增强视觉效果。这些造型可能是一幕场景，一些道具，也可能是一些动作，它们和故事情节紧密结合，不光给予观众以强大的视觉冲击，也象征性的传递了导演想在电影中表现的主题。"
				+ "在《红高粱》中，电影造型的精巧几乎成为张艺谋在艺术形式上最主要的追求。《红高粱》的追求是对生命力的讴歌，影片在表现的时候，选取了一系列独特的造型：抬轿的狂颠，高粱地上的野合，酿酒时热闹繁忙的场面，伙计们抱着酒罐向日本的汽车冲去;太阳下爷爷奶奶泥塑般的造型，孩子声嘶力竭的哭喊和日食等。《红高粱》中无边无际的高粱地，黄土弥漫的土围墙，火光，水气冲天的酒坊，都表现了原始生命力的蓬勃旺盛和热烈张扬。"
				+ "音乐上掀起强劲的“西北风”潮流"
				+ "“哎——妹妹你大胆地往前走哇往前走，莫回头通天的大路，九千九百，九千九百九哇哎...”这曲《妹妹你大胆地往前走》由姜文粗哑雄浑的嗓子里“吼”出来，迅速传遍了全国，从都市到乡村，到处都是“妹妹你大胆地往前走”的歌声，一时间，歌坛也掀起一股强劲的“西北风”潮流。它使成千上万的中国人(尤其北方人)心中那种隐隐约约的反哺归巢情结，得到了最大程度的满足。片中，九月初九敬酒神的时候，单单由唢呐营造出的豪放野性的《酒神曲》;高粱地里激情过后，黄土地男人用毫不修饰的粗犷嗓音吼出一曲风靡全国的情歌《妹妹你大胆地往前走》;结尾，儿子豆官念白方式的一段音乐，更似神来之笔……"
				+ "《红高粱》的音乐不但让赵季平完成了自己平民音乐的创作愿望，也和张艺谋进行了一次让人热泪盈眶的寻根之旅。赵季平的音乐和《红高粱》天人和一，在银幕上大写意地完成了一次雕刻生命的挥洒，大善若水的赵季平与张艺谋双手一握，西部的高粱叶子，森林一样霍霍有声。 "
				+ "总之，《红高粱》中的这些造型或体现了人的力量、情绪和生存方式，或展示了人的活力、死的悲壮和民族气节。这些热烈鲜明的造型，增强了电影的形象直观冲击力，使作品在总体上透出了一种强悍的、狂野的、生机勃勃的气质。"
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
