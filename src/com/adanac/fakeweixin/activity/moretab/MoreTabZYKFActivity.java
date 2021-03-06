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
public class MoreTabZYKFActivity extends FragmentActivity implements
		MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
	private IndicatorViewPager indicatorViewPager;
	private LayoutInflater inflate;
	private String[] names = { "知识点注释", "知识地图", "习题作业", "作业讨论", "相关资源" };
	private ScrollIndicatorView indicator;
	private int size = 5;

	// 关于视频
	public static final String TAG = "VideoPlayer";
	private VideoView mVideoView;
	private Uri mUri;
	private int mPositionWhenPaused = -1;

	private MediaController mMediaController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moretab_zykf);

		ViewPager viewPager = (ViewPager) findViewById(R.id.moretab_viewPager);
		indicator = (ScrollIndicatorView) findViewById(R.id.moretab_indicator);
		indicator.setScrollBar(new ColorBar(this, Color.RED, 5));

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
				+ "/appvideo/资源的开发.wmv");

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
						MoreTabZYKFActivity.this.finish();
					}
				});
	}

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
			String downPath = "http://adanac.qiniudn.com/app%E8%B5%84%E6%BA%90%E7%9A%84%E5%BC%80%E5%8F%91.wmv";
			DownFileUtil.downMedia(savePath, filename, downPath);
			DownFileUtil.toastDisplay(MoreTabZYKFActivity.this, "缓冲中...", 5000);
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
			MoreFragmentZYKF fragment = new MoreFragmentZYKF();
			Bundle bundle = new Bundle();
			bundle.putInt(MoreFragmentZYKF.INTENT_INT_INDEX, position);
			fragment.setArguments(bundle);
			return fragment;
		}

		@Override
		public int getItemPosition(Object object) {
			return FragmentListPageAdapter.POSITION_NONE;
		}
	}

}
