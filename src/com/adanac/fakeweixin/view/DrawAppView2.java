package com.adanac.fakeweixin.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.adanac.fakeweixin.activity.ContentFirstActivity;
import com.adanac.fakeweixin.util.DrawUtil;
import com.adanac.fakeweixin.util.ScreenUtil;

/**
 * ֪ʶ��View
 * 
 * @author adanac
 * @date 2015-11-13
 */
public class DrawAppView2 extends View {

	Context context;
	ScreenUtil sUtil = new ScreenUtil(this);
	private int width = sUtil.getWidth();
	private int height = sUtil.getHeight();

	public DrawAppView2(Context context) {
		super(context);
		this.context = context;
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// ��������
		Paint paint = new Paint();
		paint.setColor(Color.RED);// ���ú�ɫ

		DrawUtil.drawCircleAndTxt(canvas, paint, width / 2 - 40,
				height / 2 - 250, 90, "ý������", Color.rgb(255, 100, 0),
				Color.BLACK, 30);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 40,
				height / 2 + 50, 200, 90, "������ָ���ͼ", Color.GRAY, Color.BLACK,
				25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 250,
				height / 2 - 250, 150, 90, "ý�������ں�", Color.GRAY, Color.BLACK,
				25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 250,
				height / 2 - 250, 150, 90, "�Ӿ�����", Color.GRAY, Color.BLACK, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 40,
				height / 2 - 500, 120, 70, "ý���ݱ�", Color.GRAY, Color.BLACK, 20);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 250,
				height / 2 - 500, 100, 70, "ý��", Color.GRAY, Color.BLACK, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 110,
				height / 2 - 370, 120, 70, "���ŵ��ں�", Color.parseColor("yellow"),
				Color.BLACK, 20);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 110,
				height / 2 - 100, 150, 70, "���߼�Ĺ�ϵ",
				Color.parseColor("yellow"), Color.BLACK, 20);

		paint.setColor(Color.BLACK);

		// ����ý����ý���ݱ䣨width / 2 - 250,height / 2 - 500, 100, 70��
		// ��width / 2 - 40, height / 2 - 500, 120, 70��
		DrawUtil.drawAL(canvas, paint, width / 2 - 250 + 100 / 2,
				height / 2 - 500, width / 2 - 40 - 120 / 2, height / 2 - 500);

		// ����˫��ͷ����߼�Ĺ�ϵ
		DrawUtil.drawAL(canvas, paint, width / 2 + 110, height / 2 - 250,
				width / 2 + 110, height / 2 - 100 - 70 / 2);

		// ���ӷ��ŵ��ں���˫��ͷ(width / 2 + 110,height / 2 - 370, 120, 70)
		DrawUtil.drawAL(canvas, paint, width / 2 + 110, height / 2 - 370 + 70
				/ 2, width / 2 + 110, height / 2 - 250);

		// ����ý��������ý�������ں�
		DrawUtil.drawAL(canvas, paint, width / 2 - 40 - 90, height / 2 - 250,
				width / 2 - 250 + 150 / 2, height / 2 - 250);

		// �����Ӿ�������ý������(˫��ͷ)
		DrawUtil.drawAL(canvas, paint, width / 2 + 50, height / 2 - 250, width
				/ 2 + 250 - 150 / 2, height / 2 - 250);
		DrawUtil.drawAL(canvas, paint, width / 2 + 250 - 150 / 2,
				height / 2 - 250, width / 2 + 50, height / 2 - 250);

		// ����ý���ݱ���ý������
		DrawUtil.drawAL(canvas, paint, width / 2 - 40, height / 2 - 500 + 70
				/ 2, width / 2 - 40, height / 2 - 250 - 90);

		// ����ý��������������ָ�Ĳ��ͼ(ֱ��)��width / 2 - 40,height / 2 - 250, 90����width / 2 -
		// 40,height / 2 + 50, 200, 90��
		DrawUtil.drawLine(canvas, paint, width / 2 - 40, height / 2 - 250 + 90,
				width / 2 - 40, height / 2 + 5);

	}

	public void OnClick(MotionEvent event) {
		int action = event.getAction();
		if (action != MotionEvent.ACTION_DOWN) {
			return;
		}
		int x = (int) event.getX();
		int y = (int) event.getY();
		// Toast.makeText(MainContent.class, "��ӭ����APP",
		// Toast.LENGTH_SHORT).show();

	}

	/**
	 * ����¼�
	 */
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		System.out.println("x:" + x + "y:" + y);
		// ���ý������
		if (x > width / 2 - 100 && x < width / 2 + 100 && y > height / 2 - 300
				&& y < height / 2 - 100) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				System.out.println("����˴�����");
				Intent intent = new Intent();
				intent.setClass(context, ContentFirstActivity.class);
				context.startActivity(intent);
				break;

			case MotionEvent.ACTION_UP:
				System.out.println("�뿪�˴�����");
				break;
			}
		}
		return true;
	}
}
