package com.adanac.fakeweixin.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.adanac.fakeweixin.activity.moretab.MoreTabEZGXActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabFHNHActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabMJSYActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabSJSYActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabYYCCActivity;
import com.adanac.fakeweixin.util.DrawUtil;
import com.adanac.fakeweixin.util.ScreenUtil;

/**
 * 知识类View
 * 
 * @author adanac
 * @date 2015-11-13
 */
public class DrawAppView2 extends View {

	Context context;
	ScreenUtil sUtil = new ScreenUtil(this);
	private int width = sUtil.getWidth();
	private int height = sUtil.getHeight();

	public DrawAppView2(Context context) {
		super(context);
		this.context = context;
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// 创建画笔
		Paint paint = new Paint();
		paint.setColor(Color.RED);// 设置红色

		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2 - 40,
				height / 2 - 250, 90, "媒介素养", Color.rgb(247, 80, 0),
				Color.WHITE, 30);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 40,
				height / 2 + 50, 200, 90, "意义所指层次图", Color.GRAY, Color.WHITE,
				25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 250,
				height / 2 - 250, 150, 90, "媒介素养内涵", Color.GRAY, Color.WHITE,
				25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 250,
				height / 2 - 250, 150, 90, "视觉素养", Color.GRAY, Color.WHITE, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 40,
				height / 2 - 500, 120, 70, "媒介演变", Color.GRAY, Color.WHITE, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 250,
				height / 2 - 500, 100, 70, "媒介", Color.GRAY, Color.WHITE, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 110,
				height / 2 - 370, 120, 70, "符号的内涵", Color.parseColor("gray"),
				Color.WHITE, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 110,
				height / 2 - 100, 150, 70, "二者间的关系", Color.parseColor("gray"),
				Color.WHITE, 25);

		paint.setColor(Color.BLACK);

		// 连接媒介与媒介演变（width / 2 - 250,height / 2 - 500, 100, 70）
		// （width / 2 - 40, height / 2 - 500, 120, 70）
		DrawUtil.drawAL(canvas, paint, width / 2 - 250 + 100 / 2,
				height / 2 - 500, width / 2 - 40 - 120 / 2, height / 2 - 500);

		// 连接双箭头与二者间的关系
		DrawUtil.drawAL(canvas, paint, width / 2 + 110, height / 2 - 250,
				width / 2 + 110, height / 2 - 100 - 70 / 2);

		// 连接符号的内涵与双箭头(width / 2 + 110,height / 2 - 370, 120, 70)
		DrawUtil.drawAL(canvas, paint, width / 2 + 110, height / 2 - 370 + 70
				/ 2, width / 2 + 110, height / 2 - 250);

		// 连接媒介素养与媒介素养内涵
		DrawUtil.drawAL(canvas, paint, width / 2 - 40 - 90, height / 2 - 250,
				width / 2 - 250 + 150 / 2, height / 2 - 250);

		// 连接视觉素养与媒介素养(双箭头)
		DrawUtil.drawAL(canvas, paint, width / 2 + 50, height / 2 - 250, width
				/ 2 + 250 - 150 / 2, height / 2 - 250);
		DrawUtil.drawAL(canvas, paint, width / 2 + 250 - 150 / 2,
				height / 2 - 250, width / 2 + 50, height / 2 - 250);

		// 连接媒介演变与媒介素养
		DrawUtil.drawAL(canvas, paint, width / 2 - 40, height / 2 - 500 + 70
				/ 2, width / 2 - 40, height / 2 - 250 - 90);

		// 连接媒介素养与意义所指的层次图(直线)（width / 2 - 40,height / 2 - 250, 90）（width / 2 -
		// 40,height / 2 + 50, 200, 90）
		DrawUtil.drawLine(canvas, paint, width / 2 - 40, height / 2 - 250 + 90,
				width / 2 - 40, height / 2 + 5);

	}

	/**
	 * 点击事件 onTouchEvent
	 */
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		System.out.println("x:" + x + "y:" + y);

		// 点击媒介素养内涵（width / 2 - 250,height / 2 - 250, 150, 90）
		clickMJSYNH(event, x, y, width / 2 - 250 - 150 / 2, width / 2 - 250
				+ 150 / 2, height / 2 - 250 - 90 / 2,
				height / 2 - 250 + 90 / 2, MoreTabMJSYActivity.class);
		// 点击视觉素养（width / 2 + 250,height / 2 - 250, 150, 90）
		clickSJSY(event, x, y, width / 2 + 250 - 150 / 2, width / 2 + 250 + 150
				/ 2, height / 2 - 250 - 90 / 2, height / 2 - 250 + 90 / 2,
				MoreTabSJSYActivity.class);
		// 点击意义所指层次图（width / 2 - 40,height / 2 + 50, 200, 90）
		clickYYCC(event, x, y, width / 2 - 40 - 200 / 2, width / 2 - 40 + 200
				/ 2, height / 2 + 50 - 90 / 2, height / 2 + 50 + 90 / 2,
				MoreTabYYCCActivity.class);
		// 点击二者间的关系 （width / 2 + 110,height / 2 - 100, 150, 70）
		clickEZGX(event, x, y, width / 2 + 110 - 150 / 2, width / 2 + 110 + 150
				/ 2, height / 2 - 100 - 70 / 2, height / 2 - 50 + 70 / 2,
				MoreTabEZGXActivity.class);
		// 点击符号的内涵（width / 2 + 110,height / 2 - 370, 120, 70）
		clickFHNH(event, x, y, width / 2 + 110 - 120 / 2, width / 2 + 110 + 120
				/ 2, height / 2 - 370 - 70 / 2, height / 2 - 370 + 70 / 2,
				MoreTabFHNHActivity.class);
		return true;
	}

	private void clickFHNH(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<MoreTabFHNHActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "点击了符号的内涵");
	}

	private void clickEZGX(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<MoreTabEZGXActivity> clazz) {

		clickSubMethod(event, x, y, i, j, k, l, clazz, "点击了二者关系");
	}

	// 点击意义所指层次图
	private void clickYYCC(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<MoreTabYYCCActivity> clazz) {

		clickSubMethod(event, x, y, i, j, k, l, clazz, "点击了意义所指层次图");
	}

	// 点击视觉素养
	private void clickSJSY(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<MoreTabSJSYActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "点击了视觉素养");
	}

	// 点击媒介素养内涵
	private void clickMJSYNH(MotionEvent event, float x, float y, float x1,
			float x2, float y1, float y2, Class<MoreTabMJSYActivity> clazz) {
		clickSubMethod(event, x, y, x1, x2, y1, y2, clazz, "点击了媒介素养内涵");
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
