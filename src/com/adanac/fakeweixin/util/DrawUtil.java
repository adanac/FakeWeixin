package com.adanac.fakeweixin.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * ��ͼ������
 * 
 * @author adanac
 * @date 2015-11-13����12:23:11
 */
public class DrawUtil extends View {

	public DrawUtil(Context context) {
		super(context);
	}

	/**
	 * ����Բ
	 * 
	 * @param canvas
	 * @param paint
	 * @param left
	 * @param up
	 * @param right
	 * @param down
	 * @param str
	 * @param txtSize
	 * @param txtColor
	 */
	public static void drawMyOval(Canvas canvas, Paint paint, int left, int up,
			int right, int down, String str, int txtSize, int ovalColor,
			int ovalBackGroundColor, int txtColor) {
		paint.setAntiAlias(true); // ���û���Ϊ�޾��
		paint.setColor(ovalColor); // ���û�����ɫ
		canvas.drawColor(ovalBackGroundColor); // ��ɫ����
		paint.setStrokeWidth((float) 3.0); // �߿�
		paint.setStyle(Style.STROKE);

		RectF oval = new RectF(); // RectF����
		oval.left = left; // ���
		oval.top = up; // �ϱ�
		oval.right = right; // �ұ�
		oval.bottom = down; // �±�
		canvas.drawOval(oval, paint); // ������Բ

		// д��
		drawTxtCenter(canvas, paint, str, txtColor, txtSize, left
				+ (right - left) / 2, up + (down - up) / 2);
	}

	/**
	 * �������ֵ�Բ
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
		// 1.��Բ
		paint.setColor(circleColor);
		paint.setAntiAlias(true);// ���û��ʵľ��Ч���� true��ȥ��
		canvas.drawCircle(left, up, radius, paint);

		// 2��д��
		// paint.setTextSize(txtSize);
		// paint.setColor(txtColor);
		// paint.setTextAlign(Paint.Align.CENTER);
		// paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		// canvas.drawText(str, left, up, paint);
		drawTxtCenter(canvas, paint, str, txtColor, txtSize, left, up);
	}

	/**
	 * ����ͷ
	 * 
	 * @param sx
	 * @param sy
	 * @param ex
	 * @param ey
	 */
	public static void drawAL(Canvas canvas, Paint paint, int sx, int sy,
			int ex, int ey) {
		double H = 8; // ��ͷ�߶�
		double L = 3.5; // �ױߵ�һ��
		int x3 = 0;
		int y3 = 0;
		int x4 = 0;
		int y4 = 0;
		double awrad = Math.atan(L / H); // ��ͷ�Ƕ�
		double arraow_len = Math.sqrt(L * L + H * H); // ��ͷ�ĳ���
		double[] arrXY_1 = rotateVec(ex - sx, ey - sy, awrad, true, arraow_len);
		double[] arrXY_2 = rotateVec(ex - sx, ey - sy, -awrad, true, arraow_len);
		double x_3 = ex - arrXY_1[0]; // (x3,y3)�ǵ�һ�˵�
		double y_3 = ey - arrXY_1[1];
		double x_4 = ex - arrXY_2[0]; // (x4,y4)�ǵڶ��˵�
		double y_4 = ey - arrXY_2[1];
		Double X3 = new Double(x_3);
		x3 = X3.intValue();
		Double Y3 = new Double(y_3);
		y3 = Y3.intValue();
		Double X4 = new Double(x_4);
		x4 = X4.intValue();
		Double Y4 = new Double(y_4);
		y4 = Y4.intValue();
		// ����
		canvas.drawLine(sx, sy, ex, ey, paint);
		Path triangle = new Path();
		triangle.moveTo(ex, ey);
		triangle.lineTo(x3, y3);
		triangle.lineTo(x4, y4);
		triangle.close();
		canvas.drawPath(triangle, paint);

	}

	/**
	 * ����ͷ
	 * 
	 * @param sx
	 * @param sy
	 * @param ex
	 * @param ey
	 */
	public static void drawALObject(Canvas canvas, Paint paint, Object o1,
			Object o2) {
		double H = 8; // ��ͷ�߶�
		double L = 3.5; // �ױߵ�һ��
		int x3 = 0;
		int y3 = 0;
		int x4 = 0;
		int y4 = 0;

		double awrad = Math.atan(L / H); // ��ͷ�Ƕ�
		double arraow_len = Math.sqrt(L * L + H * H); // ��ͷ�ĳ���

	}

	/**
	 * ����Ҫ���ӵ���������ļ�ͷ������
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
		// ʸ����ת��������������ֱ���x������y��������ת�ǡ��Ƿ�ı䳤�ȡ��³���
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
	 * ��ֱ��
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
	 * �������ֵ�Բ�Ǿ���
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
	 * ��ͼƬ��д��
	 * 
	 * @param canvas
	 * @param width
	 * @param height
	 * @param p
	 * @param str
	 */
	public static void drawTxt(Canvas canvas, Paint paint, int left, int up,
			String str, int txtSize, int txtColor) {
		paint.setTextSize(txtSize);
		paint.setColor(txtColor);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText(str, left, up, paint);
	}

