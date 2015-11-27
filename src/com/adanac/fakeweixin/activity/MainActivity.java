package com.adanac.fakeweixin.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.adanac.fakeweixin.R;
import com.adanac.fakeweixin.adapter.ImageAdapter;

/**
 * @author adanac
 * @date 2015-11-27
 * @version 1.0
 */
public class MainActivity extends Activity implements OnPageChangeListener,
		OnClickListener {

	private ViewPager viewPager;
	private List<View> viewList;
	// private int
	// images[]={R.drawable.v1,R.drawable.v2,R.drawable.v3,R.drawable.v4};//导航图片资源
	private View view1, view2, view3, view4;
	private ImageView points[];// 存放小圆圈数组

	private int currentIndex = 0;// 当前页面,默认首页

	private Button startButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViewPager();// 初始化ViewPager对象
		initPoint();// 初始化导航小圆点
	}

	private void initPoint() {
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll);
		points = new ImageView[4];
		for (int i = 0; i < points.length; i++) {
			points[i] = (ImageView) linearLayout.getChildAt(i);// 遍历LinearLayout下的所有ImageView子节点
			points[i].setEnabled(true);// 设置当前状态为允许（可点，灰色）
			// 设置点击监听
			points[i].setOnClickListener(this);

			// 额外设置一个标识符，以便点击小圆点时跳转对应页面
			points[i].setTag(i);// 标识符与圆点顺序一致
		}

		currentIndex = 0;
		points[currentIndex].setEnabled(false);// 设置首页为当前页(小点着色,蓝色)

	}

	private void initViewPager() {
		viewPager = (ViewPager) findViewById(R.id.viewpager);// 取得ViewPager实例
		viewList = new ArrayList<View>();// 实例化list集合

		/*
		 * 用代码的动态添加View //添加对应的view进入集合（数据源） for(int i=0;i<images.length;i++){
		 * ImageView imageView=new ImageView(MainActivity.this);
		 * imageView.setLayoutParams(new
		 * LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		 * imageView.setScaleType(ScaleType.FIT_XY);//设置缩放样式
		 * imageView.setImageResource(images[i]); viewList.add(imageView); }
		 */

		// 用xml静态添加view
		view1 = View.inflate(MainActivity.this, R.layout.view1, null);
		view2 = View.inflate(MainActivity.this, R.layout.view2, null);
		view3 = View.inflate(MainActivity.this, R.layout.view3, null);
		view4 = View.inflate(MainActivity.this, R.layout.view4, null);
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		viewList.add(view4);

		// 设置适配器
		ImageAdapter adapter = new ImageAdapter(viewList);

		// 绑定适配器
		viewPager.setAdapter(adapter);

		// 设置页卡切换监听
		viewPager.setOnPageChangeListener(this);

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int position) {// 当前页卡被选择时,position为当前页数

		if (position == 3) {// 由于进入微信这个按钮在第4个页面（view）才会出现，如果一开始就加载这个按钮监听，就导致空指针异常
			// startButton = (Button) findViewById(R.id.btn_start);
			// startButton.setOnClickListener(new OnClickListener() {//
			// 匿名内部类，区分小圆圈的点击事件
			//
			// @Override
			// public void onClick(View v) {
			// Toast.makeText(MainActivity.this, "欢迎进入APP",
			// Toast.LENGTH_SHORT).show();
			// startActivity(new Intent(MainActivity.this,
			// TabMainActivity.class));
			// }
			// });
			// onClickMain(view);
		}
		points[position].setEnabled(false);// 不可点
		points[currentIndex].setEnabled(true);// 恢复之前页面状态
		currentIndex = position;

	}

	/**
	 * View4.xml中对应： android:onClick="onClickMain"
	 * 
	 * @param view
	 */
	public void onClickMain(View view) {
		startActivity(new Intent(getApplicationContext(), MainContent.class));
	}

	@Override
	public void onClick(View v) {
		// 利用刚设置的标识符跳转页面
		Log.v("tuzi", v.getTag() + "");
		viewPager.setCurrentItem(Integer.parseInt(v.getTag().toString()));

	}
}
