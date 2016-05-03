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
import android.util.Log;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fakeweixin.util.ProcBoundUtil;

public class YS02Activity extends Activity {
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
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;《辛德勒的名单》影评</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：奥尔华艺                    时间：2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;《辛德勒的名单》作为第66届奥斯卡最佳影片，是由澳大利亚小说家托马斯•科内雅雷斯所著的《辛德勒名单》改编而成。影片真实的再现了德国企业家奥斯卡•辛德勒在第二次世界大战期间，通过各种方式，用尽财产保护1100余名犹太人免遭法西斯杀害的真实故事。故事情节真实感人，让观众深受触动。<br/>"
				+ "<img src='http://adanac.qiniudn.com/imgys02.png' />"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>《辛德勒的名单》电影剧照</small><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人物形象分析:"
				+ "辛德勒的行为在历史长河中留下的是英雄形象，但他也并非最初的动机就是拯救犹太人，也是十分巿侩与唯利是图，他的性格中除了商人的现实，也带有一点恻隐的侠意色彩，他的小聪明和狡黠让他发了一笔谈不上是光彩的战争财，却也让他完成了一件伟大的事迹，只是这一路上，固然有人性道德的觉醒，却也有些骑虎难下，无心插柳的无奈，这也是辛德勒这个角色引人玩味之处，他的救人有“为人”也有“为己”的动机，而在整个过程中两者的比例一直在省思调整着，辛德勒并非一开始就一个英雄，斯皮尔伯格没有将他神话，反而表现他更多的是如何去由“为己”真正的做到“为人”，由此引申开去的是战争给我们带来的是什么，而我们又是否从已经生过的战争体会到了和平的重要性。"
				+ "镜头的运用"
				+ "本片中又很多不固定的镜头，特别是在几次犹太人被“打包上车”进行“特殊处理”时前的镜头运用。时摇时晃的镜头即模拟出了当时犹太人心中的恐慌与不安，又带给了观众一种紧张与担忧之感。仰拍的角度一般都是表现拍摄者的态度，但本片却不同，更多的仰拍镜头都是从犹太人的角度出发，给观众一种身历其境，与犹太人一起受压迫，整日生活在恐慌与高度紧张的状态之中。"
				+ "色彩"
				+ "本片的另一大亮点就是色彩了运用，在排除了技术设备的问题后，以黑白为主色调的的画面就是导演斯皮尔伯格给我们的又一件礼物了。白色在西方文化中，白色象征纯洁;即使在某些亚洲文化中，白色也象征死亡。黑色，但在本片中，意指死亡，危险和邪恶。身着红衣的童真小女孩是整部影片中堪称具有电影史上“里程碑”意义的一笔。即使战争中唯一光明的体现，更是片中屠杀犹太人血腥的又一次渲染及最终唤醒辛德勒人性的钥匙。红色的衣着，即是正义的体现，又是邪恶的渲染。这不可谓不是导演的又一次高超技能的展现。《辛德勒名单》中名单出现了三次，第一次，在火车站前，犹太人第一次点名，这是厄运的开始。其中，对打字机的特写及其音响的配置对表现名单的恐怖起到了催化的作用，使其与片中的第三次“名单”形成了鲜明的对比。同样的变现手法、却是人看到的是生的希望与死的惨烈之间的差别。"
				+ "音乐运用"
				+ "“辛德勒的名单”具史诗的格局和撼人的情绪，同样的，本片的音乐作者约翰·威廉斯对影片配乐的创作也选择了用真挚无华的追思，去思考和感受这个历史的伤痛，以及在其中所散发的人性力量。片头在辛德勒第一次走进舞会结交军官时。舞曲《por_una_cabeza》作为背景音乐充分的体现出了二战时期德国上流社会的荒淫与奢华，消遣与萎靡。更巧妙的运用了探戈时急时缓的舞曲特点，表现出辛特勒处事圆滑，善于交际的性格。在全片开头就揭示了其后故事发展的背景。《Theme From Schindler's List》主旋律的第一次出现在影片使用画外音交待犹太人搬迁的时候。旋律朴实、平缓却使人心中内心百感交加，没有对历史的太多的控诉，更多的是对历史的反省。内敛却着实深刻。在在最后辛德勒逃亡时最显凄凉，沦为战犯，灵魂在“辛特勒的犹太人”送的金戒指中彻底得到了升华。曲风温婉，惆怅。平静却又沉痛的不停吟诵着战争的残酷与悲哀。"
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
