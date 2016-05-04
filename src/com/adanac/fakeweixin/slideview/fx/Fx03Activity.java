package com.adanac.fakeweixin.slideview.fx;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Fx03Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_fx_03);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtfx03);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>《媒介素养导论》（Introduction to Media Literacy）</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作者：段京肃                    &nbsp;&nbsp;更新时间：2015.12.18</font></small><br/><br/>"
				+ "<img src=\""
				+ R.drawable.map_three_fx03
				+ "\"/>"
				+ "《媒介素养导论》（Introduction to Media Literacy）是由段京肃、杜骏飞编写，福建人民出版社2007年7月出版。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作者在书中指出，媒介素养（media literacv）是指公众接触、解读、使用媒介的素质和修养。它包括了三个环节：接触媒介、获取信息；解读媒介、批判地接受媒介信息；利用媒介工作和生活，通过媒介发出声音并维护自己的利益。媒介素养不仅是资质，而且是方法和技能，它决定了现代人最基本和最核心的媒介生存能力。在西方发达国家，媒介素养教育不仅早已成为学校课程中的固有内容，而且也是国民终身教育的重要内容。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该书系南京大学新闻传播学院“媒介素养课题组”最新研究成果，结构完整，材料丰瞻，观点新锐，视野宽广。在学术方面，该书具备科学体系、富有研究深度，并广泛涉及新闻学、传播学、社会学、政治学、心理学、教育学等各个知识领域。在应用方面，该书不仅是适合于文理各科学生阅读学习的人文读本，也是现代企事业机构及社会大众培育素养、提高职业竞争力的重要工具书。<br/>	"
				+ "参考资料来源：<br/>"
				+ "[1] 亚马逊.《媒介素养导论》简介[EB/OL].[2015-1-14]http://www.amazon.cn/媒介素养导论/dp/B003ZHTV6O/ref=sr_1_1?ie=UTF8&qid=1394424415&sr=8-1&keywords=媒介素养导论.<br/>"
				+ "[2] 百度百科.《媒介素养导论》简介[EB/OL].[2015-1-14].http://baike.baidu.com/view/2040203.htm.<br/>"
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
