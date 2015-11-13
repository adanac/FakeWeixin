package com.adanac.fakeweixin.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.adanac.fakeweixin.util.DrawUtil;
import com.adanac.fakeweixin.util.ScreenUtil;

/**
 * 首页
 * 
 * @author adanac
 * @date 2015-11-13下午4:44:38
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
		// 创建画笔
		Paint paint = new Paint();
		// paint.setColor(Color.RED);// 设置红色

		// 画椭圆
		DrawUtil.drawMyOval(canvas, paint, width / 2 - 150, height / 2 - 300,
				width / 2 + 150, height / 2 - 150, "媒介素养", 40, Color.BLACK,
				Color.YELLOW, Color.BLACK);
		DrawUtil.drawLine(canvas, paint, 350, 250, 350, height / 2 - 300); // 媒介素养小短线
		DrawUtil.drawLine(canvas, paint, 350, 600, 350, height / 2 - 150); // 媒介素养小短线

		DrawUtil.drawRectCenterTxt(canvas, paint, 200, 250, 140, 70, "媒介新闻",
				Color.GRAY, Color.BLACK, 25);

		DrawUtil.drawRectCenterTxt(canvas, paint, 90, 120, 70, 60, "学术",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 170, 120, 70, 60, "科技",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 250, 120, 70, 60, "娱乐",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 330, 120, 70, 60, "其他",
				Color.GRAY, Color.BLACK, 20);

		DrawUtil.drawLine(canvas, paint, 200 + 70, 250, 430, 250);// 连接媒介新闻和微课程
		DrawUtil.drawLine(canvas, paint, 200 + 70, 600, 430, 600); // 连接学术空间和媒介作品
		DrawUtil.drawLine(canvas, paint, 90, 180, 330, 180);// 连接学术和其他
		DrawUtil.drawLine(canvas, paint, 90, 150, 90, 180);// 画学术小短线;
		DrawUtil.drawLine(canvas, paint, 170, 150, 170, 180);// 画科技小短线;
		DrawUtil.drawLine(canvas, paint, 250, 150, 250, 180);// 画娱乐小短线;
		DrawUtil.drawLine(canvas, paint, 330, 150, 330, 180);// 画其他小短线;
		DrawUtil.drawLine(canvas, paint, 200, 215, 200, 180);// 画新闻媒介小短线;

		DrawUtil.drawRectCenterTxt(canvas, paint, 500, 250, 140, 70, "微课程",
				Color.GRAY, Color.BLACK, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 430, 120, 90, 60, "知识类",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 120, 90, 60, "能力类",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 630, 120, 90, 60, "情感类",
				Color.GRAY, Color.BLACK, 20);

		// drawLine(canvas, paint, 500, 150, 500, 215);// 连接能力类和微课程
		DrawUtil.drawLine(canvas, paint, 430, 180, 630, 180);// 连接知识类和情感类
		DrawUtil.drawLine(canvas, paint, 430, 150, 430, 180);// 画知识类小短线;
		DrawUtil.drawLine(canvas, paint, 530, 150, 530, 180);// 画能力小短线;
		DrawUtil.drawLine(canvas, paint, 630, 150, 630, 180);// 画情感小短线;
		DrawUtil.drawLine(canvas, paint, 500, 215, 500, 180);// 画微课程小短线;

		DrawUtil.drawRectCenterTxt(canvas, paint, 200, 600, 140, 70, "学术空间",
				Color.GRAY, Color.BLACK, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 100, 730, 90, 60, "研究学者",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 200, 730, 90, 60, "理论文章",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 300, 730, 90, 60, "好书分享",
				Color.GRAY, Color.BLACK, 20);

		DrawUtil.drawLine(canvas, paint, 200, 635, 200, 700); // 连接学术空间和理论文章
		DrawUtil.drawLine(canvas, paint, 100, 675, 300, 675);// 连接研究学者和好书分享
		DrawUtil.drawLine(canvas, paint, 100, 675, 100, 700);// 2根小短线
		DrawUtil.drawLine(canvas, paint, 300, 675, 300, 700);// 2根小短线

		DrawUtil.drawRectCenterTxt(canvas, paint, 500, 600, 140, 70, "媒介作品",
				Color.GRAY, Color.BLACK, 25);
		DrawUtil.drawRectCenterTxt(canvas, paint, 430, 730, 90, 60, "图像",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 530, 730, 90, 60, "音频",
				Color.GRAY, Color.BLACK, 20);
		DrawUtil.drawRectCenterTxt(canvas, paint, 630, 730, 90, 60, "视频",
				Color.GRAY, Color.BLACK, 20);

		// drawLine(canvas, paint, 500, 635, 500, 700); // 连接媒介作品和音频
		DrawUtil.drawLine(canvas, paint, 430, 675, 630, 675);// 连接图像和视频
		DrawUtil.drawLine(canvas, paint, 430, 675, 430, 700);// 画图像小短线
		DrawUtil.drawLine(canvas, paint, 530, 675, 530, 700);// 画音频小短线
		DrawUtil.drawLine(canvas, paint, 630, 675, 630, 700);// 画视频小短线
		DrawUtil.drawLine(canvas, paint, 500, 635, 500, 675);// 画媒介作品小短线
	}
}
