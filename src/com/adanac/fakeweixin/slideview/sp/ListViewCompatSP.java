package com.adanac.fakeweixin.slideview.sp;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import com.adanac.fakeweixin.slideview.TwoSPMainActivity.MessageItem;

public class ListViewCompatSP extends ListView {

	private static final String TAG = "ListViewCompat";

	private SlideViewSP mFocusedItemView;

	private int position;

	public ListViewCompatSP(Context context) {
		super(context);
	}

	public ListViewCompatSP(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ListViewCompatSP(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void shrinkListItem(int position) {
		View item = getChildAt(position);

		if (item != null) {
			try {
				((SlideViewSP) item).shrink();
			} catch (ClassCastException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int x = (int) event.getX();
		int y = (int) event.getY();
		position = pointToPosition(x, y);
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN: {
			Log.e(TAG, "postion=" + position);
			if (position != INVALID_POSITION) {
				MessageItem data = (MessageItem) getItemAtPosition(position);
				mFocusedItemView = data.slideView;
				Log.e(TAG, "FocusedItemView=" + mFocusedItemView);
			}
		}
		default:
			break;
		}

		if (mFocusedItemView != null) {
			if (position == INVALID_POSITION) {
				mFocusedItemView.shrink();
				return super.onTouchEvent(event);
			}
			mFocusedItemView.onRequireTouchEvent(event);
		}

		return super.onTouchEvent(event);
	}

	public int getPosition() {
		return position;
	}
}
