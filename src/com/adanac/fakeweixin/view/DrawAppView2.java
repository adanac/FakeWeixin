package com.adanac.fakeweixin.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.adanac.fakeweixin.util.DrawUtil;
import com.adanac.fakeweixin.util.ScreenUtil;

/**
 * 知识类
 * 
 * @author adanac
 * @date 2015-11-13下午4:44:52
 */
public class DrawAppView2 extends View {

	public DrawAppView2(Context context) {
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
		paint.setColor(Color.RED);// 设置红色

		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2, height / 2 - 200,
				100, "媒介素养", Color.YELLOW, Color.BLACK, 35);
		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2, height / 2 + 100,
				200, 90, "意义所指层次图", Color.GRAY, Color.BLACK, 18);
		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 250,
				height / 2 - 200, 200, 90, "媒介素养的内涵", Color.GRAY, Color.BLACK,
				18);
		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 250,
				height / 2 - 200, 200, 90, "视觉素养", Color.GRAY, Color.BLACK, 18);
		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2, height / 2 - 400,
				150, 90, "媒介演变", Color.GRAY, Color.BLACK, 18);
		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 250,
				height / 2 - 400, 200, 90, "媒介", Color.GRAY, Color.BLACK, 18);
		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 250,
				height / 2 - 400, 150, 90, "符号的内涵", Color.GRAY, Color.BLACK, 18);
		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 250,
				height / 2 + 100, 150, 90, "二者间的关系",
				Color.parseColor("yellow"), Color.BLACK, 18);

		paint.setColor(Color.BLACK);
		// 连接媒介素养与媒介素养的内涵
		DrawUtil.drawAL(canvas, paint, width / 2 - 100, height / 2 - 200, width
				/ 2 - 250 + 200 / 2, height / 2 - 200);

		// 连接视觉素养与媒介素养(双箭头)
		DrawUtil.drawAL(canvas, paint, width / 2 + 100, height / 2 - 200, width
				/ 2 + 250 - 200 / 2, height / 2 - 200);
		DrawUtil.drawAL(canvas, paint, width / 2 + 250 - 200 / 2,
				height / 2 - 200, width / 2 + 100, height / 2 - 200);

		// 连接媒介演变与媒介素养
		DrawUtil.drawAL(canvas, paint, width / 2, height / 2 - 355, width / 2,
				height / 2 - 300);

		// 连接媒介素养与意义所指的层次图(直线)
		DrawUtil.drawLine(canvas, paint, width / 2, height / 2 - 100,
				width / 2, height / 2 + 55);

	}

	private void drawTxtPic(Canvas canvas) {

		// 1、创建一个drawable对象，一个输出的Bitmap并以此创建一个画布
		// 根据源文件新建一个darwable对象
		int id = getResources().getIdentifier(
				"com.adanac.fakeweixin:drawable/icon", null, null);
		Drawable imageDrawable = getResources().getDrawable(id);
		// 新建一个新的输出图片
		Bitmap output = Bitmap.createBitmap(169, 169, Bitmap.Config.ARGB_8888);
		canvas = new Canvas(output);

		// 2、创建圆角矩形
		// 新建一个矩形
		RectF outerRect = new RectF(0, 0, 169, 169);
		// 产生一个红色的圆角矩形 或者任何有色颜色，不能是透明！
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.RED);
		canvas.drawRoundRect(outerRect, 10, 10, paint);

		// 3、在矩形上画图形
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		imageDrawable.setBounds(0, 0, 169, 169);
		imageDrawable.draw(canvas);

		// 4、写字
		paint.setTextSize(24);
		paint.setColor(Color.WHITE);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText("test", 85, 159, paint);
	}

	// 画图片，就是贴图
	private void drawPng(Canvas canvas, Paint p, int id) {
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id);
		canvas.drawBitmap(bitmap, 200, 260, p);
	}
}
