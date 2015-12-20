package com.adanac.fakeweixin.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.adanac.fakeweixin.activity.moretab.MoreTabEZGXActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabFHNHActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabMJSYActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabSJSYActivity;
import com.adanac.fakeweixin.activity.moretab.MoreTabYYCCActivity;
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
				height / 2 - 250, 90, "ý������", Color.rgb(247, 80, 0),
				Color.WHITE, 30);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 40,
				height / 2 + 50, 200, 90, "������ָ���ͼ", Color.GRAY, Color.WHITE,
				25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 250,
				height / 2 - 250, 150, 90, "ý�������ں�", Color.GRAY, Color.WHITE,
				25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 250,
				height / 2 - 250, 150, 90, "�Ӿ�����", Color.GRAY, Color.WHITE, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 40,
				height / 2 - 500, 120, 70, "ý���ݱ�", Color.GRAY, Color.WHITE, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 - 250,
				height / 2 - 500, 100, 70, "ý��", Color.GRAY, Color.WHITE, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 110,
				height / 2 - 370, 120, 70, "���ŵ��ں�", Color.parseColor("gray"),
				Color.WHITE, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, width / 2 + 110,
				height / 2 - 100, 150, 70, "���߼�Ĺ�ϵ", Color.parseColor("gray"),
				Color.WHITE, 25);

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

	/**
	 * ����¼� onTouchEvent
	 */
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		System.out.println("x:" + x + "y:" + y);

		// ���ý�������ں���width / 2 - 250,height / 2 - 250, 150, 90��
		clickMJSYNH(event, x, y, width / 2 - 250 - 150 / 2, width / 2 - 250
				+ 150 / 2, height / 2 - 250 - 90 / 2,
				height / 2 - 250 + 90 / 2, MoreTabMJSYActivity.class);
		// ����Ӿ�������width / 2 + 250,height / 2 - 250, 150, 90��
		clickSJSY(event, x, y, width / 2 + 250 - 150 / 2, width / 2 + 250 + 150
				/ 2, height / 2 - 250 - 90 / 2, height / 2 - 250 + 90 / 2,
				MoreTabSJSYActivity.class);
		// ���������ָ���ͼ��width / 2 - 40,height / 2 + 50, 200, 90��
		clickYYCC(event, x, y, width / 2 - 40 - 200 / 2, width / 2 - 40 + 200
				/ 2, height / 2 + 50 - 90 / 2, height / 2 + 50 + 90 / 2,
				MoreTabYYCCActivity.class);
		// ������߼�Ĺ�ϵ ��width / 2 + 110,height / 2 - 100, 150, 70��
		clickEZGX(event, x, y, width / 2 + 110 - 150 / 2, width / 2 + 110 + 150
				/ 2, height / 2 - 100 - 70 / 2, height / 2 - 50 + 70 / 2,
				MoreTabEZGXActivity.class);
		// ������ŵ��ں���width / 2 + 110,height / 2 - 370, 120, 70��
		clickFHNH(event, x, y, width / 2 + 110 - 120 / 2, width / 2 + 110 + 120
				/ 2, height / 2 - 370 - 70 / 2, height / 2 - 370 + 70 / 2,
				MoreTabFHNHActivity.class);
		return true;
	}

	private void clickFHNH(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<MoreTabFHNHActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "����˷��ŵ��ں�");
	}

	private void clickEZGX(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<MoreTabEZGXActivity> clazz) {

		clickSubMethod(event, x, y, i, j, k, l, clazz, "����˶��߹�ϵ");
	}

	// ���������ָ���ͼ
	private void clickYYCC(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<MoreTabYYCCActivity> clazz) {

		clickSubMethod(event, x, y, i, j, k, l, clazz, "�����������ָ���ͼ");
	}

	// ����Ӿ�����
	private void clickSJSY(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<MoreTabSJSYActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "������Ӿ�����");
	}

	// ���ý�������ں�
	private void clickMJSYNH(MotionEvent event, float x, float y, float x1,
			float x2, float y1, float y2, Class<MoreTabMJSYActivity> clazz) {
		clickSubMethod(event, x, y, x1, x2, y1, y2, clazz, "�����ý�������ں�");
	}

	private void clickSubMethod(MotionEvent event, float x, float y, float x1,
			float x2, float y1, float y2, Class<?> clazz, String str) {
		if (x > x1 && x < x2 && y > y1 && y < y2) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				System.out.println(str);
				Intent intent = new Intent();
				intent.setClass(context, clazz);
				context.startActivity(intent);
				break;
			}
		}
	}
}
