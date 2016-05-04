package com.adanac.fakeweixin.slideview.fx;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Fx03Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_fx_03);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtfx03);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>��ý���������ۡ���Introduction to Media Literacy��</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���ߣ��ξ���                    &nbsp;&nbsp;����ʱ�䣺2015.12.18</font></small><br/><br/>"
				+ "<img src=\""
				+ R.drawable.map_three_fx03
				+ "\"/>"
				+ "��ý���������ۡ���Introduction to Media Literacy�����ɶξ��ࡢ�ſ��ɱ�д���������������2007��7�³��档<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����������ָ����ý��������media literacv����ָ���ڽӴ��������ʹ��ý������ʺ����������������������ڣ��Ӵ�ý�顢��ȡ��Ϣ�����ý�顢���еؽ���ý����Ϣ������ý�鹤�������ͨ��ý�鷢��������ά���Լ������档ý���������������ʣ������Ƿ����ͼ��ܣ����������ִ��������������ĵ�ý������������������������ң�ý�����������������ѳ�ΪѧУ�γ��еĹ������ݣ�����Ҳ�ǹ��������������Ҫ���ݡ�<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����ϵ�Ͼ���ѧ���Ŵ���ѧԺ��ý�����������顱�����о��ɹ����ṹ���������Ϸ�հ���۵�������Ұ��㡣��ѧ�����棬����߱���ѧ��ϵ�������о���ȣ����㷺�漰����ѧ������ѧ�����ѧ������ѧ������ѧ������ѧ�ȸ���֪ʶ������Ӧ�÷��棬���鲻�����ʺ����������ѧ���Ķ�ѧϰ�����Ķ�����Ҳ���ִ�����ҵ�������������������������ְҵ����������Ҫ�����顣<br/>	"
				+ "�ο�������Դ��<br/>"
				+ "[1] ����ѷ.��ý���������ۡ����[EB/OL].[2015-1-14]http://www.amazon.cn/ý����������/dp/B003ZHTV6O/ref=sr_1_1?ie=UTF8&qid=1394424415&sr=8-1&keywords=ý����������.<br/>"
				+ "[2] �ٶȰٿ�.��ý���������ۡ����[EB/OL].[2015-1-14].http://baike.baidu.com/view/2040203.htm.<br/>"
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
