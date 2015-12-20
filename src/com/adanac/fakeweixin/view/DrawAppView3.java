package com.adanac.fakeweixin.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.adanac.fakeweixin.activity.moretab.MoreTabZYKFActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabZYXZActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabZYYYActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabZYZHActivity;
import com.adanac.fakeweixin.util.DrawUtil;
import com.adanac.fakeweixin.util.ScreenUtil;

/**
 * 能力类View
 * 
 * @author adanac
 * 
 */
public class DrawAppView3 extends View {

	Context context;
	ScreenUtil sUtil = new ScreenUtil(this);
	private int width = sUtil.getWidth();
	private int height = sUtil.getHeight();

	public DrawAppView3(Context context) {
		super(context);
		this.context = context;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// 创建画笔
		Paint paint = new Paint();

		int rectWidth = 160;
		int rectHeight = 80;
		int centerX = width / 2 - rectWidth / 2;
		int centerY = height / 2 - rectHeight - 100;

		DrawUtil.drawRectCenterTxt(canvas, paint, 270, 200, 160, 90, "媒介素养",
				Color.rgb(247, 80, 0), Color.WHITE, 30);

		DrawUtil.drawRectCenterTxt(canvas, paint, 100, 400, 150, 90, "培养方法",
				Color.GRAY, Color.WHITE, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 270, 400, 150, 90, "媒介解读",
				Color.GRAY, Color.WHITE, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 450, 400, 150, 90, "媒介资源开发",
				Color.GRAY, Color.WHITE, 25);

		// 第二层
		DrawUtil.drawRectCenterTxt(canvas, paint, 280, 600, 150, 90, "资源的选择",
				Color.GRAY, Color.WHITE, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 450, 600, 150, 90, "资源的转化",
				Color.GRAY, Color.WHITE, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 620, 600, 150, 90, "资源的运用",
				Color.GRAY, Color.WHITE, 25);

		paint.setColor(Color.BLACK);

		// 连接第一层
		// 连接媒介素养与媒介解读(270, 200, 160, 90)(270, 400, 150, 90)
		DrawUtil.drawAL(canvas, paint, 270, 200 + 90 / 2, 270, 400 - 90 / 2);
		// 连接培养方法与媒介资源开发（直线）（100, 400, 150, 90）（450, 400, 150, 90）
		DrawUtil.drawLine(canvas, paint, 100, 300, 450, 300);
		// 培养方法小箭头（100, 400, 120, 60）
		DrawUtil.drawAL(canvas, paint, 100, 300, 100, 400 - 90 / 2);
		// 媒介资源开发小箭头（450, 400, 150, 90）
		DrawUtil.drawAL(canvas, paint, 450, 300, 450, 400 - 90 / 2);

		// 连接第二层
		// 连接资源开发与资源转化
		DrawUtil.drawAL(canvas, paint, 450, 400 + 90 / 2, 450, 600 - 90 / 2);
		// 连接资源选择与资源运用（直线 ）
		DrawUtil.drawLine(canvas, paint, 280, 500, 620, 500);
		// 资源选择小箭头(280, 600, 150, 90)
		DrawUtil.drawAL(canvas, paint, 280, 500, 280, 600 - 90 / 2);
		// 资源运用小箭头
		DrawUtil.drawAL(canvas, paint, 620, 500, 620, 600 - 90 / 2);
	}

	/**
	 * 点击事件 onTouchEvent
	 */
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		System.out.println("x:" + x + "y:" + y);

		// 点击媒介资源开发（450, 400, 150, 90）
		clickMJZYKF(event, x, y, 450 - 150 / 2, 450 + 150 / 2, 400 - 90 / 2,
				400 + 90 / 2, MoreTabZYKFActivity.class);

		// 点击资源选择(280, 600, 150, 90)
		clickMJZYXZ(event, x, y, 280 - 150 / 2, 280 + 150 / 2, 600 - 90 / 2,
				600 + 90 / 2, MoreTabZYXZActivity.class);
		// 点击资源转化（450, 600, 150, 90）
		clickMJZYZH(event, x, y, 450 - 150 / 2, 450 + 150 / 2, 600 - 90 / 2,
				600 + 90 / 2, MoreTabZYZHActivity.class);
		// 点击资源运用（620, 600, 150, 90）
		clickMJZYYY(event, x, y, 620 - 150 / 2, 620 + 150 / 2, 600 - 90 / 2,
				600 + 90 / 2, MoreTabZYYYActivity.class);
		return true;
	}

	private void clickMJZYYY(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<MoreTabZYYYActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "点击了媒介资源运用");
	}

	private void clickMJZYZH(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<MoreTabZYZHActivity> clazz) {

		clickSubMethod(event, x, y, i, j, k, l, clazz, "点击了媒介资源转化");
	}

	private void clickMJZYXZ(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<MoreTabZYXZActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "点击了媒介资源选择");

	}

	// 点击媒介资源开发
	private void clickMJZYKF(MotionEvent event, float x, float y, float x1,
			float x2, float y1, float y2, Class<MoreTabZYKFActivity> clazz) {
		clickSubMethod(event, x, y, x1, x2, y1, y2, clazz, "点击了媒介资源开发");
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
