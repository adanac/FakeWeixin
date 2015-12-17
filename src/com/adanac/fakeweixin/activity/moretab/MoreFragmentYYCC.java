package com.adanac.fakeweixin.activity.moretab;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
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
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_item_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_item_textView);
		switch (tabIndex) {
		case 0:
			Drawable d = getResources().getDrawable(R.drawable.map_yycc_know01);
			d.setBounds(0, 0, 200, 200); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(d, null, null, null);
			d = getResources().getDrawable(R.drawable.map_yycc_know02);
			d.setBounds(0, 0, 200, 200); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(d, null, null, null);
			d = getResources().getDrawable(R.drawable.map_yycc_know03);
			d.setBounds(0, 0, 200, 200); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(d, null, null, null);
			textView.setText("图1 “代表者——被代表者”二项式\n图2 “符号——能指——所指”语义三角形\n图3 所指意义层次图");
			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_yycc);
			d.setBounds(0, 0, 500, 500); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(d, null, null, null);
			// textView.setText("setCompoundDrawables");
			break;
		case 2:
			textView.setTextSize(15);
			textView.setText("\n\n解读训练案例：\n图1 视觉文化网LOGO\n查询访问视觉文化网http://www.fromeyes.cn/并思考：\n1.观察网站的标志LOGO的造型特点，尝试分析其能指与所指及其之间的关系。\n2.此标志LOGO的造型结构对你理解此网站的主题内容有无暗示作用？");
			d = getResources().getDrawable(R.drawable.map_yycc_zuoye);
			d.setBounds(0, 0, 500, 500); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(d, null, null, null);
			// textView.setText("图  摄影作品《我要读书》");
			break;
		default:
			textView.setTextSize(20);
			textView.setText("相关资源链接：\n视觉文化网：http://www.fromeyes.cn/\n复旦大学媒介素养小组：http://vr.theatre.ntu.edu.tw/fineart/");
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
