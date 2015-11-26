package com.adanac.fakeweixin.tabmain;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.view.indicator.Indicator;
import com.adanac.view.indicator.IndicatorViewPager;
import com.adanac.view.indicator.IndicatorViewPager.IndicatorFragmentPagerAdapter;
import com.adanac.view.viewpager.SViewPager;

public class TabMainActivity extends FragmentActivity {
	private IndicatorViewPager indicatorViewPager;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.tabmain_activity);
		SViewPager viewPager = (SViewPager) findViewById(R.id.tabmain_viewPager);
		Indicator indicator = (Indicator) findViewById(R.id.tabmain_indicator);
		indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
		indicatorViewPager
				.setAdapter(new MyAdapter(getSupportFragmentManager()));
		// ��ֹviewpager�Ļ����¼�
		viewPager.setCanScroll(false);
		// ����viewpager�������治���¼��ص�ҳ������
		viewPager.setOffscreenPageLimit(4);
	}

	private class MyAdapter extends IndicatorFragmentPagerAdapter {
		private String[] tabNames = { "��ҳ", "��Ϣ", "����", "��" };
		private int[] tabIcons = { R.drawable.maintab_1_selector,
				R.drawable.maintab_2_selector, R.drawable.maintab_3_selector,
				R.drawable.maintab_4_selector };
		private LayoutInflater inflater;

		public MyAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
			inflater = LayoutInflater.from(getApplicationContext());
		}

		@Override
		public int getCount() {
			return tabNames.length;
		}

		@Override
		public View getViewForTab(int position, View convertView,
				ViewGroup container) {
			if (convertView == null) {
				convertView = (TextView) inflater.inflate(R.layout.tab_main,
						container, false);
			}
			TextView textView = (TextView) convertView;

			textView.setText(tabNames[position]);
			textView.setCompoundDrawablesWithIntrinsicBounds(0,
					tabIcons[position], 0, 0);
			return textView;
		}

		@Override
		public Fragment getFragmentForPage(int position) {
			FirstLayerFragment mainFragment = new FirstLayerFragment();
			Bundle bundle = new Bundle();
			bundle.putString(FirstLayerFragment.INTENT_STRING_TABNAME,
					tabNames[position]);
			bundle.putInt(FirstLayerFragment.INTENT_INT_INDEX, position);
			mainFragment.setArguments(bundle);
			return mainFragment;
		}
	}
}