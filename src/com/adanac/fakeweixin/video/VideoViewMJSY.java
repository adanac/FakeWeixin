package com.adanac.fakeweixin.video;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.adanac.fakeweixin.R;

public class VideoViewMJSY extends Activity implements
		MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
	public static final String TAG = "VideoPlayer";
	private VideoView mVideoView;
	private Uri mUri;
	private int mPositionWhenPaused = -1;

	private MediaController mMediaController;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_videoview);

		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		mVideoView = (VideoView) findViewById(R.id.videoview);

		// 文件路径

		mUri = Uri.parse(Environment.getExternalStorageDirectory()
				+ "/媒介素养.flv");

		// Create media controller
		mMediaController = new MediaController(this);

		// 设置MediaController
		mVideoView.setMediaController(mMediaController);

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
		// Play Video
		mVideoView.setVideoURI(mUri);
		mVideoView.start();

		super.onStart();
	}

	// 暂停

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

}