package com.adanac.fakeweixin.slideview.hh;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class HH02Activity extends Activity {
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
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�ƹ����ġ�����ɽ��ͼ��</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ���й��鷨��԰                    ʱ�䣺2015.10.10</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;������ɽ��ͼ���ǻƹ�������Ľ�����Ҳ���й��Ŵ�ɽˮ�����۷塣������һ���������⸱�����������Ǻ�ԭ��ʹ���⸱���ڵ�Ӱ��������ô����ȥ���ᡣ<br/>"
				+ "<img src='"
				+ R.drawable.imghh02
				+ "' />"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>�ƹ����ġ�����ɽ��ͼ��</small><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��������°�ˮɫ��Զɽ��Լ�����������������Ⱥ�������ɽ�ͣ�������ãã��ˮ����ˮһɫ�������߷�ͻ��Զ���ã��ɽ�����ï�ܣ���׺���ᡢéͤ��ˮ���������۴�������ʹû��ȥ������ɽ�������ڻ�����Ȼ���Ը��ܵ�����ϣ��ͨ��������ɽ��ͼ����չ�ֵġ��󡱣���ɽ��������ĸ���ɽˮ��"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���������ߵ���ʵǿ����Ũ����ʪ�ĺ���������������ռ�Ĵ��ڣ��ܹ����ܵ�����Զ����ɽ�����߹���˿����������ֱ�����Ų�ͬ���ʸУ��������յ��˶��벻ͬ�Ľṹ��ʽ�ܱ��ֲ�ͬ���������˲�ͬ�ĸ��ܣ��ߵĴ����ص�����¶�ܱ��ֻ���Ĳ�Σ��ߵ����ػ���������ٴ��ܱ�������Ľ�������ɵȵȣ��ڡ�����ɽ��ͼ���е��ܹ����ܵ�ɽ�͵ĵ����������С�"
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
