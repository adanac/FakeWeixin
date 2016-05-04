package com.adanac.fakeweixin.slideview.wz;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.adanac.fakeweixin.R;

public class Wz01Activity extends Activity {

	private TextView textView;
	private String html;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_three_wz_01);
		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		textView = (TextView) findViewById(R.id.txtwz01);
		html = "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>��ý��ʱ����ȫ��ý����������</h2>"
				+ "<small><font color='#00bbaa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���ߣ��²���                  ����ʱ�䣺2015.12.18</font></small><br/><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��ý�����ǵĳɳ����ײ�����������Ӱ�죿�����Ǵ�һ���о�����˵��2008��11�����������ơ���Pediatrics����־����ı�����ʾ�����껳���뿴̫��������صĵ��ӽ�Ŀ�йء����о���2003λ12��17������������֣��ۿ��϶�������ص����е��Ӿ��硶���Ů��������������������������Ů͵�Խ����ļ��ʸ��ߣ����еļ����ǽ��ٿ�ͬ���Ŀ�ߵ������������Ӳ����Ƕ����������Ӱ������ý�塣�������ҹ��ҵ��Э���һλ��������Ϊ��һ��㲥���Ӷ��������ֱ��Ӱ�죬ԶС�����ߵ��ӡ����Ӻͻ�����������Ӱ�졣<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��ý���조��̬���硱<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�ִ�������������һ��ý�黯�����磬��ý�������ڣ�Ϊ���ǡ����족��һ������̬���硱����������ʵ�����һ�����֣����Ǵ�ýͨ�����������¼�����Ϣ����ѡ��ӹ������½ṹ���Ժ�������չʾ�����硣����ͨ����ʶ�����Ǹ��ӹ��Ĺ��̣�������Ѵ�ýչʾ�����統�ɿ͹����籾�����ǳ����ݴ˶ԡ���̬���硱������Ӧ��������ʵ����Ϊ�������ǵķ�Ӧֱ����������ʵ���硣���ڡ���̬���硱����ʵ����֮���ƫ���������������������磬���������Ľ׶ξ������ǵ�������ʱ�ڡ������ձ���Ϊ������ý����ɺ��ӵ����졢�������塢��������ֵ�ۻ��ҵȵȲ���Ӱ�죬��ý���ٶ������Ĳ������������Ų�����ж�����Ρ�2008��ȫ���˴�ί����еĵ�һ��ִ�������ʾ��Լ10%��δ�������񡢴�400��֮�ڵ��й���������ꡱ����ѧϰ����������Ľ����ܵ�����������Ĳ���Ӱ�죬��񫻹�������������⣬����ͥ��������Σ����δ������Υ��������ֱ����͡��Żﻯ�����仯�������ֶγ��˻������ƣ������о��д�ý����ҪӰ�졣<br/>	"
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
