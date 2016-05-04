package com.adanac.fakeweixin.slideview.sy;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Sy01Activity extends Activity {
	// private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_four_sy_01);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtsy01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�������׵£���ɭ˹����֮��ʱ���㳡��ʤ���ա�</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ���ִ���Ӱ��                    ʱ�䣺2015.12.10</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�������׵£���ɭ˹���أ�Alfred Eisenstaedt�����������ļ�ʵ��Ӱ�ң�����Ϊ��������Ӱ֮����(1898��1995)�������׵�?��ɭ˹����1898����������³ʿ��������Ĳ������ڣ�14��ʱ��ӵ�����Լ��ĵ�һ�����۵���Ƭ��������ʼ���㣬����Ϊ��������Ʒ�������������ʱ���㳡��ʤ���ա���<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\""
				+ R.drawable.imgsy01
				+ "\"/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>��ʱ���㳡��ʤ���ա�</small><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����ս��������Ϣ����ŦԼ��ʱ���㳡��һλ��ϲ�ĺ���ʿ��§���������Ե�İ����ʿ���ҵ�������������Ƭ�����ڡ�Times����־���Ƿ�ӳս���������������ɻ��������������Ʒ�������Ʒ�������Ǻ����뻤ʿ��������ŦԼʱ���㳡�����������ڻ������ĵ�λ�ã����������������������������ҵ����Ǻʹ�������Ⱥ��һ����Աȡ���Ʒ����ƽ�ĵ�����Ƕȣ�����˳�⣬�������ı��������壬��ӳս���������������ɻ��ֵ����顣"
				+ "</body>" + "</html>";

		textView.setMovementMethod(ScrollingMovementMethod.getInstance());// ����
		ImageGetter imageGetter = new ImageGetter() {
			@Override
			public Drawable getDrawable(String source) {
				int id = Integer.parseInt(source);

				// ����id����Դ�ļ��л�ȡͼƬ����
				Drawable d = getResources().getDrawable(id);
				d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
				return d;
			}
		};

		textView.append(Html.fromHtml(html, imageGetter, null));

		// handler = new Handler() {
		// @Override
		// public void handleMessage(Message msg) {
		// if (msg.what == 0x101) {
		// textView.setText((CharSequence) msg.obj);
		// }
		// super.handleMessage(msg);
		// }
		// };
		//
		// // ��Ϊ����������ͼƬ�Ǻ�ʱ���� ����Ҫ�������߳�
		// Thread t = new Thread(new Runnable() {
		// Message msg = Message.obtain();
		//
		// @Override
		// public void run() {
		// /**
		// * Ҫʵ��ͼƬ����ʾ��Ҫʹ��Html.fromHtml��һ���ع�������public static Spanned
		// * fromHtml (String source, Html.ImageGetterimageGetter,
		// * Html.TagHandler
		// * tagHandler)����Html.ImageGetter��һ���ӿڣ�����Ҫʵ�ִ˽ӿڣ�������getDrawable
		// * (String source)�����з���ͼƬ��Drawable����ſ��ԡ�
		// */
		// ImageGetter imageGetter = new ImageGetter() {
		//
		// @Override
		// public Drawable getDrawable(String source) {
		// URL url;
		// Drawable drawable = null;
		// try {
		// url = new URL(source);
		// drawable = Drawable.createFromStream(
		// url.openStream(), null);
		// Log.e("width:", drawable.getIntrinsicWidth() + "");
		// Log.e("height:", drawable.getIntrinsicHeight() + "");
		// int[] res = ProcBoundUtil.procBound(
		// drawable.getIntrinsicWidth(),
		// drawable.getIntrinsicHeight());
		// drawable.setBounds(0, 0, res[0], res[1]);
		// } catch (MalformedURLException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// return drawable;
		// }
		// };
		// CharSequence test = Html.fromHtml(html, imageGetter, null);
		// msg.what = 0x101;
		// msg.obj = test;
		// handler.sendMessage(msg);
		// }
		// });
		// t.start();

	}
}
