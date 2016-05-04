package com.adanac.fakeweixin.slideview.wz;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Wz02Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_wz_02);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtwz02);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ý��������ѧϰ</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���ߣ��ξ���                   ����ʱ�䣺2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ý��ķ�չΪ���ǵ�ѧϰ�����˻�������ս��20����ĩ��������ý��Խ�������˾޴���������������ܵ���͸������ý�黯�����ѧϰ�������Ƿǳ����ڵġ����¾��ǲ�����ý�黯���������ѧϰ����Ҫ�Ժͱ�Ҫ�ԣ�ý�黷���ĸ��ӻ�ҲҪ�����������ѧϰ���������ж���<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ͨ��ý���ѧϰ����ữѧϰ����Ҫ;�������ִ�����У�ý���Ѿ���Ϊ���������İ��¡��й��������С���ϣ�ѧ���ϡ��ĸ��ԣ�������Ӵ���ѧ�ĽǶȿ�����Ӧ��˵����ϣ��������ϡ�����������ʲô�ˣ���������ֱ���뿪������Ӧ���� ��������Ϣ��������ֹ����<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�Բ�ͬ������˵��������������һ������Ϣ�ĺ蹵���С������ǵ��������������ǵĶ��������Ǳ���֪���Ա�ȥӦ�õĶ���֮����һ������������Ǳ����Լ�ȥ����������ǽ�Ҫ�����ǵ��Ļ��ṩ�����ǵ���Ϣ���������Ϣ��ȥ�������������������У������Ļ�����Ϣ����Ҫ�Ǹ��ֲ�ͬ��ý�飬���Ĺ�����Ҫ��ͨ������ý����ɵġ���һ ����Ϣ�ĺ蹵����������ڲ�ͬ�����Ƕ��ǲ�һ���ģ���ɲ����ԭ������������պ�ʹ��ý�������ֱ����ء�<br/>	"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����20����ĩ��ý��Խ�������˾޴���������������ܵ���͸����������Ϣ����Ϊ���ĵļ������������ڼ��������������ʻ��������������־ޱ䣬���������г�Ա���������Ǿ�Ӣ������ͨ�ˣ����������Ӧ������ȫ�µ�Ҫ����Ϊÿһ���˶����ò��������Ѿ��仯���ڼ����仯����ỷ���У�������µ���ỷ���У�ý�鼰�������γ���һ�ֶ��ص��Ļ���������������ǰ��δ�е�Ӱ�졣�����Ļ����Ǳ����ǹ㷺��ע�Ĵ����Ļ����������ǶԴ����Ļ����в�ͬ����ʶ�����ۣ����������Ļ�ȴƾ��������Ч�����ִ���ýѸ�ٲ�ɢ���͹��ϲ������Ļ���������ʹ�Ļ�ƽӹ�������ʻ���ģʽ����ʹ����ɥʧ����ѡ��Ŀռ�����Ҿ��ϵ������������������˹����������˵����ý���Ļ������������ճ������Ϊ���ǵ�ע�����ͻ�е�һ���������ڵı���������Ҳ�Ǹ����ջ�����ǰ�����Դˣ��������Ϊ���������ڰ������ƻ����˵�Ǳ�ܺʹ���������<br/>	"
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
