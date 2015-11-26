package com.adanac.fakeweixin.activity.sub;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
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

		// 在第3个页面画图形（）
		final DrawAppView3 view_three = new DrawAppView3(this);
		view_two.setMinimumHeight(600);
		view_two.setMinimumWidth(800);
		// 通知view组件重绘
		view_two.invalidate();
		((ViewGroup) page_03).addView(view_three);

		// 在第4个页面画图形
		final DrawAppView4 view_four = new DrawAppView4(this);
		view_four.setMinimumHeight(600);
		view_four.setMinimumWidth(800);
		// 通知view组件重绘
		view_four.invalidate();
		((ViewGroup) page_04).addView(view_four);

		views = new ArrayList<View>();
		// views.add(page_01);
		views.add(page_02);
		// views.add(page_03);
		// views.add(page_04);

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
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int arg0) {

	}

	@Override
	public void onClick(View v) {
		// 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
		restartBotton();
		// ImageView和TetxView置为绿色，页面随之跳转
		switch (v.getId()) {
		case R.id.ll_home:
			iv_home.setImageResource(R.drawable.agt_aisles);
			know_top.setText("知识类-媒介素养");
			tv_home.setTextColor(0xff1B940A);
			viewPager.setCurrentItem(0);
			break;
		case R.id.ll_address:
			know_top.setText("知识类-学生作品");
			iv_address.setImageResource(R.drawable.agt_mp3);
			tv_address.setTextColor(0xff1B940A);
			viewPager.setCurrentItem(1);
			break;
		case R.id.ll_friend:
			know_top.setText("知识类-个人空间");
			iv_friend.setImageResource(R.drawable.agt_games);
			tv_friend.setTextColor(0xff1B940A);
			viewPager.setCurrentItem(2);
			break;
		case R.id.ll_setting:
			know_top.setText("知识类-帮助");
			iv_setting.setImageResource(R.drawable.agt_setting);
			tv_setting.setTextColor(0xff1B940A);
			viewPager.setCurrentItem(3);
			// startActivity(new Intent(MainContent.this,
			// EmotionalActivity.class));
			break;
		case R.string.view1_str0:
			know_top.setText("知识类2-帮助~~");
			iv_setting.setImageResource(R.drawable.agt_setting);
			tv_setting.setTextColor(0xff1B940A);
			viewPager.setCurrentItem(3);
			break;
		default:
			break;
		}
	}

	private void restartBotton() {
		// ImageView置为灰色
		iv_home.setImageResource(R.drawable.agt_aisles);
		iv_address.setImageResource(R.drawable.agt_mp3);
		iv_friend.setImageResource(R.drawable.agt_games);
		iv_setting.setImageResource(R.drawable.agt_setting);
		// TextView置为白色
		tv_home.setTextColor(0xffffffff);
		tv_address.setTextColor(0xffffffff);
		tv_friend.setTextColor(0xffffffff);
		tv_setting.setTextColor(0xffffffff);

	}

}
