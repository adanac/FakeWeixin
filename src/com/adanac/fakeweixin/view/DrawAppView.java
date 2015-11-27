package com.adanac.fakeweixin.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.adanac.fakeweixin.activity.MainContent;
import com.adanac.fakeweixin.activity.sub.EmotionActivity;
import com.adanac.fakeweixin.activity.sub.EnableActivity;
import com.adanac.fakeweixin.activity.sub.KnowActivity;
import com.adanac.fakeweixin.util.DrawUtil;
import com.adanac.fakeweixin.util.ScreenUtil;

/**
 * 首页View
 * 
 * @author adanac
 * @date 2015-11-27
 * @version 1.0
 */
public class DrawAppView extends View {

	private Context context;
	ScreenUtil sUtil = new ScreenUtil(this);
	private int width = sUtil.getWidth();
	private int height = sUtil.getHeight();

	public DrawAppView(Context context) {
		super(context);
		this.context = context;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// 创建画笔
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
		DrawUtil.drawLine(canvas, paint, 100, 675, 300, 675); // 连接研究学者和好书分享
		DrawUtil.drawLine(canvas, paint, 100, 675, 100, 700); // 2根小短线
		DrawUtil.drawLine(canvas, paint, 300, 675, 300, 700); // 2根小短线

		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 600, 140, 70, "使用媒介",
				Color.GRAY, Color.BLACK, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 430, 730, 90, 60, "图文",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 730, 90, 60, "音频",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 630, 730, 90, 60, "视频",
				Color.GRAY, Color.BLACK, 20);

		// drawLine(canvas, paint, 500, 635, 500, 700); // 连接媒介作品和音频
		DrawUtil.drawLine(canvas, paint, 430, 675, 630, 675); // 连接图像和视频
		DrawUtil.drawLine(canvas, paint, 430, 675, 430, 700); // 画图像小短线
		DrawUtil.drawLine(canvas, paint, 530, 675, 530, 700); // 画音频小短线
		DrawUtil.drawLine(canvas, paint, 630, 675, 630, 700); // 画视频小短线
		DrawUtil.drawLine(canvas, paint, 530, 635, 530, 675); // 画媒介作品小短线

		// 四个箭头
		DrawUtil.drawAL(canvas, paint, 200, 565, 200, 285); // 连接研究媒介与走进媒介
		DrawUtil.drawAL(canvas, paint, 270, 250, 460, 250); // 连接走进媒介与理解媒介
		DrawUtil.drawAL(canvas, paint, 530, 285, 530, 565); // 连接理解媒介与使用媒介
		DrawUtil.drawAL(canvas, paint, 460, 600, 270, 600); // 连接使用媒介与研究媒介

	}

	/**
	 * 点击事件 onTouchEvent
	 */
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		System.out.println("x:" + x + "y:" + y);

		// 点击中间
		clickMJSY(event, x, y, width / 2 - 100, width / 2 + 100,
				height / 2 - 300, height / 2 - 100, MainContent.class);

		// 点击知识类（430, 120, 90, 60）
		clickZSL(event, x, y, 430 - 90 / 2, 430 + 90 / 2, 120 - 60 / 2,
				120 + 60 / 2, KnowActivity.class);

		// 点击能力类（530, 120, 90, 60）
		clickNLL(event, x, y, 530 - 90 / 2, 530 + 90 / 2, 120 - 60 / 2,
				120 + 60 / 2, EnableActivity.class);

		// 点击情感类（ 630, 120, 90, 60）
		clickQGL(event, x, y, 630 - 90 / 2, 630 + 90 / 2, 120 - 60 / 2,
				120 + 60 / 2, EmotionActivity.class);

		return true;
	}

	// 点击情感类
	private void clickQGL(MotionEvent event, float x, float y, float x1,
			float x2, float y1, float y2, Class<EmotionActivity> clazz) {
		clickSubMethod(event, x, y, x1, x2, y1, y2, clazz, "点击了情感类");
	}

	// 点击能力类
	private void clickNLL(MotionEvent event, float x, float y, float x1,
			float x2, float y1, float y2, Class<EnableActivity> clazz) {
		clickSubMethod(event, x, y, x1, x2, y1, y2, clazz, "点击了能力类");
	}

	// 点击知识类
	private void clickZSL(MotionEvent event, float x, float y, float x1,
			float x2, float y1, float y2, Class<KnowActivity> clazz) {

		clickSubMethod(event, x, y, x1, x2, y1, y2, clazz, "点击了知识类");
	}

	// 点击中间
	private void clickMJSY(MotionEvent event, float x, float y, float x1,
			float x2, float y1, float y2, Class<MainContent> clazz) {
		clickSubMethod(event, x, y, x1, x2, y1, y2, clazz, "点击了中间区域类");
	}

	private void clickSubMethod(MotionEvent event, float x, float y, float x1,
			float x2, float y1, float y2, Class<?> clazz, String str) {
		if (x > x1 && x < x2 && y > y1 && y < y2) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				System.out.println(str);
				Intent intent = new Intent();
				intent.setClass(context, clazz);
				context.startActivity(intent);
				break;
			}
		}
	}

}
