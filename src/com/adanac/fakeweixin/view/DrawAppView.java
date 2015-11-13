package com.adanac.fakeweixin.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.adanac.fakeweixin.util.DrawUtil;
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
		// paint.setColor(Color.RED);// ���ú�ɫ

		// ����Բ
		DrawUtil.drawMyOval(canvas, paint, width / 2 - 150, height / 2 - 300,
				width / 2 + 150, height / 2 - 150, "ý������", 40, Color.BLACK,
				Color.YELLOW, Color.BLACK);
		DrawUtil.drawLine(canvas, paint, 350, 250, 350, height / 2 - 300); // ý������С����
		DrawUtil.drawLine(canvas, paint, 350, 600, 350, height / 2 - 150); // ý������С����

		DrawUtil.drawRectCenterTxt(canvas, paint, 200, 250, 140, 70, "ý������",
				Color.GRAY, Color.BLACK, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, 90, 120, 70, 60, "ѧ��",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 170, 120, 70, 60, "�Ƽ�",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 250, 120, 70, 60, "����",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 330, 120, 70, 60, "����",
				Color.GRAY, Color.BLACK, 20);

		DrawUtil.drawLine(canvas, paint, 200 + 70, 250, 430, 250);// ����ý�����ź�΢�γ�
		DrawUtil.drawLine(canvas, paint, 200 + 70, 600, 430, 600); // ����ѧ���ռ��ý����Ʒ
		DrawUtil.drawLine(canvas, paint, 90, 180, 330, 180);// ����ѧ��������
		DrawUtil.drawLine(canvas, paint, 90, 150, 90, 180);// ��ѧ��С����;
		DrawUtil.drawLine(canvas, paint, 170, 150, 170, 180);// ���Ƽ�С����;
		DrawUtil.drawLine(canvas, paint, 250, 150, 250, 180);// ������С����;
		DrawUtil.drawLine(canvas, paint, 330, 150, 330, 180);// ������С����;
		DrawUtil.drawLine(canvas, paint, 200, 215, 200, 180);// ������ý��С����;

		DrawUtil.drawRectCenterTxt(canvas, paint, 500, 250, 140, 70, "΢�γ�",
				Color.GRAY, Color.BLACK, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 430, 120, 90, 60, "֪ʶ��",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 120, 90, 60, "������",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 630, 120, 90, 60, "�����",
				Color.GRAY, Color.BLACK, 20);

		// drawLine(canvas, paint, 500, 150, 500, 215);// �����������΢�γ�
		DrawUtil.drawLine(canvas, paint, 430, 180, 630, 180);// ����֪ʶ��������
		DrawUtil.drawLine(canvas, paint, 430, 150, 430, 180);// ��֪ʶ��С����;
		DrawUtil.drawLine(canvas, paint, 530, 150, 530, 180);// ������С����;
		DrawUtil.drawLine(canvas, paint, 630, 150, 630, 180);// �����С����;
		DrawUtil.drawLine(canvas, paint, 500, 215, 500, 180);// ��΢�γ�С����;

		DrawUtil.drawRectCenterTxt(canvas, paint, 200, 600, 140, 70, "ѧ���ռ�",
				Color.GRAY, Color.BLACK, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 100, 730, 90, 60, "�о�ѧ��",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 200, 730, 90, 60, "��������",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 300, 730, 90, 60, "�������",
				Color.GRAY, Color.BLACK, 20);

		DrawUtil.drawLine(canvas, paint, 200, 635, 200, 700); // ����ѧ���ռ����������
		DrawUtil.drawLine(canvas, paint, 100, 675, 300, 675);// �����о�ѧ�ߺͺ������
		DrawUtil.drawLine(canvas, paint, 100, 675, 100, 700);// 2��С����
		DrawUtil.drawLine(canvas, paint, 300, 675, 300, 700);// 2��С����

		DrawUtil.drawRectCenterTxt(canvas, paint, 500, 600, 140, 70, "ý����Ʒ",
				Color.GRAY, Color.BLACK, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 430, 730, 90, 60, "ͼ��",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 730, 90, 60, "��Ƶ",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 630, 730, 90, 60, "��Ƶ",
				Color.GRAY, Color.BLACK, 20);

		// drawLine(canvas, paint, 500, 635, 500, 700); // ����ý����Ʒ����Ƶ
		DrawUtil.drawLine(canvas, paint, 430, 675, 630, 675);// ����ͼ�����Ƶ
		DrawUtil.drawLine(canvas, paint, 430, 675, 430, 700);// ��ͼ��С����
		DrawUtil.drawLine(canvas, paint, 530, 675, 530, 700);// ����ƵС����
		DrawUtil.drawLine(canvas, paint, 630, 675, 630, 700);// ����ƵС����
		DrawUtil.drawLine(canvas, paint, 500, 635, 500, 675);// ��ý����ƷС����
	}
}
