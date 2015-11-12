package com.adanac.fakeweixin.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

public class DrawUtil {

	/**
	 * 画带文字的圆
	 */
	public static void drawCircleAndTxt(Canvas canvas, Paint paint, int left,
			int up, int radius, String str, int circleColor, int txtColor,
			int txtSize) {
		// 1.画圆
		paint.setColor(circleColor);
		paint.setAntiAlias(true);// 设置画笔的锯齿效果。 true是去除
		canvas.drawCircle(left, up, radius, paint);

		// 2、写字
		paint.setTextSize(txtSize);
		paint.setColor(txtColor);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawText(str, left, up, paint);

	}

}
