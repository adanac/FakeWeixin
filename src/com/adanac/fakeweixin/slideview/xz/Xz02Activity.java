package com.adanac.fakeweixin.slideview.xz;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Xz02Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_xz_02);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtxz02);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;½��</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ��������ѧý������С��                  ʱ�䣺2015.12.18</font></small><br/><br/>"
				+ "<img src='"
				+ R.drawable.map_three_xz02
				+ "'/>"
				+ "½�ʣ�������ѧ����ѧԺ���ڣ�������ѧ��Ϣ�봫���о����ġ�����ý��������о������������й����Ž���ѧ�ᴫ��ѧ�о��ֻ����鳤,�����л�����ѧ���Ա����Ҫ�о�����Ϊ�㲥���Ӳ�ҵ������רҵ������й�ý��ĸý�������о��ȡ�<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1983�걾�Ʊ�ҵ�ڻ�������ѧ�Զ���������������ϵ����ѧѧʿѧλ��1987���ҵ�ڱ����㲥ѧԺ�����о��������ѧ������ѧ��˶ʿѧλ��1994���ڸ�����ѧ��ѧ������ѧ����ʿѧλ��1998��9����1999��9����Ϊ�������ظ߼�����ѧ���������ϼ��ݴ�ѧ���ɲ��񴫲�ѧԺ���з����о���2000��2����9����������Ĵ�ѧ�����봫��ѧԺ���²�ʿ���о���2000��11����Ӣ��ŵ���������ش�ѧӢ����ý��ϵ���з����о���2002����۽����ѧ����ѧԺ����ѧ�����ʡ�<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1997�꣬������Ĵ�ѧ���Ŵ���ѧԺ����ѧ�ߣ�1998��1999�꣬�����ϼ��ݴ�ѧ���Ხ�񴫲�ѧԺ���������ظ߼�����ѧ�ߣ�2000�꣬������Ĵ�ѧ���Ŵ���ѧԺ���²�ʿ���о���2000��Ӣ��ŵ���������ش�ѧӢ����ý��ϵ��ѧ�����ʣ�2002����۽����ѧ����ѧԺ��ѧ�����ʡ�<br/>	"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��½�ʽ��ڴ�ͷ�����ġ�������ѧý������С�顱���й���½���������齨��ý�������о���ʵ�����Ŷ�֮һ��Ҳ�����翪ʼý�������о���ʵ����ѧ���о�С��֮һ����һֱŬ���ؽ�����ý��������ý�������������о���ʵ����<br/>"
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
