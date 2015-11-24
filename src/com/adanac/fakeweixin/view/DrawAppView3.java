package com.adanac.fakeweixin.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.adanac.fakeweixin.util.DrawUtil;
import com.adanac.fakeweixin.util.ScreenUtil;

/**
 * 能力类View
 * 
 * @author adanac
 * 
 */
public class DrawAppView3 extends View {

	ScreenUtil sUtil = new ScreenUtil(this);
	private int width = sUtil.getWidth();
	private int height = sUtil.getHeight();

	public DrawAppView3(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// 创建画笔
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);// 设置蓝色

		int rectWidth = 160;
		int rectHeight = 80;
		int centerX = width / 2 - rectWidth / 2;
		int centerY = height / 2 - rectHeight - 100;

		DrawUtil.drawRt(canvas, paint, 250, 200, 160, 80, "媒介素养",
				Color.rgb(255, 100, 0), Color.BLACK, 25);

		DrawUtil.drawRt(canvas, paint, 100, 400, 120, 60, "培养方法", Color.BLACK,
				Color.YELLOW, 20);
		DrawUtil.drawRt(canvas, paint, 250, 400, 120, 60, "媒介解读", Color.BLACK,
				Color.YELLOW, 20);
		DrawUtil.drawRt(canvas, paint, 400, 400, 120, 60, "媒介资源开发",
				Color.BLACK, Color.YELLOW, 20);

		// 第二层
		DrawUtil.drawRt(canvas, paint, 250, 600, 120, 60, "资源的选择", Color.BLACK,
				Color.YELLOW, 20);
		DrawUtil.drawRt(canvas, paint, 400, 600, 120, 60, "资源的转化", Color.BLACK,
				Color.YELLOW, 20);
		DrawUtil.drawRt(canvas, paint, 550, 600, 120, 60, "资源的运用", Color.BLACK,
				Color.YELLOW, 20);

		paint.setColor(Color.BLACK);

		// 连接第一层
		// 连接媒介素养与媒介解读(250, 200, 160, 80)(250, 400, 120, 60)
		DrawUtil.drawAL(canvas, paint, 250, 200 + 80 / 2, 250, 400 - 60 / 2);
		// 连接培养方法与媒介资源开发（直线）（100, 400, 120, 60）（100, 400, 120, 60）
		DrawUtil.drawLine(canvas, paint, 100, 300, 400, 300);
		// 培养方法小箭头（100, 400, 120, 60）
		DrawUtil.drawAL(canvas, paint, 100, 300, 100, 400 - 60 / 2);
		// 媒介资源开发小箭头（400, 400, 120, 60）
		DrawUtil.drawAL(canvas, paint, 400, 300, 400, 400 - 60 / 2);

		// 连接第二层
		// 连接资源开发与资源转化
		DrawUtil.drawAL(canvas, paint, 400, 400 + 60 / 2, 400, 600 - 60 / 2);
		// 连接资源选择与资源运用（直线 ）
		DrawUtil.drawLine(canvas, paint, 250, 500, 550, 500);
		// 资源选择小箭头
		DrawUtil.drawAL(canvas, paint, 250, 500, 250, 600 - 60 / 2);
		// 资源运用小箭头
		DrawUtil.drawAL(canvas, paint, 550, 500, 550, 600 - 60 / 2);
	}

}
