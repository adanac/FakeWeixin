package com.adanac.fakeweixin.util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;

/**
 * 画图工具类
 * 
 * @author adanac
 * @date 2015-11-13上午12:23:11
 */
public class DrawUtil {

	/**
	 * 画带文字的圆
	 * 
	 * @param canvas
	 * @param paint
	 * @param left
	 * @param up
	 * @param radius
	 * @param str
	 * @param circleColor
	 * @param txtColor
	 * @param txtSize
	 */
	public static void drawCircleAndTxt(Canvas canvas, Paint paint, int left,
			int up, int radius, String str, int circleColor, int txtColor,
			int txtSize) {
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
	 * 画箭头
	 * 
	 * @param sx
	 * @param sy
	 * @param ex
	 * @param ey
	 */
	public static void drawAL(Canvas canvas, Paint paint, int sx, int sy,
			int ex, int ey) {
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

	/**
	 * 画箭头
	 * 
	 * @param sx
	 * @param sy
	 * @param ex
	 * @param ey
	 */
	public static void drawALObject(Canvas canvas, Paint paint, Object o1,
			Object o2) {
		double H = 8; // 箭头高度
		double L = 3.5; // 底边的一半
		int x3 = 0;
		int y3 = 0;
		int x4 = 0;
		int y4 = 0;

		double awrad = Math.atan(L / H); // 箭头角度
		double arraow_len = Math.sqrt(L * L + H * H); // 箭头的长度

	}

	/**
	 * 计算要连接的两个区域的箭头的坐标
	 * 
	 * @param px
	 * @param py
	 * @param ang
	 * @param isChLen
	 * @param newLen
	 * @return
	 */
	private static double[] rotateVec(int px, int py, double ang,
			boolean isChLen, double newLen) {
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

	/**
	 * 画直线
	 * 
	 * @param canvas
	 * @param paint
	 * @param ox1
	 * @param oy1
	 * @param ox2
	 * @param oy2
	 */
	public static void drawLine(Canvas canvas, Paint paint, int ox1, int oy1,
			int ox2, int oy2) {
		// Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		// paint.setColor(color);
		canvas.drawLine(ox1, oy1, ox2, oy2, paint);
	}

	/**
	 * 画带文字的圆角矩形
	 * 
	 * @param canvas
	 * @param p
	 * @param ox
	 * @param oy
	 * @param a
	 * @param b
	 * @param str
	 * @param rectColor
	 * @param txtColor
	 * @param txtSize
	 */
	public static void drawRt(Canvas canvas, Paint p, int ox, int oy, int a,
			int b, String str, int rectColor, int txtColor, int txtSize) {
		drawRectAndTxt(canvas, p, ox, oy, a, b, str, rectColor, txtColor,
				txtSize);
	}

	/**
	 * 在图片上写字
	 * 
	 * @param canvas
	 * @param width
	 * @param height
	 * @param p
	 * @param str
	 */
	public static void drawTxt(Canvas canvas, int width, int height, Paint p,
			String str) {
		p.setTextSize(24);
		p.setColor(Color.WHITE);
		p.setTextAlign(Paint.Align.CENTER);
		p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText(str, width / 2, height / 2 - 140, p);
	}

	/**
	 * 画圆角矩形
	 * 
	 * @param canvas
	 * @param p
	 * @param left
	 * @param right
	 * @param width
	 * @param height
	 */
	public static void drawRRect(Canvas canvas, Paint p, int left, int right,
			int width, int height) {
		p.setStyle(Paint.Style.FILL);// 充满
		p.setColor(Color.GREEN);
		p.setAntiAlias(true);// 设置画笔的锯齿效果

		RectF oval3 = new RectF(left, right, width, height);// 设置个新的长方形
		canvas.drawRoundRect(oval3, 20, 15, p);// 第二个参数是x半径，第三个参数是y半径
	}

	/**
	 * 画带文字的矩形
	 * 
	 * @param canvas
	 * @param paint
	 * @param ox
	 * @param oy
	 * @param a
	 * @param b
	 * @param str
	 * @param rectColor
	 * @param txtColor
	 * @param txtSize
	 */
	public static void drawRect(Canvas canvas, Paint paint, int ox, int oy,
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

	/**
	 * 画带文字的矩形并使文字居中
	 * 
	 * @param canvas
	 * @param paint
	 * @param ox
	 * @param oy
	 * @param a
	 * @param b
	 * @param str
	 * @param rectColor
	 * @param txtColor
	 * @param txtSize
	 */
	public static void drawRectCenterTxt(Canvas canvas, Paint paint, int ox,
			int oy, int a, int b, String str, int rectColor, int txtColor,
			int txtSize) {
		// // 1.画矩形
		// // 产生一个红色的圆角矩形 或者任何有色颜色，不能是透明！
		// RectF outerRect = new RectF(ox - a / 2, oy - b / 2, ox + a / 2, oy +
		// b
		// / 2);
		// paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		// paint.setColor(rectColor);
		// canvas.drawRoundRect(outerRect, 10, 10, paint);
		//
		// // 2、写字
		// paint.setTextSize(txtSize);
		// paint.setColor(txtColor);
		// paint.setTextAlign(Paint.Align.CENTER);
		// paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		// canvas.drawText(str, ox, oy, paint);

		Rect targetRect = new Rect(ox - a / 2, oy - b / 2, ox + a / 2, oy + b
				/ 2);
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);

		paint.setColor(rectColor);
		canvas.drawRect(targetRect, paint);

		paint.setColor(txtColor);
		paint.setStrokeWidth(3);
		paint.setTextSize(txtSize);
		FontMetricsInt fontMetrics = paint.getFontMetricsInt();
		// 转载请注明出处：http://blog.csdn.net/hursing
		int baseline = (targetRect.bottom + targetRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
		// 下面这行是实现水平居中，drawText对应改为传入targetRect.centerX()
		paint.setTextAlign(Paint.Align.CENTER);
		canvas.drawText(str, targetRect.centerX(), baseline, paint);
	}

	/**
	 * 画带文字的圆角矩形
	 * 
	 * @param canvas
	 * @param paint
	 * @param ox
	 * @param oy
	 * @param a
	 * @param b
	 * @param str
	 * @param rectColor
	 * @param txtColor
	 * @param txtSize
	 */
	private static void drawRectAndTxt(Canvas canvas, Paint paint, int ox,
			int oy, int a, int b, String str, int rectColor, int txtColor,
			int txtSize) {
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

	/**
	 * 画贝塞尔曲线
	 * 
	 * @param canvas
	 * @param p
	 */
	public static void drawBezierCurve(Canvas canvas, Paint p) {
		canvas.drawText("画贝塞尔曲线:", 10, 310, p);
		p.reset();
		p.setStyle(Paint.Style.STROKE);
		p.setColor(Color.GREEN);
		Path path2 = new Path();
		path2.moveTo(100, 320);// 设置Path的起点
		path2.quadTo(150, 310, 170, 400); // 设置贝塞尔曲线的控制点坐标和终点坐标
		canvas.drawPath(path2, p);// 画出贝塞尔曲线
	}

	/**
	 * 画笑脸弧线
	 * 
	 * @param canvas
	 * @param p
	 */
	public static void drawSmileArc(Canvas canvas, Paint p) {
		p.setStyle(Paint.Style.STROKE);// 设置空心
		RectF oval1 = new RectF(150, 20, 180, 40);
		canvas.drawArc(oval1, 180, 180, false, p);// 小弧形
		oval1.set(190, 20, 220, 40);
		canvas.drawArc(oval1, 180, 180, false, p);// 小弧形
		oval1.set(160, 30, 210, 60);
		canvas.drawArc(oval1, 0, 180, false, p);// 小弧形
	}

	/**
	 * 画扇形和椭圆
	 * 
	 * @param canvas
	 * @param p
	 */
	public static void drawSectorAndEllipse(Canvas canvas, Paint p) {
		canvas.drawText("画扇形和椭圆:", 10, 120, p);
		/* 设置渐变色 这个正方形的颜色是改变的 */
		Shader mShader = new LinearGradient(0, 0, 100, 100,
				new int[] { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
						Color.LTGRAY }, null, Shader.TileMode.REPEAT); // 一个材质,打造出一个线性梯度沿著一条线。
		p.setShader(mShader);
		// p.setColor(Color.BLUE);
		RectF oval2 = new RectF(60, 100, 200, 240);// 设置个新的长方形，扫描测量
		canvas.drawArc(oval2, 200, 130, true, p);
		// 画弧，第一个参数是RectF：该类是第二个参数是角度的开始，第三个参数是多少度，第四个参数是真的时候画扇形，是假的时候画弧线
		// 画椭圆，把oval改一下
		oval2.set(210, 100, 250, 130);
		canvas.drawOval(oval2, p);
	}

	/**
	 * 画多边形：比如六边形
	 * 
	 * @param canvas
	 * @param p
	 */
	public static void drawPolygon(Canvas canvas, Paint p) {
		p.reset();// 重置
		p.setColor(Color.LTGRAY);
		p.setStyle(Paint.Style.STROKE);// 设置空心
		Path path1 = new Path();
		path1.moveTo(180, 200);
		path1.lineTo(200, 200);
		path1.lineTo(210, 210);
		path1.lineTo(200, 220);
		path1.lineTo(180, 220);
		path1.lineTo(170, 210);
		path1.close();// 封闭
		canvas.drawPath(path1, p);
	}

	/**
	 * 画点
	 * 
	 * @param canvas
	 * @param p
	 */
	public static void drawPoint(Canvas canvas, Paint p) {
		p.setStyle(Paint.Style.FILL);
		canvas.drawText("画点：", 10, 390, p);
		canvas.drawPoint(60, 390, p);// 画一个点
		canvas.drawPoints(new float[] { 60, 400, 65, 400, 70, 400 }, p);// 画多个点
	}
}
