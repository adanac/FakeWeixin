package com.adanac.fakeweixin.activity.sub;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fakeweixin.adapter.ContentAdapter;
import com.adanac.fakeweixin.view.DrawAppView;
import com.adanac.fakeweixin.view.DrawAppView2;
import com.adanac.fakeweixin.view.DrawAppView3;
import com.adanac.fakeweixin.view.DrawAppView4;

/**
 * 知识类Activity
 * 
 * @author adanac
 * @date 2015-11-24
 * @version 1.0
 */
public class KnowActivity extends Activity implements OnClickListener,
		OnPageChangeListener {
	private Context mContext;
	// 底部菜单4个Linearlayout
	private LinearLayout ll_home;
	private LinearLayout ll_address;
	private LinearLayout ll_friend;
	private LinearLayout ll_setting;

	// 底部菜单4个ImageView
	private ImageView iv_home;
	private ImageView iv_address;
	private ImageView iv_friend;
	private ImageView iv_setting;

	// 顶部标题
	private TextView know_top;

	// 底部菜单4个菜单标题
	private TextView tv_home;
	private TextView tv_address;
	private TextView tv_friend;
	private TextView tv_setting;

	// 中间内容区域
	private ViewPager viewPager;

	// ViewPager适配器ContentAdapter
	private ContentAdapter adapter;

	private List<View> views;

	private static final String TAG = "Rabbit";

	// private Button mbButton;
	// private ImageView imageView;
	private LinearLayout linearLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.know_content);

		// 初始化控件
		initView();
		// 初始化底部按钮事件
		initEvent();
		// 打印日志
		Log.i(TAG, "1----------onCreate");

	}

	private void initView() {

		// 底部菜单4个Linearlayout
		this.ll_home = (LinearLayout) findViewById(R.id.ll_home);
		this.ll_address = (LinearLayout) findViewById(R.id.ll_address);
		this.ll_friend = (LinearLayout) findViewById(R.id.ll_friend);
		this.ll_setting = (LinearLayout) findViewById(R.id.ll_setting);

		// 底部菜单4个ImageView
		this.iv_home = (ImageView) findViewById(R.id.iv_home);
		this.iv_address = (ImageView) findViewById(R.id.iv_address);
		this.iv_friend = (ImageView) findViewById(R.id.iv_friend);
		this.iv_setting = (ImageView) findViewById(R.id.iv_setting);

		// 顶部标题
		this.know_top = (TextView) findViewById(R.id.know_top);

		// 底部菜单4个菜单标题
		this.tv_home = (TextView) findViewById(R.id.tv_home);
		this.tv_address = (TextView) findViewById(R.id.tv_address);
		this.tv_friend = (TextView) findViewById(R.id.tv_friend);
		this.tv_setting = (TextView) findViewById(R.id.tv_setting);

		// 中间内容区域ViewPager
		this.viewPager = (ViewPager) findViewById(R.id.vp_content);

		// 适配器
		View page_01 = View.inflate(KnowActivity.this, R.layout.page_01, null);
		View page_02 = View.inflate(KnowActivity.this, R.layout.page_02, null);
		View page_03 = View.inflate(KnowActivity.this, R.layout.page_03, null);
		View page_04 = View.inflate(KnowActivity.this, R.layout.page_04, null);

		// 在第1个页面画图形
		final DrawAppView view_one = new DrawAppView(this);
		view_one.setMinimumHeight(600);
		view_one.setMinimumWidth(800);
		// 通知view组件重绘
		view_one.invalidate();
		((ViewGroup) page_01).addView(view_one);

		// 在第2个页面画图形（知识类）
		final DrawAppView2 view_two = new DrawAppView2(this);
		view_two.setMinimumHeight(600);
		view_two.setMinimumWidth(800);
		// 通知view组件重绘
		view_two.invalidate();
		((ViewGroup) page_02).addView(view_two);

		// 在第3个页面画图形（能力类）
		final DrawAppView3 view_three = new DrawAppView3(this);
		view_two.setMinimumHeight(600);
		view_two.setMinimumWidth(800);
		// 通知view组件重绘
		view_two.invalidate();
		((ViewGroup) page_03).addView(view_three);

		// 在第4个页面画图形（情感类）
		final DrawAppView4 view_four = new DrawAppView4(this);
		view_four.setMinimumHeight(600);
		view_four.setMinimumWidth(800);
		// 通知view组件重绘
		view_four.invalidate();
		((ViewGroup) page_04).addView(view_four);

		views = new ArrayList<View>();
		views.add(page_02);// 知识类
		views.add(page_01);// 首页
		views.add(page_03);// 能力类
		views.add(page_04);// 情感类

		this.adapter = new ContentAdapter(views);
		viewPager.setAdapter(adapter);

	}

	private void initEvent() {
		// 设置按钮监听
		ll_home.setOnClickListener((OnClickListener) this);
		ll_address.setOnClickListener((OnClickListener) this);
		ll_friend.setOnClickListener((OnClickListener) this);
		ll_setting.setOnClickListener((OnClickListener) this);

		// 设置ViewPager滑动监听
		viewPager.setOnPageChangeListener(this);

		// 设置返回按钮
		findViewById(R.id.know_iv_back).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						// 使当前Activity结束就可以了
						KnowActivity.this.finish();
					}
				});
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int arg0) {
		restartBotton();
		// 当前view被选择的时候,改变底部菜单图片，文字颜色
		switch (arg0) {
		case 0:
			know_top.setText("理解媒介 - 知识类");
			iv_home.setImageResource(R.drawable.map_sy);
			// tv_home.setTextColor(0xff1B940A);
			break;
		case 1:
			know_top.setText("首页");
			iv_address.setImageResource(R.drawable.map_zp);
			// tv_address.setTextColor(0xff1B940A);
			break;
		case 2:
			know_top.setText("理解媒介 - 能力类");
			iv_friend.setImageResource(R.drawable.map_kj);
			// tv_friend.setTextColor(0xff1B940A);
			break;
		case 3:
			know_top.setText("理解媒介 - 情感类");
			iv_setting.setImageResource(R.drawable.map_set);
			// tv_setting.setTextColor(0xff1B940A);
			break;

		default:
			break;
		}
	}

	@Override
	public void onClick(View v) {
		// 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
		restartBotton();
		// ImageView和TetxView置为绿色，页面随之跳转
		switch (v.getId()) {
		case R.id.ll_home:
			iv_home.setImageResource(R.drawable.map_sy);
			know_top.setText("首页");
			// tv_home.setTextColor(0xff1B940A);
			viewPager.setCurrentItem(1);
			// startActivity(new Intent(getApplicationContext(),
			// MainContent.class));
			break;
		case R.id.ll_address:
			know_top.setText("学生作品");
			iv_address.setImageResource(R.drawable.map_zp);
			// tv_address.setTextColor(0xff1B940A);
			viewPager.setCurrentItem(0);
			// startActivity(new Intent(getApplicationContext(),
			// KnowActivity.class));
			break;
		case R.id.ll_friend:
			know_top.setText("个人空间");
			iv_friend.setImageResource(R.drawable.map_kj);
			// tv_friend.setTextColor(0xff1B940A);
			viewPager.setCurrentItem(2);
			// startActivity(new Intent(getApplicationContext(),
			// EnableActivity.class));
			break;
		case R.id.ll_setting:
			know_top.setText("帮助");
			iv_setting.setImageResource(R.drawable.map_set);
			// tv_setting.setTextColor(0xff1B940A);
			viewPager.setCurrentItem(3);
			// startActivity(new Intent(getApplicationContext(),
			// EmotionActivity.class));
			break;
		default:
			break;
		}
	}

	private void restartBotton() {
		// ImageView置为灰色
		iv_home.setImageResource(R.drawable.map_sy);
		iv_address.setImageResource(R.drawable.map_zp);
		iv_friend.setImageResource(R.drawable.map_kj);
		iv_setting.setImageResource(R.drawable.map_set);
		// TextView置为白色
		tv_home.setTextColor(0xffffffff);
		tv_address.setTextColor(0xffffffff);
		tv_friend.setTextColor(0xffffffff);
		tv_setting.setTextColor(0xffffffff);

	}

}
