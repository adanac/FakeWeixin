package com.adanac.fakeweixin.activity.moretab;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fragment.LazyFragment;

/**
 * 意义所指层次图
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class MoreFragmentYYCC extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_yycc);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_yycc_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_yycc_textView);
		textView.setTextSize(12);
		Drawable d = null;
		switch (tabIndex) {
		case 0:
			textView.setMovementMethod(ScrollingMovementMethod.getInstance());
			d = getResources().getDrawable(R.drawable.map_yycc_know01);
			d.setBounds(0, 0, 300, 290); // 必须设置图片大小，否则不显示
			Drawable d1 = getResources()
					.getDrawable(R.drawable.map_yycc_know02);
			d1.setBounds(0, 0, 350, 230);
			Drawable d2 = getResources()
					.getDrawable(R.drawable.map_yycc_know03);
			d2.setBounds(0, 0, 350, 290);
			textView.setCompoundDrawables(d, d1, d2, null);

			// textView.setText("图1\t\"代表者——被代表者\"二项式");
			// textView.append("\n\n图2\t\"符号——能指——所指\"语义三角形\n\n图3\t所指意义层次图");

			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_yycc);
			d.setBounds(0, 0, 700, 500); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(d, null, null, null);
			// textView.setText("setCompoundDrawables");
			break;
		case 2:
			d = getResources().getDrawable(R.drawable.map_yycc_zuoye);
			d.setBounds(0, 0, 450, 300); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, d, null, null);
			textView.setMovementMethod(LinkMovementMethod.getInstance());
			textView.append(Html
					.fromHtml("<b>解读训练案例：</b><br/>"
							+ "视觉文化网:<a href=\"http://www.fromeyes.cn/\">http://www.fromeyes.cn/</a><br/><br/>"
							+ "<b>思考：</b><br/>"
							+ "1.观察网站的标志LOGO的造型特点，尝试分析其能指与所指及其之间的关系。<br/>"
							+ "2.此标志LOGO的造型结构对你理解此网站的主题内容有无暗示作用？"));
			break;
		default:
			textView.setText(Html
					.fromHtml("<b>相关资源链接：</b><br/>"
							+ "视觉文化网：<a href=\"http://www.fromeyes.cn/\">http://www.fromeyes.cn/</a><br/>"
							+ "复旦大学媒介素养小组：<a href=\"http://vr.theatre.ntu.edu.tw/fineart/\">http://vr.theatre.ntu.edu.tw/fineart/</a>"));
			textView.setMovementMethod(LinkMovementMethod.getInstance());
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
