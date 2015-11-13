package com.adanac.fakeweixin.util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;

/**
 * ��ͼ������
 * 
 * @author adanac
 * @date 2015-11-13����12:23:11
 */
public class DrawUtil {

	/**
	 * �������ֵ�Բ
	 */
	public static void drawCircleAndTxt(Canvas canvas, Paint paint, int left,
			int up, int radius, String str, int circleColor, int txtColor,
			int txtSize) {
		// 1.��Բ
		paint.setColor(circleColor);
		paint.setAntiAlias(true);// ���û��ʵľ��Ч���� true��ȥ��
		canvas.drawCircle(left, up, radius, paint);

		// 2��д��
		paint.setTextSize(txtSize);
		paint.setColor(txtColor);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText(str, left, up, paint);

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
		// double[] arrXY_1 = rotateVec(ex - sx, ey - sy, awrad, true,
		// arraow_len);
		// double[] arrXY_2 = rotateVec(ex - sx, ey - sy, -awrad, true,
		// arraow_len);
		// double x_3 = ex - arrXY_1[0]; // (x3,y3)�ǵ�һ�˵�
		// double y_3 = ey - arrXY_1[1];
		// double x_4 = ex - arrXY_2[0]; // (x4,y4)�ǵڶ��˵�
		// double y_4 = ey - arrXY_2[1];
		// Double X3 = new Double(x_3);
		// x3 = X3.intValue();
		// Double Y3 = new Double(y_3);
		// y3 = Y3.intValue();
		// Double X4 = new Double(x_4);
		// x4 = X4.intValue();
		// Double Y4 = new Double(y_4);
		// y4 = Y4.intValue();
		// ����
		// canvas.drawLine(sx, sy, ex, ey, paint);
		// Path triangle = new Path();
		// triangle.moveTo(ex, ey);
		// triangle.lineTo(x3, y3);
		// triangle.lineTo(x4, y4);
		// triangle.close();
		// canvas.drawPath(triangle, paint);

	}

	// ����Ҫ���ӵ���������ļ�ͷ������
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
	 * @param ox1
	 *            ��ʼ���x��λ��
	 * @param oy1
	 *            ��ʼ���y��λ��
	 * @param ox2
	 *            �յ��x��ˮƽλ��
	 * @param oy2
	 *            �յ�y�ᴹֱλ��
	 * @param color
	 *            �ߵ���ɫ
	 */

	public static void drawLine(Canvas canvas, Paint paint, int ox1, int oy1,
			int ox2, int oy2) {
		// Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		// paint.setColor(color);
		canvas.drawLine(ox1, oy1, ox2, oy2, paint);
	}

	// �������ֵ�Բ�Ǿ���
	public static void drawRt(Canvas canvas, Paint p, int ox, int oy, int a,
			int b, String str, int rectColor, int txtColor, int txtSize) {
		drawRectAndTxt(canvas, p, ox, oy, a, b, str, rectColor, txtColor,
				txtSize);
	}

	// ��ͼƬ��д��
	public static void drawTxt(Canvas canvas, int width, int height, Paint p,
			String str) {
		p.setTextSize(24);
		p.setColor(Color.WHITE);
		p.setTextAlign(Paint.Align.CENTER);
		p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText(str, width / 2, height / 2 - 140, p);
	}

	// ��Բ�Ǿ���
	public static void drawRRect(Canvas canvas, Paint p, int left, int right,
			int width, int height) {
		p.setStyle(Paint.Style.FILL);// ����
		p.setColor(Color.GREEN);
		p.setAntiAlias(true);// ���û��ʵľ��Ч��

		RectF oval3 = new RectF(left, right, width, height);// ���ø��µĳ�����
		canvas.drawRoundRect(oval3, 20, 15, p);// �ڶ���������x�뾶��������������y�뾶
	}

	// �������ֵľ���
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

	// �������ֵ�Բ�Ǿ���
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
		paint.setTextSize(txtSize);
		paint.setColor(txtColor);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText(str, ox, oy, paint);
	}

}
