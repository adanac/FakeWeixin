package com.adanac.fakeweixin.slideview.hh;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fakeweixin.util.ProcBoundUtil;

public class HH02Activity extends Activity {
	private Handler handler;
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
				+ "<h1>�ƹ����ġ�����ɽ��ͼ��</h1>"
				+ "<p align='center'><font color='#00bbaa'>��Դ���й��鷨��԰                    ʱ�䣺2015.10.10</p>"
				+ "������ɽ��ͼ���ǻƹ�������Ľ�����Ҳ���й��Ŵ�ɽˮ�����۷塣������һ���������⸱�����������Ǻ�ԭ��ʹ���⸱���ڵ�Ӱ��������ô����ȥ���ᡣ<br/>"
				+ "<img src='http://adanac.qiniudn.com/imghh02.png' /><br/>"

				+ "�ƹ����ġ�����ɽ��ͼ��<br/>"
				+ "��������°�ˮɫ��Զɽ��Լ�����������������Ⱥ�������ɽ�ͣ�������ãã��ˮ����ˮһɫ�������߷�ͻ��Զ���ã��ɽ�����ï�ܣ���׺���ᡢéͤ��ˮ���������۴�������ʹû��ȥ������ɽ�������ڻ�����Ȼ���Ը��ܵ�����ϣ��ͨ��������ɽ��ͼ����չ�ֵġ��󡱣���ɽ��������ĸ���ɽˮ��"
				+ "���������ߵ���ʵǿ����Ũ����ʪ�ĺ���������������ռ�Ĵ��ڣ��ܹ����ܵ�����Զ����ɽ�����߹���˿����������ֱ�����Ų�ͬ���ʸУ��������յ��˶��벻ͬ�Ľṹ��ʽ�ܱ��ֲ�ͬ���������˲�ͬ�ĸ��ܣ��ߵĴ����ص�����¶�ܱ��ֻ���Ĳ�Σ��ߵ����ػ���������ٴ��ܱ�������Ľ�������ɵȵȣ��ڡ�����ɽ��ͼ���е��ܹ����ܵ�ɽ�͵ĵ����������С�"
				+ "</body>" + "</html>";

		textView.setMovementMethod(ScrollingMovementMethod.getInstance());// ����

		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (msg.what == 0x101) {
					textView.setText((CharSequence) msg.obj);
				}
				super.handleMessage(msg);
			}
		};

		// ��Ϊ����������ͼƬ�Ǻ�ʱ���� ����Ҫ�������߳�
		Thread t = new Thread(new Runnable() {
			Message msg = Message.obtain();

			@Override
			public void run() {
				/**
				 * Ҫʵ��ͼƬ����ʾ��Ҫʹ��Html.fromHtml��һ���ع�������public static Spanned
				 * fromHtml (String source, Html.ImageGetterimageGetter,
				 * Html.TagHandler
				 * tagHandler)����Html.ImageGetter��һ���ӿڣ�����Ҫʵ�ִ˽ӿڣ�������getDrawable
				 * (String source)�����з���ͼƬ��Drawable����ſ��ԡ�
				 */
				ImageGetter imageGetter = new ImageGetter() {

					@Override
					public Drawable getDrawable(String source) {
						URL url;
						Drawable drawable = null;
						try {
							url = new URL(source);
							drawable = Drawable.createFromStream(
									url.openStream(), null);
							Log.e("width:", drawable.getIntrinsicWidth() + "");
							Log.e("height:", drawable.getIntrinsicHeight() + "");
							int[] res = ProcBoundUtil.procBound(
									drawable.getIntrinsicWidth(),
									drawable.getIntrinsicHeight());
							drawable.setBounds(0, 0, res[0], res[1]);
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						return drawable;
					}
				};
				CharSequence test = Html.fromHtml(html, imageGetter, null);
				msg.what = 0x101;
				msg.obj = test;
				handler.sendMessage(msg);
			}
		});
		t.start();

	}
}
