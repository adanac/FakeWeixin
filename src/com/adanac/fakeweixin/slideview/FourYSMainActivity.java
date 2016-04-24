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
import com.adanac.fakeweixin.slideview.SlideViewYS.OnSlideListener;
import com.adanac.fakeweixin.slideview.ys.YS01Activity;
import com.adanac.fakeweixin.slideview.ys.YS02Activity;
import com.adanac.fakeweixin.slideview.ys.YS03Activity;

public class FourYSMainActivity extends Activity implements
		OnItemClickListener, OnClickListener, OnSlideListener {

	private static final String TAG = "MainActivity";

	private ListViewCompatYS mListView;
	SlideAdapter slideAdapter;
	private List<MessageItem> mMessageItems = new ArrayList<FourYSMainActivity.MessageItem>();

	private SlideViewYS mLastSlideViewWithStatusOn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_four_ys);
		initView();

		// ���ü���
		initEvent();
	}

	private void initEvent() {

		// ���÷��ذ�ť
		findViewById(R.id.moretab_iv_back).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						// ʹ��ǰActivity�����Ϳ�����
						FourYSMainActivity.this.finish();
					}
				});
	}

	private void initView() {
		mListView = (ListViewCompatYS) findViewById(R.id.list_four_ys);

		for (int i = 0; i < 3; i++) {
			MessageItem item = new MessageItem();
			switch (i % 3) {
			case 0:
				item.iconRes = R.drawable.map_four_ys01;
				item.title = "���������Ӱ��";
				item.msg = "��Դ���¶�����";
				item.time = "2015.12.18";
				break;
			case 1:
				item.iconRes = R.drawable.map_four_ys01;
				item.title = "�������յ�������Ӱ��";
				item.msg = "��Դ���¶�����";
				item.time = "2015.12.18";
				break;
			default:
				item.iconRes = R.drawable.map_four_ys01;
				item.title = "����ɽ�����ǹ���Ӱ��";
				item.msg = "��Դ���¶�����";
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
			SlideViewYS slideView = (SlideViewYS) convertView;
			if (slideView == null) {
				View itemView = mInflater.inflate(R.layout.slide_list_item,
						null);

				slideView = new SlideViewYS(FourYSMainActivity.this);
				slideView.setContentView(itemView);

				holder = new ViewHolder(slideView);
				slideView.setOnSlideListener(FourYSMainActivity.this);
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
			holder.leftHolder.setOnClickListener(FourYSMainActivity.this);
			holder.rightHolder.setOnClickListener(FourYSMainActivity.this);
			return slideView;
		}

	}

	public class MessageItem {
		public int iconRes;
		public String title;
		public String msg;
		public String time;
		public SlideViewYS slideView;
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
		SlideViewYS slideView = mMessageItems.get(position).slideView;
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
							YS01Activity.class));
					break;
				case 1:
					startActivity(new Intent(getApplicationContext(),
							YS02Activity.class));
					break;
				default:
					startActivity(new Intent(getApplicationContext(),
							YS03Activity.class));
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
			mLastSlideViewWithStatusOn = (SlideViewYS) view;
		}
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.left_holder) {
			Log.e(TAG, "onClick v=" + v);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("��ʾ").setIcon(R.drawable.ic_launcher)
					.setMessage("ȷ��ɾ����Ŀ��").setNegativeButton("ȡ��", null);
			builder.setPositiveButton("ɾ��",
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
			builder.setTitle("��ʾ").setIcon(R.drawable.ic_launcher)
					.setMessage("ȷ��ɾ����Ŀ��").setNegativeButton("ȡ��", null);
			builder.setPositiveButton("ɾ��",
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
