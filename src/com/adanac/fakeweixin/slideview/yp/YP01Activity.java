package com.adanac.fakeweixin.slideview.yp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class YP01Activity extends Activity {
	// private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_two_yp_01);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtyp01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��������</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ���Ӿ��Ļ���                    ʱ�䣺2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����ԭ���Ǳ�������������������׳ƺ��٣�᯲Ρ���ѩ�������йٹ龩���С�����������Ǽ�ѡ�ʫ�䣬˵���ƴ��ʹ�����ԭ�������δ����ֽ�����ȡ��Ϊ�����١����δ�ĩѧ�߳�Ԫ���ڡ����ֹ�ǡ����������أ����ٱ��������ƣ����������١������������ڡ���Ϫ��̸�����ּ��ء���β�����溺������������Թ���ڡ��乭Ī��ȥ���㣬������񲻼ĳ�����˵���ڱ���ʱ��������β�ĺ��١�<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\""
				+ R.drawable.two_yp_eh01
				+ "\"/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>����</small><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����������Ͳ���ٸˡ���Ƥ�����ᡢ���ҡ����ˡ���ë��ǧ���Լ����빹�ɡ�����������ɫ���ӵ����쾡�µĵ�������Ȫӳ�¡��ˣ�����������ʼ������¶����һλ�����˼������ʹ���ä���˵�˼����У���Ʒչʾ�˶��ص�������༼�������Լ������ױȵ������⾳����ʾ���й����������Ķ������������ؿ��˶��������ı�����������20���ͻ������־�����Ʒ������<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;<img src=\""
				+ R.drawable.two_yp_eh02
				+ "\"/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>������������ͼ</small><br/>"

				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��ǡ��ּǡ��ƣ��������ߣ���������Ҳ�������ģ�ν֮�������������ǽ�������ͨ���˵ļӹ�֮�󣬲������˵ĸ��������֮���������˵������������ġ������������ǡ�����֮�����������������������������Ĵ����ǲ����μ�������ɵġ���ϣ�����Ƕ�Υ����Ȼ���ɵ��ż������ķ񶨡���߾�����������ܹ���Խ�йٸ�֪�����뵽����Ʒ���̵�Ʒζ���Ӷ��������ľ����뾫���������"
				+ "�����Ӳ���������������������������ԡ�����������ֲ�ͬ���ʣ�����ȡ���͡��ķ�ʽ��Ϊһ�壬ͨ�����������������ڣ�����һ���Ľ������ɣ������γɼȶ�����ͳһ�ı仯���С������˿ڵġ���Ȫӳ�¡�������������׶Ժڰ����Ĳ�������������ʱ��Ӧ�á�������á����ַ���</body>"
				+ "</html>";
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

		// ��Ϊ����������ͼƬ�Ǻ�ʱ���� ����Ҫ�������߳�
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
