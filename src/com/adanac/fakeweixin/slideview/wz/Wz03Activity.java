package com.adanac.fakeweixin.slideview.wz;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Wz03Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_wz_03);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtwz03);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>新媒体时代提升高校学生媒介素养的策略</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作者：贾先涛                   更新时间：2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;推荐语：信息化时代，信息获取、辨析、组织、利用能力成为个体综合能力的重要组成部分。媒介素养教育还处于萌芽、成长期，高校学生缺少必要的媒介素养教育，在媒体应用方面出现了一些负面效果。高校应该建立完善的媒体素养教育体系，本文从媒介素养课程、师资，媒介教育，学生传播能力培养方面提出了促进媒介素养教育的策略，探讨媒介素养教育的实施。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;大众传播发展史表明，每一次媒体技术的革新都会促进大众传媒的变革。数字技术引领传媒进入新的发展时代，WEB2. 0 技术的出现促进了网络媒体的发展，如BBS、博客、播客、维客、QQ、MSN、SNS 网络等。数字技术的发展不仅催生了新的传媒形式，还促进了媒体的融合，互联网络、电信网络及有信电视网络的融合，对传媒的发展有决定性的影响。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;相对于电视、广播、报刊等传统大众传媒，基于数字技术的媒体如BBS、博客、播客、SNS网络、IP 电视、楼宇电视、手机等媒体称为新媒体。新媒体的出现在很大程度上改变着传媒的发展形态，这些媒体赋予传播者较多的自由和自主，也被人们称为自媒体。与传统大众媒介相比，新媒体有以下传播性: 信息传播时效性强、传播方式网状化、传播者和信息接受者的双重身份、信息传播个性化。<br/>	"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数据显示，2010 年6 月份，我国的网民数量超过4 亿人，手机网民超过2. 7 亿。根据第26 次《中国互联网络发展状况统计报告》，在网民年龄结构中，20 － 29 岁的人群占到互联网网民的28. 6% 及手机网民的35. 4%。从职业结构看，学生是新媒体的主要使用群体。该年龄段的学生多为高校学生，因此，高校学生的媒体素养对于营造良好的传播环境有着重要的意义。<br/>	"
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
