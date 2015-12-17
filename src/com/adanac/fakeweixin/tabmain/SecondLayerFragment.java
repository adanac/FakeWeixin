package com.adanac.fakeweixin.tabmain;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fakeweixin.util.DrawUtil;
import com.adanac.fakeweixin.view.DrawAppView2;
import com.adanac.fragment.LazyFragment;

public class SecondLayerFragment extends LazyFragment {
	public static final String INTENT_STRING_TABNAME = "intent_String_tabName";
	public static final String INTENT_INT_POSITION = "intent_int_position";
	private String tabName;
	private int position;
	private TextView textView;
	private ProgressBar progressBar;
	private View indexView;
	private Context context;
	private Canvas canvas = new Canvas();

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		tabName = getArguments().getString(INTENT_STRING_TABNAME);
		position = getArguments().getInt(INTENT_INT_POSITION);
		setContentView(R.layout.fragment_tabmain_mjsy);
		textView = (TextView) findViewById(R.id.fragment_mainTab_item_textView);
		// textView.setText(tabName + " " + position + " 界面加载完毕");

		switch (position) {
		case 0:
			textView.setText("画出第1个页面");
			// indexView = findViewById(R.id.frament_mainTab_item_IndexView);

			indexView.draw(canvas);
			// TabMainActivity activity = new TabMainActivity();
			// indexView = new DrawAppView(activity);
			// toIndex(indexView);
			break;
		case 1:
			// textView.setText("画出第2个页面");
			// indexView = findViewById(R.id.frament_mainTab_item_IndexView);
			indexView = new DrawAppView2(indexView.getContext());
			break;
		case 2:
			// textView.setText("能力类");
			break;
		default:
			// textView.setText("情感类");
		}

		// progressBar = (ProgressBar)
		// findViewById(R.id.fragment_mainTab_item_progressBar);
		handler.sendEmptyMessageDelayed(1, 3000);
	}

	private void toIndex(View view) {
		startActivity(new Intent(getApplicationContext(), DrawIndex.class));
	}

	private Canvas drawIndexView() {

		// View view = findViewById(R.id.frament_mainTab_item_IndexView);
		Paint paint = new Paint();
		// paint.setColor(Color.RED);// 设置红色

		// 画椭圆
		// DrawUtil.drawMyOval(canvas, paint, width / 2 - 150, height / 2 - 300,
		// width / 2 + 150, height / 2 - 150, R.string.view1_str0, 35,
		// Color.BLACK, Color.YELLOW, Color.BLACK);

		// DrawUtil.drawLine(canvas, paint, 350, 250, 350, height / 2 - 300); //
		// 媒介素养小短线
		// DrawUtil.drawLine(canvas, paint, 350, 600, 350, height / 2 - 150); //
		// 媒介素养小短线

		DrawUtil.drawRectCenterTxt(canvas, paint, 200, 250, 140, 70, "走进媒介",
				Color.GRAY, Color.BLACK, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, 90, 120, 70, 60, "书法",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 170, 120, 70, 60, "摄影",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 250, 120, 70, 60, "影视",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 330, 120, 70, 60, "其他",
				Color.GRAY, Color.BLACK, 20);

		DrawUtil.drawLine(canvas, paint, 200 + 70, 250, 430, 250);// 连接媒介新闻和微课程
		DrawUtil.drawLine(canvas, paint, 200 + 70, 600, 430, 600); // 连接学术空间和媒介作品
		DrawUtil.drawLine(canvas, paint, 90, 180, 330, 180);// 连接学术和其他
		DrawUtil.drawLine(canvas, paint, 90, 150, 90, 180);// 画学术小短线;
		DrawUtil.drawLine(canvas, paint, 170, 150, 170, 180);// 画科技小短线;
		DrawUtil.drawLine(canvas, paint, 250, 150, 250, 180);// 画娱乐小短线;
		DrawUtil.drawLine(canvas, paint, 330, 150, 330, 180);// 画其他小短线;
		DrawUtil.drawLine(canvas, paint, 200, 215, 200, 180);// 画新闻媒介小短线;

		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 250, 140, 70, "理解媒介",
				Color.GRAY, Color.BLACK, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 430, 120, 90, 60, "知识类",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 120, 90, 60, "能力类",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 630, 120, 90, 60, "情感类",
				Color.GRAY, Color.BLACK, 20);

		// drawLine(canvas, paint, 500, 150, 500, 215);// 连接能力类和微课程
		DrawUtil.drawLine(canvas, paint, 430, 180, 630, 180);// 连接知识类和情感类
		DrawUtil.drawLine(canvas, paint, 430, 150, 430, 180);// 画知识类小短线;
		DrawUtil.drawLine(canvas, paint, 530, 150, 530, 180);// 画能力小短线;
		DrawUtil.drawLine(canvas, paint, 630, 150, 630, 180);// 画情感小短线;
		DrawUtil.drawLine(canvas, paint, 530, 215, 530, 180);// 画微课程小短线;

		DrawUtil.drawRectCenterTxt(canvas, paint, 200, 600, 140, 70, "研究媒介",
				Color.GRAY, Color.BLACK, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 100, 730, 90, 60, "研究学者",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 200, 730, 90, 60, "理论文章",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 300, 730, 90, 60, "好书分享",
				Color.GRAY, Color.BLACK, 20);

		DrawUtil.drawLine(canvas, paint, 200, 635, 200, 700); // 连接学术空间和理论文章
		DrawUtil.drawLine(canvas, paint, 100, 675, 300, 675);// 连接研究学者和好书分享
		DrawUtil.drawLine(canvas, paint, 100, 675, 100, 700);// 2根小短线
		DrawUtil.drawLine(canvas, paint, 300, 675, 300, 700);// 2根小短线

		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 600, 140, 70, "使用媒介",
				Color.GRAY, Color.BLACK, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 430, 730, 90, 60, "图文",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 730, 90, 60, "音频",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 630, 730, 90, 60, "视频",
				Color.GRAY, Color.BLACK, 20);

		// drawLine(canvas, paint, 500, 635, 500, 700); // 连接媒介作品和音频
		DrawUtil.drawLine(canvas, paint, 430, 675, 630, 675);// 连接图像和视频
		DrawUtil.drawLine(canvas, paint, 430, 675, 430, 700);// 画图像小短线
		DrawUtil.drawLine(canvas, paint, 530, 675, 530, 700);// 画音频小短线
		DrawUtil.drawLine(canvas, paint, 630, 675, 630, 700);// 画视频小短线
		DrawUtil.drawLine(canvas, paint, 530, 635, 530, 675);// 画媒介作品小短线

		// 四个箭头
		DrawUtil.drawAL(canvas, paint, 200, 565, 200, 285);// 连接研究媒介与走进媒介
		DrawUtil.drawAL(canvas, paint, 270, 250, 460, 250);// 连接走进媒介与理解媒介
		DrawUtil.drawAL(canvas, paint, 530, 285, 530, 565);// 连接理解媒介与使用媒介
		DrawUtil.drawAL(canvas, paint, 460, 600, 270, 600);// 连接使用媒介与研究媒介
		return canvas;
	}

	@Override
	protected void onDestroyViewLazy() {
		super.onDestroyViewLazy();
		handler.removeMessages(1);
	}

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(android.os.Message msg) {
			textView.setVisibility(View.VISIBLE);
			// progressBar.setVisibility(View.GONE);
			indexView.setVisibility(View.VISIBLE);
		};
	};
}
