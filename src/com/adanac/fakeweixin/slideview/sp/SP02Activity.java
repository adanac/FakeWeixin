package com.adanac.fakeweixin.slideview.sp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class SP02Activity extends Activity {
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_two_sp_02);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtsp02);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>��ѧ΢��Ƶ֮��ý���������ں���</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ���Ӿ��Ļ���                    ʱ�䣺2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;΢��Ƶ����ҪĿ���Ǹ������Ӿ��Ļ���ý���������γ̵Ŀ���ѧϰ������������е�ĳһ��֪ʶ�㲻���������ɻ����ͨ���ۿ���֪ʶ���΢��Ƶ��<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ϊ�������ѧϰ���Ͼ�ʦ����ѧ2014���Ӿ��Ļ��о�����Ա����ѧ��Դ�������赼ʦ������£�����¼�Ʋ��༭������΢��Ƶ��ѧ��Ʒ������ͬѧ�ǿ�����ʱ�ۿ���<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��֪ʶ�����Ҫ�����У�<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ý����ǳ�����Ϣ��һ���н����ý������������Ը���ý����Ϣʱ��ѡ�������������������������������������Ӧ��������<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ý���������Գ�Ϊ�����������ý���Ļ��ġ����۾�����ͨ���Ծ���ý����Ʒ�Ľ��ѵ���������ڸ�֪�����顢��ͨ�뽻���Ĺ������𲽻����Ծ���ʶ����ǿ����������Ϊ����ý����춨��ʵ������</body>"
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

	}
}
