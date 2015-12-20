package com.adanac.fakeweixin.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.adanac.fakeweixin.activity.MainContent;
import com.adanac.fakeweixin.activity.sub.EmotionActivity;
import com.adanac.fakeweixin.activity.sub.EnableActivity;
import com.adanac.fakeweixin.activity.sub.KnowActivity;
import com.adanac.fakeweixin.slideview.FourQTMainActivity;
import com.adanac.fakeweixin.slideview.FourSFMainActivity;
import com.adanac.fakeweixin.slideview.FourSYMainActivity;
import com.adanac.fakeweixin.slideview.FourYSMainActivity;
import com.adanac.fakeweixin.slideview.ThreeFxMainActivity;
import com.adanac.fakeweixin.slideview.ThreeWzMainActivity;
import com.adanac.fakeweixin.slideview.ThreeXzMainActivity;
import com.adanac.fakeweixin.util.DrawUtil;
import com.adanac.fakeweixin.util.ScreenUtil;
import com.adanac.fakeweixin.view.sub.TwoSp01MoreTabActivity;
import com.adanac.fakeweixin.view.sub.TwoTw01MoreTabActivity;
import com.adanac.fakeweixin.view.sub.TwoYp01MoreTabActivity;

/**
 * ��ҳView
 * 
 * @author adanac
 * @date 2015-11-27
 * @version 1.0
 */
public class DrawAppView extends View {

	private Context context;
	ScreenUtil sUtil = new ScreenUtil(this);
	private int width = sUtil.getWidth();
	private int height = sUtil.getHeight();

	public DrawAppView(Context context) {
		super(context);
		this.context = context;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// ��������
		Paint paint = new Paint();
		// paint.setColor(Color.RED);// ���ú�ɫ

		// ����Բ
		// DrawUtil.drawMyOval(canvas, paint, width / 2 - 150, height / 2 - 300,
		// width / 2 + 150, height / 2 - 150, R.string.view1_str0, 35,
		// Color.BLACK, Color.YELLOW, Color.BLACK);

		// DrawUtil.drawLine(canvas, paint, 350, 250, 350, height / 2 - 300); //
		// ý������С����
		// DrawUtil.drawLine(canvas, paint, 350, 600, 350, height / 2 - 150); //
		// ý������С����

		DrawUtil.drawRectCenterTxt(canvas, paint, 200, 250, 140, 70, "�߽�ý��",
				Color.rgb(247, 80, 0), Color.WHITE, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, 90, 120, 70, 60, "�鷨",
				Color.GRAY, Color.WHITE, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 170, 120, 70, 60, "��Ӱ",
				Color.GRAY, Color.WHITE, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 250, 120, 70, 60, "Ӱ��",
				Color.GRAY, Color.WHITE, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 330, 120, 70, 60, "�滭",
				Color.GRAY, Color.WHITE, 20);

		DrawUtil.drawLine(canvas, paint, 200 + 70, 250, 430, 250);// ����ý�����ź�΢�γ�
		DrawUtil.drawLine(canvas, paint, 200 + 70, 600, 430, 600); // ����ѧ���ռ��ý����Ʒ
		DrawUtil.drawLine(canvas, paint, 90, 180, 330, 180);// ����ѧ��������
		DrawUtil.drawLine(canvas, paint, 90, 150, 90, 180);// ��ѧ��С����;
		DrawUtil.drawLine(canvas, paint, 170, 150, 170, 180);// ���Ƽ�С����;
		DrawUtil.drawLine(canvas, paint, 250, 150, 250, 180);// ������С����;
		DrawUtil.drawLine(canvas, paint, 330, 150, 330, 180);// ������С����;
		DrawUtil.drawLine(canvas, paint, 200, 215, 200, 180);// ������ý��С����;

		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 250, 140, 70, "���ý��",
				Color.rgb(247, 80, 0), Color.WHITE, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 430, 120, 90, 60, "֪ʶ��",
				Color.GRAY, Color.WHITE, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 120, 90, 60, "������",
				Color.GRAY, Color.WHITE, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 630, 120, 90, 60, "�����",
				Color.GRAY, Color.WHITE, 20);

