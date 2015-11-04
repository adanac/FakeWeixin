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

import com.adanac.fakeweixin.util.ScreenUtil;

/**
 * 画椭圆
 * 
 * @author vance
 * 
 */
public class DrawAppView3 extends View {

	public DrawAppView3(Context context) {
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
		paint.setColor(Color.BLUE);// 设置蓝色

		int rectWidth = 160;
		int rectHeight = 80;
		int centerX = width / 2 - rectWidth / 2;
		int centerY = height / 2 - rectHeight - 100;

		drawRt(canvas, paint, 250, 300, 160, 80, "课程分类", Color.GREEN,
				Color.RED, 25);

		drawRt(canvas, paint, 200, 200, 120, 60, "语文", Color.BLACK,
				Color.YELLOW, 20);
		drawRt(canvas, paint, 400, 200, 120, 60, "数学", Color.BLACK,
				Color.YELLOW, 20);
		// drawRt(canvas, paint, 400, 200, 120, 60, "数学", Color.BLACK,
		// Color.YELLOW, 20);
		// drawRt(canvas, paint, 400, 200, 120, 60, "数学", Color.BLACK,
		// Color.YELLOW, 20);
		// drawRt(canvas, paint, 400, 200, 120, 60, "数学", Color.BLACK,
		// Color.YELLOW, 20);

		// 连接图片
		paint.setColor(Color.BLACK);
		drawLine(canvas, paint, 250, 360, 200, 170);
		drawLine(canvas, paint, 250, 360, 400, 170);
	}

	/**
	 * 画直线
	 * 
	 * @param canvas
	 * @param ox1
	 *            起始点的x轴位置
	 * @param oy1
	 *            起始点的y轴位置
	 * @param ox2
	 *            终点的x轴水平位置
	 * @param oy2
	 *            终点y轴垂直位置
	 * @param color
	 *            线的颜色
	 */

	private void drawLine(Canvas canvas, Paint paint, int ox1, int oy1,
			int ox2, int oy2) {
		// Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		// paint.setColor(color);
		canvas.drawLine(ox1, oy1, ox2, oy2, paint);
	}

	// 计算
	public double[] rotateVec(int px, int py, double ang, boolean isChLen,
			double newLen) {
		double mathstr[] = new double[2];
		// 矢量旋转函数，参数含义分别是x分量、y分量、旋转角、是否改变长度、新长度
		double vx = px * Math.cos(ang) - py * Math.sin(ang);
		double vy = px * Math.sin(ang) + py * Math.cos(ang);
		if (isChLen) {
			double d = Math.sqrt(vx * vx + vy * vy);
			vx = vx / d * newLen;
			vy = vy / d * newLen;
			mathstr[0] = vx;
			mathstr[1] = vy;
		}
		return mathstr;
	}

	// 画带文字的圆角矩形
	private void drawRt(Canvas canvas, Paint p, int ox, int oy, int a, int b,
			String str, int rectColor, int txtColor, int txtSize) {
		drawRectAndTxt(canvas, p, ox, oy, a, b, str, rectColor, txtColor,
				txtSize);

	}

	// 画图片，就是贴图
	private void drawPng(Canvas canvas, Paint p, int id) {
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id);
		canvas.drawBitmap(bitmap, 200, 260, p);
	}

	// 在图片上写字
	private void drawTxt(Canvas canvas, int width, int height, Paint p,
			String str) {
		p.setTextSize(24);
		p.setColor(Color.WHITE);
		p.setTextAlign(Paint.Align.CENTER);
		p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText(str, width / 2, height / 2 - 140, p);
	}

	// 画圆角矩形
	private void drawRRect(Canvas canvas, Paint p, int left, int right,
			int width, int height) {
		p.setStyle(Paint.Style.FILL);// 充满
		p.setColor(Color.GREEN);
		p.setAntiAlias(true);// 设置画笔的锯齿效果

		RectF oval3 = new RectF(left, right, width, height);// 设置个新的长方形
		canvas.drawRoundRect(oval3, 20, 15, p);// 第二个参数是x半径，第三个参数是y半径
	}

	// 画带文字的圆角矩形
	private void drawRectAndTxt(Canvas canvas, Paint paint, int ox, int oy,
			int a, int b, String str, int rectColor, int txtColor, int txtSize) {
		// 1.画矩形
		// 产生一个红色的圆角矩形 或者任何有色颜色，不能是透明！
		RectF outerRect = new RectF(ox - a / 2, oy - b / 2, ox + a / 2, oy + b
				/ 2);
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(rectColor);
		canvas.drawRoundRect(outerRect, 10, 10, paint);

		// 2、写字
		paint.setTextSize(txtSize);
		paint.setColor(txtColor);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText(str, ox, oy, paint);
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
}
