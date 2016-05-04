package com.adanac.fakeweixin.slideview.wz;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Wz02Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_wz_02);
		// 初始化控件
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtwz02);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;媒介与终身学习</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作者：段京肃                   更新时间：2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;媒介的发展为我们的学习带来了机遇与挑战。20世纪末期以来，媒介越发显现了巨大的威力和无所不能的渗透力，在媒介化社会身学习的能力是非常终于的。文章就是阐述了媒介化社会中终身学习的重要性和必要性，媒介环境的复杂化也要求公民就有终身学习的能力和行动。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通过媒介的学习是社会化学习的重要途径，在现代社会中，媒介已经成为人们终生的伴侣。中国古语中有“活到老，学到老”的格言，而如果从传播学的角度看，还应该说“活到老，传播到老”——无论是什么人，从他出生直到离开人世，应该是 “生命不息，传播不止”。<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;对不同的人来说，“我们生活在一个‘信息的鸿沟’中。在我们的身体所告诉我们的东西和我们必须知道以便去应用的东西之间有一个真空区，我们必须自己去填充它，我们将要用我们的文化提供给我们的信息（或错误信息）去填充它。”在这个过程中，承载文化和信息的主要是各种不同的媒介，填充的过程主要是通过各种媒介活动完成的。这一 “信息的鸿沟”的填充结果在不同的人那儿是不一样的，造成差异的原因就与人们掌握和使用媒介的能力直接相关。<br/>	"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;进入20世纪末，媒介越发显现了巨大的威力和无所不能的渗透力，“以信息技术为中心的技术革命，正在加速重造社会的物质基础。”社会的这种巨变，对社会的所有成员——无论是精英还是普通人，都提出了适应新社会的全新的要求，因为每一个人都不得不生活在已经变化并在继续变化的社会环境中，在这个新的社会环境中，媒介及其活动最终形成了一种独特的文化，对整个社会产生前所未有的影响。这种文化就是被人们广泛关注的大众文化，尽管人们对大众文化还有不同的认识和评价，但“大众文化却凭借其利润效果和现代传媒迅速播散，客观上操纵着文化主流，诱使文化平庸化、均质化、模式化，使大众丧失自由选择的空间和自我决断的资禀。”正如道格拉斯·凯尔纳所说：“媒体文化渐渐主宰了日常生活，成为我们的注意力和活动中的一种无所不在的背景，常常也是富有诱惑力的前景。对此，许多人认为，它们正在暗地里破坏着人的潜能和创造力。”<br/>	"
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
