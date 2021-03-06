package com.adanac.fakeweixin.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

public class DownFileUtil {

	public static void downMedia(final String savePath, final String filename,
			final String downPath) {
		File fd = new File(savePath);
		if (!fd.exists()) {
			fd.mkdirs();
			Log.i("创建文件夹：", savePath);
		}

		new Thread() {
			public void run() {
				try {
					down_file(downPath, savePath, filename);
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public static void down_file(String downPath, String savePath,
			String filename) throws IOException {
		URL myURL = new URL(downPath);
		URLConnection conn = myURL.openConnection();
		conn.connect();
		InputStream is = conn.getInputStream();
		int fileSize = conn.getContentLength();
		if (fileSize <= 0)
			throw new RuntimeException("can not know the file's size");
		if (is == null)
			throw new RuntimeException("stream is null");
		FileOutputStream fos = new FileOutputStream(savePath + "/" + filename);
		byte buf[] = new byte[1024];
		int downLoadFileSize = 0;
		do {
			// 循环读取
			int numread = is.read(buf);
			if (numread == -1) {
				break;
			}
			fos.write(buf, 0, numread);
			downLoadFileSize += numread;
		} while (true);
		Log.i("文件大小：", downLoadFileSize + "");
		try {
			is.close();
			fos.close();
		} catch (Exception ex) {
			Log.e("mytag", "error:" + ex.getMessage(), ex);
		}
	}

	public static void toastDisplay(Activity clazz, String str, int duration) {
		Toast.makeText(clazz, str, duration).show();
	}
}
