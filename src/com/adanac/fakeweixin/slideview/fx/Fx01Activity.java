package com.adanac.fakeweixin.slideview.fx;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Fx01Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_fx_01);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtfx01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��ý���ں����ۡ�</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���ߣ���С��                   &nbsp;&nbsp;����ʱ�䣺2015.12.18</font></small><br/><br/>"
				+ "<img src=\""
				+ R.drawable.map_three_fx01
				+ "\"/>"
				+ "��ý���ں����ۡ�һ������С��������»���������2015��7�³��档<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�ڡ�������+�����������£���ͳý��Ӧ������ƽ�ý���ںϣ��Ը�ǿ��������ƶ����ķ�չ�����������ֵ��ÿһ��ý��������˼����ʱ�����⡣<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���ע��˼����ͳý�����ƽ�ý���ںϹ����еġ������롰������������ԣ�һ��������۲���̽��������ý�弼�����������´�����̬������������Ҫ��������������������ҵ��Ӱ���Լ���ͳý���Ӧ��ս�ԣ���һ�����ʵ������������ű���������������������ģʽ�Լ���������Ӧ����δ��£�����Ӧ�������۳����±仯�����黹�ԡ�����ʽ�������������ݡ�����ý�塱�����������ȼ���Ӱ������ҵ��չ�Ĵ����ƽ���������������ڴӸ���������Ұ̽��ý���ںϵ�δ������<br/>	"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����ץס�˵��¹��ڴ�ý�����ձ��ע��һ���ȵ����⣬�ṩ��������ʶ��м�ֵ����Ϣ��Ҳ�ṩ����฻�����������˼����Ϊѧ����ʿ��ʶý���ںϵı�Ȼ�ԡ�ý���ںϵ���̬�������ý���ںϵ�Ӱ���ṩ��ո���ӽǣ�������ҵ�����������Ӧ��ý���ںϴ�����ʱ�ؿ���Ұ����˼·��<br/>"
				+ "�ο�������Դ��<br/>"
				+ "[1]�������[EB/OL]http://book.douban.com/subject/26438768/[2015-12-10]<br/>"
				+ "[2]����[EB/OL]http://item.jd.com/11719363.html[2015-12-10]<br/>"
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