	/**
	 * ��ͼƬ��������ͼ��getResources()�����Ǵ�view�̳й�����
	 * 
	 * @param canvas
	 * @param p
	 * @param id
	 */
	public void drawPng(Canvas canvas, Paint p, int id) {
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id);
		canvas.drawBitmap(bitmap, 200, 260, p);
	}

	/**
	 * ��ͼƬ��д����
	 * 
	 * @param canvas
	 */
	public void drawTxtPic(Canvas canvas) {

		// 1������һ��drawable����һ�������Bitmap���Դ˴���һ������
		// ����Դ�ļ��½�һ��darwable����
		int id = getResources().getIdentifier(
				"com.adanac.fakeweixin:drawable/icon", null, null);
		Drawable imageDrawable = getResources().getDrawable(id);
		// �½�һ���µ����ͼƬ
		Bitmap output = Bitmap.createBitmap(169, 169, Bitmap.Config.ARGB_8888);
		canvas = new Canvas(output);

		// 2������Բ�Ǿ���
		// �½�һ������
		RectF outerRect = new RectF(0, 0, 169, 169);
		// ����һ����ɫ��Բ�Ǿ��� �����κ���ɫ��ɫ��������͸����
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.RED);
		canvas.drawRoundRect(outerRect, 10, 10, paint);

		// 3���ھ����ϻ�ͼ��
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		imageDrawable.setBounds(0, 0, 169, 169);
		imageDrawable.draw(canvas);

		// 4��д��
		paint.setTextSize(24);
		paint.setColor(Color.WHITE);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText("test", 85, 159, paint);
	}

	/**
	 * ��Բ�Ǿ���
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
		p.setStyle(Paint.Style.FILL);// ����
		p.setColor(Color.GREEN);
		p.setAntiAlias(true);// ���û��ʵľ��Ч��

		RectF oval3 = new RectF(left, right, width, height);// ���ø��µĳ�����
		canvas.drawRoundRect(oval3, 20, 15, p);// �ڶ���������x�뾶��������������y�뾶
	}

	/**
	 * �������ֵľ��Σ�bug:���ֲ��ܾ�����ʾ��
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
		// 1.������
		// ����һ����ɫ��Բ�Ǿ��� �����κ���ɫ��ɫ��������͸����
		RectF outerRect = new RectF(ox - a / 2, oy - b / 2, ox + a / 2, oy + b
				/ 2);
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(rectColor);
		canvas.drawRoundRect(outerRect, 10, 10, paint);

		// 2��д��
		paint.setTextSize(txtSize);
		paint.setColor(txtColor);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText(str, ox, oy, paint);
	}

	/**
	 * �������ֵľ��β�ʹ���־���
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

		Rect targetRect = new Rect(ox - a / 2, oy - b / 2, ox + a / 2, oy + b
				/ 2);
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);

		// ������
		paint.setColor(rectColor);
		canvas.drawRect(targetRect, paint);
		// д��
		drawTxtCenter(canvas, paint, str, txtColor, txtSize, targetRect);
	}

	/**
	 * ��������ʾ����
	 * 
	 * @param canvas
	 * @param paint
	 * @param str
	 * @param txtColor
	 * @param txtSize
	 * @param targetRect
	 */
	private static void drawTxtCenter(Canvas canvas, Paint paint, String str,
			int txtColor, int txtSize, Rect targetRect) {
		// д��
		paint.setColor(txtColor);
		paint.setStrokeWidth(3);
		paint.setTextSize(txtSize);
		FontMetricsInt fontMetrics = paint.getFontMetricsInt();
		// ÿ����Ա��ֵ������baselineΪ��׼����ģ����Ը�ֵ��ʾ��baseline֮��
		int baseline = (targetRect.bottom + targetRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
		// ����������ʵ��ˮƽ���У�drawText��Ӧ��Ϊ����targetRect.centerX()
		paint.setTextAlign(Paint.Align.CENTER);
		canvas.drawText(str, targetRect.centerX(), baseline, paint);
	}

	/**
	 * ��������ʾ����
	 * 
	 * @param canvas
	 * @param paint
	 * @param str
	 * @param txtColor
	 * @param txtSize
	 * @param left
	 * @param baseline
	 *            ����д������߶���
	 */
	private static void drawTxtCenter(Canvas canvas, Paint paint, String str,
			int txtColor, int txtSize, int left, int baseline) {

		// paint.setTextSize(txtSize);
		// paint.setColor(txtColor);
		// paint.setTextAlign(Paint.Align.CENTER);
		// paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		// canvas.drawText(str, ox, oy, paint);

		// д��
		paint.setColor(txtColor);
		paint.setStrokeWidth(3);
		paint.setTextSize(txtSize);
		FontMetricsInt fontMetrics = paint.getFontMetricsInt();
		// ÿ����Ա��ֵ������baselineΪ��׼����ģ����Ը�ֵ��ʾ��baseline֮��
		baseline = (baseline * 2 - fontMetrics.bottom - fontMetrics.top) / 2;
		// ����������ʵ��ˮƽ���У�drawText��Ӧ��Ϊ����targetRect.centerX()
		paint.setTextAlign(Paint.Align.CENTER);
		canvas.drawText(str, left, baseline, paint);
	}

	public static void drawArowLine(Canvas canvas, int ax, int ay, int ra,
			int bx, int by, int rb, Paint paint) {
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

	/**
	 * �������ֵ�Բ�Ǿ���
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
		// 1.������
		// ����һ����ɫ��Բ�Ǿ��� �����κ���ɫ��ɫ��������͸����
		RectF outerRect = new RectF(ox - a / 2, oy - b / 2, ox + a / 2, oy + b
				/ 2);
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(rectColor);
		canvas.drawRoundRect(outerRect, 10, 10, paint);

		// 2��д��
		drawTxtCenter(canvas, paint, str, txtColor, txtSize, ox, oy);
	}

	/**
	 * ������������
	 * 
	 * @param canvas
	 * @param p
	 */
	public static void drawBezierCurve(Canvas canvas, Paint p) {
		canvas.drawText("������������:", 10, 310, p);
		p.reset();
		p.setStyle(Paint.Style.STROKE);
		p.setColor(Color.GREEN);
		Path path2 = new Path();
		path2.moveTo(100, 320);// ����Path�����
		path2.quadTo(150, 310, 170, 400); // ���ñ��������ߵĿ��Ƶ�������յ�����
		canvas.drawPath(path2, p);// ��������������
	}

	/**
	 * ��Ц������
	 * 
	 * @param canvas
	 * @param p
	 */
	public static void drawSmileArc(Canvas canvas, Paint p) {
		p.setStyle(Paint.Style.STROKE);// ���ÿ���
		RectF oval1 = new RectF(150, 20, 180, 40);
		canvas.drawArc(oval1, 180, 180, false, p);// С����
		oval1.set(190, 20, 220, 40);
		canvas.drawArc(oval1, 180, 180, false, p);// С����
		oval1.set(160, 30, 210, 60);
		canvas.drawArc(oval1, 0, 180, false, p);// С����
	}

	/**
	 * �����κ���Բ
	 * 
	 * @param canvas
	 * @param p
	 */
	public static void drawSectorAndEllipse(Canvas canvas, Paint p) {
		canvas.drawText("�����κ���Բ:", 10, 120, p);
		/* ���ý���ɫ ��������ε���ɫ�Ǹı�� */
		Shader mShader = new LinearGradient(0, 0, 100, 100,
				new int[] { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
						Color.LTGRAY }, null, Shader.TileMode.REPEAT); // һ������,�����һ�������ݶ�����һ���ߡ�
		p.setShader(mShader);
		// p.setColor(Color.BLUE);
		RectF oval2 = new RectF(60, 100, 200, 240);// ���ø��µĳ����Σ�ɨ�����
		canvas.drawArc(oval2, 200, 130, true, p);
		// ��������һ��������RectF�������ǵڶ��������ǽǶȵĿ�ʼ�������������Ƕ��ٶȣ����ĸ����������ʱ�����Σ��Ǽٵ�ʱ�򻭻���
		// ����Բ����oval��һ��
		oval2.set(210, 100, 250, 130);
		canvas.drawOval(oval2, p);
	}

	/**
	 * ������Σ�����������
	 * 
	 * @param canvas
	 * @param p
	 */
	public static void drawPolygon(Canvas canvas, Paint p) {
		p.reset();// ����
		p.setColor(Color.LTGRAY);
		p.setStyle(Paint.Style.STROKE);// ���ÿ���
		Path path1 = new Path();
		path1.moveTo(180, 200);
		path1.lineTo(200, 200);
		path1.lineTo(210, 210);
		path1.lineTo(200, 220);
		path1.lineTo(180, 220);
		path1.lineTo(170, 210);
		path1.close();// ���
		canvas.drawPath(path1, p);
	}

	/**
	 * ����
	 * 
	 * @param canvas
	 * @param p
	 */
	public static void drawPoint(Canvas canvas, Paint p) {
		p.setStyle(Paint.Style.FILL);
		canvas.drawText("���㣺", 10, 390, p);
		canvas.drawPoint(60, 390, p);// ��һ����
		canvas.drawPoints(new float[] { 60, 400, 65, 400, 70, 400 }, p);// �������
	}
}
