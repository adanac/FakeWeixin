package com.adanac.fakeweixin.slideview.hh;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class HH01Activity extends Activity {
	// private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_four_qt_01);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtqt01);
		html = "<html><head></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�����С�������ҹ��ͼ��</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ���ٶȰٿ�                   ʱ�䣺2015.10.10</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��������еġ�������ҹ��ͼ������ͼ�У����ǿ��Է��֣�ÿ�����ƺ�����һ����С�ģ�Ϊʲô�أ�ͼ���ƺ�������е����ﻭ�ıȽϴ󣬸輿��Ի���С����Щ��Ϊʲô�ڻ���ռ�ı�����ͬ�أ����ǿ��Է��֣����������Ҫ������ĳߴ�ԶԶ�������������������͸�ӹ��ɣ���ֱ�ǲ���˼��ġ����й��������������ҵ�����˼ά������ʱ�գ�ʹ����ġ���ѧ�ԡ��������������������ԣ��������·���ǿ���������⾳����<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\""
				+ R.drawable.imghh01
				+ "\"/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>��������ҹ��ͼ��</small><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��������ҹ��ͼ�������������ϣ���ȡ�˴�ͳ�Ĺ�ͼ��ʽ������ʱ�����Ѳ�ͬʱ���н��еĻ��֯��ͬһ�����ϡ�ȫ����֯��������.��������ڸ��ӣ������ڶ࣬ȴ���ŵñ������򣬷���öȡ��ڳ���֮�䣬���ҷǳ�������������硢������������Ʒ����齵�֮������ʹ֮�����໥�����ԣ����б˴˷���У��ȶ����ɻ�������һ������"
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
