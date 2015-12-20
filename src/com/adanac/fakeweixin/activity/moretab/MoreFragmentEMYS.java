package com.adanac.fakeweixin.activity.moretab;

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
 * 情感类 - 影视
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class MoreFragmentEMYS extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_emys);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_emys_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_emys_textView);
		textView.setTextSize(12);
		Drawable d = null;
		switch (tabIndex) {
		case 0:
			textView.setText(Html
					.fromHtml("·影视作品源自社会现实 <br/>\t影视作品是对生活素材的挑选、集中和提炼，是对真人真事的超越与加工改造。<br/>\t·影视的媒介作用影视对现实生活的复现绝不是对生活的机械照搬，而是对生活素材的艺术化的主观创造。<br/>\t·影视作品的教育价值<br/>\t认知功能：<br/>\t  ——知识传递 <br/>\t   ——民族文化传承：显性文化的传承隐性文化的传承<br/>\t审美功能:影视艺术的审美功能主要是指人们通过影视作品欣赏活动，与创</br>"
							+ "作者产生情感上的共鸣，体会创作者在拍摄制作作品时的所思所想 "));
			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_emys_zp01);
			d.setBounds(0, 0, 230, 300); // 必须设置图片大小，否则不显示

			Drawable d1 = getResources().getDrawable(R.drawable.map_emys_zp02);
			d1.setBounds(0, 0, 230, 300); // 必须设置图片大小，否则不显示

			Drawable d2 = getResources().getDrawable(R.drawable.map_emys_zp03);
			d2.setBounds(0, 0, 230, 300); // 必须设置图片大小，否则不显示

			Drawable d3 = getResources().getDrawable(R.drawable.map_emys_zp01);
			d3.setBounds(0, 0, 230, 300); // 必须设置图片大小，否则不显示

			textView.setCompoundDrawables(d, d1, d2, d3);
			textView.setMovementMethod(ScrollingMovementMethod.getInstance());
			break;
		case 2:
			textView.setText("课后观看影片《射雕英雄传》。比较它们在视觉元素（色彩、光影、构图、景别、角度、运动、蒙太奇等）方面的差异，并思考如何发挥民族文化元素在电影中的作用。");
			d = getResources().getDrawable(R.drawable.map_emys_sk);
			d.setBounds(0, 0, 700, 500); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, null, null, d);
			break;
		default:
			textView.setText(Html.fromHtml("相关参考文献：<br/>"
					+ "戴锦华.镜与世俗神话——影片精读18例[M].中国人民大学出版社，2004.<br/>"
					+ "彭吉象.影视美学[M].北京大学出版社，2002.<br/>"
					+ "罗健.影视艺术中的民族音乐元素.电影评介[J].2007（2）<br/>"));
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
