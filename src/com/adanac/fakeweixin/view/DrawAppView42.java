package com.adanac.fakeweixin.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.adanac.fakeweixin.R;
import com.adanac.fakeweixin.util.RadialMenuWidget;
import com.adanac.fakeweixin.util.RadialMenuWidget.RadialMenuEntry;

/**
 * 情感类
 * 
 * @author adanac
 * 
 */
public class DrawAppView42 extends Activity {

	private RadialMenuWidget PieMenu;
	private LinearLayout ll;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page_042);
		ll = new LinearLayout(this);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT);
		addContentView(ll, params);
	}

	public boolean onTouchEvent(MotionEvent e) {
		int state = e.getAction();
		int eventX = (int) e.getX();
		int eventY = (int) e.getY();
		if (state == MotionEvent.ACTION_DOWN) {

			Toast.makeText(DrawAppView42.this, "Screen Touched!",
					Toast.LENGTH_SHORT).show();

			// Screen Sizes
			int xScreenSize = (getResources().getDisplayMetrics().widthPixels);
			int yScreenSize = (getResources().getDisplayMetrics().heightPixels);
			int xLayoutSize = ll.getWidth();
			int yLayoutSize = ll.getHeight();
			int xCenter = xScreenSize / 2;
			int xSource = eventX;
			int yCenter = yScreenSize / 2;
			int ySource = eventY;

			if (xScreenSize != xLayoutSize) {
				xCenter = xLayoutSize / 2;
				xSource = eventX - (xScreenSize - xLayoutSize);
			}
			if (yScreenSize != yLayoutSize) {
				yCenter = yLayoutSize / 2;
				ySource = eventY - (yScreenSize - yLayoutSize);
			}

			PieMenu = new RadialMenuWidget(getBaseContext());

			PieMenu.setSourceLocation(xSource, ySource);
			PieMenu.setShowSourceLocation(true);
			PieMenu.setCenterLocation(xCenter, yCenter);

			PieMenu.setHeader("X:" + xSource + " Y:" + ySource, 20);

			PieMenu.setCenterCircle(new Menu0());
			// PieMenu.addMenuEntry(new CircleOptions());
			// PieMenu.addMenuEntry(new Menu1());
			// PieMenu.addMenuEntry(new Menu2());
			// PieMenu.addMenuEntry(new Menu3());

			ll.addView(PieMenu);
		}
		return true;
	}

	public static class Menu0 implements RadialMenuEntry {

		@Override
		public String getName() {

			return "media0";
		}

		@Override
		public String getLabel() {
			return "媒介解读";
		}

		@Override
		public int getIcon() {
			return 0;
		}

		private List<RadialMenuEntry> children = new ArrayList<RadialMenuEntry>(
				Arrays.asList(new Ink(), new Calligraphy(), new Photography(),
						new Filmgraphy()));

		@Override
		public List<RadialMenuEntry> getChildren() {

			return children;
		}

		@Override
		public void menuActiviated() {

		}

	}

	public static class CircleOptions implements RadialMenuEntry {
		public String getName() {
			return "CircleOptions";
		}

		public String getLabel() {
			return "Circle\nSymbols";
		}

		public int getIcon() {
			return 0;
		}

		private List<RadialMenuEntry> children = new ArrayList<RadialMenuEntry>(
				Arrays.asList(new Ink(), new Calligraphy(), new Photography(),
						new Filmgraphy()));

		public List<RadialMenuEntry> getChildren() {
			return children;
		}

		public void menuActiviated() {
			System.out.println("Circle Options Activated");
		}
	}

	public static class Ink implements RadialMenuEntry {
		public String getName() {
			return "Ink";
		}

		public String getLabel() {
			return "水墨画";
		}

		public int getIcon() {
			// return R.drawable.red_circle;
			return 0;
		}

		public List<RadialMenuEntry> getChildren() {
			return null;
		}

		public void menuActiviated() {
			System.out.println("Ink Activated");
		}
	}

	public static class Calligraphy implements RadialMenuEntry {
		public String getName() {
			return "Calligraphy";
		}

		public String getLabel() {
			return "书法";
		}

		public int getIcon() {
			// return R.drawable.red_circle;
			return 0;
		}

		public List<RadialMenuEntry> getChildren() {
			return null;
		}

		public void menuActiviated() {
			System.out.println("Calligraphy Activated");
		}
	}

	public static class Photography implements RadialMenuEntry {
		public String getName() {
			return "Photography";
		}

		public String getLabel() {
			return "摄影";
		}

		public int getIcon() {
			// return R.drawable.red_circle;
			return 0;
		}

		public List<RadialMenuEntry> getChildren() {
			return null;
		}

		public void menuActiviated() {
			System.out.println("Photo Activated");
		}
	}

	public static class Filmgraphy implements RadialMenuEntry {
		public String getName() {
			return "Filmgraphy";
		}

		public String getLabel() {
			return "影视";
		}

		public int getIcon() {
			// return R.drawable.red_circle;
			return 0;
		}

		public List<RadialMenuEntry> getChildren() {
			return null;
		}

		public void menuActiviated() {
			System.out.println("Filmgraphy Activated");
		}
	}
}
