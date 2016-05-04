package com.adanac.fakeweixin.slideview.ys;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class YS01Activity extends Activity {
	// private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_four_ys_01);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtys01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���������Ӱ��</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ���¶�����                   ʱ�䣺2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;<img src=\""
				+ R.drawable.imgys01
				+ "\"/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>�����������Ӱ����</small><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ɫ�ʺ������ϻ�ò��׵�Ч��"
				+ "����ı��Ϊ��Ӱ����ĵ��ݣ�ɫ�ʺ�����һֱ��������ע�ġ����ڵ�Ӱɫ�ʺ�����������̽��Ҳ��ʾ��������ѧ�������ţ����ĵ�Ӱ��������Ͳ�ȱ���Ӿ������������ı��������ʹ���ʵ��ĵ�Ӱɫ����ʹ���ڲ�������̼����Ӿ��𺳣������ó�ʹ�ö��ص����ʹﵽ����׷�������������Ч����"
				+ "ɫ��ʵ�����ǰ���������������ġ��ڵ�Ӱ��Ʒ�У�ɫ�ʺ͹��ߡ����湹ͼ�ȶ������Ӿ����͵Ĺ��ܡ����Ǳ���Ϊ��ͻ������ı������ɫ��ɫ�����ã��ر�ؽ�ɫ�ʵ��г�������������"
				+ "����ı���������ĵ�Ӱ��ʹ��ɫ�ʰ�쵵����������е�Ӱ�����գ���ǿ�Ӿ�Ч������Щ���Ϳ�����һĻ������һЩ���ߣ�Ҳ������һЩ���������Ǻ͹�����ڽ��ܽ�ϣ�������������ǿ����Ӿ������Ҳ�����ԵĴ����˵������ڵ�Ӱ�б��ֵ����⡣"
				+ "�ڡ���������У���Ӱ���͵ľ��ɼ�����Ϊ����ı��������ʽ������Ҫ��׷�󡣡����������׷���Ƕ���������ک�裬ӰƬ�ڱ��ֵ�ʱ��ѡȡ��һϵ�ж��ص����ͣ�̧�εĿ�ߣ��������ϵ�Ұ�ϣ����ʱ���ַ�æ�ĳ��棬����Ǳ��žƹ����ձ���������ȥ;̫����үү�������ܰ�����ͣ�������˻���ߵĿ޺�����ʳ�ȡ�������������ޱ��޼ʵĸ����أ�������������Χǽ����⣬ˮ������ľƷ�����������ԭʼ�����������ʢ���������"
				+ "����������ǿ���ġ������硱����"
				+ "��������������󵨵���ǰ������ǰ�ߣ�Ī��ͷͨ��Ĵ�·����ǧ�Ű٣���ǧ�Űپ��۰�...��������������󵨵���ǰ�ߡ��ɽ��Ĵ����ۻ��ɤ����𡱳�����Ѹ�ٴ�����ȫ�����Ӷ��е���壬�������ǡ�������󵨵���ǰ�ߡ��ĸ�����һʱ�䣬��̳Ҳ����һ��ǿ���ġ������硱��������ʹ��ǧ������й���(���䱱����)������������ԼԼ�ķ����鳲��ᣬ�õ������̶ȵ����㡣Ƭ�У����³��ž������ʱ�򣬵���������Ӫ����ĺ���Ұ�Եġ���������;�������Ｄ����󣬻����������ú������εĴ���ɤ�����һ������ȫ������衶������󵨵���ǰ�ߡ�;��β�����Ӷ�����׷�ʽ��һ�����֣���������֮�ʡ���"
				+ "��������������ֲ������Լ�ƽ������Լ�ƽ�����ֵĴ���Ը����Ҳ������ı������һ����������ӯ����Ѱ��֮�á��Լ�ƽ�����ֺ͡�����������˺�һ������Ļ�ϴ�д��������һ�ε�������Ļ�����������ˮ���Լ�ƽ������ı˫��һ�գ������ĸ���Ҷ�ӣ�ɭ��һ������������ "
				+ "��֮������������е���Щ���ͻ��������˵����������������淽ʽ����չʾ���˵Ļ��������ı�׳���������ڡ���Щ�������������ͣ���ǿ�˵�Ӱ������ֱ�۳������ʹ��Ʒ��������͸����һ��ǿ���ġ���Ұ�ġ��������������ʡ�"
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
