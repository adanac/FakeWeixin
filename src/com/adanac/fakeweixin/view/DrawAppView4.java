package com.adanac.fakeweixin.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.adanac.fakeweixin.activity.moretab.MoreTabEMFlashActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabEMSFActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabEMSMLActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabEMSYActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabEMXDSJActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabEMYSActivity;
import com.adanac.fakeweixin.util.DrawUtil;
import com.adanac.fakeweixin.util.ScreenUtil;

/**
 * 情感类View
 * 
 * @author adanac
 * 
 */
public class DrawAppView4 extends View {

	Context context;

	public DrawAppView4(Context context) {
		super(context);
		this.context = context;
	}

	ScreenUtil sUtil = new ScreenUtil(this);
	int width = sUtil.getWidth();
	int height = sUtil.getHeight();

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// 创建画笔
		Paint paint = new Paint();

		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2, height / 2 - 200,
				100, "媒介解读", Color.rgb(247, 80, 0), Color.WHITE, 30);
		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2, height / 2 - 450,
				70, "水墨画", Color.GRAY, Color.WHITE, 25);
		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2, height / 2 + 50,
				70, "影视", Color.GRAY, Color.WHITE, 25);
		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2 - 225,
				height / 2 - 325, 70, "现代设计", Color.GRAY, Color.WHITE, 25);
		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2 - 225,
				height / 2 - 75, 70, "FLASH", Color.GRAY, Color.WHITE, 25);
		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2 + 225,
				height / 2 - 325, 70, "书法", Color.GRAY, Color.WHITE, 25);
		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2 + 225,
				height / 2 - 75, 70, "摄影", Color.GRAY, Color.WHITE, 25);

		paint.setColor(Color.BLACK);
		DrawUtil.drawAL(canvas, paint, width / 2, height / 2 - 200 - 100,
				width / 2, height / 2 - 450 + 70);
		DrawUtil.drawAL(canvas, paint, width / 2, height / 2 - 200 + 100,
				width / 2, height / 2 + 50 - 70);
		DrawUtil.drawArowLine(canvas, width / 2, height / 2 - 200, 100,
				width / 2 - 225, height / 2 - 325, 70, paint);
		DrawUtil.drawArowLine(canvas, width / 2, height / 2 - 200, 100,
				width / 2 - 225, height / 2 - 75, 70, paint);
		DrawUtil.drawArowLine(canvas, width / 2, height / 2 - 200, 100,
				width / 2 + 225, height / 2 - 75, 70, paint);
		DrawUtil.drawArowLine(canvas, width / 2, height / 2 - 200, 100,
				width / 2 + 225, height / 2 - 325, 70, paint);
	}

	/**
	 * 点击事件 onTouchEvent
	 */
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		System.out.println("x:" + x + "y:" + y);

		// 点击水墨画（width / 2, height / 2 - 450,70）
		clickEMSML(event, x, y, width / 2, height / 2 - 450, 70,
				MoreTabEMSMLActivity.class);
		// 点击现代设计（width / 2 - 225,height / 2 - 325）
		clickEMXDSJ(event, x, y, width / 2 - 225, height / 2 - 325, 70,
				MoreTabEMXDSJActivity.class);
		// 点击Flash(width / 2 - 225, height / 2 - 75, 70)
		clickEMFlash(event, x, y, width / 2 - 225, height / 2 - 75, 70,
				MoreTabEMFlashActivity.class);
		// 点击影视(width / 2, height / 2 + 50,70)
		clickEMYS(event, x, y, width / 2, height / 2 + 50, 70,
				MoreTabEMYSActivity.class);
		// 点击摄影
		clickEMSY(event, x, y, width / 2 + 225, height / 2 - 75, 70,
				MoreTabEMSYActivity.class);
		// 点击书法
		clickEMSF(event, x, y, width / 2 + 225, height / 2 - 325, 70,
				MoreTabEMSFActivity.class);
		return true;
	}

	private void clickEMSF(MotionEvent event, float x, float y, int i, int j,
			int k, Class<MoreTabEMSFActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, clazz, "点击了书法");

	}

	private void clickEMSY(MotionEvent event, float x, float y, int i, int j,
			int k, Class<MoreTabEMSYActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, clazz, "点击了摄影");

	}

	private void clickEMYS(MotionEvent event, float x, float y, int i, int j,
			int k, Class<MoreTabEMYSActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, clazz, "点击了影视");

	}

	private void clickEMFlash(MotionEvent event, float x, float y, int i,
			int j, int k, Class<MoreTabEMFlashActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, clazz, "点击了Flash");
	}

	private void clickEMXDSJ(MotionEvent event, float x, float y, int i, int j,
			int k, Class<MoreTabEMXDSJActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, clazz, "点击了现代设计");

	}

	private void clickEMSML(MotionEvent event, float x, float y, int xo,
			int yo, int r, Class<MoreTabEMSMLActivity> clazz) {
		clickSubMethod(event, x, y, xo, yo, r, clazz, "点击了水墨画");
	}

	private void clickSubMethod(MotionEvent event, float x, float y, int xo,
			int yo, int r, Class<?> clazz, String str) {
		if (x >= xo - r && x <= xo + r && y >= yo - r && y <= yo + r) {
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
