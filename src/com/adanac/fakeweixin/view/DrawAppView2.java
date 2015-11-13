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
 * ֪ʶ��
 * 
 * @author adanac
 * @date 2015-11-13����4:44:52
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
		// ��������
		Paint paint = new Paint();
		paint.setColor(Color.RED);// ���ú�ɫ

		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2, height / 2 - 200,
				100, "ý������", Color.YELLOW, Color.BLACK, 35);
		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2, height / 2 + 100,
				200, 90, "������ָ���ͼ", Color.GRAY, Color.BLACK, 18);
		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 250,
				height / 2 - 200, 200, 90, "ý���������ں�", Color.GRAY, Color.BLACK,
				18);
		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 250,
				height / 2 - 200, 200, 90, "�Ӿ�����", Color.GRAY, Color.BLACK, 18);
		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2, height / 2 - 400,
				150, 90, "ý���ݱ�", Color.GRAY, Color.BLACK, 18);
		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 250,
				height / 2 - 400, 200, 90, "ý��", Color.GRAY, Color.BLACK, 18);
		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 250,
				height / 2 - 400, 150, 90, "���ŵ��ں�", Color.GRAY, Color.BLACK, 18);
		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 250,
				height / 2 + 100, 150, 90, "���߼�Ĺ�ϵ",
				Color.parseColor("yellow"), Color.BLACK, 18);

		paint.setColor(Color.BLACK);
		// ����ý��������ý���������ں�
		DrawUtil.drawAL(canvas, paint, width / 2 - 100, height / 2 - 200, width
				/ 2 - 250 + 200 / 2, height / 2 - 200);

		// �����Ӿ�������ý������(˫��ͷ)
		DrawUtil.drawAL(canvas, paint, width / 2 + 100, height / 2 - 200, width
				/ 2 + 250 - 200 / 2, height / 2 - 200);
		DrawUtil.drawAL(canvas, paint, width / 2 + 250 - 200 / 2,
				height / 2 - 200, width / 2 + 100, height / 2 - 200);

		// ����ý���ݱ���ý������
		DrawUtil.drawAL(canvas, paint, width / 2, height / 2 - 355, width / 2,
				height / 2 - 300);

		// ����ý��������������ָ�Ĳ��ͼ(ֱ��)
		DrawUtil.drawLine(canvas, paint, width / 2, height / 2 - 100,
				width / 2, height / 2 + 55);

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

	// ��ͼƬ��������ͼ
	private void drawPng(Canvas canvas, Paint p, int id) {
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id);
		canvas.drawBitmap(bitmap, 200, 260, p);
	}
}
