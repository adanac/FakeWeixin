package com.adanac.fakeweixin.slideview.wz;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Wz03Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_wz_03);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtwz03);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>��ý��ʱ��������Уѧ��ý�������Ĳ���</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���ߣ�������                   ����ʱ�䣺2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�Ƽ����Ϣ��ʱ������Ϣ��ȡ����������֯������������Ϊ�����ۺ���������Ҫ��ɲ��֡�ý������������������ѿ���ɳ��ڣ���Уѧ��ȱ�ٱ�Ҫ��ý��������������ý��Ӧ�÷��������һЩ����Ч������УӦ�ý������Ƶ�ý������������ϵ�����Ĵ�ý�������γ̡�ʦ�ʣ�ý�������ѧ����������������������˴ٽ�ý�����������Ĳ��ԣ�̽��ý������������ʵʩ��<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���ڴ�����չʷ������ÿһ��ý�弼���ĸ��¶���ٽ����ڴ�ý�ı����ּ������촫ý�����µķ�չʱ����WEB2. 0 �����ĳ��ִٽ�������ý��ķ�չ����BBS�����͡����͡�ά�͡�QQ��MSN��SNS ����ȡ����ּ����ķ�չ�����������µĴ�ý��ʽ�����ٽ���ý����ںϣ��������硢�������缰���ŵ���������ںϣ��Դ�ý�ķ�չ�о����Ե�Ӱ�졣<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����ڵ��ӡ��㲥�������ȴ�ͳ���ڴ�ý���������ּ�����ý����BBS�����͡����͡�SNS���硢IP ���ӡ�¥����ӡ��ֻ���ý���Ϊ��ý�塣��ý��ĳ����ںܴ�̶��ϸı��Ŵ�ý�ķ�չ��̬����Щý�帳�贫���߽϶�����ɺ�������Ҳ�����ǳ�Ϊ��ý�塣�봫ͳ����ý����ȣ���ý�������´�����: ��Ϣ����ʱЧ��ǿ��������ʽ��״���������ߺ���Ϣ�����ߵ�˫����ݡ���Ϣ�������Ի���<br/>	"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;������ʾ��2010 ��6 �·ݣ��ҹ���������������4 ���ˣ��ֻ����񳬹�2. 7 �ڡ����ݵ�26 �Ρ��й��������緢չ״��ͳ�Ʊ��桷������������ṹ�У�20 �� 29 �����Ⱥռ�������������28. 6% ���ֻ������35. 4%����ְҵ�ṹ����ѧ������ý�����Ҫʹ��Ⱥ�塣������ε�ѧ����Ϊ��Уѧ������ˣ���Уѧ����ý����������Ӫ�����õĴ�������������Ҫ�����塣<br/>	"
				+ "</body></html>";
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
	}
}
