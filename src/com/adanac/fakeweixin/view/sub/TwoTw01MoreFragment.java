package com.adanac.fakeweixin.view.sub;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fragment.LazyFragment;

/**
 * 使用媒介 - 图文
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class TwoTw01MoreFragment extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_two_tw);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_two_tw_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_two_tw_textView);
		textView.setMovementMethod(ScrollingMovementMethod.getInstance());// 滚动
		textView.setTextSize(12);
		Drawable d = null;
		Drawable d1 = null;
		switch (tabIndex) {
		case 0:
			textView.setText(Html
					.fromHtml("<html><head><title></title></head><body><h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生作品之《易经》</h2><br/>"
							+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：视觉文化网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间：2015.12.18<br/>"
							+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;南京师范大学2010级现代教育技术硕士经过对“媒介素养”的学习，已经掌握了“媒介素养”的相关知识，了解了何为媒介素养，那么怎么才能将其发挥到实践中去呢？"
							+ "他们通过对媒介工具的使用，将中国博大精深的传统文化之《易经》进行深入解读并对资源进行开发呈现，对弘扬中国传统文化有深远意义。"
							+ "（相关作品链接：<a href=\"http://www.fromeyes.cn/ZhuanTi/sjwhzy/jiaoji/\">http://www.fromeyes.cn/ZhuanTi/sjwhzy/jiaoji/</a>）</body></html>"));
			d = getResources().getDrawable(R.drawable.map_two_tw01);
			d.setBounds(0, 0, 700, 900);

			textView.setCompoundDrawables(null, null, null, d);
			break;
		case 1:
			textView.setText(Html
					.fromHtml("<html><head><title></title></head><body><h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生作品之《古乐灵音》</h2><br/>"
							+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：视觉文化网                    时间：2015.12.18<br/>\t作品《古乐灵音》是南京师范大学2011级现代教育技术硕士共同创作的。中国传统乐器作为中国传统文化中不可分割的一个组成部分，源远流长，他们希望通过自己的绵薄之力，利用信息技术手段来展现中国传统乐器文化的魅力，而哪怕只能展现其魅力之一。作品包含了编钟、古琴、古筝、月琴、琵琶、二胡、笛、萧、埙和鼓。中国传统乐器文化作为中华文化的一部分，是不能被大家遗忘和舍弃的。在这里，望有志之士充分发挥聪明才智，挖掘古乐文化精髓，使我中华文化生辉于世界文化之中，使我中华文化屹立于世界之巅。（相关作品链接：http://www.fromeyes.cn/ZhuanTi/sjwhzy/2011级专业硕士古灵音乐/index.html）</body></html>"));
			d = getResources().getDrawable(R.drawable.map_two_tw03);
			d.setBounds(0, 0, 700, 500); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, null, null, d);
			break;
		case 2:
			textView.setText(Html
					.fromHtml("<html><head><title></title></head><body><h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生对作品《太阳的睫毛》的解读</h2><br/>"
							+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：视觉文化网                    时间：2015.12.18 <br/>"
							+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请欣赏下面的作品，通过自己的学习体验以及丰富的想象力，运用所指意义层次图表达自己的想法吧。</body></html>"));
			d = getResources().getDrawable(R.drawable.map_two_tw04);
			d.setBounds(0, 0, 650, 900); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, null, null, d);
			break;
		default:
			textView.setText(Html
					.fromHtml("相关链接：<br/>"
							+ "可视化方法周期表：<a href=\"http://www.visual-literacy.org/periodic_table/periodic_table.html\">http://www.visual-literacy.org/periodic_table/periodic_table.html</a><br/>"));
			break;
		}
		handler.sendEmptyMessageDelayed(1, 1000);
	}

	@Override
	public void onDestroyViewLazy() {
		super.onDestroyViewLazy();
		handler.removeMessages(1);
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			progressBar.setVisibility(View.GONE);
			textView.setVisibility(View.VISIBLE);
		}
	};
}
