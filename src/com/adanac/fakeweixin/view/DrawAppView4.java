package com.adanac.fakeweixin.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.adanac.fakeweixin.util.DrawUtil;
import com.adanac.fakeweixin.util.ScreenUtil;

/**
 * 情感类View
 * 
 * @author adanac
 * 
 */
public class DrawAppView4 extends View {

	public DrawAppView4(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		ScreenUtil sUtil = new ScreenUtil(this);
		int width = sUtil.getWidth();
		int height = sUtil.getHeight();
		// 创建画笔
		Paint paint = new Paint();
		paint.setColor(Color.GREEN);// 设置红色

		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2, height / 2 - 200,
				100, "媒介解读", Color.rgb(255, 100, 0), Color.BLACK, 35);
		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2, height / 2 - 450,
				70, "水墨画", Color.CYAN, Color.BLACK, 30);
		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2, height / 2 + 50,
				70, "影视", Color.CYAN, Color.BLACK, 30);
		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2 - 225,
				height / 2 - 325, 70, "现代设计", Color.CYAN, Color.BLACK, 30);
		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2 - 225,
				height / 2 - 75, 70, "FLASH", Color.CYAN, Color.BLACK, 30);
		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2 + 225,
				height / 2 - 325, 70, "书法", Color.CYAN, Color.BLACK, 30);
		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2 + 225,
				height / 2 - 75, 70, "摄影", Color.CYAN, Color.BLACK, 30);

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
}
