package com.adanac.fakeweixin.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * ImageAdapter
 * 
 * @author adanac
 * @date 2015-11-27
 * @version 1.0
 */
public class ImageAdapter extends PagerAdapter {
	private List<View> list;

	public ImageAdapter(List<View> list) {// 利用构造器接收list集合参数
		this.list = list;
	}

	@Override
	public int getCount() {// 返回页卡数量
		if (list.size() != 0) {
			return list.size();
		}
		return 0;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {// 判断是否为view对象
		return arg0 == arg1;// 官方demo给出的建议写法
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {// 实例化一个页卡，view对象存放在ViewGroup里
		container.addView(list.get(position));
		return list.get(position);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {// 销毁一个页卡
		container.removeView(list.get(position));
	}

}