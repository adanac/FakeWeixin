package com.adanac.fakeweixin.tabmain;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fakeweixin.util.DrawUtil;
import com.adanac.fakeweixin.view.DrawAppView2;
import com.adanac.fragment.LazyFragment;

public class SecondLayerFragment extends LazyFragment {
	public static final String INTENT_STRING_TABNAME = "intent_String_tabName";
	public static final String INTENT_INT_POSITION = "intent_int_position";
	private String tabName;
	private int position;
	private TextView textView;
	private ProgressBar progressBar;
	private View indexView;
	private Context context;
	private Canvas canvas = new Canvas();

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		tabName = getArguments().getString(INTENT_STRING_TABNAME);
		position = getArguments().getInt(INTENT_INT_POSITION);
		setContentView(R.layout.fragment_tabmain_mjsy);
		textView = (TextView) findViewById(R.id.fragment_mainTab_item_textView);
		// textView.setText(tabName + " " + position + " ����������");

		switch (position) {
		case 0:
			textView.setText("������1��ҳ��");
			// indexView = findViewById(R.id.frament_mainTab_item_IndexView);

			indexView.draw(canvas);
			// TabMainActivity activity = new TabMainActivity();
			// indexView = new DrawAppView(activity);
			// toIndex(indexView);
			break;
		case 1:
			// textView.setText("������2��ҳ��");
			// indexView = findViewById(R.id.frament_mainTab_item_IndexView);
			indexView = new DrawAppView2(indexView.getContext());
			break;
		case 2:
			// textView.setText("������");
			break;
		default:
			// textView.setText("�����");
		}

		// progressBar = (ProgressBar)
		// findViewById(R.id.fragment_mainTab_item_progressBar);
		handler.sendEmptyMessageDelayed(1, 3000);
	}

	private void toIndex(View view) {
		startActivity(new Intent(getApplicationContext(), DrawIndex.class));
	}

	private Canvas drawIndexView() {

		// View view = findViewById(R.id.frament_mainTab_item_IndexView);
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
				Color.GRAY, Color.BLACK, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, 90, 120, 70, 60, "�鷨",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 170, 120, 70, 60, "��Ӱ",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 250, 120, 70, 60, "Ӱ��",
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

		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 250, 140, 70, "���ý��",
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
		DrawUtil.drawLine(canvas, paint, 530, 215, 530, 180);// ��΢�γ�С����;

		DrawUtil.drawRectCenterTxt(canvas, paint, 200, 600, 140, 70, "�о�ý��",
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

		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 600, 140, 70, "ʹ��ý��",
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
		DrawUtil.drawLine(canvas, paint, 530, 635, 530, 675);// ��ý����ƷС����

		// �ĸ���ͷ
		DrawUtil.drawAL(canvas, paint, 200, 565, 200, 285);// �����о�ý�����߽�ý��
		DrawUtil.drawAL(canvas, paint, 270, 250, 460, 250);// �����߽�ý�������ý��
		DrawUtil.drawAL(canvas, paint, 530, 285, 530, 565);// �������ý����ʹ��ý��
		DrawUtil.drawAL(canvas, paint, 460, 600, 270, 600);// ����ʹ��ý�����о�ý��
		return canvas;
	}

	@Override
	protected void onDestroyViewLazy() {
		super.onDestroyViewLazy();
		handler.removeMessages(1);
	}

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(android.os.Message msg) {
			textView.setVisibility(View.VISIBLE);
			// progressBar.setVisibility(View.GONE);
			indexView.setVisibility(View.VISIBLE);
		};
	};
}
