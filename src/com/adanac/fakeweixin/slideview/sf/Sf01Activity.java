package com.adanac.fakeweixin.slideview.sf;

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

public class Sf01Activity extends Activity {
	private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_four_sf_01);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtsf01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��������֮����ѩʱ������</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ�������ձ�                    ʱ�䣺2015.10.10</br></font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����ѩʱ�������ǽ����鷨������֮���鷨��Ʒ��������д�ɣ��ִ�����������ƴ�ġ����Ŀǰ��δ���ۡ�����23cm����14.8cm ���������У���ʮ���֡�����ѩʱ��������һ��������������������д���ڴ�ѩ����ʱ��������鼰�����˵��ʺ�<br/>"
				+ "<img src=\"http://adanac.qiniudn.com/imgsf01.png\"/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>����ѩʱ������</small><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���ģ�"
				+ "��֮���ס���ѩʱ�磬���밲�ơ�δ��Ϊ�ᡣ�����Ρ�����֮���ס�ɽ���ź"
				+ "ԭ�����壺"
				+ "����֮���ϣ��ղ�����һ��ѩ����������ת���ˣ����������һ�ж��ðɣ��Ǽ�����û�ܰ���æ����������������Ϻܶ����������ô���Ρ�����֮���ϣ�ɽ���ź�������"
				+ "������"
				+ "��ѩ�������ת�磬����֮��������������˱���ʺ�֮�⡣ĩ�С�ɽ���ź�����������˵����֣�ԭ��д���ż�ķ��棬�ڴ���ԭ��һ��ġ��ͬһ��ֽ�ϡ�"
				+ "����鼣��Բ�ʲط�Ϊ����������ձʣ�������Ʋ����¶��䀣��ɺ�ת��Ҳ��ΪԲת�ıʷ��������������ȣ������������У������������̬���������ؼ�ղ������ ��Բ�����ţ�����������ԣ��ζ֮��ɲ⡱����������ɫ��������Ϊ�����\�ܵ�����鼣��Ӱ�졣��������֮������Ǳ�������\΢�з����¶���Ƚ϶Է������\����ϣ����Եõ�������ӡ��"
				+ "����֮�鷨���ص���������ġ����ơ������塱��ָ���ֵ���״����̬�����ơ���ָ�ʻ��������ɶ��У��ԡ��족��Ϊ������������������ݣ�������Ӧ�Ĺ�ϵ���� �������Ҽ���΢���ʣ�ĩ���Ҷ٣���������б�����ơ���ѩ����Ҳ�����Ƶ����Σ��ϲ�������б��ĩһ�ử�ձ��������µı��ƣ�����Ҳ�����������ֵ����ġ���һ�ио����µġ�������һ�ᣬΪʲ�N�������ĸо��أ����ֻ��ÿ���ֺ���ıʻ������Է�����б�ĽǶȴ�����ͬ����ͬһ���ֵ�����Ҳ����ͬһ�����ϣ��ڶ�������Щ�仯������Ϊ�������ʣ��������ּ����裬����Ҳ��ƫ��ƫ��ı仯����Щ�仯�Եú���Ȼ��Ҳʹ����̶̵����о��зḻ�����С�"
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
