package com.adanac.fakeweixin.slideview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adanac.fakeweixin.R;
import com.adanac.fakeweixin.slideview.SlideViewXz.OnSlideListener;
import com.adanac.fakeweixin.slideview.fx.Fx01Activity;
import com.adanac.fakeweixin.slideview.fx.Fx02Activity;
import com.adanac.fakeweixin.slideview.fx.Fx03Activity;

public class ThreeFxMainActivity extends Activity implements
		OnItemClickListener, OnClickListener, OnSlideListener {

	private static final String TAG = "MainActivity";

	private ListViewCompatFx mListView;
	SlideAdapter slideAdapter;
	private List<MessageItem> mMessageItems = new ArrayList<ThreeFxMainActivity.MessageItem>();

	private SlideViewXz mLastSlideViewWithStatusOn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_fx);
		initView();
		initEvent();
	}

	private void initEvent() {

		// 设置返回按钮
		findViewById(R.id.moretab_iv_back).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						// 使当前Activity结束就可以了
						ThreeFxMainActivity.this.finish();
					}
				});
	}

	private void initView() {
		mListView = (ListViewCompatFx) findViewById(R.id.list_fx);

		for (int i = 0; i < 3; i++) {
			MessageItem item = new MessageItem();
			switch (i % 3) {
			case 0:
				item.iconRes = R.drawable.three_fx01;
				item.title = "《媒体融合新论》";
				item.msg = "作者：万小广";
				item.time = "2015.12.18";
				break;
			case 1:
				item.iconRes = R.drawable.three_fx02;
				item.title = "《媒介素养读本》";
				item.msg = "作者：范红";
				item.time = "2015.12.18";
				break;
			default:
				item.iconRes = R.drawable.three_fx03;
				item.title = "《媒介素养导论》";
				item.msg = "作者：段京肃";
				item.time = "2015.12.18";
				break;
			}
			mMessageItems.add(item);
		}

		// footer = LayoutInflater.from(this).inflate(R.layout.footer, null);
		// mListView.addFooterView(footer);
		slideAdapter = new SlideAdapter();
		mListView.setAdapter(slideAdapter);
		mListView.setOnItemClickListener(this);
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

				slideView = new SlideViewXz(ThreeFxMainActivity.this);
				slideView.setContentView(itemView);

				holder = new ViewHolder(slideView);
				slideView.setOnSlideListener(ThreeFxMainActivity.this);
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
			holder.leftHolder.setOnClickListener(ThreeFxMainActivity.this);
			holder.rightHolder.setOnClickListener(ThreeFxMainActivity.this);
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
		Log.e(TAG, "onItemClick position=" + position);
		SlideViewXz slideView = mMessageItems.get(position).slideView;
		if (slideView.ismIsMoveClick()) {
			return;
		}
		if (slideView.close() && slideView.getScrollX() == 0) {
			if (mLastSlideViewWithStatusOn == null
					|| mLastSlideViewWithStatusOn.getScrollX() == 0) {

				Toast.makeText(this, "onItemClick position=" + position, 0)
						.show();
				switch (position) {
				case 0:
					startActivity(new Intent(getApplicationContext(),
							Fx01Activity.class));
					break;
				case 1:
					startActivity(new Intent(getApplicationContext(),
							Fx02Activity.class));
					break;
				default:
					startActivity(new Intent(getApplicationContext(),
							Fx03Activity.class));
					break;
				}
			}
		}
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

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.left_holder) {
			Log.e(TAG, "onClick v=" + v);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("提示").setIcon(R.drawable.ic_launcher)
					.setMessage("确定删此条目？").setNegativeButton("取消", null);
			builder.setPositiveButton("删除",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							mMessageItems.remove(mListView.getPosition());
							slideAdapter.notifyDataSetChanged();
						}
					});
			builder.show();
		} else if (v.getId() == R.id.right_holder) {
			Log.e(TAG, "onClick v=" + v);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("提示").setIcon(R.drawable.ic_launcher)
					.setMessage("确定删此条目？").setNegativeButton("取消", null);
			builder.setPositiveButton("删除",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							mMessageItems.remove(mListView.getPosition());
							slideAdapter.notifyDataSetChanged();
						}
					});
			builder.show();
		}
	}
}
