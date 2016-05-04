package com.adanac.fakeweixin.slideview.xz;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Xz03Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_xz_03);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtxz03);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;������</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ���Ӿ��Ļ���                  ʱ�䣺2015.12.18</font></small><br/><br/>"
				+ "<img src=\""
				+ R.drawable.map_three_xz03
				+ "\"/>"
				+ "�����裨1955������Ů�����塣ԭ�ΰ���ʦ����ѧ������ѧѧԺԺ�������ڣ���Ϊ�Ͼ�ʦ����ѧ��������ϵ���ڣ���ʿ����ʦ��УѧλίԱ��ίԱ��У��ѧίԱ��ίԱ�������ڸ�������Ϣ�����������Ӿ��Ļ��о�����<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1995����2002������������θ�Ӣ����ѧ���ֱ��ڸ���˹���ѧ����������ѧ�Ͳ�����Э�������Ϣ�����������Ӿ��Ļ����ۺ��о��������ʿ���Ӣ��ѧУ����Ϣ��������Ϣ�Ļ�����״������Ӣ���������Ҳ����������ù�����С���Ұ�����������²������Ļ�ר���о��������������Ķ�ý������������ز�����ղء������ʹ������¡��⡢�¡��ɵ�ŷ�޴�½���ң������˴�������ӰͼƬ��¼�񣬶�ŷ�޵��Ļ��Ų��������Ļ���Դ���������еĸд������顣��2001�������Ͼ�ʦ����ѧΪ��������ѧרҵ������ѧרҵ������ѧרҵ�͹㲥����רҵ�о����������п������Ӿ��Ļ��γ̡�<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;������Ĵ����������С��Ӿ��Ļ����ۡ���2003�������ִ���������ѧ����2003������������Ϣ���������Ƚ��о�����2004���͡����������������ɡ�������ѵ������1991���ȣ��ڡ��ȽϽ����о������绯�����о������й��绯�������������ձ������Ļ㱨���ȷ�����Ϣ����֧���µ��Ӿ�����������������Ϣ�Ļ������������Ϣ���������߼���ϵ����������ʱ���������Ļ���չ�봫����������60��ƪ�����ȫ���绯�������㹤���߳ƺš�����ʡ�����ѧ�ɹ������챯���׽�������𽱵ȡ�<br/>	"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�����辫����ƿ��������Ӿ��Ļ��γ̣�����Ϣ����Ϊ֧�֡��������Ļ�Ϊ��Դ���������Ӿ��������Ļ��Ծ���ʶΪĿ�ꣻ���ڹ����״��Ӿ��Ļ��о����أ��Ӿ��Ļ���ý�������ۺ��о��о����ġ�2009�꣬����������������������׼2009��ȹ��Ҿ�Ʒ�γ̽�����Ŀ��֪ͨ�����̸ߺ�[2009]21�ţ�����ʽ�·���������������ֵġ��Ӿ��Ļ���ý���������������Ҽ���Ʒ�γ̡�<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2010����������������Ӿ��Ļ��Ŷ�ȡ�õġ����������µ��Ӿ��Ļ��γ̽��衱�ɹ�����ѡΪ�Ͼ�ʦ����ѧ��ʮ��������ѧ�ɹ��صȽ��� <br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2011�����������ֱ����Ľ̲ġ��Ӿ��Ļ���ý������������Ͼ�ʦ����ѧ����̲ĳ�������ȫ����������2011��9�����Ͼ�ʦ����ѧ�����繫�����桶�Ӿ��Ļ���ý�����������廯�̲ģ����ֽ̲�+��ý��μ�+ר����վ�����ÿγ���ѡΪ���Ҿ�Ʒ��Դ�����ſγ̣�2014���Ѿ����߹��Ұ��γ���վ��<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���������Ϊ�ƽ��ҹ����Ӿ��Ļ��о���ý���������������˾޴�Ĺ��ף�������ĬĬ�ظ����š�<br/>"
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
