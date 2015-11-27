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
	// images[]={R.drawable.v1,R.drawable.v2,R.drawable.v3,R.drawable.v4};//����ͼƬ��Դ
	private View view1, view2, view3, view4;
	private ImageView points[];// ���СԲȦ����

	private int currentIndex = 0;// ��ǰҳ��,Ĭ����ҳ

	private Button startButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViewPager();// ��ʼ��ViewPager����
		initPoint();// ��ʼ������СԲ��
	}

	private void initPoint() {
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll);
		points = new ImageView[4];
		for (int i = 0; i < points.length; i++) {
			points[i] = (ImageView) linearLayout.getChildAt(i);// ����LinearLayout�µ�����ImageView�ӽڵ�
			points[i].setEnabled(true);// ���õ�ǰ״̬Ϊ�����ɵ㣬��ɫ��
			// ���õ������
			points[i].setOnClickListener(this);

			// ��������һ����ʶ�����Ա���СԲ��ʱ��ת��Ӧҳ��
			points[i].setTag(i);// ��ʶ����Բ��˳��һ��
		}

		currentIndex = 0;
		points[currentIndex].setEnabled(false);// ������ҳΪ��ǰҳ(С����ɫ,��ɫ)

	}

	private void initViewPager() {
		viewPager = (ViewPager) findViewById(R.id.viewpager);// ȡ��ViewPagerʵ��
		viewList = new ArrayList<View>();// ʵ����list����

		/*
		 * �ô���Ķ�̬���View //��Ӷ�Ӧ��view���뼯�ϣ�����Դ�� for(int i=0;i<images.length;i++){
		 * ImageView imageView=new ImageView(MainActivity.this);
		 * imageView.setLayoutParams(new
		 * LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		 * imageView.setScaleType(ScaleType.FIT_XY);//����������ʽ
		 * imageView.setImageResource(images[i]); viewList.add(imageView); }
		 */

		// ��xml��̬���view
		view1 = View.inflate(MainActivity.this, R.layout.view1, null);
		view2 = View.inflate(MainActivity.this, R.layout.view2, null);
		view3 = View.inflate(MainActivity.this, R.layout.view3, null);
		view4 = View.inflate(MainActivity.this, R.layout.view4, null);
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		viewList.add(view4);

		// ����������
		ImageAdapter adapter = new ImageAdapter(viewList);

		// ��������
		viewPager.setAdapter(adapter);

		// ����ҳ���л�����
		viewPager.setOnPageChangeListener(this);

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int position) {// ��ǰҳ����ѡ��ʱ,positionΪ��ǰҳ��

		if (position == 3) {// ���ڽ���΢�������ť�ڵ�4��ҳ�棨view���Ż���֣����һ��ʼ�ͼ��������ť�������͵��¿�ָ���쳣
			// startButton = (Button) findViewById(R.id.btn_start);
			// startButton.setOnClickListener(new OnClickListener() {//
			// �����ڲ��࣬����СԲȦ�ĵ���¼�
			//
			// @Override
			// public void onClick(View v) {
			// Toast.makeText(MainActivity.this, "��ӭ����APP",
			// Toast.LENGTH_SHORT).show();
			// startActivity(new Intent(MainActivity.this,
			// TabMainActivity.class));
			// }
			// });
			// onClickMain(view);
		}
		points[position].setEnabled(false);// ���ɵ�
		points[currentIndex].setEnabled(true);// �ָ�֮ǰҳ��״̬
		currentIndex = position;

	}

	/**
	 * View4.xml�ж�Ӧ�� android:onClick="onClickMain"
	 * 
	 * @param view
	 */
	public void onClickMain(View view) {
		startActivity(new Intent(getApplicationContext(), MainContent.class));
	}

	@Override
	public void onClick(View v) {
		// ���ø����õı�ʶ����תҳ��
		Log.v("tuzi", v.getTag() + "");
		viewPager.setCurrentItem(Integer.parseInt(v.getTag().toString()));

	}
}
