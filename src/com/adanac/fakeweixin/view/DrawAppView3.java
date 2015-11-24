package com.adanac.fakeweixin.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.adanac.fakeweixin.util.DrawUtil;
import com.adanac.fakeweixin.util.ScreenUtil;

/**
 * ������View
 * 
 * @author adanac
 * 
 */
public class DrawAppView3 extends View {

	ScreenUtil sUtil = new ScreenUtil(this);
	private int width = sUtil.getWidth();
	private int height = sUtil.getHeight();

	public DrawAppView3(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// ��������
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);// ������ɫ

		int rectWidth = 160;
		int rectHeight = 80;
		int centerX = width / 2 - rectWidth / 2;
		int centerY = height / 2 - rectHeight - 100;

		DrawUtil.drawRt(canvas, paint, 250, 200, 160, 80, "ý������",
				Color.rgb(255, 100, 0), Color.BLACK, 25);

		DrawUtil.drawRt(canvas, paint, 100, 400, 120, 60, "��������", Color.BLACK,
				Color.YELLOW, 20);
		DrawUtil.drawRt(canvas, paint, 250, 400, 120, 60, "ý����", Color.BLACK,
				Color.YELLOW, 20);
		DrawUtil.drawRt(canvas, paint, 400, 400, 120, 60, "ý����Դ����",
				Color.BLACK, Color.YELLOW, 20);

		// �ڶ���
		DrawUtil.drawRt(canvas, paint, 250, 600, 120, 60, "��Դ��ѡ��", Color.BLACK,
				Color.YELLOW, 20);
		DrawUtil.drawRt(canvas, paint, 400, 600, 120, 60, "��Դ��ת��", Color.BLACK,
				Color.YELLOW, 20);
		DrawUtil.drawRt(canvas, paint, 550, 600, 120, 60, "��Դ������", Color.BLACK,
				Color.YELLOW, 20);

		paint.setColor(Color.BLACK);

		// ���ӵ�һ��
		// ����ý��������ý����(250, 200, 160, 80)(250, 400, 120, 60)
		DrawUtil.drawAL(canvas, paint, 250, 200 + 80 / 2, 250, 400 - 60 / 2);
		// ��������������ý����Դ������ֱ�ߣ���100, 400, 120, 60����100, 400, 120, 60��
		DrawUtil.drawLine(canvas, paint, 100, 300, 400, 300);
		// ��������С��ͷ��100, 400, 120, 60��
		DrawUtil.drawAL(canvas, paint, 100, 300, 100, 400 - 60 / 2);
		// ý����Դ����С��ͷ��400, 400, 120, 60��
		DrawUtil.drawAL(canvas, paint, 400, 300, 400, 400 - 60 / 2);

		// ���ӵڶ���
		// ������Դ��������Դת��
		DrawUtil.drawAL(canvas, paint, 400, 400 + 60 / 2, 400, 600 - 60 / 2);
		// ������Դѡ������Դ���ã�ֱ�� ��
		DrawUtil.drawLine(canvas, paint, 250, 500, 550, 500);
		// ��Դѡ��С��ͷ
		DrawUtil.drawAL(canvas, paint, 250, 500, 250, 600 - 60 / 2);
		// ��Դ����С��ͷ
		DrawUtil.drawAL(canvas, paint, 550, 500, 550, 600 - 60 / 2);
	}

}
