package com.adanac.fakeweixin.activity.moretab;

import java.io.File;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
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
public class MoreTabZYXZActivity extends FragmentActivity implements
		MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener,
		OnBufferingUpdateListener, MediaPlayer.OnPreparedListener {
	private IndicatorViewPager indicatorViewPager;
	private LayoutInflater inflate;
	private String[] names = { "知识点注释", "知识地图", "习题作业", "作业讨论", "相关资源" };
	private ScrollIndicatorView indicator;
	private int size = 5;

	// TODO
	// 底部菜单没有显示出来是因为代码中没有写出来

	// 顶部标题
	private TextView moretab_mjsy_top;

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

	// 底部菜单4个菜单标题
	private TextView tv_home;
	private TextView tv_address;
	private TextView tv_friend;
	private TextView tv_setting;

	// 关于视频
	public static final String TAG = "VideoPlayer";
	private VideoView mVideoView;
	private Uri mUri;
	private int mPositionWhenPaused = -1;
	private int videoWidth;
	private int videoHeight;
	public MediaPlayer mediaPlayer;

	private MediaController mMediaController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moretab_zyxz);

		ViewPager viewPager = (ViewPager) findViewById(R.id.moretab_viewPager);
		indicator = (ScrollIndicatorView) findViewById(R.id.moretab_indicator);
		indicator.setScrollBar(new ColorBar(this, Color.RED, 5));

		// 画出底部菜单
		initBottomView();

		// 设置监听
		initEvent();

		// 设置滚动监听
		int selectColorId = R.color.tab_top_text_2;
		int unSelectColorId = R.color.tab_top_text_1;
		indicator.setOnTransitionListener(new OnTransitionTextListener()
				.setColorId(this, selectColorId, unSelectColorId));

		viewPager.setOffscreenPageLimit(5);
		indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
		inflate = LayoutInflater.from(getApplicationContext());
		indicatorViewPager
				.setAdapter(new MyAdapter(getSupportFragmentManager()));

		// 关于视频播放
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		mVideoView = (VideoView) findViewById(R.id.videoview);

		// 文件路径

		mUri = Uri.parse(Environment.getExternalStorageDirectory()
				+ "/appvideo/资源的选择.wmv");

		// Create media controller
		mMediaController = new MediaController(this);

		// 设置MediaController
		mVideoView.setMediaController(mMediaController);

	}

	private void initEvent() {

		// 设置返回按钮
		findViewById(R.id.moretab_iv_back).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						// 使当前Activity结束就可以了
						MoreTabZYXZActivity.this.finish();
					}
				});
	}

	private void initBottomView() {
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
		this.moretab_mjsy_top = (TextView) findViewById(R.id.moretab_ezgx_top);

		// 底部菜单4个菜单标题
		this.tv_home = (TextView) findViewById(R.id.tv_home);
		this.tv_address = (TextView) findViewById(R.id.tv_address);
		this.tv_friend = (TextView) findViewById(R.id.tv_friend);
		this.tv_setting = (TextView) findViewById(R.id.tv_setting);

	}

	private OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// 设置是否自动布局
			indicator.setSplitAuto(isChecked);
		}
	};

	// 监听MediaPlayer上报的错误信息

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		return false;
	}

	// Video播完的时候得到通知

	@Override
	public void onCompletion(MediaPlayer mp) {
		this.finish();
	}

	@Override
	public void onPrepared(MediaPlayer arg0) {
		videoWidth = mediaPlayer.getVideoWidth();
		videoHeight = mediaPlayer.getVideoHeight();
		if (videoHeight != 0 && videoWidth != 0) {
			arg0.start();
		}
		Log.e("mediaPlayer", "onPrepared");

	}

	@Override
	public void onBufferingUpdate(MediaPlayer arg0, int bufferingProgress) {
		// skbProgress.setSecondaryProgress(bufferingProgress); int
		// currentProgress=skbProgress.getMax()*mediaPlayer.getCurrentPosition()/mediaPlayer.getDuration();
		// Log.e(currentProgress+"% play", bufferingProgress + "% buffer"); }
	}

	// 开始
	public void onStart() {
		int index = mUri.getPath().lastIndexOf("/");
		String savePath = mUri.getPath().substring(0, index);
		Log.e("savePath:", savePath);
		String filename = mUri.getLastPathSegment();
		Log.e("filename:", filename);
		File file = new File(savePath + "/" + filename);
		if (!file.exists()) {
			// Down Video
			String downPath = "http://adanac.qiniudn.com/app%E8%B5%84%E6%BA%90%E7%9A%84%E9%80%89%E6%8B%A9.wmv";
			DownFileUtil.downMedia(savePath, filename, downPath);
			DownFileUtil.toastDisplay(MoreTabZYXZActivity.this, "缓冲中...", 5000);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Play Video
		mVideoView.setVideoURI(mUri);
		mVideoView.stopPlayback();
		super.onPause();

	}

	// 暂停
	public void onPause() {
		// Stop video when the activity is pause.
		mPositionWhenPaused = mVideoView.getCurrentPosition();

		mVideoView.start();

		super.onStart();
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
			MoreFragmentZYXZ fragment = new MoreFragmentZYXZ();
			Bundle bundle = new Bundle();
			bundle.putInt(MoreFragmentZYXZ.INTENT_INT_INDEX, position);
			fragment.setArguments(bundle);
			return fragment;
		}

		@Override
		public int getItemPosition(Object object) {
			return FragmentListPageAdapter.POSITION_NONE;
		}
	}

}
