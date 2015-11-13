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
 * ��ҳ
 * 
 * @author adanac
 * @date 2015-11-13����4:44:38
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
		// ��������
		Paint paint = new Paint();
		paint.setColor(Color.RED);// ���ú�ɫ

		// ����Բ

		drawMyOval(canvas, paint, width / 2 - 150, height / 2 - 300,
				width / 2 + 150, height / 2 - 150, "ý������", 40, Color.BLACK);
		drawLine(canvas, paint, 350, 250, 350, height / 2 - 300); // ý������С����
		drawLine(canvas, paint, 350, 600, 350, height / 2 - 150); // ý������С����

		paint.setColor(Color.BLUE);
		drawMyRect(canvas, paint, 200, 250, 140, 70, "ý������", 25, Color.BLACK);
		paint.setColor(Color.RED);
		drawMyRect(canvas, paint, 90, 120, 70, 60, "ѧ��", 20, Color.BLACK);
		paint.setColor(Color.RED);
		drawMyRect(canvas, paint, 170, 120, 70, 60, "�Ƽ�", 20, Color.BLACK);
		paint.setColor(Color.RED);
		drawMyRect(canvas, paint, 250, 120, 70, 60, "����", 20, Color.BLACK);
		paint.setColor(Color.RED);
		drawMyRect(canvas, paint, 330, 120, 70, 60, "����", 20, Color.BLACK);

		drawLine(canvas, paint, 200 + 70, 250, 430, 250);// ����ý�����ź�΢�γ�
		drawLine(canvas, paint, 200 + 70, 600, 430, 600); // ����ѧ���ռ��ý����Ʒ
		drawLine(canvas, paint, 90, 180, 330, 180);// ����ѧ��������
		drawLine(canvas, paint, 90, 150, 90, 180);// ��ѧ��С����;
		drawLine(canvas, paint, 170, 150, 170, 180);// ���Ƽ�С����;
		drawLine(canvas, paint, 250, 150, 250, 180);// ������С����;
		drawLine(canvas, paint, 330, 150, 330, 180);// ������С����;
		drawLine(canvas, paint, 200, 215, 200, 180);// ������ý��С����;

		paint.setColor(Color.BLUE);
		drawMyRect(canvas, paint, 500, 250, 140, 70, "΢�γ�", 25, Color.BLACK);
		drawMyRect(canvas, paint, 430, 120, 90, 60, "֪ʶ��", 20, Color.BLACK);
		drawMyRect(canvas, paint, 530, 120, 90, 60, "������", 20, Color.BLACK);
		drawMyRect(canvas, paint, 630, 120, 90, 60, "�����", 20, Color.BLACK);

		// drawLine(canvas, paint, 500, 150, 500, 215);// �����������΢�γ�
		drawLine(canvas, paint, 430, 180, 630, 180);// ����֪ʶ��������
		drawLine(canvas, paint, 430, 150, 430, 180);// ��֪ʶ��С����;
		drawLine(canvas, paint, 530, 150, 530, 180);// ������С����;
		drawLine(canvas, paint, 630, 150, 630, 180);// �����С����;
		drawLine(canvas, paint, 500, 215, 500, 180);// ��΢�γ�С����;

		paint.setColor(Color.BLUE);
		drawMyRect(canvas, paint, 200, 600, 140, 70, "ѧ���ռ�", 25, Color.BLACK);
		drawMyRect(canvas, paint, 100, 730, 90, 60, "�о�ѧ��", 20, Color.BLACK);
		drawMyRect(canvas, paint, 200, 730, 90, 60, "��������", 20, Color.BLACK);
		drawMyRect(canvas, paint, 300, 730, 90, 60, "�������", 20, Color.BLACK);

		drawLine(canvas, paint, 200, 635, 200, 700); // ����ѧ���ռ����������
		drawLine(canvas, paint, 100, 675, 300, 675);// �����о�ѧ�ߺͺ������
		drawLine(canvas, paint, 100, 675, 100, 700);// 2��С����
		drawLine(canvas, paint, 300, 675, 300, 700);// 2��С����

		paint.setColor(Color.BLUE);
		drawMyRect(canvas, paint, 500, 600, 140, 70, "ý����Ʒ", 25, Color.BLACK);
		drawMyRect(canvas, paint, 430, 730, 90, 60, "ͼ��", 20, Color.BLACK);
		drawMyRect(canvas, paint, 530, 730, 90, 60, "��Ƶ", 20, Color.BLACK);
		drawMyRect(canvas, paint, 630, 730, 90, 60, "��Ƶ", 20, Color.BLACK);

		// drawLine(canvas, paint, 500, 635, 500, 700); // ����ý����Ʒ����Ƶ
		drawLine(canvas, paint, 430, 675, 630, 675);// ����ͼ�����Ƶ
		drawLine(canvas, paint, 430, 675, 430, 700);// ��ͼ��С����
		drawLine(canvas, paint, 530, 675, 530, 700);// ����ƵС����
		drawLine(canvas, paint, 630, 675, 630, 700);// ����ƵС����
		drawLine(canvas, paint, 500, 635, 500, 675);// ��ý����ƷС����
	}

	/**
	 * 
	 * @param canvas
	 * @param paint
	 * @param i
	 *            ����x����
	 * @param j
	 *            ����y
	 * @param k
	 *            ��
	 * @param l
	 *            ��
	 * @param str
	 *            ����
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
		paint.setAntiAlias(true); // ���û���Ϊ�޾��
		paint.setColor(Color.GREEN); // ���û�����ɫ
		canvas.drawColor(Color.WHITE); // ��ɫ����
		paint.setStrokeWidth((float) 3.0); // �߿�
		paint.setStyle(Style.STROKE);

		RectF oval = new RectF(); // RectF����
		oval.left = left; // ���
		oval.top = up; // �ϱ�
		oval.right = right; // �ұ�
		oval.bottom = down; // �±�
		canvas.drawOval(oval, paint); // ������Բ

		paint.setTextSize(txtSize);
		paint.setColor(txtColor);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText(str, left + (right - left) / 2, up + (down - up) / 2,
				paint);
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

	private void drawLine(Canvas canvas, Paint paint, int ox1, int oy1,
			int ox2, int oy2) {
		// Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		// paint.setColor(color);
		canvas.drawLine(ox1, oy1, ox2, oy2, paint);
	}

	/**
	 * ����ͷ
	 * 
	 * @param sx
	 * @param sy
	 * @param ex
	 * @param ey
	 */
	public void drawAL(Canvas canvas, Paint paint, int sx, int sy, int ex,
			int ey) {
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

	// ����
	public double[] rotateVec(int px, int py, double ang, boolean isChLen,
			double newLen) {
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

	// �������ֵ�Բ�Ǿ���
	private void drawRt(Canvas canvas, Paint p, int ox, int oy, int a, int b,
			String str, int rectColor, int txtColor, int txtSize) {
		drawRectAndTxt(canvas, p, ox, oy, a, b, str, rectColor, txtColor,
				txtSize);

	}

	// ��ͼƬ��������ͼ
	private void drawPng(Canvas canvas, Paint p, int id) {
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id);
		canvas.drawBitmap(bitmap, 200, 260, p);
	}

	// ��ͼƬ��д��
	private void drawTxt(Canvas canvas, int width, int height, Paint p,
			String str) {
		p.setTextSize(24);
		p.setColor(Color.WHITE);
		p.setTextAlign(Paint.Align.CENTER);
		p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText(str, width / 2, height / 2 - 140, p);
	}

	// ��Բ�Ǿ���
	private void drawRRect(Canvas canvas, Paint p, int left, int right,
			int width, int height) {
		p.setStyle(Paint.Style.FILL);// ����
		p.setColor(Color.GREEN);
		p.setAntiAlias(true);// ���û��ʵľ��Ч��

		RectF oval3 = new RectF(left, right, width, height);// ���ø��µĳ�����
		canvas.drawRoundRect(oval3, 20, 15, p);// �ڶ���������x�뾶��������������y�뾶
	}

	// �������ֵ�Բ�Ǿ���
	private void drawRectAndTxt(Canvas canvas, Paint paint, int ox, int oy,
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

	private void drawTxtPic(Canvas canvas) {

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
}
