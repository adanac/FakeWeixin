package com.adanac.fakeweixin.slideview.sp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class SP01Activity extends Activity {
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_two_sp_01);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtsp01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��ѧ΢��Ƶ֮�����ŵ��ں���</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ���Ӿ��Ļ���                    ʱ�䣺2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;΢��Ƶ����ҪĿ���Ǹ������Ӿ��Ļ���ý���������γ̵Ŀ���ѧϰ������������е�ĳһ��֪ʶ�㲻���������ɻ����ͨ���ۿ���֪ʶ���΢��Ƶ��<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ϊ�������ѧϰ���Ͼ�ʦ����ѧ2014���Ӿ��Ļ��о�����Ա����ѧ��Դ�������赼ʦ������£�����¼�Ʋ��༭������΢��Ƶ��ѧ��Ʒ������ͬѧ�ǿ�����ʱ�ۿ���<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��֪ʶ�����Ҫ�����У�<br/>"
				+ "һ�����ŵ�ʵ���빦��<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.���ŵ�ʵ���Ǵ������ѷ��Ŷ���Ϊ�ɴ�������������ĳ�ֶ�������<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.�����š��Ĺ��ܡ���������<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	����=������<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	������=��������<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;<img src=\""
				+ R.drawable.two_sp_fh01
				+ "\"/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>������������ͼ</small><br/>"
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

	}
}