		// drawLine(canvas, paint, 500, 150, 500, 215);// �����������΢�γ�
		DrawUtil.drawLine(canvas, paint, 430, 180, 630, 180);// ����֪ʶ��������
		DrawUtil.drawLine(canvas, paint, 430, 150, 430, 180);// ��֪ʶ��С����;
		DrawUtil.drawLine(canvas, paint, 530, 150, 530, 180);// ������С����;
		DrawUtil.drawLine(canvas, paint, 630, 150, 630, 180);// �����С����;
		DrawUtil.drawLine(canvas, paint, 530, 215, 530, 180);// ��΢�γ�С����;

		DrawUtil.drawRectCenterTxt(canvas, paint, 200, 600, 140, 70, "�о�ý��",
				Color.rgb(247, 80, 0), Color.WHITE, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 100, 730, 90, 60, "�о�ѧ��",
				Color.GRAY, Color.WHITE, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 200, 730, 90, 60, "��������",
				Color.GRAY, Color.WHITE, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 300, 730, 90, 60, "�������",
				Color.GRAY, Color.WHITE, 20);

		DrawUtil.drawLine(canvas, paint, 200, 635, 200, 700); // ����ѧ���ռ����������
		DrawUtil.drawLine(canvas, paint, 100, 675, 300, 675); // �����о�ѧ�ߺͺ������
		DrawUtil.drawLine(canvas, paint, 100, 675, 100, 700); // 2��С����
		DrawUtil.drawLine(canvas, paint, 300, 675, 300, 700); // 2��С����

		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 600, 140, 70, "ʹ��ý��",
				Color.rgb(247, 80, 0), Color.WHITE, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 430, 730, 90, 60, "ͼ��",
				Color.GRAY, Color.WHITE, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 730, 90, 60, "��Ƶ",
				Color.GRAY, Color.WHITE, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 630, 730, 90, 60, "��Ƶ",
				Color.GRAY, Color.WHITE, 20);

		// drawLine(canvas, paint, 500, 635, 500, 700); // ����ý����Ʒ����Ƶ
		DrawUtil.drawLine(canvas, paint, 430, 675, 630, 675); // ����ͼ�����Ƶ
		DrawUtil.drawLine(canvas, paint, 430, 675, 430, 700); // ��ͼ��С����
		DrawUtil.drawLine(canvas, paint, 530, 675, 530, 700); // ����ƵС����
		DrawUtil.drawLine(canvas, paint, 630, 675, 630, 700); // ����ƵС����
		DrawUtil.drawLine(canvas, paint, 530, 635, 530, 675); // ��ý����ƷС����

		// �ĸ���ͷ
		DrawUtil.drawAL(canvas, paint, 200, 565, 200, 285); // �����о�ý�����߽�ý��
		DrawUtil.drawAL(canvas, paint, 270, 250, 460, 250); // �����߽�ý�������ý��
		DrawUtil.drawAL(canvas, paint, 530, 285, 530, 565); // �������ý����ʹ��ý��
		DrawUtil.drawAL(canvas, paint, 460, 600, 270, 600); // ����ʹ��ý�����о�ý��

	}

	/**
	 * ����¼� onTouchEvent
	 */
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		System.out.println("x:" + x + "y:" + y);

		// ����м�
		// clickMJSY(event, x, y, width / 2 - 100, width / 2 + 100,
		// height / 2 - 300, height / 2 - 100, MainContent.class);

		// ���֪ʶ�ࣨ430, 120, 90, 60��
		clickZSL(event, x, y, 430 - 90 / 2, 430 + 90 / 2, 120 - 60 / 2,
				120 + 60 / 2, KnowActivity.class);

		// ��������ࣨ530, 120, 90, 60��
		clickNLL(event, x, y, 530 - 90 / 2, 530 + 90 / 2, 120 - 60 / 2,
				120 + 60 / 2, EnableActivity.class);

		// �������ࣨ 630, 120, 90, 60��
		clickQGL(event, x, y, 630 - 90 / 2, 630 + 90 / 2, 120 - 60 / 2,
				120 + 60 / 2, EmotionActivity.class);

		// ���ʹ��ý�� - ͼ�ģ�430, 730, 90, 60��
		clickTW(event, x, y, 430 - 90 / 2, 430 + 90 / 2, 730 - 60 / 2,
				730 + 60 / 2, TwoTw01MoreTabActivity.class);
		// ���ʹ��ý�� - ��Ƶ��530, 730, 90, 60��
		clickYP(event, x, y, 530 - 90 / 2, 530 + 90 / 2, 730 - 60 / 2,
				730 + 60 / 2, TwoYp01MoreTabActivity.class);
		// ���ʹ��ý�� - ��Ƶ��630, 730, 90, 60��
		clickSP(event, x, y, 630 - 90 / 2, 630 + 90 / 2, 730 - 60 / 2,
				730 + 60 / 2, TwoSp01MoreTabActivity.class);

		// ����о�ý�� - �о�ѧ�ߣ�100, 730, 90, 60��
		clickXZ(event, x, y, 100 - 90 / 2, 100 + 90 / 2, 730 - 60 / 2,
				730 + 60 / 2, ThreeXzMainActivity.class);
		// ����о�ý�� - ��������
		clickWZ(event, x, y, 200 - 90 / 2, 200 + 90 / 2, 730 - 60 / 2,
				730 + 60 / 2, ThreeWzMainActivity.class);
		// ����о�ý�� - �������
		clickFX(event, x, y, 300 - 90 / 2, 300 + 90 / 2, 730 - 60 / 2,
				730 + 60 / 2, ThreeFxMainActivity.class);

		// ����߽�ý�� - �鷨(90, 120, 70, 60)
		clickSF(event, x, y, 90 - 70 / 2, 90 + 70 / 2, 120 - 60 / 2,
				120 + 60 / 2, FourSFMainActivity.class);
		// ����߽�ý�� - ��Ӱ
		clickSY(event, x, y, 170 - 70 / 2, 170 + 70 / 2, 120 - 60 / 2,
				120 + 60 / 2, FourSYMainActivity.class);
		// ����߽�ý�� - Ӱ��
		clickYS(event, x, y, 250 - 70 / 2, 250 + 70 / 2, 120 - 60 / 2,
				120 + 60 / 2, FourYSMainActivity.class);
		// ����߽�ý�� - ����
		clickQT(event, x, y, 330 - 70 / 2, 330 + 70 / 2, 120 - 60 / 2,
				120 + 60 / 2, FourQTMainActivity.class);
		return true;
	}

	private void clickQT(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<FourQTMainActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "����˻滭");

	}

	private void clickYS(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<FourYSMainActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "�����Ӱ��");

	}

	private void clickSY(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<FourSYMainActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "�������Ӱ");

	}

	private void clickSF(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<FourSFMainActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "������鷨");

	}

	private void clickFX(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<ThreeFxMainActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "����˺������");

	}

	private void clickWZ(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<ThreeWzMainActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "�������������");

	}

	private void clickXZ(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<ThreeXzMainActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "������о�ѧ��");
	}

	private void clickSP(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<TwoSp01MoreTabActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "�������Ƶ");

	}

	private void clickYP(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<TwoYp01MoreTabActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "�������Ƶ");

	}

	private void clickTW(MotionEvent event, float x, float y, int i, int j,
			int k, int l, Class<TwoTw01MoreTabActivity> clazz) {
		clickSubMethod(event, x, y, i, j, k, l, clazz, "�����ͼ��");

	}

	// ��������
	private void clickQGL(MotionEvent event, float x, float y, float x1,
			float x2, float y1, float y2, Class<EmotionActivity> clazz) {
		clickSubMethod(event, x, y, x1, x2, y1, y2, clazz, "����������");
	}

	// ���������
	private void clickNLL(MotionEvent event, float x, float y, float x1,
			float x2, float y1, float y2, Class<EnableActivity> clazz) {
		clickSubMethod(event, x, y, x1, x2, y1, y2, clazz, "�����������");
	}

	// ���֪ʶ��
	private void clickZSL(MotionEvent event, float x, float y, float x1,
			float x2, float y1, float y2, Class<KnowActivity> clazz) {

		clickSubMethod(event, x, y, x1, x2, y1, y2, clazz, "�����֪ʶ��");
	}

	// ����м�
	private void clickMJSY(MotionEvent event, float x, float y, float x1,
			float x2, float y1, float y2, Class<MainContent> clazz) {
		clickSubMethod(event, x, y, x1, x2, y1, y2, clazz, "������м�������");
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
