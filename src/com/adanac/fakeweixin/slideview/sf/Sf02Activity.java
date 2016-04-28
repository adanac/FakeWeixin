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

public class Sf02Activity extends Activity {
	private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_four_sf_02);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtsf02);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h1>��������ʳ����</h1>"
				+ "<p align='center'><font color='#00bbaa'>��Դ���й��鷨��԰                    ʱ�䣺2015.11.25</p>"
				+ "�����ݺ�ʳʫ������ֽ����25 �У���129�֣�����������Ĵ�����������һ��ǲ�˵�ʫ����������������ݵ�����ĺ�ʳ�������� ����֮̾��ʫд�ò������飬"
				+ "�����������ʱ���¶������顣��ʫ���鷨Ҳ��������������;����£��и� �����ġ�ͨƪ�鷨�����崣�������ˣ����Ʊ��ţ����޻���֮�ʡ������ݺ�ʳʫ�������鷨ʷ��Ӱ��ܴ�"
				+ " ����Ϊ�����µ������顱��Ҳ�������鷨��Ʒ�е��ϳˡ������ͥ���ڴ�ʫ�����ϣ����������³��������ʦ�� ����̨���⣬��ʹ���¸�Ϊ֮��δ�ؼ��ˡ�<br/>"
				+ "<img src='http://adanac.qiniudn.com/imgsf02.png' /><br/>"

				+ "���������ݺ�ʳʫ����<br/>"
				+ "�����ġ���"
				+ "���������ݣ��ѹ�����ʳ��������ϧ������ȥ����ϧ�� �����ֿ��꣬��������ɪ�����ź��Ļ���������֧ѩ������͵��ȥ��ҹ�������������ⲡ���꣬����ͷ�Ѱס�"
				+ "�������뻧�����������ѡ�С�������ۣ�����ˮ��������󺮲ˣ�������ʪέ����֪�Ǻ�ʳ����������ֽ����������أ���Ĺ�����Ҳ���Ϳ����Ҵ�����"
				+ "ʫ��������������С�ݡ����ҡ�����ֽ�� ��Ĺ������Ⱦ��һ�ֳ�����������⾳������������ʱ�˲����ؾӻ��ݵĻҰ����Ƶ��ľ��� �����С������󺮲ˣ�������ʪέ����������������ȵ����������ʫ����������ǧ����ʫ���У����������ϳ�֮�����������߻�����һ��������ʽ�����鷨��������ʱ����������ˡ����̷����鷨������������ı����⾳����ʹ�����ݺ�ʳʫ������Ϊǧ��������"
				+ "�����ݺ�ʳʫ�������Զ��ƣ������������������ʫд�ò�����꣬�鷨Ҳ��������������;����£��иж����ġ�ͨƪ�����崣�Ѹ�����Ƚ���ʹ�����죬һ���ǳɡ�������ʫ���ľ���еı仯��Ԣ�ڵ㻭�����ı仯�У������棬���棬ת����䣬˳�ֶ�������Ȼ��ɡ���������棬����С��������ܣ��������أ��п���խ���β���䣬������ȣ��仯��ǧ���ѹֻ�ͥ��Ϊ֮������̾Ի�������´�ʫ����̫�ף��̿�̫����δ�������������³��������ʦ������̨���⣬��ʹ���¸�Ϊ֮��δ�ؼ��ˡ���(�����ݺ�ʳʫ�ϡ�)�����Ҳ�а������ƣ�������ƽ�����������漣������ʮ�ž����Դ�Ϊ�׹ۡ��������ݺ�ʳʫ�����������鷨��Ʒ�е��ϳˣ����鷨ʷ��Ӱ��ܴ�Ԫ�������������Ϊ������֮����ͤ�򡷡������䡶��ֶ�塷֮��ġ����µ������顱��"
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
