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

		// �ļ�·��

		mUri = Uri.parse(Environment.getExternalStorageDirectory()
				+ "/ý������.flv");

		// Create media controller
		mMediaController = new MediaController(this);

		// ����MediaController
		mVideoView.setMediaController(mMediaController);

	}

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

}