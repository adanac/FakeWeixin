package com.adanac.fakeweixin.slideview.sy;

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

public class Sy01Activity extends Activity {
	private Handler handler;
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
				+ "<h2>�������׵£���ɭ˹����֮��ʱ���㳡��ʤ���ա�</h2>"
				+ "<p align='center'><font color='#00bbaa'>��Դ���ִ���Ӱ��                    ʱ�䣺2015.12.10</p>"
				+ "�������׵£���ɭ˹���أ�Alfred Eisenstaedt�����������ļ�ʵ��Ӱ�ң�����Ϊ��������Ӱ֮����(1898��1995)�������׵�?��ɭ˹����1898����������³ʿ��������Ĳ������ڣ�14��ʱ��ӵ�����Լ��ĵ�һ�����۵���Ƭ��������ʼ���㣬����Ϊ��������Ʒ�������������ʱ���㳡��ʤ���ա���<br/>"
				+ "<img src=\"http://adanac.qiniudn.com/imgsy01.png\"/><br/>"
				+ "��ʱ���㳡��ʤ���ա�<br/>"
				+ "����ս��������Ϣ����ŦԼ��ʱ���㳡��һλ��ϲ�ĺ���ʿ��§���������Ե�İ����ʿ���ҵ�������������Ƭ�����ڡ�Times����־���Ƿ�ӳս���������������ɻ��������������Ʒ�������Ʒ�������Ǻ����뻤ʿ��������ŦԼʱ���㳡�����������ڻ������ĵ�λ�ã����������������������������ҵ����Ǻʹ�������Ⱥ��һ����Աȡ���Ʒ����ƽ�ĵ�����Ƕȣ�����˳�⣬�������ı��������壬��ӳս���������������ɻ��ֵ����顣"
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
