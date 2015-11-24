package com.adanac.fakeweixin.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.adanac.fakeweixin.activity.ContentFirstActivity;
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
				height / 2 - 250, 90, "媒介素养", Color.rgb(255, 100, 0),
				Color.BLACK, 30);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 40,
				height / 2 + 50, 200, 90, "意义所指层次图", Color.GRAY, Color.BLACK,
				25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 250,
				height / 2 - 250, 150, 90, "媒介素养内涵", Color.GRAY, Color.BLACK,
				25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 250,
				height / 2 - 250, 150, 90, "视觉素养", Color.GRAY, Color.BLACK, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 40,
				height / 2 - 500, 120, 70, "媒介演变", Color.GRAY, Color.BLACK, 20);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 250,
				height / 2 - 500, 100, 70, "媒介", Color.GRAY, Color.BLACK, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 110,
				height / 2 - 370, 120, 70, "符号的内涵", Color.parseColor("yellow"),
				Color.BLACK, 20);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 110,
				height / 2 - 100, 150, 70, "二者间的关系",
				Color.parseColor("yellow"), Color.BLACK, 20);

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

	public void OnClick(MotionEvent event) {
		int action = event.getAction();
		if (action != MotionEvent.ACTION_DOWN) {
			return;
		}
		int x = (int) event.getX();
		int y = (int) event.getY();
		// Toast.makeText(MainContent.class, "欢迎进入APP",
		// Toast.LENGTH_SHORT).show();

	}

	/**
	 * 点击事件
	 */
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		System.out.println("x:" + x + "y:" + y);
		// 点击媒介素养
		if (x > width / 2 - 100 && x < width / 2 + 100 && y > height / 2 - 300
				&& y < height / 2 - 100) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				System.out.println("点击了此区域");
				Intent intent = new Intent();
				intent.setClass(context, ContentFirstActivity.class);
				context.startActivity(intent);
				break;

			case MotionEvent.ACTION_UP:
				System.out.println("离开了此区域");
				break;
			}
		}
		return true;
	}
}
