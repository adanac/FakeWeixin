package com.adanac.fakeweixin.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.adanac.fakeweixin.util.ScreenUtil;

/**
 * 首页
 * 
 * @author adanac
 * @date 2015-11-13下午4:44:38
 */
public class DrawAppView extends View {

	public DrawAppView(Context context) {
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

		// 画椭圆

		drawMyOval(canvas, paint, width / 2 - 150, height / 2 - 300,
				width / 2 + 150, height / 2 - 150, "媒介素养", 40, Color.BLACK);
		drawLine(canvas, paint, 350, 250, 350, height / 2 - 300); // 媒介素养小短线
		drawLine(canvas, paint, 350, 600, 350, height / 2 - 150); // 媒介素养小短线

		paint.setColor(Color.BLUE);
		drawMyRect(canvas, paint, 200, 250, 140, 70, "媒介新闻", 25, Color.BLACK);
		paint.setColor(Color.RED);
		drawMyRect(canvas, paint, 90, 120, 70, 60, "学术", 20, Color.BLACK);
		paint.setColor(Color.RED);
		drawMyRect(canvas, paint, 170, 120, 70, 60, "科技", 20, Color.BLACK);
		paint.setColor(Color.RED);
		drawMyRect(canvas, paint, 250, 120, 70, 60, "娱乐", 20, Color.BLACK);
		paint.setColor(Color.RED);
		drawMyRect(canvas, paint, 330, 120, 70, 60, "其他", 20, Color.BLACK);

		drawLine(canvas, paint, 200 + 70, 250, 430, 250);// 连接媒介新闻和微课程
		drawLine(canvas, paint, 200 + 70, 600, 430, 600); // 连接学术空间和媒介作品
		drawLine(canvas, paint, 90, 180, 330, 180);// 连接学术和其他
		drawLine(canvas, paint, 90, 150, 90, 180);// 画学术小短线;
		drawLine(canvas, paint, 170, 150, 170, 180);// 画科技小短线;
		drawLine(canvas, paint, 250, 150, 250, 180);// 画娱乐小短线;
		drawLine(canvas, paint, 330, 150, 330, 180);// 画其他小短线;
		drawLine(canvas, paint, 200, 215, 200, 180);// 画新闻媒介小短线;

		paint.setColor(Color.BLUE);
		drawMyRect(canvas, paint, 500, 250, 140, 70, "微课程", 25, Color.BLACK);
		drawMyRect(canvas, paint, 430, 120, 90, 60, "知识类", 20, Color.BLACK);
		drawMyRect(canvas, paint, 530, 120, 90, 60, "能力类", 20, Color.BLACK);
		drawMyRect(canvas, paint, 630, 120, 90, 60, "情感类", 20, Color.BLACK);

		// drawLine(canvas, paint, 500, 150, 500, 215);// 连接能力类和微课程
		drawLine(canvas, paint, 430, 180, 630, 180);// 连接知识类和情感类
		drawLine(canvas, paint, 430, 150, 430, 180);// 画知识类小短线;
		drawLine(canvas, paint, 530, 150, 530, 180);// 画能力小短线;
		drawLine(canvas, paint, 630, 150, 630, 180);// 画情感小短线;
		drawLine(canvas, paint, 500, 215, 500, 180);// 画微课程小短线;

		paint.setColor(Color.BLUE);
		drawMyRect(canvas, paint, 200, 600, 140, 70, "学术空间", 25, Color.BLACK);
		drawMyRect(canvas, paint, 100, 730, 90, 60, "研究学者", 20, Color.BLACK);
		drawMyRect(canvas, paint, 200, 730, 90, 60, "理论文章", 20, Color.BLACK);
		drawMyRect(canvas, paint, 300, 730, 90, 60, "好书分享", 20, Color.BLACK);

		drawLine(canvas, paint, 200, 635, 200, 700); // 连接学术空间和理论文章
		drawLine(canvas, paint, 100, 675, 300, 675);// 连接研究学者和好书分享
		drawLine(canvas, paint, 100, 675, 100, 700);// 2根小短线
		drawLine(canvas, paint, 300, 675, 300, 700);// 2根小短线

		paint.setColor(Color.BLUE);
		drawMyRect(canvas, paint, 500, 600, 140, 70, "媒介作品", 25, Color.BLACK);
		drawMyRect(canvas, paint, 430, 730, 90, 60, "图像", 20, Color.BLACK);
		drawMyRect(canvas, paint, 530, 730, 90, 60, "音频", 20, Color.BLACK);
		drawMyRect(canvas, paint, 630, 730, 90, 60, "视频", 20, Color.BLACK);

		// drawLine(canvas, paint, 500, 635, 500, 700); // 连接媒介作品和音频
		drawLine(canvas, paint, 430, 675, 630, 675);// 连接图像和视频
		drawLine(canvas, paint, 430, 675, 430, 700);// 画图像小短线
		drawLine(canvas, paint, 530, 675, 530, 700);// 画音频小短线
		drawLine(canvas, paint, 630, 675, 630, 700);// 画视频小短线
		drawLine(canvas, paint, 500, 635, 500, 675);// 画媒介作品小短线
	}

	/**
	 * 
	 * @param canvas
	 * @param paint
	 * @param i
	 *            中心x坐标
	 * @param j
	 *            中心y
	 * @param k
	 *            长
	 * @param l
	 *            宽
	 * @param str
	 *            文字
	 */
	private void drawMyRect(Canvas canvas, Paint paint, int i, int j, int k,
			int l, String str, int txtSize, int txtColor) {
		canvas.drawRect(i - k / 2, j - l / 2, i + k / 2, j + l / 2, paint);
		paint.setTextSize(txtSize);
		paint.setColor(txtColor);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText(str, i, j, paint);

	}

	protected void drawMyOval(Canvas canvas, Paint paint, int left, int up,
			int right, int down, String str, int txtSize, int txtColor) {
		paint.setAntiAlias(true); // 设置画笔为无锯齿
		paint.setColor(Color.GREEN); // 设置画笔颜色
		canvas.drawColor(Color.WHITE); // 白色背景
		paint.setStrokeWidth((float) 3.0); // 线宽
		paint.setStyle(Style.STROKE);

		RectF oval = new RectF(); // RectF对象
		oval.left = left; // 左边
		oval.top = up; // 上边
		oval.right = right; // 右边
		oval.bottom = down; // 下边
		canvas.drawOval(oval, paint); // 绘制椭圆

		paint.setTextSize(txtSize);
		paint.setColor(txtColor);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText(str, left + (right - left) / 2, up + (down - up) / 2,
				paint);
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
