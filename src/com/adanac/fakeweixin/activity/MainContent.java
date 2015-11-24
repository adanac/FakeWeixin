package com.adanac.fakeweixin.activity;

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
import com.adanac.fakeweixin.view.DrawAppView_bak;

public class MainContent extends Activity implements OnClickListener,
		OnPageChangeListener {
	// �ײ��˵�4��Linearlayout
	private LinearLayout ll_home;
	private LinearLayout ll_address;
	private LinearLayout ll_friend;
	private LinearLayout ll_setting;

	// �ײ��˵�4��ImageView
	private ImageView iv_home;
	private ImageView iv_address;
	private ImageView iv_friend;
	private ImageView iv_setting;

	// ��������
	private TextView tv_top;

	// �ײ��˵�4���˵�����
	private TextView tv_home;
	private TextView tv_address;
	private TextView tv_friend;
	private TextView tv_setting;

	// �м���������
	private ViewPager viewPager;

	// ViewPager������ContentAdapter
	private ContentAdapter adapter;

	private List<View> views;

	private static final String TAG = "Rabbit";

	// private Button mbButton;
	// private ImageView imageView;
	private LinearLayout linearLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_content);

		// ��ʼ���ؼ�
		initView();
		// ��ʼ���ײ���ť�¼�
		initEvent();

		Log.i(TAG, "1----------onCreate");
	}

	private void initContent() {
		// TODO Ҫ�Ѳ�ͬ��ͼ��д����ͬ��view�У����������ӵ��ܵ�content��
		LinearLayout layoutContent = (LinearLayout) findViewById(R.id.main_content);
		final DrawAppView_bak view_one = new DrawAppView_bak(this);
		view_one.setMinimumHeight(600);
		view_one.setMinimumWidth(800);
		// ֪ͨview����ػ�
		view_one.invalidate();
		layoutContent.addView(view_one);

	}

	private void initEvent() {
		// ���ð�ť����
		ll_home.setOnClickListener((OnClickListener) this);
		ll_address.setOnClickListener((OnClickListener) this);
		ll_friend.setOnClickListener((OnClickListener) this);
		ll_setting.setOnClickListener((OnClickListener) this);

		// ����ViewPager��������
		viewPager.setOnPageChangeListener(this);
	}

	private void initView() {

		// �ײ��˵�4��Linearlayout
		this.ll_home = (LinearLayout) findViewById(R.id.ll_home);
		this.ll_address = (LinearLayout) findViewById(R.id.ll_address);
		this.ll_friend = (LinearLayout) findViewById(R.id.ll_friend);
		this.ll_setting = (LinearLayout) findViewById(R.id.ll_setting);

		// �ײ��˵�4��ImageView
		this.iv_home = (ImageView) findViewById(R.id.iv_home);
		this.iv_address = (ImageView) findViewById(R.id.iv_address);
		this.iv_friend = (ImageView) findViewById(R.id.iv_friend);
		this.iv_setting = (ImageView) findViewById(R.id.iv_setting);

		// ��������
		this.tv_top = (TextView) findViewById(R.id.tv_top);

		// �ײ��˵�4���˵�����
		this.tv_home = (TextView) findViewById(R.id.tv_home);
		this.tv_address = (TextView) findViewById(R.id.tv_address);
		this.tv_friend = (TextView) findViewById(R.id.tv_friend);
		this.tv_setting = (TextView) findViewById(R.id.tv_setting);

		// �м���������ViewPager
		this.viewPager = (ViewPager) findViewById(R.id.vp_content);

		// ������
		View page_01 = View.inflate(MainContent.this, R.layout.page_01, null);
		View page_02 = View.inflate(MainContent.this, R.layout.page_02, null);
		View page_03 = View.inflate(MainContent.this, R.layout.page_03, null);
		View page_04 = View.inflate(MainContent.this, R.layout.page_04, null);

		// �ڵ�1��ҳ�滭ͼ��
		final DrawAppView view_one = new DrawAppView(this);
		view_one.setMinimumHeight(600);
		view_one.setMinimumWidth(800);
		// ֪ͨview����ػ�
		view_one.invalidate();
		((ViewGroup) page_01).addView(view_one);

		// �ڵ�2��ҳ�滭ͼ�Σ�֪ʶ�ࣩ
		final DrawAppView2 view_two = new DrawAppView2(this);
		view_two.setMinimumHeight(600);
		view_two.setMinimumWidth(800);
		// ֪ͨview����ػ�
		view_two.invalidate();
		((ViewGroup) page_02).addView(view_two);

		// �ڵ�3��ҳ�滭ͼ�Σ���
		final DrawAppView3 view_three = new DrawAppView3(this);
		view_two.setMinimumHeight(600);
		view_two.setMinimumWidth(800);
		// ֪ͨview����ػ�
		view_two.invalidate();
		((ViewGroup) page_03).addView(view_three);

		// �ڵ�4��ҳ�滭ͼ��
		final DrawAppView4 view_four = new DrawAppView4(this);
		view_four.setMinimumHeight(600);
		view_four.setMinimumWidth(800);
		// ֪ͨview����ػ�
		view_four.invalidate();
		((ViewGroup) page_04).addView(view_four);

		views = new ArrayList<View>();
		views.add(page_01);
		views.add(page_02);
		views.add(page_03);
		views.add(page_04);

		this.adapter = new ContentAdapter(views);
		viewPager.setAdapter(adapter);

	}

	@Override
	public void onClick(View v) {
		// ��ÿ�ε�������еĵײ���ť(ImageView,TextView)��ɫ��Ϊ��ɫ��Ȼ����ݵ����ɫ
		restartBotton();
		// ImageView��TetxView��Ϊ��ɫ��ҳ����֮��ת
		switch (v.getId()) {
		case R.id.ll_home:
			iv_home.setImageResource(R.drawable.agt_aisles);
			tv_top.setText("ý������");
			tv_home.setTextColor(0xff1B940A);
			viewPager.setCurrentItem(0);
			break;
		case R.id.ll_address:
			tv_top.setText("ѧ����Ʒ");
			iv_address.setImageResource(R.drawable.agt_mp3);
			tv_address.setTextColor(0xff1B940A);
			viewPager.setCurrentItem(1);
			break;
		case R.id.ll_friend:
			tv_top.setText("���˿ռ�");
			iv_friend.setImageResource(R.drawable.agt_games);
			tv_friend.setTextColor(0xff1B940A);
			viewPager.setCurrentItem(2);
			break;
		case R.id.ll_setting:
			tv_top.setText("����");
			iv_setting.setImageResource(R.drawable.agt_setting);
			tv_setting.setTextColor(0xff1B940A);
			viewPager.setCurrentItem(3);
			// startActivity(new Intent(MainContent.this,
			// EmotionalActivity.class));
			break;
		case R.string.view1_str0:
			tv_top.setText("����~~");
			iv_setting.setImageResource(R.drawable.agt_setting);
			tv_setting.setTextColor(0xff1B940A);
			viewPager.setCurrentItem(3);
			break;
		default:
			break;
		}
	}

	private void restartBotton() {
		// ImageView��Ϊ��ɫ
		iv_home.setImageResource(R.drawable.agt_aisles);
		iv_address.setImageResource(R.drawable.agt_mp3);
		iv_friend.setImageResource(R.drawable.agt_games);
		iv_setting.setImageResource(R.drawable.agt_setting);
		// TextView��Ϊ��ɫ
		tv_home.setTextColor(0xffffffff);
		tv_address.setTextColor(0xffffffff);
		tv_friend.setTextColor(0xffffffff);
		tv_setting.setTextColor(0xffffffff);
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
		// ��ǰview��ѡ���ʱ��,�ı�ײ��˵�ͼƬ��������ɫ
		switch (arg0) {
		case 0:
			tv_top.setText("ý������");
			iv_home.setImageResource(R.drawable.agt_aisles);
			tv_home.setTextColor(0xff1B940A);
			break;
		case 1:
			tv_top.setText("ѧ����Ʒ");
			iv_address.setImageResource(R.drawable.agt_mp3);
			tv_address.setTextColor(0xff1B940A);
			break;
		case 2:
			tv_top.setText("���˿ռ�");
			iv_friend.setImageResource(R.drawable.agt_games);
			tv_friend.setTextColor(0xff1B940A);
			break;
		case 3:
			tv_top.setText("����");
			iv_setting.setImageResource(R.drawable.agt_setting);
			tv_setting.setTextColor(0xff1B940A);
			break;

		default:
			break;
		}

	}
}
