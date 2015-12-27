package com.adanac.fakeweixin.view.sub;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fakeweixin.slideview.ListViewCompatXz;
import com.adanac.fakeweixin.slideview.SlideViewXz;
import com.adanac.fakeweixin.slideview.SlideViewXz.OnSlideListener;
import com.adanac.fragment.LazyFragment;

/**
 * 研究媒介 - 研究学者
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class ThreeXzMoreFragment extends LazyFragment implements
		OnItemClickListener, OnClickListener, OnSlideListener {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	private ListViewCompatXz mListView;
	SlideAdapter slideAdapter;
	private List<MessageItem> mMessageItems = new ArrayList<ThreeXzMoreFragment.MessageItem>();

	private SlideViewXz mLastSlideViewWithStatusOn;

	// 关于视频
	// public static final String TAG = "VideoPlayer";
	// private VideoView mVideoView;
	// private Uri mUri;
	// private int mPositionWhenPaused = -1;
	// private MediaController mMediaController;

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_three_xz);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_three_xz_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_three_xz_textView);
		textView.setTextSize(12);
		Drawable d = null;
		Drawable d1 = null;
		switch (tabIndex) {
		case 0:

			mListView = (ListViewCompatXz) findViewById(R.id.list_xz);

			for (int i = 0; i < 3; i++) {
				MessageItem item = new MessageItem();
				switch (i % 3) {
				case 0:
					item.iconRes = R.drawable.three_xz01;
					item.title = "卜卫";
					item.msg = "学者";
					item.time = "2015.12.18";
					break;
				case 1:
					item.iconRes = R.drawable.three_xz02;
					item.title = "陆晔";
					item.msg = "学者";
					item.time = "2015.12.18";
					break;
				default:
					item.iconRes = R.drawable.three_xz03;
					item.title = "张舒予";
					item.msg = "学者";
					item.time = "2015.12.18";
					break;
				}

				mMessageItems.add(item);
			}

			// footer = LayoutInflater.from(this).inflate(R.layout.footer,
			// null);
			// mListView.addFooterView(footer);
			slideAdapter = new SlideAdapter();
			mListView.setAdapter(slideAdapter);
			mListView.setOnItemClickListener(this);
			break;
		case 1:
			d = getResources().getDrawable(R.drawable.map_two_sp_02);
			d.setBounds(0, 0, 900, 500); // 必须设置图片大小，否则不显示
			textView.setCompoundDrawables(null, null, null, d);
			break;

		default:
			d = getResources().getDrawable(R.drawable.map_two_sp_03);
			d.setBounds(0, 0, 900, 500); // 必须设置图片大小，否则不显示
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

	// 监听MediaPlayer上报的错误信息

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

	private class SlideAdapter extends BaseAdapter {

		private LayoutInflater mInflater;

		SlideAdapter() {
			super();
			mInflater = getLayoutInflater();
		}

		@Override
		public int getCount() {
			return mMessageItems.size();
		}

		@Override
		public Object getItem(int position) {
			return mMessageItems.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			SlideViewXz slideView = (SlideViewXz) convertView;
			if (slideView == null) {
				View itemView = mInflater.inflate(R.layout.slide_list_item,
						null);

				slideView = new SlideViewXz();
				slideView.setContentView(itemView);

				holder = new ViewHolder(slideView);
				slideView.setOnSlideListener(ThreeXzMoreFragment.this);
				slideView.setTag(holder);
			} else {
				holder = (ViewHolder) slideView.getTag();
			}
			MessageItem item = mMessageItems.get(position);
			item.slideView = slideView;
			item.slideView.reset();
			holder.icon.setImageResource(item.iconRes);
			holder.title.setText(item.title);
			holder.msg.setText(item.msg);
			holder.time.setText(item.time);
			holder.leftHolder.setOnClickListener(ThreeXzMoreFragment.this);
			holder.rightHolder.setOnClickListener(ThreeXzMoreFragment.this);
			return slideView;
		}

	}

	public class MessageItem {
		public int iconRes;
		public String title;
		public String msg;
		public String time;
		public SlideViewXz slideView;
	}

	private static class ViewHolder {
		public ImageView icon;
		public TextView title;
		public TextView msg;
		public TextView time;
		public ViewGroup leftHolder;
		public ViewGroup rightHolder;

		ViewHolder(View view) {
			icon = (ImageView) view.findViewById(R.id.icon);
			title = (TextView) view.findViewById(R.id.title);
			msg = (TextView) view.findViewById(R.id.msg);
			time = (TextView) view.findViewById(R.id.time);
			leftHolder = (ViewGroup) view.findViewById(R.id.left_holder);
			rightHolder = (ViewGroup) view.findViewById(R.id.right_holder);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		SlideViewXz slideView = mMessageItems.get(position).slideView;
		if (slideView.ismIsMoveClick()) {
			return;
		}
		if (slideView.close() && slideView.getScrollX() == 0) {
			if (mLastSlideViewWithStatusOn == null
					|| mLastSlideViewWithStatusOn.getScrollX() == 0) {

			}
		}
	}

	public LayoutInflater getLayoutInflater() {

		return null;
	}

	@Override
	public void onSlide(View view, int status) {
		if (mLastSlideViewWithStatusOn != null
				&& mLastSlideViewWithStatusOn != view) {
			mLastSlideViewWithStatusOn.shrink();
		}

		if (status == SLIDE_STATUS_ON) {
			mLastSlideViewWithStatusOn = (SlideViewXz) view;
		}
	}

}
