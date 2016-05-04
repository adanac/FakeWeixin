package com.adanac.fakeweixin.view.sub;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.adanac.fakeweixin.R;
import com.adanac.fragment.LazyFragment;

/**
 * ʹ��ý�� - ͼ��
 * 
 * @author adanac
 * @date 2015-12-17
 * @version 1.0
 */
public class TwoTw01MoreFragment extends LazyFragment {
	private ProgressBar progressBar;
	private TextView textView;
	private int tabIndex;
	public static final String INTENT_INT_INDEX = "intent_int_index";

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_tabmain_two_tw);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
		progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_two_tw_progressBar);
		textView = (TextView) findViewById(R.id.fragment_mainTab_two_tw_textView);
		textView.setMovementMethod(ScrollingMovementMethod.getInstance());// ����
		textView.setTextSize(12);
		Drawable d = null;
		Drawable d1 = null;
		switch (tabIndex) {
		case 0:
			textView.setText(Html
					.fromHtml("<html><head><title></title></head><body><h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ѧ����Ʒ֮���׾���</h2><br/>"
							+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ���Ӿ��Ļ���&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ʱ�䣺2015.12.18<br/>"
							+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�Ͼ�ʦ����ѧ2010���ִ���������˶ʿ�����ԡ�ý����������ѧϰ���Ѿ������ˡ�ý�������������֪ʶ���˽��˺�Ϊý����������ô��ô���ܽ��䷢�ӵ�ʵ����ȥ�أ�"
							+ "����ͨ����ý�鹤�ߵ�ʹ�ã����й�������Ĵ�ͳ�Ļ�֮���׾�������������������Դ���п������֣��Ժ����й���ͳ�Ļ�����Զ���塣"
							+ "�������Ʒ���ӣ�<a href=\"http://www.fromeyes.cn/ZhuanTi/sjwhzy/jiaoji/\">http://www.fromeyes.cn/ZhuanTi/sjwhzy/jiaoji/</a>��</body></html>"));
			d = getResources().getDrawable(R.drawable.map_two_tw01);
			d.setBounds(0, 0, 700, 900);

			textView.setCompoundDrawables(null, null, null, d);
			break;
		case 1:
			textView.setText(Html
					.fromHtml("<html><head><title></title></head><body><h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ѧ����Ʒ֮������������</h2><br/>"
							+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ���Ӿ��Ļ���                    ʱ�䣺2015.12.18<br/>\t��Ʒ���������������Ͼ�ʦ����ѧ2011���ִ���������˶ʿ��ͬ�����ġ��й���ͳ������Ϊ�й���ͳ�Ļ��в��ɷָ��һ����ɲ��֣�ԴԶ����������ϣ��ͨ���Լ����ౡ֮����������Ϣ�����ֶ���չ���й���ͳ�����Ļ���������������ֻ��չ��������֮һ����Ʒ�����˱��ӡ����١����ݡ����١����á��������ѡ��������͹ġ��й���ͳ�����Ļ���Ϊ�л��Ļ���һ���֣��ǲ��ܱ���������������ġ����������־֮ʿ��ַ��Ӵ������ǣ��ھ�����Ļ����裬ʹ���л��Ļ������������Ļ�֮�У�ʹ���л��Ļ�����������֮�ۡ��������Ʒ���ӣ�http://www.fromeyes.cn/ZhuanTi/sjwhzy/2011��רҵ˶ʿ��������/index.html��</body></html>"));
			d = getResources().getDrawable(R.drawable.map_two_tw03);
			d.setBounds(0, 0, 700, 500); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, null, null, d);
			break;
		case 2:
			textView.setText(Html
					.fromHtml("<html><head><title></title></head><body><h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ѧ������Ʒ��̫���Ľ�ë���Ľ��</h2><br/>"
							+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Դ���Ӿ��Ļ���                    ʱ�䣺2015.12.18 <br/>"
							+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�������������Ʒ��ͨ���Լ���ѧϰ�����Լ��ḻ����������������ָ������ͼ����Լ����뷨�ɡ�</body></html>"));
			d = getResources().getDrawable(R.drawable.map_two_tw04);
			d.setBounds(0, 0, 650, 900); // ��������ͼƬ��С��������ʾ
			textView.setCompoundDrawables(null, null, null, d);
			break;
		default:
			textView.setText(Html
					.fromHtml("������ӣ�<br/>"
							+ "���ӻ��������ڱ�<a href=\"http://www.visual-literacy.org/periodic_table/periodic_table.html\">http://www.visual-literacy.org/periodic_table/periodic_table.html</a><br/>"));
			break;
		}
		handler.sendEmptyMessageDelayed(1, 1000);
	}

	@Override
	public void onDestroyViewLazy() {
		super.onDestroyViewLazy();
		handler.removeMessages(1);
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			progressBar.setVisibility(View.GONE);
			textView.setVisibility(View.VISIBLE);
		}
	};
}
