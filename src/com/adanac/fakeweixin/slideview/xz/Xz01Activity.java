package com.adanac.fakeweixin.slideview.xz;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Xz01Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_xz_01);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtxz01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;卜卫</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：百度百科                 时间：2015.12.18</font></small><br/><br/>"
				+ "<img src=\""
				+ R.drawable.map_three_xz01
				+ "\"/>"
				+ "卜卫(1957—)，女，研究员、教授，汉族，1989年研究生毕业后，进入中国社会科学院从事传播与儿童发展研究，现为中国社会科学院新闻与传播研究所副研究员，媒介传播与儿童发展研究中心主任。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;卜卫教授的研究方向包括：一、媒介与青少年：主要研究儿童青少年的媒介采用及其影响、通过儿童参与媒介促进儿童权利、媒介新技术（如互联网）的使用与青少年的社会参与、媒介教育等；二、性别与媒介：主要研究媒介内容的社会性别分析、性别与媒介接收、女性媒介在中国社会的角色与作用、性别平等的媒介干预策略研究等；三、互联网影响，主要研究媒介、互联网鸿沟及其消除策略研究、弱势群体的媒介资源及其影响的研究等。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;自1994年来，卜卫教授作为主持人完成了多项重要的研究课题，包括：中国社会科学院重点课题“社会科学研究成果指标体系的研究与设计”（1994-1998）；国家社会科学基金课题“大众传播对青少年的影响”（1996-1999）；中宣部委托课题“儿童图书市场研究”（1998年）；联合国儿童基金会课题“联合国儿童基金会在中国的媒介机会”、“儿童权利传播手册”、“中国大众媒介中的艾滋病报道研究”（1999到2002）；与其他单位合作的课题“中国五城市用户互联网使用及其影响”（2000-2001）等。<br/>	"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1997年，专著《进入地球村——中国儿童与大众传播》获国家图书奖提名奖，同年获全国青年社会科学优秀奖（最高奖）；《培养独生子女健康人格》（主编）获团中央五个一工程奖；《社会科学成果价值评估》2002年获中国社会科学院优秀成果奖三等奖。卜卫教授1997年发表的《论媒介教育的意义、内容和方法》一文被公认为正式拉开了我国媒介素养教育的帷幕。她在我国青少年媒介素养教育研究领域具有举足轻重的地位。<br/>"
				+ "</body></html>";
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
	}

}
