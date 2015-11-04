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
 * ����Բ
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
		// ��������
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);// ������ɫ

		int rectWidth = 160;
		int rectHeight = 80;
		int centerX = width / 2 - rectWidth / 2;
		int centerY = height / 2 - rectHeight - 100;

		drawRt(canvas, paint, 250, 300, 160, 80, "�γ̷���", Color.GREEN,
				Color.RED, 25);

		drawRt(canvas, paint, 200, 200, 120, 60, "����", Color.BLACK,
				Color.YELLOW, 20);
		drawRt(canvas, paint, 400, 200, 120, 60, "��ѧ", Color.BLACK,
				Color.YELLOW, 20);
		// drawRt(canvas, paint, 400, 200, 120, 60, "��ѧ", Color.BLACK,
		// Color.YELLOW, 20);
		// drawRt(canvas, paint, 400, 200, 120, 60, "��ѧ", Color.BLACK,
		// Color.YELLOW, 20);
		// drawRt(canvas, paint, 400, 200, 120, 60, "��ѧ", Color.BLACK,
		// Color.YELLOW, 20);

		// ����ͼƬ
		paint.setColor(Color.BLACK);
		drawLine(canvas, paint, 250, 360, 200, 170);
		drawLine(canvas, paint, 250, 360, 400, 170);
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
