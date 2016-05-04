package com.adanac.fakeweixin.slideview.xz;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Xz03Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_xz_03);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtxz03);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;张舒予</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：视觉文化网                  时间：2015.12.18</font></small><br/><br/>"
				+ "<img src=\""
				+ R.drawable.map_three_xz03
				+ "\"/>"
				+ "张舒予（1955—），女，回族。原任安徽师范大学教育科学学院院长、教授，现为南京师范大学教育技术系教授，博士生导师，校学位委员会委员与校教学委员会委员。她长期耕耘于信息技术教育与视觉文化研究领域。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1995年至2002年间张舒予三次赴英国访学，分别在格拉斯哥大学、爱丁堡大学和勃朗特协会从事信息技术教育和视觉文化的综合研究。她访问考察英国学校的信息技术与信息文化教育状况，在英国著名作家勃朗特三姐妹故乡进行“田野”工作，从事勃朗特文化专题研究。她拍摄制作的多媒体软件被勃朗特博物馆收藏。她访问过法、德、意、奥、荷等欧洲大陆国家，拍摄了大量的摄影图片与录像，对欧洲的文化遗产保护与文化资源建设有深切的感触与体验。自2001年她在南京师范大学为教育技术学专业、新闻学专业、传播学专业和广播电视专业研究生开设自行开发的视觉文化课程。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;张舒予的代表性著作有《视觉文化概论》（2003）、《现代教育技术学》（2003）、《中外信息技术教育比较研究》（2004）和《电视制作——技巧·艺术·训练》（1991）等；在《比较教育研究》《电化教育研究》《中国电化教育》《人民日报》《文汇报》等发表《信息技术支撑下的视觉素养培养》、《信息文化概念辨析与信息技术教育逻辑体系》、《网络时代的民族文化发展与传播》等论文60余篇；获得全国电化教育优秀工作者称号、安徽省优秀教学成果奖和徐悲鸿首届教育基金奖等。<br/>	"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;张舒予精心设计开发新型视觉文化课程：以信息技术为支持、以民族文化为资源、以培养视觉素养和文化自觉意识为目标；她在国内首创视觉文化研究基地，视觉文化与媒介素养综合研究研究中心。2009年，《教育部、财政部关于批准2009年度国家精品课程建设项目的通知》（教高函[2009]21号）已正式下发，张舒予教授主持的《视觉文化与媒介素养》获批国家级精品课程。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2010年张舒予教授率领视觉文化团队取得的“博雅理念下的视觉文化课程建设”成果被评选为南京师范大学第十五届优秀教学成果特等奖。 <br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2011年张舒予主持编著的教材《视觉文化与媒介素养》获得南京师范大学优秀教材出版基金的全额资助，于2011年9月由南京师范大学出版社公开出版《视觉文化与媒介素养》立体化教材（文字教材+多媒体课件+专题网站），该课程入选为国家精品资源共享开放课程，2014年已经上线国家爱课程网站。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;张舒予教授为推进我国的视觉文化研究与媒介素养教育做出了巨大的贡献，并仍在默默地耕耘着。<br/>"
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
