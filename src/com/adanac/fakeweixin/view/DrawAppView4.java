package com.adanac.fakeweixin.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.adanac.fakeweixin.util.ScreenUtil;

/**
 * 情感类
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

		drawCircleAndTxt(canvas, paint, width / 2, height / 2 - 200, 100,
				"媒介解读", Color.LTGRAY, Color.BLACK, 35);
		drawCircleAndTxt(canvas, paint, width / 2, height / 2 - 450, 70, "水墨画",
				Color.CYAN, Color.BLACK, 30);
		drawCircleAndTxt(canvas, paint, width / 2, height / 2 + 50, 70, "影视",
				Color.CYAN, Color.BLACK, 30);
		drawCircleAndTxt(canvas, paint, width / 2 - 225, height / 2 - 325, 70,
				"现代设计", Color.CYAN, Color.BLACK, 30);
		drawCircleAndTxt(canvas, paint, width / 2 - 225, height / 2 - 75, 70,
				"FLASH", Color.CYAN, Color.BLACK, 30);
		drawCircleAndTxt(canvas, paint, width / 2 + 225, height / 2 - 325, 70,
				"书法", Color.CYAN, Color.BLACK, 30);
		drawCircleAndTxt(canvas, paint, width / 2 + 225, height / 2 - 75, 70,
				"摄影", Color.CYAN, Color.BLACK, 30);

		paint.setColor(Color.BLACK);
		drawAL(canvas, paint, width / 2, height / 2 - 200 - 100, width / 2,
				height / 2 - 450 + 70);
		drawAL(canvas, paint, width / 2, height / 2 - 200 + 100, width / 2,
				height / 2 + 50 - 70);
		drawArowLine(canvas, width / 2, height / 2 - 200, 100, width / 2 - 225,
				height / 2 - 325, 70, paint);
		drawArowLine(canvas, width / 2, height / 2 - 200, 100, width / 2 - 225,
				height / 2 - 75, 70, paint);
		drawArowLine(canvas, width / 2, height / 2 - 200, 100, width / 2 + 225,
				height / 2 - 75, 70, paint);
		drawArowLine(canvas, width / 2, height / 2 - 200, 100, width / 2 + 225,
				height / 2 - 325, 70, paint);
	}

	private void drawArowLine(Canvas canvas, int ax, int ay, int ra, int bx,
			int by, int rb, Paint paint) {
		// float k = (by - ay) / (bx - ax);
		double length = Math
				.sqrt((by - ay) * (by - ay) + (bx - ax) * (bx - ax));
		double axshift = (bx - ax) * (ra / length);
		double ayshift = (by - ay) * (ra / length);
		double bxshift = (bx - ax) * (rb / length);
		double byshift = (by - ay) * (rb / length);
		drawAL(canvas, paint, ax + (int) axshift, ay + (int) ayshift, bx
				- (int) bxshift, by - (int) byshift);
	}

	private void drawCircleAndTxt(Canvas canvas, Paint paint, int left, int up,
			int radius, String str, int circleColor, int txtColor, int txtSize) {
		// 1.画圆
		paint.setColor(circleColor);
		paint.setAntiAlias(true);// 设置画笔的锯齿效果。 true是去除
		canvas.drawCircle(left, up, radius, paint);

		// 2、写字
		paint.setTextSize(txtSize);
		paint.setColor(txtColor);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText(str, left, up, paint);

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

	/**
	 * 画箭头
	 * 
	 * @param sx
	 * @param sy
	 * @param ex
	 * @param ey
	 */
	public void drawAL(Canvas canvas, Paint paint, int sx, int sy, int ex,
			int ey) {
		double H = 8; // 箭头高度
		double L = 3.5; // 底边的一半
		int x3 = 0;
		int y3 = 0;
		int x4 = 0;
		int y4 = 0;
		double awrad = Math.atan(L / H); // 箭头角度
		double arraow_len = Math.sqrt(L * L + H * H); // 箭头的长度
		double[] arrXY_1 = rotateVec(ex - sx, ey - sy, awrad, true, arraow_len);
		double[] arrXY_2 = rotateVec(ex - sx, ey - sy, -awrad, true, arraow_len);
		double x_3 = ex - arrXY_1[0]; // (x3,y3)是第一端点
		double y_3 = ey - arrXY_1[1];
		double x_4 = ex - arrXY_2[0]; // (x4,y4)是第二端点
		double y_4 = ey - arrXY_2[1];
		Double X3 = new Double(x_3);
		x3 = X3.intValue();
		Double Y3 = new Double(y_3);
		y3 = Y3.intValue();
		Double X4 = new Double(x_4);
		x4 = X4.intValue();
		Double Y4 = new Double(y_4);
		y4 = Y4.intValue();
		// 画线
		canvas.drawLine(sx, sy, ex, ey, paint);
		Path triangle = new Path();
		triangle.moveTo(ex, ey);
		triangle.lineTo(x3, y3);
		triangle.lineTo(x4, y4);
		triangle.close();
		canvas.drawPath(triangle, paint);

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
