package com.adanac.fakeweixin.view.sub;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.adanac.fakeweixin.R;
import com.adanac.fragment.LazyFragment;

/**
 * ʹ��ý�� - ͼ��
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class ThreeWzMoreFragment extends LazyFragment implements
		MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	// ������Ƶ
	public static final String TAG = "VideoPlayer";
	private VideoView mVideoView;
	private Uri mUri;
	private int mPositionWhenPaused = -1;
	private MediaController mMediaController;

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_two_sp);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_two_sp_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_two_sp_textView);
		textView.setTextSize(12);
		Drawable d = null;
		Drawable d1 = null;
		switch (tabIndex) {
		case 0:

			d = getResources().getDrawable(R.drawable.map_two_sp_01);
			d.setBounds(0, 0, 900, 600);

			textView.setCompoundDrawables(null, null, null, d);
			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_two_sp_02);
			d.setBounds(0, 0, 900, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, null, null, d);
			break;

		default:
			d = getResources().getDrawable(R.drawable.map_two_sp_03);
			d.setBounds(0, 0, 900, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, null, null, d);
			break;
		}
		handler.sendEmptyMessageDelayed(1, 1000);
	}

	@Override
	public void onDestroyViewLazy() {
		super.onDestroyViewLazy();
		handler.removeMessages(1);
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			progressBar.setVisibility(View.GONE);
			textView.setVisibility(View.VISIBLE);
		}
	};

	// ����MediaPlayer�ϱ��Ĵ�����Ϣ

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		return false;
	}

	@Override
	public void onCompletion(MediaPlayer arg0) {
		super.getActivity().finish();

	}

}
