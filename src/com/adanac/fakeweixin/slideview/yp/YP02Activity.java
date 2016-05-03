package com.adanac.fakeweixin.slideview.yp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class YP02Activity extends Activity {
	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_two_yp_02);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtyp02);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��������</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ���Ӿ��Ļ���                    ʱ�䣺2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���٣�������١����١������٣����й�����ϵĵ�������֮һ���������ڿ���ʱ�ھ��Ѿ�ʢ�е�����������������Ҳ����ǧ�������ʷ�ˡ������ͳ��ű����������١��������й������ƾõ���ʷ����ʫ�������¡��С�����Ů����ɪ��֮������ʫ����С�š����С���ɪ���ģ��������桱�ȼ��ء�<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\""
				+ R.drawable.two_yp_gq01
				+ "\"/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>����</small><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���ٵ����ƣ�����ḻ����Զ�����˶Դ�����������˵:�����Ƴ�����������֣�������������ʮ��ȣ�����֮������ʮ����Ҳ�������磬������Ҳ�������£������֮�������Ҳ�������Ի��,��Ի��,����ˮҲ,ˮ��ƽҲ�����߷�Ҳ,��ƽ���·���ǰ��������������в�Ҳ����Բ���죬�·����ء����س��˴磬��ͨ�˷磻���ӳ��Ĵ磬�Ժ��������������壬�԰�������������Ҳ�������߾�Ҳ�����Ͷ�����С���߳�Ҳ�����������ҡ�׷����Ӷ��ң������źϾ���֮��Ҳ����Ϊ������Ϊ������Ϊ��΢Ϊ�£���Ϊ��������������º�ƽ�������񡣡�((��֪ի���ס��Ϲ����ۡ�)��Щ˵���Ƿ�ɿ������Ҳ��ۣ������������˹��˶Թ������ƵĿ�����<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���ٵ�����������Ϊ��Ϥ�ľ�������ɽ��ˮ���˰ɡ���˵���ص���ʦ����һ���ڻ�ɽҰ�ص��٣��Է������ھ�����ᵽ������桰ΡΡ��־�ڸ�ɽ���͡������־����ˮ�������������������գ���֮�Ķ�������ͬ�������������󣬲���ʹʧ֪����ˤ�پ��ң������٣����и�ɽ��ˮ֮����</body>"
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
