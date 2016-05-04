package com.adanac.fakeweixin.slideview.xz;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Xz01Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_xz_01);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtxz01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ���ٶȰٿ�                 ʱ�䣺2015.12.18</font></small><br/><br/>"
				+ "<img src=\""
				+ R.drawable.map_three_xz01
				+ "\"/>"
				+ "����(1957��)��Ů���о�Ա�����ڣ����壬1989���о�����ҵ�󣬽����й�����ѧԺ���´������ͯ��չ�о�����Ϊ�й�����ѧԺ�����봫���о������о�Ա��ý�鴫�����ͯ��չ�о��������Ρ�<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�������ڵ��о����������һ��ý���������꣺��Ҫ�о���ͯ�������ý����ü���Ӱ�졢ͨ����ͯ����ý��ٽ���ͯȨ����ý���¼������绥��������ʹ����������������롢ý������ȣ������Ա���ý�飺��Ҫ�о�ý�����ݵ�����Ա�������Ա���ý����ա�Ů��ý�����й����Ľ�ɫ�����á��Ա�ƽ�ȵ�ý���Ԥ�����о��ȣ�����������Ӱ�죬��Ҫ�о�ý�顢�������蹵�������������о�������Ⱥ���ý����Դ����Ӱ����о��ȡ�<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��1994����������������Ϊ����������˶�����Ҫ���о����⣬�������й�����ѧԺ�ص���⡰����ѧ�о��ɹ�ָ����ϵ���о�����ơ���1994-1998������������ѧ������⡰���ڴ������������Ӱ�족��1996-1999����������ί�п��⡰��ͯͼ���г��о�����1998�꣩�����Ϲ���ͯ�������⡰���Ϲ���ͯ��������й���ý����ᡱ������ͯȨ�������ֲᡱ�����й�����ý���еİ��̲������о�����1999��2002������������λ�����Ŀ��⡰�й�������û�������ʹ�ü���Ӱ�족��2000-2001���ȡ�<br/>	"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1997�꣬ר�����������塪���й���ͯ����ڴ����������ͼ�齱��������ͬ���ȫ����������ѧ���㽱����߽�����������������Ů�����˸񡷣����ࣩ�����������һ���̽���������ѧ�ɹ���ֵ������2002����й�����ѧԺ����ɹ������Ƚ�����������1997�귢��ġ���ý����������塢���ݺͷ�����һ�ı�����Ϊ��ʽ�������ҹ�ý�������������Ļ�������ҹ�������ý�����������о�������о������صĵ�λ��<br/>"
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
