package com.adanac.fakeweixin.slideview.sy;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Sy02Activity extends Activity {
	// private Handler handler;
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_four_sy_02);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtsy02);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�⺣����Ʒ����Ҫ���顷</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ���ִ���Ӱ��                    ʱ�䣺2015.12.12</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����Ҫ���顷�����Ʒ�������ҹ�������Ӱ���߽⺣��������Ƭ�е��������������ꡣ20����ǰ���⺣��������һ��Ѱ���Լ�����������˲�䡣�������ţ��������������Ƕ���ͷд�ֵ������꣬����������һ̧ͷ��˲Ϣ��Ͱѽ⺣���������ε�ץס�ˣ�����ŷ����⺢�ӵ��۾��ر��һ�����Ϻ���һ�붼���۾���ͫ�����ƺ��кöര����������ߡ�����û����һ���۾�������Ȼ���ú��ȳ���������Ҳ���Բ�����ʲô�ر�����ע��ĵط��ˡ���ǡǡ����һ˫�۾�ʹ��ȫ���鶯���������������ź�ǿ�Ĵ�͸�ԣ��ܹ����뵽���ǵ������ʹ�����̱����ε�����ס������Ҳ�Ĺ��������۾��Ľ⺣�����۹�����ʮ�����ޣ�Ȼ���˿�ȴֻ�б����������𺳵ĸо���<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src='"
				+ R.drawable.imgsy02
				+ "' /><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>�⺣�� ����Ҫ���顷</small><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���������ڽ��ҵĵڶ��ţ��⺣��Ҫ�Ѿ��ش�ǰ���������Ӽ��Ŀյ����͹�ȥ���㡣���Ҵ���͸��������Ĺ��ߣ�����ͷ���ϵ�̳�������������Ҳ������Ů����С�����⺣��Ѹ�ٵػ�����80-200mm�佹��ͷ�����ȵض�ס��������ڽ���ǰ��ȴ��ţ��ȴ��š���������Ǧ���ٴ�̧���۾���ǰ����ʱ���⺣�����ϵ������˿��š���һɲ�ǣ���ֻ��һ�ָ��ܣ��Ǿ��Ǵ����Ŀ�У��ṹ����Ŀ�У�ץȡ˲��Ŀ�У����չ��ߵĿ�С��ᴩ�������������̵Ļ�����ʵ�ǳ��򵥣�ǰ��ֻ�������ŵ�Ƭ��һ��һ�����Ƿ�������ͳ������㡣"
				+ "�Ӵˣ��������߱�ȫ���Ĵ��С�ż�����ף����ᷢ��һ��ũ���СŮ������һ˫�������۾�����Ƭ�����ڲ�����Ľ��䣬ÿ�쿴��������ȥ�Ҵҡ�����һ˫�����Ĵ��۾����ں�͸��������һ˫ʧ��Ĵ��۾�����Լ��������Ө����⣬��¶����֪ʶ�Ŀ�����׷�󣬶������������̾Ϣ����У԰����������ꡣ�����������ĬĬ���ӣ����������Դ�����������˼���û�������������ӣ�������������һ���޿ɿ��ܵ������������ٻ���ȴ�������㣬�������ֲ������㣬�����������������������ԡ�����ĵش������Ŀ���ĳ�����ѻ�����ҡ�"
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
