package com.adanac.fakeweixin.activity.moretab;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fragment.LazyFragment;

/**
 * @author adanac
 * @date 2015-11-27
 * @version 1.0
 */
public class MoreFragment extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_item);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_item_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_item_textView);
		switch (tabIndex) {
		case 0:
			textView.setText("媒介就是承载信息的一切中介物。而媒介素养则是面对各种媒介信息时的选择能力、理解能力、质疑能力、评价能力、应用能力。  媒介素养可以成为帮助我们理解媒介文化的“新眼镜”。通过对具体媒介作品的解读训练，可以在感知、体验、沟通与交流的过程中逐步唤醒自觉意识，增强评价能力，为今后的媒介表达奠定扎实基础。");
			break;

		default:
			textView.setText("界面 " + tabIndex + " 加载完毕");
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
}
