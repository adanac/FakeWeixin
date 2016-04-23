package com.adanac.fakeweixin.activity.moretab;

import java.io.File;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.adanac.fakeweixin.R;
import com.adanac.fakeweixin.util.DownFileUtil;
import com.adanac.view.indicator.FragmentListPageAdapter;
import com.adanac.view.indicator.IndicatorViewPager;
import com.adanac.view.indicator.IndicatorViewPager.IndicatorFragmentPagerAdapter;
import com.adanac.view.indicator.ScrollIndicatorView;
import com.adanac.view.indicator.slidebar.ColorBar;
import com.adanac.view.indicator.transition.OnTransitionTextListener;

/**
 * @author adanac
 * @date 2015-11-27
 * @version 1.0
 */
public class MoreTabEMFlashActivity extends FragmentActivity implements
		MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
	private IndicatorViewPager indicatorViewPager;
	private LayoutInflater inflate;
	private String[] names = { "֪ʶ��ע��", "��Ʒ����", "˼����ϰ", "�����Դ" };
	private ScrollIndicatorView indicator;
	private int size = 4;

	// TODO
	// �ײ��˵�û����ʾ��������Ϊ������û��д����

	// ��������
	private TextView moretab_emflash_top;

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

	// �ײ��˵�4���˵�����
	private TextView tv_home;
	private TextView tv_address;
	private TextView tv_friend;
	private TextView tv_setting;

	// ������Ƶ
	public static final String TAG = "VideoPlayer";
	private VideoView mVideoView;
	private Uri mUri;
	private int mPositionWhenPaused = -1;
	private MediaController mMediaController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moretab_emflash);

		ViewPager viewPager = (ViewPager) findViewById(R.id.moretab_viewPager_emflash);
		indicator = (ScrollIndicatorView) findViewById(R.id.moretab_indicator_emflash);
		indicator.setScrollBar(new ColorBar(this, Color.RED, 5));

		// �����ײ��˵�
		initBottomView();

		// ���ü���
		initEvent();

		// ���ù�������
		int selectColorId = R.color.tab_top_text_2;
		int unSelectColorId = R.color.tab_top_text_1;
		indicator.setOnTransitionListener(new OnTransitionTextListener()
				.setColorId(this, selectColorId, unSelectColorId));

		viewPager.setOffscreenPageLimit(4);
		indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
		inflate = LayoutInflater.from(getApplicationContext());
		indicatorViewPager
				.setAdapter(new MyAdapter(getSupportFragmentManager()));

		// ������Ƶ����
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		mVideoView = (VideoView) findViewById(R.id.videoview_emflash);

		// �ļ�·��

		mUri = Uri.parse(Environment.getExternalStorageDirectory()
				+ "/appvideo/Flash.wmv");

		// Create media controller
		mMediaController = new MediaController(this);

		// ����MediaController
		mVideoView.setMediaController(mMediaController);

	}

	private void initEvent() {

		// ���÷��ذ�ť
		findViewById(R.id.moretab_iv_back).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						// ʹ��ǰActivity�����Ϳ�����
						MoreTabEMFlashActivity.this.finish();
					}
				});
	}

	private void initBottomView() {
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
		this.moretab_emflash_top = (TextView) findViewById(R.id.moretab_emflash_top);

		// �ײ��˵�4���˵�����
		this.tv_home = (TextView) findViewById(R.id.tv_home);
		this.tv_address = (TextView) findViewById(R.id.tv_address);
		this.tv_friend = (TextView) findViewById(R.id.tv_friend);
		this.tv_setting = (TextView) findViewById(R.id.tv_setting);

	}

	private OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// �����Ƿ��Զ�����
			indicator.setSplitAuto(isChecked);
		}
	};

	// ����MediaPlayer�ϱ��Ĵ�����Ϣ

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		return false;
	}

	// Video�����ʱ��õ�֪ͨ

	@Override
	public void onCompletion(MediaPlayer mp) {
		this.finish();
	}

	// ��ʼ
	public void onStart() {
		int index = mUri.getPath().lastIndexOf("/");
		String savePath = mUri.getPath().substring(0, index);
		Log.e("savePath:", savePath);
		String filename = mUri.getLastPathSegment();
		Log.e("filename:", filename);
		File file = new File(savePath + "/" + filename);
		if (!file.exists()) {
			// Down Video
			String downPath = "http://adanac.qiniudn.com/appflash.wmv";
			DownFileUtil.downMedia(savePath, filename, downPath);
			DownFileUtil.toastDisplay(MoreTabEMFlashActivity.this, "������...",
					5000);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Play Video
		mVideoView.setVideoURI(mUri);
		mVideoView.start();

		super.onStart();
	}

	// ��ͣ
	public void onPause() {
		// Stop video when the activity is pause.
		mPositionWhenPaused = mVideoView.getCurrentPosition();
		mVideoView.stopPlayback();
		Log.d(TAG, "OnStop: mPositionWhenPaused = " + mPositionWhenPaused);
		Log.d(TAG, "OnStop: getDuration  = " + mVideoView.getDuration());

		super.onPause();
	}

	public void onResume() {
		// Resume video player
		if (mPositionWhenPaused >= 0) {
			mVideoView.seekTo(mPositionWhenPaused);
			mPositionWhenPaused = -1;
		}

		super.onResume();
	}

	private class MyAdapter extends IndicatorFragmentPagerAdapter {

		public MyAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
		}

		@Override
		public int getCount() {
			return size;
		}

		@Override
		public View getViewForTab(int position, View convertView,
				ViewGroup container) {
			if (convertView == null) {
				convertView = inflate.inflate(R.layout.tab_top, container,
						false);
			}
			TextView textView = (TextView) convertView;
			textView.setText(names[position % names.length]);
			textView.setPadding(20, 0, 20, 0);
			return convertView;
		}

		@Override
		public Fragment getFragmentForPage(int position) {
			MoreFragmentEMFlash fragment = new MoreFragmentEMFlash();
			Bundle bundle = new Bundle();
			bundle.putInt(MoreFragmentEMFlash.INTENT_INT_INDEX, position);
			fragment.setArguments(bundle);
			return fragment;
		}

		@Override
		public int getItemPosition(Object object) {
			return FragmentListPageAdapter.POSITION_NONE;
		}
	}

}
