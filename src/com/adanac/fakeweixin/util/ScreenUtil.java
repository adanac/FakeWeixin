package com.adanac.fakeweixin.util;

import android.util.DisplayMetrics;
import android.view.View;

/**
 * 屏幕相关类
 * 
 * @author adanac
 * @date 2015-11-13上午12:23:31
 */
public class ScreenUtil {
	private View view;
	private int width;
	private int height;
	private float density;
	private int screenWidth;
	private int screenHeight;
	private DisplayMetrics metric;

	public ScreenUtil(View view) {
		this.view = view;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public int getWidth() {
		return getMetric().widthPixels;
	}

	public int getHeight() {
		return getMetric().heightPixels;
	}

	public float getDensity() {
		return getMetric().density;
	}

	public int getScreenWidth() {
		return (int) (getWidth() * getDensity());
	}

	public int getScreenHeight() {
		return (int) (getHeight() * getDensity());
	}

	public DisplayMetrics getMetric() {
		return this.view.getResources().getDisplayMetrics();
	}

}